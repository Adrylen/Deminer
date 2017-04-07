/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import org.game.controller.GameController;
import org.game.graphics.view.frame.DialogFrame;
import org.game.graphics.view.panel.GraphicalGridView;
import org.game.graphics.view.panel.InfoPanel;
import org.game.graphics.view.menu.Menu;
import org.game.models.GameGrid;
import org.game.models.Scores;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kieffersarah
 */
public class Window extends JFrame implements Observer {
	private GameController controller;
	private GraphicalGridView gridView;
	private Observable gameModel;
	private InfoPanel infoPanel;

	public Window(String str, int sizeX, int sizeY){
        super(str);
        this.gridView = null;
        this.setSize(sizeX,sizeY);

        this.setContentPane(new JDesktopPane());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new Menu("Game"));
        this.add(menuBar, BorderLayout.NORTH);

        infoPanel = new InfoPanel();
        this.add(infoPanel, BorderLayout.SOUTH);
    }

    public void setObservable(Observable gameModel) {
    	this.gameModel = gameModel;
    }

	public void useController(GameController controller) {
    	this.controller = controller;
	}

    public void main() {
		if(this.gridView != null) {
			//this.gridView.purge();
			this.remove(this.gridView);
		}
		this.gridView = new GraphicalGridView((GameGrid) this.gameModel, this.controller);
        this.add(this.gridView, BorderLayout.CENTER);
        this.infoPanel.setSmiley("ʕ•ᴥ•ʔ");

        this.setVisible(true);
    }

    private GraphicalGridView getPanel() {
    	for(Component c : this.getContentPane().getComponents()) {
    		if(c instanceof  GraphicalGridView) {
    			return (GraphicalGridView) c;
		    }
	    }
	    return null;
    }

	@Override
	public void update(Observable obs, Object obj) {
		for(int i = 0; i < ((GameGrid) obj).getRows(); i++){
			for(int j = 0; j < ((GameGrid) obj).getCols(); j++) {
				this.getPanel().getButton(i,j).changeIcon();
			}
		}

		infoPanel.updateMines(((GameGrid)obj).getNumberOfMines());
		if(this.controller.isStarted()) {
			infoPanel.getTimer().start();
		} else {
			infoPanel.getTimer().reset();
		}

		if(this.controller.isLoose()) {
			infoPanel.getTimer().stop();
			infoPanel.setSmiley("ʕ⁎̯͡⁎ʔ༄");
			DialogFrame.alert(this,false);
		} else if(this.controller.isWin()) {
			infoPanel.getTimer().stop();
			infoPanel.setSmiley("୧ʕ•̀ᴥ•́ʔ୨");
			Scores.write(Scores.read().updateScores(DialogFrame.askPseudo(this), infoPanel.getTimer().getTime()));
//			this.menu.getScoreBoard().update();
			DialogFrame.alert(this,true);
		}
	}
}
