/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view.frame;


import org.game.graphics.engine.WindowDeminer;
import org.game.graphics.view.panel.NewGamePanel;
import org.game.models.NewGame;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author kieffersarah
 */
public class NewGameFrame extends JFrame{
    private NewGamePanel game = new NewGamePanel();
    private NewGameFrame ui = this;

    public NewGameFrame(String str){
        super(str);
    }
    
    
    public void main(){
        this.setLayout(new BorderLayout(0, 0));
        this.add(getGame(), BorderLayout.CENTER);
        this.setSize(350, 500);
        this.setResizable(false);
        this.getGame().getCancel().addMouseListener(new MouseAdapter(){
            @Override 
                public void mouseClicked(MouseEvent e){
                    getUi().dispose();
                }
        });

	    this.getGame().getStart().addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e){
			    if(getUi().getGame().getBeginner().isSelected()) {
			        WindowDeminer.create(NewGame.BEGINNER);
			    } else if(getUi().getGame().getIntermediate().isSelected()) {
			        WindowDeminer.create(NewGame.INTERMEDIATE);
			    } else if(getUi().getGame().getExpert().isSelected()) {
			        WindowDeminer.create(NewGame.EXPERT);
			    } else if(getUi().getGame().getCust().isSelected()) {
			        WindowDeminer.create(new int[]{
			        	getUi().getGame().getCustom().getPanelR().getSlider().getValue(),
				        getUi().getGame().getCustom().getPanelC().getSlider().getValue(),
				        getUi().getGame().getCustom().getPanelM().getSlider().getValue()
			        });
			    }
			    getUi().dispose();
		    }
	    });
        this.setVisible(true);
    }

    /**
     * @return the game
     */
    public NewGamePanel getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(NewGamePanel game) {
        this.game = game;
    }

    /**
     * @return the ui
     */
    private NewGameFrame getUi() {
        return ui;
    }
}
