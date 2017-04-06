/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import org.game.controller.GameController;
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
	private Menu menu;
	private Observable gameModel;
	private InfoPanel infoPanel;

	private boolean start;

    private int sizeX = 300;
    private int sizeY = 400;

	public Window(String str, int sizeX, int sizeY){
        super(str);
        this.gridView = null;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.setSize(sizeX,sizeY);

        this.setContentPane(new JDesktopPane());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu = new Menu("Game"));
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
		this.start = true;

		if(this.gridView != null) {
			//this.gridView.purge();
			this.remove(this.gridView);
		}
		this.gridView = new GraphicalGridView((GameGrid) this.gameModel, this.controller);
        this.add(this.gridView, BorderLayout.CENTER);

        this.setVisible(true);
    }

    /**
     * @return the sizeX
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * @param sizeX the sizeX to set
     */
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * @return the sizeY
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * @param sizeY the sizeY to set
     */
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public GraphicalGridView getPanel() {
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
			DialogFrame.alert(this,false);
		} else if(this.controller.isWin()) {
			infoPanel.getTimer().stop();
			Scores.write(Scores.read().updateScores(DialogFrame.askPseudo(this), infoPanel.getTimer().getTime()));
//			this.menu.getScoreBoard().update();
			DialogFrame.alert(this,true);
		}
	}
}
