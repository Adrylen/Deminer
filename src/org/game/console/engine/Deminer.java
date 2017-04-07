package org.game.console.engine;

import org.game.console.view.Console;
import org.game.controller.GameController;
import org.game.models.GameGrid;

// TODO Comments
public class Deminer {
	private Console view;
	private GameGrid gameModel;
	private GameController controls;

	private boolean end;

	public Deminer() {
		this.gameModel = new GameGrid();
		this.controls = new GameController(this.gameModel);
		this.view = new Console(this.gameModel);
		this.gameModel.addObserver(this.view);

		this.end = false;
	}

	private void init() {
		StringBuilder inits = new StringBuilder();
		do {
			inits.delete(0,inits.length())
				.append(this.view.getInitialisation());
		} while(!this.controls.createGrid(inits.toString()));
	}

	private void update() {
		this.controls.manageInput(this.view.getInstructions());
		this.controls.checkVictory();
		this.end = this.controls.gameIsClosed() || this.controls.isLoose() || this.controls.isWin();
	}

	private void close() {
		this.view.displayBug(this.gameModel);
	}

	public void launch() {
		init();
		do {
			update();
		} while(!this.end);
		close();
	}
}
