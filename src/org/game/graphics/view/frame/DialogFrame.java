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
package org.game.graphics.view.frame;

/* Project Imports */
import org.game.graphics.engine.WindowDeminer;

/* Swing Imports */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* This dialog frame appears when the player loose
* or win and permits him to enter his pseudo,
* restart or quit.
*/
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
