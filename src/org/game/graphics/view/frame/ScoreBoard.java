package org.game.graphics.view.frame;

import org.game.models.Scores;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* This permits to the player to see
* all the high scores of the Deminor.
* All difficulties are linked, so only
* Beginner time can actually be saved.
* (But if you're not a great player,
* may be an Expert can win faster than you.
*/
public class ScoreBoard extends JFrame {
	private GridBagConstraints placement;
	private JLabel[] highScores;
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
		this.setVisible(true);
	}
}
