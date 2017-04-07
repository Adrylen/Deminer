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
package org.game.graphics.view.menu;

/* Project Imports */
import org.game.graphics.view.frame.ScoreBoard;

/* Java Imports */
import java.awt.event.ActionEvent;

/* Swing Imports */
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/* This is the main menu */
public class Menu extends JMenu{
	private ScoreBoard scoreBoard;
	public Menu(String str){
		super(str);
		this.main();
	}

	private void main(){
		createSubMenu();
		createNewElement("High Scores");
		createNewElement("Quit");
	}

	private void createSubMenu(){
		this.add(new SubMenu("New"));
	}

	private void createNewElement(String str){
		if(str.equals("High Scores")) {
			this.add(new JMenuItem(new AbstractAction(str) {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					scoreBoard = new ScoreBoard(str, 180, 220);
					scoreBoard.main();
				}
			}));
		} else {
			this.add(new JMenuItem(new AbstractAction(str) {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					System.exit(0);
				}
			}));
		}
	}
}
