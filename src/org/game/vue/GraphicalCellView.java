/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import javax.swing.JButton;

import org.game.graphics.events.MouseEventListener;
import org.game.models.Case;


/**
 *
 * @author kieffersarah
 */
public class GraphicalCellView extends JButton {
    private Case gameCase;

    public GraphicalCellView(Case gameCase){
        super();
        this.gameCase = gameCase;
        this.addMouseListener(new MouseEventListener());
    }

    public Case getCase() {
    	return this.gameCase;
    }
}
