/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import javax.swing.JButton;

/**
 *
 * @author kieffersarah
 */
public class GraphicalCellView extends JButton{

    public GraphicalCellView(char symbol){
        super(new StringBuilder().append(symbol).toString());
    }
}
