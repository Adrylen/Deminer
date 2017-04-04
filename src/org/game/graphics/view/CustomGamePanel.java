/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.GridLayout;

/**
 *
 * @author kieffersarah
 */
public class CustomGamePanel extends JPanel {
    private int rows = 9;
    private int columns = 19;
    private int mines = 76;
    public JSlider slideR= new JSlider(9, 24, getRows());
    public JSlider slideC= new JSlider(9, 30, getColumns());
    public JSlider slideM= new JSlider(10, 145, getMines());
    public JTextField textR = new JTextField(String.valueOf(getRows()),2);
    public JTextField textC = new JTextField(String.valueOf(getColumns()),2);
    public JTextField textM = new JTextField(String.valueOf(getMines()),2);
    
    public CustomGamePanel(){
        this.setLayout(new GridLayout(3,2));
        slideR.setPaintTicks(true);
        slideR.setPaintLabels(true);
        slideR.setMinorTickSpacing(1);
        slideR.setMajorTickSpacing(2);
        slideC.setPaintTicks(true);
        slideC.setPaintLabels(true);
        slideC.setMinorTickSpacing(2);
        slideC.setMajorTickSpacing(4);
        slideM.setPaintTicks(true);
        slideM.setPaintLabels(true);
        slideM.setMinorTickSpacing(13);
        slideM.setMajorTickSpacing(26);
        this.add(slideR);
        this.add(textR);
        this.add(slideC);
        this.add(textC);
        this.add(slideM);
        this.add(textM);
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
    
}