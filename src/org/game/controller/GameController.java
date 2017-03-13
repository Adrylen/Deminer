/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.Case;
import org.game.models.GameGrid;

public class GameController {
	private GameGrid gameModel;

	private boolean firstTurn = true;
	private boolean win = false;
	private boolean loose = false;
	private boolean quitGame = false;

	public GameController(GameGrid gameModel) {
		this.gameModel = gameModel;
	}

	public boolean gameIsClosed() {
		return this.quitGame;
	}

	public boolean isLoose() {
		return this.loose;
	}

	public boolean isWin() {
		return this.win;
	}

	public boolean createGrid(String str) {
		String[] args = str.split(" ");
		if(args.length == 3) {
			try {
				int rows = InputController.getInit(args[0], 10, 100);
				int cols = InputController.getInit(args[1], 10, 100);
				int percent = InputController.getInit(args[2], 10, 85);
				this.gameModel.setGrid(rows, cols)
						.setPercent(percent)
						.update();
				return true;
			} catch(NumberFormatException e) {
				System.out.println("Need integer inputs...");
				return false;
			}
		} else {
			System.out.println("Need three inputs...");
			return false;
		}
	}

	private void show(int i, int j) {
		if(this.firstTurn) {
			GameGenerator.randomize(this.gameModel, i, j);
			this.firstTurn = false;
		}
		if(this.gameModel.getCase(i,j).isHidden()) {
			this.gameModel.getCase(i,j).show();
			if(!this.gameModel.getCase(i,j).hasNeighbors()) {
				this.show((i == 0) ? i : i-1, j);
				this.show((i == this.gameModel.getRows()-1) ? i : i+1, j);
				this.show(i, (j == 0) ? j : j-1);
				this.show(i, (j == this.gameModel.getCols()-1) ? j : j+1);
			}
		}
	}

	private void updateModel(String[] args, boolean show) {
		int i, j;
		try {
			i = Integer.parseInt(args[1]);
			j = Integer.parseInt(args[2]);
		} catch(NumberFormatException e) {
			System.out.println("Second and third arguments must be integers...");
			return;
		}
		if(show) {
			this.show(i, j);
		} else {
			switch(args[3]) {
				case "x": this.gameModel.getCase(i,j).markAsMined();         break;
				case "?": this.gameModel.getCase(i,j).markAsIndeterminate(); break;
				case "#": this.gameModel.getCase(i,j).unmark();              break;
				default :
					System.out.println("This symbol is not supported.");
					return;
			}
		}
		this.gameModel.update();
	}

	private void manageOtherCommand(String command) {
		if(command.equals("q")) {
			this.quitGame = true;
		} else if(command.equals("x")) {
			this.gameModel.toggleDebug();
		}
	}

	public void manageInput(String command) {
		InputController in = new InputController();
		if(in.isInput(command)) {
			String[] args = command.split(" ");
			if(in.isShowCommand(args)) {
				updateModel(args, true);
			} else if(in.isMarkCommand(args)) {
				updateModel(args, false);
			} else if(in.isOtherCommand(command)) {
				manageOtherCommand(command);
			} else {
				System.out.println("Unknown or invalid command...\n"+
					" => d i j   | Show a case at (i,j) position\n"+
					" => m i j s | Mark a case at (i,j) position\n"+
					" => q       | Quit the game\n"+
					" => x       | Toggle debug mode"
				);
			}
		}
	}

	public void checkVictory() {
		for(Case[] row : this.gameModel.getGrid()) {
			for(Case gameCase : row) {
				if(gameCase.isHidden()) {
					if(!gameCase.hasNeighbors() || (gameCase.isMined() && !gameCase.isMarkedAsMined())) {
						return;
					}
				} else {
					if(gameCase.isMined()) {
						this.loose = true;
						System.out.println("You loose...");
						return;
					}
				}
			}
		}
		this.win = true;
		System.out.println("You WIN !!!");
	}
}
