/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.game.graphics.events.MouseEventListener;
import org.game.models.Case;


/**
 *
 * @author kieffersarah
 */
public class GraphicalCellView extends JButton {
    private Case gameCase;
    private Icon mine = new ImageIcon("deminer.png");

    public GraphicalCellView(Case gameCase){
        super(new StringBuilder().append(gameCase.getSymbol()).toString());
        this.gameCase = gameCase;
        this.changeIcon();
        this.addMouseListener(new MouseEventListener());
    }

    public Case getCase() {
	    return this.gameCase;
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
                this.setEnabled(false);
                break;
            case '2':
                this.setText("2");
                this.setEnabled(false);
                break;
            case '3':
                this.setText("3");
                this.setEnabled(false);
                break;
            case '4':
                this.setText("4");
                this.setEnabled(false);
                break;
            case '5':
                this.setText("5");
                this.setEnabled(false);
                break;
            case '6':
                this.setText("6");
                this.setEnabled(false);
                break;
            case '7':
                this.setText("7");
                this.setEnabled(false);
                break;
            case '8':
                this.setText("8");
                this.setEnabled(false);
                break;
            
                   
        }
    }
}
