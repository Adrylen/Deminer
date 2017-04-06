/*
 *   Java Project
 *   Project
 *   Package : org.game.graphics.view
 *   Created by adrylen on 05/04/17.
*/

package org.game.graphics.view;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

public class ScoreBoard extends JInternalFrame{
	private GridBagConstraints placement;
	private ScoreBoard SB = this;
	private boolean visible = true;
	private int y = 0;

	public ScoreBoard(String str, int width, int height) {
		super(str);
		this.placement = new GridBagConstraints();
		this.placement.gridx = 0;

		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
	}

	private JLabel addScore(String str) {
		JLabel score = new JLabel(str);

		this.placement.weighty = 0.5;
		this.placement.gridy = y++;

		return score;
	}

	public void main() {
		this.add(addScore("1. Adrien M"), this.placement);
		this.add(addScore("2. Sarah"), this.placement);
		this.add(addScore("3. Valentin"), this.placement);
		this.add(addScore("24581. Adrien L"), this.placement);

		this.placement.gridy = y;
		this.placement.weighty = 0.2;
		this.add(new JButton(new AbstractAction("Close") {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				SB.toggleVisible();
			}
		}), this.placement);
	}

	public void toggleVisible() {
		this.setVisible(visible);
		visible = !visible;
	}
}
