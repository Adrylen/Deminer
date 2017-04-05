/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import java.awt.Dimension;
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
    private JButton cancel = new JButton("Cancel");
    
    public NewGamePanel(){
        this.main();
    }
    
    public void main(){
        create();
        getChoice().setLayout(new GridLayout(5,1));
        getGroup().add(getBeginner());
        getGroup().add(getIntermediate());
        getGroup().add(getExpert());
        getGroup().add(getCust());
        getChoice().add(getSelect());
        getChoice().add(getBeginner());
        getChoice().add(getIntermediate());
        getChoice().add(getExpert());
        getChoice().add(getCust());
        this.setLayout(new GridLayout(4,1));
        this.add(getChoice());
        this.add(getCustom());
        this.add(getStart());
        this.add(getCancel());

    }
    
    public void create(){
        this.getCust().addItemListener(new ItemListener(){
        @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    getCustom().getPanelC().getSlider().setEnabled(true);
                    getCustom().getPanelR().getSlider().setEnabled(true);
                    getCustom().getPanelM().getSlider().setEnabled(true);
                    getCustom().getPanelC().getText().setEnabled(true);
                    getCustom().getPanelR().getText().setEnabled(true);
                    getCustom().getPanelM().getText().setEnabled(true);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    getCustom().getPanelC().getSlider().setEnabled(false);
                    getCustom().getPanelR().getSlider().setEnabled(false);
                    getCustom().getPanelM().getSlider().setEnabled(false);
                    getCustom().getPanelC().getText().setEnabled(false);
                    getCustom().getPanelR().getText().setEnabled(false);
                    getCustom().getPanelM().getText().setEnabled(false);
                }
            }
    });
        
    }
    

    /**
     * @return the custom
     */
    public CustomGamePanel getCustom() {
        return custom;
    }

    /**
     * @param custom the custom to set
     */
    public void setCustom(CustomGamePanel custom) {
        this.custom = custom;
    }

    /**
     * @return the choice
     */
    public JPanel getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(JPanel choice) {
        this.choice = choice;
    }

    /**
     * @return the beginner
     */
    public JRadioButton getBeginner() {
        return beginner;
    }

    /**
     * @param beginner the beginner to set
     */
    public void setBeginner(JRadioButton beginner) {
        this.beginner = beginner;
    }

    /**
     * @return the intermediate
     */
    public JRadioButton getIntermediate() {
        return intermediate;
    }

    /**
     * @param intermediate the intermediate to set
     */
    public void setIntermediate(JRadioButton intermediate) {
        this.intermediate = intermediate;
    }

    /**
     * @return the expert
     */
    public JRadioButton getExpert() {
        return expert;
    }

    /**
     * @param expert the expert to set
     */
    public void setExpert(JRadioButton expert) {
        this.expert = expert;
    }

    /**
     * @return the cust
     */
    public JRadioButton getCust() {
        return cust;
    }

    /**
     * @param cust the cust to set
     */
    public void setCust(JRadioButton cust) {
        this.cust = cust;
    }

    /**
     * @return the select
     */
    public JLabel getSelect() {
        return select;
    }

    /**
     * @param select the select to set
     */
    public void setSelect(JLabel select) {
        this.select = select;
    }

    /**
     * @return the group
     */
    public ButtonGroup getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(ButtonGroup group) {
        this.group = group;
    }

    /**
     * @return the start
     */
    public JButton getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(JButton start) {
        this.start = start;
    }

    /**
     * @return the cancel
     */
    public JButton getCancel() {
        return cancel;
    }

    /**
     * @param cancel the cancel to set
     */
    public void setCancel(JButton cancel) {
        this.cancel = cancel;
    }

}
