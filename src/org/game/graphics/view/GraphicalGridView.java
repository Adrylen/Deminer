/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import org.game.controller.GameController;
import org.game.models.GameGrid;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 *
 * @author kieffersarah
 */
public class GraphicalGridView extends JPanel{
    private GameGrid grid;

    public GraphicalGridView(GameGrid grid, GameController controller){
    	this.grid = grid;
        int rows = grid.getRows();
        int cols = grid.getCols();
        this.setLayout(new GridLayout(rows, cols));
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
//                Case gameCase=grid.getCase(i, j);
                this.add(new GraphicalCellView(grid.getCase(i,j), controller));
            }
        }
    }

    public GameGrid getGrid() {
    	return this.grid;
    }

    public GraphicalCellView getButton(int i, int j) {
    	int nb = this.grid.getCols()*i + j;
		return (GraphicalCellView) this.getComponent(nb);
    }
}
