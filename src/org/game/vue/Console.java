/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import org.game.models.GameGrid;

/**
 *
 * @author kieffersarah
 */
public class Console implements Observer {
	private Observable control = null;
	private boolean debugMode = false;

	public Console(Observable control) {
		this.control = control;
	}

	public void update(Observable obs, Object obj) {
		if(this.control == obs) {
			if(obj instanceof GameGrid) {
				if (!this.debugMode) {
					this.display((GameGrid) obj);
				} else {
					this.displayBug((GameGrid) obj);
				}
			} else if(obj instanceof String) {
				System.out.println(obj.toString());
			} else {
				this.debugMode = !this.debugMode;
			}
		}
	}
    
    public void display(GameGrid grid){
        int rows = grid.getRows();
        int cols = grid.getCols();
        for(int i=-1; i<rows; i++){
            for(int j=-1; j<cols; j++){
                if(i==-1){
                    if(j==-1){
                        System.out.print("   ");
                    }else{
                        System.out.printf("%3d",j);                        
                    }
                }else if(j==-1 && i!=-1){
                    System.out.printf("%3d",i);
                }else{
                    System.out.printf("%3c",grid.getCase(i, j).getSymbol());
                }
            }
            System.out.println("");
        }
    }
    
    public void displayBug(GameGrid grid){
        int rows = grid.getRows();
        int cols = grid.getCols();
        for(int i=-1; i<rows; i++){
            for(int j=-1; j<cols; j++){
                if(i==-1){
                    if(j==-1){
                        System.out.print("   ");
                    }else{
                        System.out.printf("%3d",j);                       
                    }
                }else if(j==-1 && i!=-1){
                    System.out.printf("%3d",i);
                }else{
                    if(!grid.getCase(i, j).isMined()){
                        System.out.printf("%3c",grid.getCase(i, j).getSymbol());  
                    }else{
                        System.out.print("  x");
                    }
                }
            }
            System.out.println("");
        }
    }
    
    public String getInstructions(){
        System.out.println("What is your instruction?");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public String getInitialisation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How much rows?");
        String str = sc.nextLine() + " ";
        System.out.println("How much columns?");
        str += sc.nextLine() + " ";
        System.out.println("What percent of mines?");
        str += sc.nextLine();
        return str;
        
    }
}
