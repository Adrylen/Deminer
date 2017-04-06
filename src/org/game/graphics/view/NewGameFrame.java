/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;


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
                    getUi().setVisible(false);
                }
        });
        
        this.getGame().getStart().addMouseListener(new MouseAdapter(){
            @Override 
                public void mouseClicked(MouseEvent e){
                    getUi().setVisible(false);
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
    public NewGameFrame getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(NewGameFrame ui) {
        this.ui = ui;
    }

}
