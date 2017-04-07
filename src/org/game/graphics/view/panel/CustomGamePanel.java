/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view.panel;

import org.game.graphics.view.component.CustomOptionPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 *
 * @author kieffersarah
 */
public class CustomGamePanel extends JPanel {
    private CustomOptionPanel panelR= null;
    private CustomOptionPanel panelC= null;
    private CustomOptionPanel panelM= null;

    
    CustomGamePanel(){
        this.setLayout(new GridLayout(3,3));
        panelR= new CustomOptionPanel("Rows", 9, 24, 9, 1, 2);
        panelC= new CustomOptionPanel("Columns", 9, 30, 19, 2, 4);
        panelM= new CustomOptionPanel("Mines", 10, 145, 76, 13, 26);
        this.add(panelR.init());
        this.add(panelC.init());
        this.add(panelM.init());
    }

    /**
     * @return the panelR
     */
    public CustomOptionPanel getPanelR() {
        return panelR;
    }

    /**
     * @return the panelC
     */
    public CustomOptionPanel getPanelC() {
        return panelC;
    }

    /**
     * @return the panelM
     */
    public CustomOptionPanel getPanelM() {
        return panelM;
    }
}