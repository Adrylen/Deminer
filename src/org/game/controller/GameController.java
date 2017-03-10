/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.Case;
import org.game.models.GameGrid;

import java.util.Observable;

class GameController extends Observable {
	private String[] args;
	private int[] inits;
	private boolean firstTurn = true;
	private boolean win = false;
	private boolean loose = false;
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

	private void show(GameGrid gameModel, int i, int j) {
		if(this.firstTurn) {
			GameGenerator.randomize(gameModel, this.inits[2]);
			this.firstTurn = false;
		}
		if(gameModel.getCase(i,j).isHidden()) {
			gameModel.getCase(i,j).show();
			if(!gameModel.getCase(i,j).hasNeighbors()) {
				int iMin = (i == 0) ? i : i-1,
					jMin = (j == 0) ? j : j-1,
					iMax = (i == gameModel.getRows()-1) ? i : i+1,
					jMax = (j == gameModel.getCols()-1) ? j : j+1;
				for(int a = iMin; a <= iMax; a++) {
					for (int b = jMin; b <= jMax; b++) {
						this.show(gameModel, a, b);
					}
				}
			}
		}
	}

	private void updateModel(GameGrid gameModel, boolean show) {
		try {
			if(show) {
				this.show(gameModel, Integer.parseInt(this.args[1]), Integer.parseInt(this.args[2]));
//				gameModel.getCase(Integer.parseInt(this.args[1]), Integer.parseInt(this.args[2])).show();
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

	public boolean manageInit(GameGrid gameGrid, String str) {
		this.args = str.split(" ");
		if(this.args.length == 3) {
			try {
				int init0 = Integer.parseInt(this.args[0]),
					init1 = Integer.parseInt(this.args[1]),
					init2 = Integer.parseInt(this.args[2]);
				inits[0] = (init0 <= 100) ? (init0 >= 10) ? init0 : 10 : 100;
				inits[1] = (init1 <= 100) ? (init1 >= 10) ? init1 : 10 : 100;
				inits[2] = (init2 <= 85) ? (init2 >= 10) ? init2 : 10 : 85;
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

	public void checkVictory(GameGrid gameModel) {
		for(Case[] row : gameModel.getGrid()) {
			for(Case gameCase : row) {
				if(gameCase.isHidden() && gameCase.isMined() && !gameCase.isMarkedAsMined()) {
					return;
				} else if(!gameCase.isHidden() && gameCase.isMined()) {
					this.loose = true;
					setChanged();
					notifyObservers("You loose...");
					return;
				} else if(gameCase.isHidden() && !gameCase.hasNeighbors()) {
					return;
				}
			}
		}
		this.win = true;
		setChanged();
		notifyObservers("You WIN !!!");
	}

	public boolean isLoose() {
		return this.loose;
	}

	public boolean isWin() {
		return this.win;
	}
}
