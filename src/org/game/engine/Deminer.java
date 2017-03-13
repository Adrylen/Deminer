/*
    Java Project
    Deminer
    Package : org.game.controler

    Created by adrylen on 08/03/17.
*/

package org.game.engine;

import org.game.controller.GameController;
import org.game.models.GameGrid;
import org.game.vue.Console;

public class Deminer {
	private Console view;
	private GameGrid gameModel;
	private GameController controls;

	private boolean end;

	public Deminer() {
		this.gameModel = new GameGrid();
		this.controls = new GameController();
		this.view = new Console(this.controls);
		this.controls.addObserver(this.view);
		this.end = false;
	}

	private void init() {
		StringBuilder inits = new StringBuilder();
		do {
			inits.delete(0,inits.length()).append(this.view.getInitialisation());
		} while(!this.controls.createGrid(this.gameModel, inits.toString()));
	}

	private void update() {
		this.controls.manageInput(this.gameModel, this.view.getInstructions());
		this.controls.checkVictory(this.gameModel);
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
