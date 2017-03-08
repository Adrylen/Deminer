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
        for(int i=-1; i<rows; i++){
            for(int j=-1; j<cols; j++){
                if(i==-1){
                    System.out.print(j);
                }else if(j==-1 && i!=-1){
                    System.out.print(i);
                }else{
                    System.out.print(grid.getCase(i, j).getSymbol());
                }
            }
            System.out.println("");
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
