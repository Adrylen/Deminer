/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;

/**
 *
 * @author kieffersarah
 */
public class Menu extends JMenu{
	private ScoreBoard scoreBoard;
	public Menu(String str){
		super(str);
		this.main();
	}

	public void main(){
		createSubMenu("New");
		createNewElement("High Scores");
		createNewElement("Quit");
	}

	private void createSubMenu(String str){
		this.add(new SubMenu(str));
	}

	private void createNewElement(String str){
		if(str.equals("High Scores")) {
			this.add(new JMenuItem(new AbstractAction(str) {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					scoreBoard = new ScoreBoard(str, 180, 220);
					scoreBoard.main();
//					boolean isAdded = false;
//					for(Component c : WindowDeminer.getWindow().getContentPane().getComponents()) {
//						if(c instanceof ScoreBoard) {
//							isAdded = true;
//							break;
//						}
//					}
//					if(!isAdded) {
//						WindowDeminer.getWindow().getContentPane().add(scoreBoard);
//					}
//					scoreBoard.toggleVisible();
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

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}
}
