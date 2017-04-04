/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

/**
 *
 * @author kieffersarah
 */
public class NewGameFrame extends JInternalFrame{
    private int sizeX = 300;
    private int sizeY = 400;
    private NewGamePanel game = new NewGamePanel();

    public NewGameFrame(String str, int sizeX, int sizeY){
        super(str);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    
    public void main(){
        this.setLayout(new BorderLayout(5, 5));
        this.add(game, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(sizeX,sizeY);
        this.setVisible(true);
    }
}
