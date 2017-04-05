/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.game.controller.Timer;

/**
 *
 * @author kieffersarah
 */
public class CustomOptionPanel extends JPanel{
    
    private String str;
    private int min;
    private int max;
    private int value;
    private int minor;
    private int major;
    private JSlider slider = null;
    private JLabel label = null;
    private JTextField text = null;
    private GridBagConstraints placement;
    public Dimension dim= new Dimension(30,20);
    
    public CustomOptionPanel(String str, int min, int max, int value, int minor, int major){
        this.setMin(min);
        this.setMax(max);
        this.setMinor(minor);
        this.setMajor(major);
        this.setStr(str);
        this.setValue(value);        
    }
    
    public CustomOptionPanel init(){
        
        this.placement = new GridBagConstraints();
	this.placement.ipadx = 0;
	this.placement.fill = GridBagConstraints.HORIZONTAL;
	this.setLayout(new GridBagLayout());
	this.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); 
        this.addLabel();
        this.addSlider();
        this.addText();

        return this;
    }

    private void addSlider(){
        slider = new JSlider(getMin(), getMax(), getValue());
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(minor);
        slider.setMajorTickSpacing(major);
        slider.setEnabled(false);  
        this.placement.weightx = 0.005;
	this.placement.gridx = 1;
	this.placement.gridy = 0;
	this.add(slider, this.placement);
    }
    
    private void addLabel(){
        label = new JLabel(str);
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	this.placement.weightx = 0.5;
	this.placement.gridx = 0;
	this.placement.gridy = 0;
	this.add(label, this.placement);
    }
    
    private void addText(){
        text = new JTextField(String.valueOf(value),3);
        text.setEnabled(false);
	text.setHorizontalAlignment(SwingConstants.TRAILING);
	text.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

	this.placement.weightx = 0.5;
	this.placement.gridx = 2;
	this.placement.gridy = 0;
        text.setPreferredSize(dim);
	this.add(text, this.placement);
    }
    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the minor
     */
    public int getMinor() {
        return minor;
    }

    /**
     * @param minor the minor to set
     */
    public void setMinor(int minor) {
        this.minor = minor;
    }

    /**
     * @return the major
     */
    public int getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(int major) {
        this.major = major;
    }

    /**
     * @return the slider
     */
    public JSlider getSlider() {
        return slider;
    }

    /**
     * @param slider the slider to set
     */
    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the text
     */
    public JTextField getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(JTextField text) {
        this.text = text;
    }

    /**
     * @return the placement
     */
    public GridBagConstraints getPlacement() {
        return placement;
    }

    /**
     * @param placement the placement to set
     */
    public void setPlacement(GridBagConstraints placement) {
        this.placement = placement;
    }
}
