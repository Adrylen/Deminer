/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import java.util.Scanner;
import org.game.models.GameGrid;

/**
 *
 * @author kieffersarah
 */
public class Console {
    
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
    
    public static void displayBug(GameGrid grid){
        int rows = grid.getRows();
        int cols = grid.getCols();
        for(int i=-1; i<rows; i++){
            for(int j=-1; j<cols; j++){
                if(i==-1){
                    System.out.print(j);
                }else if(j==-1 && i!=-1){
                    System.out.print(i);
                }else{
                    if(!grid.getCase(i, j).isMined()){
                        System.out.print(grid.getCase(i, j).getSymbol());  
                    }else{
                        System.out.print('x');
                    }
                }
            }
            System.out.println("");
        }
    }
    
    public static String getInstructions(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
}
