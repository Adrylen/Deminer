/*
 *   Java Project
 *   Project
 *   Package : org.game.graphics.view
 *   Created by adrylen on 05/04/17.
*/

package org.game.graphics.view;

import org.game.graphics.controller.WindowDeminer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogFrame {
	public static final int RESTART_OPTION = 0;
	public static final int QUIT_OPTION = 1;

	public static void alert(JFrame frame, boolean win) {
		int action = JOptionPane.showOptionDialog(
			frame,
			win ? "You Win !!!" : "You loose...",
			"End of the game",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.ERROR_MESSAGE,
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
}
