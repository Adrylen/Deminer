/*
 *   Java Project
 *   Project
 *   Package : org.game.graphics.view
 *   Created by adrylen on 05/04/17.
*/

package org.game.graphics.view;

import org.game.models.Scores;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ScoreBoard extends JFrame {
	private GridBagConstraints placement;
	private JLabel[] highScores;
	private ScoreBoard SB = this;
	private boolean visible = true;
	private int y = 0;

	public ScoreBoard(String str, int width, int height) {
		super(str);
		this.highScores = new JLabel[Scores.LENGTH];
		this.placement = new GridBagConstraints();
		this.placement.gridx = 0;

		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(width, height));
	}

	private void addScores() {
		Scores scores = Scores.read();

		for(int i = 0; i < Scores.LENGTH; ++i) {
			highScores[i] = new JLabel((i+1)+". "+scores.getPseudo(i)+" : "+scores.getScore(i));
			this.placement.weighty = 0.5;
			this.placement.gridy = y++;
			this.add(highScores[i], this.placement);
		}
	}

	public void main() {
		this.addScores();
//
//		this.placement.gridy = y;
//		this.placement.weighty = 0.2;
//		this.add(new JButton(new AbstractAction("Close") {
//			@Override
//			public void actionPerformed(ActionEvent actionEvent) {
//				SB.dispose();
//			}
//		}), this.placement);

		this.setVisible(true);
	}

//	public void toggleVisible() {
//		visible = !visible;
//	}

	public void update() {
		Scores scores = Scores.read();
		for(int i = 0; i < Scores.LENGTH-1; ++i) {
			highScores[i].setText((i+1)+". "+scores.getPseudo(i)+" : "+scores.getScore(i));
		}
	}
}
