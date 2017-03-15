/*
    Java Project
    Deminer
    Package : org.game.controler

    Created by adrylen on 08/03/17.
*/

package org.game.engine;

import org.game.controller.GameController;
import org.game.graphics.view.Window;
import org.game.models.GameGrid;
import org.game.vue.Console;

public class Deminer {
	private Console view;
	private GameGrid gameModel;
	private GameController controls;
	private Window window;

	private boolean end;

	public Deminer() {
		this.gameModel = new GameGrid();
		this.controls = new GameController(this.gameModel);
		this.view = new Console(this.gameModel);
		this.gameModel.addObserver(this.view);

//		this.window = new Window("Deminer");
//		this.window.main();
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
