/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.GameGrid;

import java.util.Observable;

class GameController extends Observable {
	private String[] args;
	private int[] inits;
	private boolean quitGame = false;

	public GameController() {
		this.inits = new int[3];
	}

	private boolean isInput(String command) {
		return command.length() > 0;
	}

	private boolean isShowCommand() {
		return this.args.length == 3 && this.args[0].equals("d");
	}

	private boolean isMarkCommand() {
		return this.args.length == 4 && this.args[0].equals("m");
	}

	private boolean isOtherCommand(String command) {
		if(command.equals("q")) {
			this.quitGame = true;
		} else if(command.equals("x")) {
			setChanged();
			notifyObservers();
		} else {
			return false;
		}
		return true;
	}

	public boolean gameIsClosed() {
		return this.quitGame;
	}

	private void updateModel(GameGrid gameModel, boolean show) {
		try {
			if(show) {
				gameModel.getCase(Integer.parseInt(this.args[1]), Integer.parseInt(this.args[2])).show();
			} else {
				if(this.args[3].equals("x")) {
					gameModel.getCase(Integer.parseInt(this.args[1]), Integer.parseInt(this.args[2])).markAsMined();
				} else if(this.args[3].equals("?")) {
					gameModel.getCase(Integer.parseInt(this.args[1]), Integer.parseInt(this.args[2])).markAsIndeterminate();
				} else if(this.args[3].equals("#")) {
					gameModel.getCase(Integer.parseInt(this.args[1]), Integer.parseInt(this.args[2])).unmark();
				} else {
					System.out.println("This symbol is not supported.");
					return;
				}
			}
			setChanged();
			notifyObservers(gameModel);
		} catch(NumberFormatException e) {
			System.out.println("Problème");
		}
	}

	public void manageInput(GameGrid gameModel, String command) {
		if(isInput(command)) {
			this.args = command.split(" ");
			if(isShowCommand()) {
				updateModel(gameModel, true);
			} else if(isMarkCommand()) {
				updateModel(gameModel, false);
			} else if(isOtherCommand(command)) {
				return;
			} else {
				System.out.println("Unknown or invalid command...");
				System.out.println(" => d i j   | Show a case at (i,j) position");
				System.out.println(" => m i j s | Mark a case at (i,j) position");
				System.out.println(" => q       | Quit the game");
				System.out.println(" => x       | Toggle debug mode");
			}
		}
	}

	public int[] getInits() {
		return this.inits;
	}

	public boolean manageInit(String str) {
		this.args = str.split(" ");
		if(this.args.length == 3) {
			try {
				for(int i = 0; i < inits.length; i++) {
					inits[i] = Integer.parseInt(this.args[i]);
				}
			} catch(NumberFormatException e) {
				System.out.println("Need integer inputs...");
				return false;
			}
		} else {
			System.out.println("Need three inputs...");
			return false;
		}
		return true;
	}
}
