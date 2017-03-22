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

import org.game.controller.GameController;
import org.game.models.GameGrid;

/**
 *
 * @author kieffersarah
 */
public class Window extends JFrame implements Observer {
	private GameController controller;
	private Observable gameModel;

    private int sizeX = 300;
    private int sizeY = 400;

	public Window(String str, int sizeX, int sizeY){
        super(str);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void setObservable(Observable gameModel) {
    	this.gameModel = gameModel;
    }

	public void useController(GameController controller) {
    	this.controller = controller;
	}

    public void main() {
	GraphicalGridView gridView = new GraphicalGridView((GameGrid) this.gameModel, this.controller);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new Menu("Game"));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(sizeX,sizeY);
        this.setLayout(new BorderLayout(5, 5));

        this.add(gridView, BorderLayout.CENTER);
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
		for(int i = 0; i < ((GameGrid) obj).getRows(); i++){
			for(int j = 0; j < ((GameGrid) obj).getCols(); j++) {
    	        this.getPanel().getButton(i,j).changeIcon();
			}
		}
		if(this.controller.isLoose()) {
			System.out.println("LOOSE");
		} else if(this.controller.isWin()) {
			System.out.println("WIN");
		}
	}
}
