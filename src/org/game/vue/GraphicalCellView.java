/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.vue;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kieffersarah
 */
public class GraphicalCellView extends JButton implements ActionListener {

    public GraphicalCellView(char symbol){
        super(new StringBuilder().append(symbol).toString());
        addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Yup");
	}
}
