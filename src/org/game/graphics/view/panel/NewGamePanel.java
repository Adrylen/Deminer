/**
 * +===========================================+
 * |      ISEN CIR3 JAVA PROJECT DEMINOR       |
 * +-------------------------------------------+
 * |                  MADE BY                  |
 * |               KIEFFER Sarah               |
 * |                     &                     |
 * |              MARTINEZ Adrien              |
 * +-------------------------------------------+
 * |               PUBLISHED ON                |
 * |               7 APRIL 2017                |
 * +===========================================+
 **/

/* Package */
package org.game.graphics.view.panel;

/* Java Imports */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;

/* Swing Imports */
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/* Here we set the different elements of the new game menu */
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

	private void main(){
		create();
		getChoice().setLayout(new GridLayout(5,1));
		getGroup().add(getBeginner());
		getGroup().add(getIntermediate());
		getGroup().add(getExpert());
		getGroup().add(getCust());
		this.getCustom().getPanelR().getSlider().addChangeListener(e -> updateMineSlider());

		this.getCustom().getPanelC().getSlider().addChangeListener(e -> updateMineSlider());
		this.setLayout(new GridBagLayout());
		addC(getChoice(), getSelect(), 0, GridBagConstraints.WEST);
		addC(getChoice(), getBeginner(), 1, GridBagConstraints.WEST);
		addC(getChoice(), getIntermediate(), 2, GridBagConstraints.WEST);
		addC(getChoice(), getExpert(), 3, GridBagConstraints.WEST);
		addC(getChoice(), getCust(), 4, GridBagConstraints.WEST);
		addC(this, getChoice(), 0, GridBagConstraints.CENTER);
		addC(this, getCustom(), 1, GridBagConstraints.CENTER);
		addC(this, getStart(), 2, GridBagConstraints.CENTER);
		addC(this, getCancel(), 3, GridBagConstraints.CENTER);


	}

	private void addC(JPanel p, JComponent c, int y, int anchor){
		GridBagConstraints placement = new GridBagConstraints();
		placement.weightx = 100.0;
		placement.weighty = 100.0;
		placement.gridx = 0;
		placement.gridy = y;
		placement.gridwidth = 1;
		placement.gridheight = 1;
		placement.insets = new Insets(5,5,5,5);
		placement.anchor = anchor;
		placement.fill = GridBagConstraints.NONE;
		p.add(c, placement);
	}

	private void create(){
		this.getCust().addItemListener(e -> {
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
		});
	}

	private void updateMineSlider() {
		int i = (int) Math.ceil(getCustom().getPanelR().getSlider().getValue()*getCustom().getPanelC().getSlider().getValue()*0.85);
		if(i<getCustom().getPanelM().getSlider().getValue()){
			getCustom().getPanelM().setSecondMax(i);
			getCustom().getPanelM().getSlider().setMaximum(i);
			getCustom().getPanelM().setMax(i);
			getCustom().getPanelM().getSlider().setValue(i);
		}
		if(i>getCustom().getPanelM().getSecondMax() && i<getCustom().getPanelM().getMax()){
			getCustom().getPanelM().getSlider().setMaximum(i);
			getCustom().getPanelM().setMax(i);
		}
		if(i>getCustom().getPanelM().getMax()){
			getCustom().getPanelM().getSlider().setMaximum(getCustom().getPanelM().getMax());
			getCustom().getPanelM().setMax(i);
		}
	}

	public CustomGamePanel getCustom() {
		return custom;
	}

	private JPanel getChoice() {
		return choice;
	}

	public JRadioButton getBeginner() {
		return beginner;
	}

	public JRadioButton getIntermediate() {
		return intermediate;
	}

	public JRadioButton getExpert() {
		return expert;
	}

	public JRadioButton getCust() {
		return cust;
	}

	private JLabel getSelect() {
		return select;
	}

	private ButtonGroup getGroup() {
		return group;
	}

	public JButton getStart() {
		return start;
	}

	public JButton getCancel() {
		return cancel;
	}
}
