package org.game.graphics.view.component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import java.awt.event.FocusListener;
import javax.swing.SwingConstants;

/* Here we create and control one element of the subsection
 * The listeners are used to link up the different elements
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
    private JTextField text = null;
    private CustomOptionPanel ui = this;
    
    public CustomOptionPanel(String str, int min, int max, int initial_value, int minor, int major){
        this.setMin(min);
        this.setMax(max);
        this.setMinor(minor);
        this.setMajor(major);
        this.setStr(str);
        this.setValue(initial_value);
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
        slider.addChangeListener(e -> {
            ui.setValue(slider.getValue());
            ui.setStr(String.valueOf(value));
            text.setText(str);
        });
        addC(this, slider, 0, 1, GridBagConstraints.WEST);
    }
    
    private void addLabel(){
        addC(this, new JLabel(str+" : "), 0, 0, GridBagConstraints.WEST);
    }
    
    private void addText(){
        text = new JTextField(String.valueOf(value),3);
        text.setEnabled(false);
	text.setHorizontalAlignment(SwingConstants.TRAILING);
		text.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent focusEvent) {}
			@Override
			public void focusLost(FocusEvent focusEvent) {
				try {
					if(Integer.parseInt(text.getText()) < min) {
						text.setText(min+"");
					} else if(Integer.parseInt(text.getText()) > max) {
						text.setText(max+"");
					}
				} catch (NumberFormatException e) {
					text.setText(min+"");
				}
				slider.setValue(Integer.parseInt(text.getText()));
			}
		});
        addC(this, text, 1, 1, GridBagConstraints.EAST);
    }
    
    private void addC(JPanel p, JComponent c, int x, int y, int anchor){
        GridBagConstraints placement = new GridBagConstraints();
        placement.weightx = 100.0;
        placement.weighty = 100.0;
	placement.gridx = x;
	placement.gridy = y;
        placement.gridwidth = 1;
        placement.gridheight = 1;
        placement.insets = new Insets(5,5,5,5);
        placement.anchor = anchor;
        placement.fill = GridBagConstraints.NONE;
	p.add(c, placement);
    }

    public void setStr(String str) {
        this.str = str;
    }

    private int getMin() {
        return min;
    }

    private void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    private int getValue() {
        return value;
    }

    private void setValue(int value) {
        this.value = value;
    }

    private void setMinor(int minor) {
        this.minor = minor;
    }

    private void setMajor(int major) {
        this.major = major;
    }

    public JSlider getSlider() {
        return slider;
    }

    public JTextField getText() {
        return text;
    }

    public int getSecondMax() {
        return secondMax;
    }

    public void setSecondMax(int secondMax) {
        this.secondMax = secondMax;
    }
}
