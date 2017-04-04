/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import java.awt.GridLayout;
import javax.swing.JLabel;
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
    public JPanel panelR= new JPanel();
    public JPanel panelC= new JPanel();
    public JPanel panelM= new JPanel();
    public JLabel labelR = new JLabel("rows");
    public JLabel labelC = new JLabel("columns");
    public JLabel labelM = new JLabel("mines");
    public JSlider sliderR= new JSlider(9, 24, getRows());
    public JSlider sliderC= new JSlider(9, 30, getColumns());
    public JSlider sliderM= new JSlider(10, 145, getMines());
    public JTextField textR = new JTextField(String.valueOf(getRows()),2);
    public JTextField textC = new JTextField(String.valueOf(getColumns()),2);
    public JTextField textM = new JTextField(String.valueOf(getMines()),2);
    
    public CustomGamePanel(){
        this.setLayout(new GridLayout(3,3));
        sliderR.setPaintTicks(true);
        sliderR.setPaintLabels(true);
        sliderR.setMinorTickSpacing(1);
        sliderR.setMajorTickSpacing(2);
        sliderR.setEnabled(false);
        sliderC.setPaintTicks(true);
        sliderC.setPaintLabels(true);
        sliderC.setMinorTickSpacing(2);
        sliderC.setMajorTickSpacing(4);
        sliderC.setEnabled(false);
        sliderM.setPaintTicks(true);
        sliderM.setPaintLabels(true);
        sliderM.setMinorTickSpacing(13);
        sliderM.setMajorTickSpacing(26);
        sliderM.setEnabled(false);
        textR.setEnabled(false);
        textC.setEnabled(false);
        textM.setEnabled(false);
        panelR.add(labelR);
        panelR.add(sliderR);        
        panelR.add(textR);
        panelC.add(labelC);
        panelC.add(sliderC);
        panelC.add(textC);
        panelM.add(labelM);
        panelM.add(sliderM);
        panelM.add(textM);

        this.add(panelR);
        this.add(panelC);
        this.add(panelM);
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