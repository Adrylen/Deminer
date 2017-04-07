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

/* Project Imports */
import org.game.controller.Timer;
import org.game.graphics.events.MouseEventListener;

/* Java Imports */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;

/* Swing Imports */
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* Interface Imports */
import java.util.Observer;
import javax.swing.SwingConstants;

/* This panel is at the bottom of the window.
* It gives to the player the timer but also
* the number of remaining mines.
* It permits also to restart a party if the player
* clicks on the bear smiley.
*/
public class InfoPanel extends JPanel implements Observer {
	private GridBagConstraints placement;
	private JLabel mines;
	private JLabel timerLabel;
	private JButton smiley;
	private Timer timer;

	public InfoPanel() {
		this.placement = new GridBagConstraints();
		this.placement.ipadx = 0;
		this.placement.fill = GridBagConstraints.HORIZONTAL;

		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

		this.addCounter();
		this.addSmiley();
		this.addTimer();
	}

	private void addCounter() {
		mines = new JLabel("Mines : -1");
		mines.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

		this.placement.weightx = 0.5;
		this.placement.gridx = 0;
		this.placement.gridy = 0;

		this.add(mines, this.placement);
	}

	private void addSmiley() {
		smiley = new JButton();
		smiley.addMouseListener(new MouseEventListener(null));

		this.placement.weightx = 0.005;
		this.placement.gridx = 1;
		this.placement.gridy = 0;

		this.add(smiley, this.placement);
	}

	private void addTimer() {
		timerLabel = new JLabel("Time : 0");
		timerLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		timerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

		timer = new Timer(this);

		this.placement.weightx = 0.5;
		this.placement.gridx = 2;
		this.placement.gridy = 0;

		this.add(timerLabel, this.placement);
	}

	public void updateMines(int value) {
		mines.setText("Mines : "+value);
	}

	public Timer getTimer() {
		return timer;
	}

	public void setSmiley(String str) {
		smiley.setText(str);
	}

	@Override
	public void update(Observable observable, Object o) {
		timerLabel.setText("Time : "+timer.getTime());
	}
}
