/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.game.models.Case;

/**
 *
 * @author kieffersarah
 */
public class GraphicalCellView extends JButton{
    
    private Case gameCase;
    private Icon mine = new ImageIcon("deminer.png");

    public GraphicalCellView(Case gameCase){
        super(new StringBuilder().append(gameCase.getSymbol()).toString());
        this.gameCase=gameCase;
        this.changeIcon();
    }
    
    public void changeIcon(){
        switch(this.gameCase.getSymbol()){
            case '#':
                this.setText("#");
                break;
            case '!':
                this.setText("!");
                break;
            case 'x':
                this.setText("x");
                break;
            case '.':
                this.setText(".");
                this.setEnabled(false);
                break;
            case '?':
                this.setText("?");
                break;
            case '1':
                this.setText("1");
                break;
            case '2':
                this.setText("2");
                break;
            case '3':
                this.setText("3");
                break;
            case '4':
                this.setText("4");
                break;
            case '5':
                this.setText("5");
                break;
            case '6':
                this.setText("6");
                break;
            case '7':
                this.setText("7");
                break;
            case '8':
                this.setText("8");
                break;
            
                   
        }
    }
}
