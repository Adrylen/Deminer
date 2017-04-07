package org.game.controller;

import org.game.models.Case;
import org.game.models.GameGrid;

/* Here we check if the player win or loose,
 * how many mines there are around a case,
 * and we update the model
*/
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

	public boolean isStarted() {
		return !this.firstTurn;
	}

	public boolean createGrid(String str) {
		String[] args = str.split(" ");
		if(args.length == 3) {
			try {
				int rows = InputController.getInit(args[0], InputController.MIN_VALUE, 100);
				int cols = InputController.getInit(args[1], InputController.MIN_VALUE, 100);
				int percent = InputController.getInit(args[2], InputController.MIN_VALUE, 85);
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
		Case gameCase = this.gameModel.getCase(i,j);
		if(gameCase.isHidden()) {
			gameCase.show();
			if(!gameCase.hasNeighbors() && !gameCase.isMined()) {
				for(int a = i == 0 ? i : i-1; a <= (i == this.gameModel.getRows()-1 ? i : i+1); ++a) {
					for(int b = j == 0 ? j : j-1; b <= (j == this.gameModel.getCols()-1 ? j : j+1); ++b) {
						this.show(a,b);
					}
				}
			}
		}
	}

	public void showNeighbors(Case gameCase) {
		if(!gameCase.isMined()) {
			int[] position = this.gameModel.getCasePosition(gameCase);
			int mines = 0;
			for(int a = position[0]-1; a <= position[0]+1; a++) {
				if(!(a < 0 || a >= this.gameModel.getRows())) {
					for(int b = position[1]-1; b <= position[1]+1; b++) {
						if(!(b < 0 || b >= this.gameModel.getCols()) && !(a == position[0] && b == position[1])) {
							if(this.gameModel.getCase(a,b).isMarkedAsMined()) {
								mines++;
							}
						}
					}
				}
			}
			if(mines == gameCase.getNeighbors()) {
				for(int a = position[0]-1; a <= position[0]+1; a++) {
					if(!(a < 0 || a >= this.gameModel.getRows())) {
						for(int b = position[1]-1; b <= position[1]+1; b++) {
							if(!(b < 0 || b >= this.gameModel.getCols()) && !(a == position[0] && b == position[1])) {
								if(!this.gameModel.getCase(a,b).isMarkedAsMined() && this.gameModel.getCase(a,b).isHidden()) {
									show(a,b);
								}
							}
						}
					}
				}
				checkVictory();
				this.gameModel.update();
			}
		}
	}

	private void showAll() {
		for(int i = 0; i < this.gameModel.getRows(); i++) {
			for(int j = 0; j < this.gameModel.getCols(); j++) {
				if(this.gameModel.getCase(i,j).isMined() && this.loose) {
					this.gameModel.getCase(i,j).show();
				} else if(!this.gameModel.getCase(i,j).isMined() && this.win) {
					this.gameModel.getCase(i,j).show();
				}
			}
		}
	}

	public void updateModel(Case gameCase, boolean show) {
		int[] position = this.gameModel.getCasePosition(gameCase);
		if(show) {
			this.show(position[0], position[1]);
		} else {
			if(gameCase.isMarkedAsMined()) {
				gameCase.markAsIndeterminate();
			} else if(gameCase.isMarkedAsIndeterminate()) {
				gameCase.unmark();
			} else {
				gameCase.markAsMined();
			}
		}
		checkVictory();
		this.gameModel.update();
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
		this.win = true;
		for(Case[] row : this.gameModel.getGrid()) {
			for(Case gameCase : row) {
				if(!gameCase.isHidden() && gameCase.isMined()) {
						this.loose = true;
						showAll();
						return;
				} else if(gameCase.isHidden() && gameCase.isMined() && !gameCase.isMarkedAsMined()) {
					this.win = false;
				} else if(gameCase.isHidden() && !gameCase.isMined() &&!gameCase.hasNeighbors()) {
					this.win = false;
				}
			}
		}
		if(this.win) {
			showAll();
		}
	}
}
