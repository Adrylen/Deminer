/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import org.game.models.GameGrid;
        

/**
 *
 * @author kieffersarah
 */
public class Window extends JFrame implements Observer {
    private int sizeX = 300;
    private int sizeY = 400;
    
    public Window(String str){
        super(str);
    }


    public void main(){

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new Menu("Game"));
        GameGrid grid = new GameGrid().setGrid(10, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new BorderLayout(5, 5));
        
        this.add(new GraphicalGridView(grid), BorderLayout.CENTER);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(new JButton("South"), BorderLayout.SOUTH);
        this.add(new JButton("East"), BorderLayout.EAST);
        this.add(new JButton("West"), BorderLayout.WEST);
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
	    return (GraphicalGridView) this.getContentPane().getComponent(0);
    }

	@Override
	public void update(Observable obs, Object obj) {
	}
}
