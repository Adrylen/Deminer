package org.game.graphics.view.menu;

import org.game.graphics.view.frame.ScoreBoard;

import java.awt.event.ActionEvent;
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
