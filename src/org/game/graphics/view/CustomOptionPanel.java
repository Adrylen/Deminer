/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author kieffersarah
 */
public class CustomOptionPanel extends JPanel{
    
    private String str;
    private int min;
    private int max;
    private int secondMax;
    private int value;
    private int minor;
    private int major;
    private JSlider slider = null;
    private JLabel label = null;
    private JTextField text = null;
    public Dimension dim= new Dimension(30,20);
    private CustomOptionPanel ui = this;
    
    public CustomOptionPanel(String str, int min, int max, int value, int minor, int major){
        this.setMin(min);
        this.setMax(max);
        this.setMinor(minor);
        this.setMajor(major);
        this.setStr(str);
        this.setValue(value);
        this.setSecondMax(max);
    }
    
    public CustomOptionPanel init(){
        
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
        slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                ui.setValue(slider.getValue());
                ui.setStr(String.valueOf(value));
                text.setText(str);
            }
        });
        addC(this, slider, 0, 1, 1, 1, GridBagConstraints.WEST);
    }
    
    private void addLabel(){
        label = new JLabel(str);
        addC(this, label, 0, 0, 1, 1, GridBagConstraints.WEST);
    }
    
    private void addText(){
        text = new JTextField(String.valueOf(value),3);
        text.setEnabled(false);
	text.setHorizontalAlignment(SwingConstants.TRAILING);
        /*text.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e){
                ui.setStr(text.getText());
                ui.setValue(Integer.parseInt(str));
                slider.setValue(value);
            }
            @Override
            public void removeUpdate(DocumentEvent e){
                
            }
            @Override
            public void insertUpdate(DocumentEvent e){
                ui.setStr(text.getText());
                ui.setValue(Integer.parseInt(str));
                slider.setValue(value);
            }
        });*/
        addC(this, text, 1, 1, 1, 1, GridBagConstraints.EAST);
    }
    
    public void addC(JPanel p, JComponent c, int x, int y, int width, int height, int anchor){
        GridBagConstraints placement = new GridBagConstraints();
        placement.weightx = 100.0;
        placement.weighty = 100.0;
	placement.gridx = x;
	placement.gridy = y;
        placement.gridwidth = width;
        placement.gridheight = height;
        placement.insets = new Insets(5,5,5,5);
        placement.anchor = anchor;
        placement.fill = GridBagConstraints.NONE;
	p.add(c, placement);
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
     * @return the secondMax
     */
    public int getSecondMax() {
        return secondMax;
    }

    /**
     * @param secondMax the secondMax to set
     */
    public void setSecondMax(int secondMax) {
        this.secondMax = secondMax;
    }
}
