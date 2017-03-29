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
    public JSlider slideR= new JSlider(9, 24, getRows());
    public JSlider slideC= new JSlider(9, 30, getColumns());
    public JSlider slideM= new JSlider(10, 145, getMines());
    public JTextField textR = new JTextField(String.valueOf(getRows()),2);
    public JTextField textC = new JTextField(String.valueOf(getColumns()),2);
    public JTextField textM = new JTextField(String.valueOf(getMines()),2);
    
    public CustomGamePanel(){
        this.setLayout(new GridLayout(3,3));
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
        panelR.add(labelR);
        panelR.add(slideR);        
        panelR.add(textR);
        panelC.add(labelC);
        panelC.add(slideC);
        panelC.add(textC);
        panelM.add(labelM);
        panelM.add(slideM);
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
