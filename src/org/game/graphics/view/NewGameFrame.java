/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author kieffersarah
 */
public class NewGameFrame extends JFrame{
    private int sizeX = 300;
    private int sizeY = 400;

    public NewGameFrame(String str, int sizeX, int sizeY){
        super(str);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    
    public void main(){
        this.setLayout(new BorderLayout(5, 5));
        NewGamePanel game = new NewGamePanel();
        this.add(game, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
