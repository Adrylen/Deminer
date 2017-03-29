/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author kieffersarah
 */
public class NewGamePanel extends JPanel{
    
    private CustomGamePanel custom = new CustomGamePanel();
    private JPanel choice = new JPanel();
    private JRadioButton beginner = new JRadioButton("Beginner : 10 mines in a 9x9 field");
    private JRadioButton intermediate = new JRadioButton("Intermediate : 40 mines in a 16x16 field");
    private JRadioButton expert = new JRadioButton("Expert : 99 mines in a 16x30 field");
    private JRadioButton cust = new JRadioButton("Custom : ");
    private JLabel select = new JLabel("Select Level : ");
    private ButtonGroup group = new ButtonGroup();
    
    public NewGamePanel(){
        this.main();
    }
    
    public void main(){
        choice.setLayout(new GridLayout(5,1));
        group.add(beginner);
        group.add(intermediate);
        group.add(expert);
        group.add(cust);
        choice.add(select);
        choice.add(beginner);
        choice.add(intermediate);
        choice.add(expert);
        choice.add(cust);
        this.setLayout(new GridLayout(2,1));
        this.add(choice);
        this.add(custom);
    }
    
}
