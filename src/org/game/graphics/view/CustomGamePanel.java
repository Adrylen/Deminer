/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 *
 * @author kieffersarah
 */
public class CustomGamePanel extends JPanel {
    private int rows = 9;
    private int columns = 19;
    private int mines = 76;
    private CustomOptionPanel panelR= null;
    private CustomOptionPanel panelC= null;
    private CustomOptionPanel panelM= null;

    
    public CustomGamePanel(){
        this.setLayout(new GridLayout(3,3));
        panelR= new CustomOptionPanel("Rows", 9, 24, getRows(), 1, 2);
        panelC= new CustomOptionPanel("Columns", 9, 30, getColumns(), 2, 4);
        panelM= new CustomOptionPanel("Mines", 10, 145, getMines(), 13, 26);
        this.add(panelR.init());
        this.add(panelC.init());
        this.add(panelM.init());
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * @return the mines
     */
    public int getMines() {
        return mines;
    }

    /**
     * @param mines the mines to set
     */
    public void setMines(int mines) {
        this.mines = mines;
    }

    /**
     * @return the panelR
     */
    public CustomOptionPanel getPanelR() {
        return panelR;
    }

    /**
     * @param panelR the panelR to set
     */
    public void setPanelR(CustomOptionPanel panelR) {
        this.panelR = panelR;
    }

    /**
     * @return the panelC
     */
    public CustomOptionPanel getPanelC() {
        return panelC;
    }

    /**
     * @param panelC the panelC to set
     */
    public void setPanelC(CustomOptionPanel panelC) {
        this.panelC = panelC;
    }

    /**
     * @return the panelM
     */
    public CustomOptionPanel getPanelM() {
        return panelM;
    }

    /**
     * @param panelM the panelM to set
     */
    public void setPanelM(CustomOptionPanel panelM) {
        this.panelM = panelM;
    }
    
}