/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import org.game.models.GameGrid;

/**
 *
 * @author kieffersarah
 */
public class Console {
    private int rows;
    private int cols;
    
    public static void display(GameGrid grid){
        int rows = grid.getRows();
        int cols = grid.getCols();
        for(int i=0; i<rows; i++){
            for(int j=0; i<cols; j++){
                System.out.print(grid[i][j].)
            }
        }
    }
    
    public static void displayBug(){
        
    }
    
    public static void getInstructions(){
        
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    
}
