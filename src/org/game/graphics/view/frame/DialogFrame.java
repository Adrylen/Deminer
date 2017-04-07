/*
 *   Java Project
 *   Project
 *   Package : org.game.graphics.view
 *   Created by adrylen on 05/04/17.
*/

package org.game.graphics.view.frame;

import org.game.graphics.engine.WindowDeminer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogFrame {
	private static final int RESTART_OPTION = 0;
	private static final int QUIT_OPTION = 1;

	public static void alert(JFrame frame, boolean win) {
		int action = JOptionPane.showOptionDialog(
			frame,
			win ? "Thanks for playing !" : "You loose...",
			"End of the game",
			JOptionPane.DEFAULT_OPTION,
			win ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE,
			null,
			new Object[]{"Restart", "Quit"},
			null
		);
		if(action == RESTART_OPTION) {
			WindowDeminer.create(WindowDeminer.getActualLevel());
		} else if(action == QUIT_OPTION) {
			System.exit(0);
		}
	}

	public static String askPseudo(JFrame frame) {
		return JOptionPane.showInputDialog(frame, "YOU WIN !!!\nPseudo");
	}
}
