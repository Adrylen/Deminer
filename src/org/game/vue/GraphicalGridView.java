/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.game.models.GameGrid;

/**
 *
 * @author kieffersarah
 */
public class GraphicalGridView extends JPanel{
    
    public GraphicalGridView(GameGrid grid){
        int rows = grid.getRows();
        int cols = grid.getCols();
        this.setLayout(new GridLayout(rows, cols, 0, 0));
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                char symbol=grid.getCase(i, j).getSymbol();
                this.add(new GraphicalCellView(symbol));
            }
        }
    }
}
