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

public class GameController extends Observable {
	private boolean firstTurn = true;
	private boolean win = false;
	private boolean loose = false;
	private boolean quitGame = false;

	public boolean gameIsClosed() {
		return this.quitGame;
	}

	public boolean isLoose() {
		return this.loose;
	}

	public boolean isWin() {
		return this.win;
	}

	public boolean createGrid(GameGrid gameGrid, String str) {
		String[] args = str.split(" ");
		setChanged();
		if(args.length == 3) {
			try {
				int rows = InputController.getInit(args[0], 10, 100);
				int cols = InputController.getInit(args[1], 10, 100);
				int percent = InputController.getInit(args[2], 10, 85);
				gameGrid.setGrid(rows, cols).setPercent(percent);
				notifyObservers(gameGrid);
				return true;
			} catch(NumberFormatException e) {
				notifyObservers("Need integer inputs...");
				return false;
			}
		} else {
			notifyObservers("Need three inputs...");
			return false;
		}
	}

	private void show(GameGrid gameModel, int i, int j) {
		if(this.firstTurn) {
			GameGenerator.randomize(gameModel, i, j);
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

	private void updateModel(GameGrid gameModel, String[] args, boolean show) {
		int i, j;
		setChanged();
		try {
			i = Integer.parseInt(args[1]);
			j = Integer.parseInt(args[2]);
		} catch(NumberFormatException e) {
			notifyObservers("Second and third arguments must be integers...");
			return;
		}
		if(show) {
			this.show(gameModel, i, j);
		} else {
			switch(args[3]) {
				case "x": gameModel.getCase(i,j).markAsMined();         break;
				case "?": gameModel.getCase(i,j).markAsIndeterminate(); break;
				case "#": gameModel.getCase(i,j).unmark();              break;
				default :
					notifyObservers("This symbol is not supported.");
					return;
			}
		}
		notifyObservers(gameModel);
	}

	private void manageOtherCommand(String command) {
		if(command.equals("q")) {
			this.quitGame = true;
		} else if(command.equals("x")) {
			setChanged();
			notifyObservers();
		}
	}

	public void manageInput(GameGrid gameModel, String command) {
		InputController in = new InputController();
		if(in.isInput(command)) {
			String[] args = command.split(" ");
			if(in.isShowCommand(args)) {
				updateModel(gameModel, args, true);
			} else if(in.isMarkCommand(args)) {
				updateModel(gameModel, args, false);
			} else if(in.isOtherCommand(command)) {
				manageOtherCommand(command);
			} else {
				setChanged();
				notifyObservers("Unknown or invalid command...\n"+
					" => d i j   | Show a case at (i,j) position\n"+
					" => m i j s | Mark a case at (i,j) position\n"+
					" => q       | Quit the game\n"+
					" => x       | Toggle debug mode"
				);
			}
		}
	}

	public void checkVictory(GameGrid gameModel) {
		for(Case[] row : gameModel.getGrid()) {
			for(Case gameCase : row) {
				if(gameCase.isHidden()) {
					return;
				} else {
					if(gameCase.isMined()) {
						this.loose = true;
						setChanged();
						notifyObservers("You loose...");
						return;
					}
				}
			}
		}
		this.win = true;
		setChanged();
		notifyObservers("You WIN !!!");
	}
}
