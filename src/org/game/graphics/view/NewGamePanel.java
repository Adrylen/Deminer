/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author kieffersarah
 */
public class NewGamePanel extends JPanel{
    
    private CustomGamePanel custom = new CustomGamePanel();
    private JPanel choice = new JPanel();
    private JRadioButton beginner = new JRadioButton("Beginner : 10 mines in a 9x9 field", true);
    private JRadioButton intermediate = new JRadioButton("Intermediate : 40 mines in a 16x16 field");
    private JRadioButton expert = new JRadioButton("Expert : 99 mines in a 16x30 field");
    private JRadioButton cust = new JRadioButton("Custom : ");
    private JLabel select = new JLabel("Select Level : ");
    private ButtonGroup group = new ButtonGroup();
    private JButton start = new JButton("Start");
    private JButton cancel = new JButton("cancel");
    
    public NewGamePanel(){
        this.main();
    }
    
    public void main(){
        create();
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
        this.setLayout(new GridLayout(4,1));
        this.add(choice);
        this.add(custom);
        this.add(start);
        this.add(cancel);
        start.setSize(20,30);
        cancel.setSize(20, 30);

    }
    
    public void create(){
        this.cust.addItemListener(new ItemListener(){
        @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    custom.sliderC.setEnabled(true);
                    custom.sliderR.setEnabled(true);
                    custom.sliderM.setEnabled(true);
                    custom.textC.setEnabled(true);
                    custom.textR.setEnabled(true);
                    custom.textM.setEnabled(true);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    custom.sliderC.setEnabled(false);
                    custom.sliderR.setEnabled(false);
                    custom.sliderM.setEnabled(false);
                    custom.textC.setEnabled(false);
                    custom.textR.setEnabled(false);
                    custom.textM.setEnabled(false);
                }
            }
    });
        
    }
    
}
