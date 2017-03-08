/*
    Java Project
    Deminer
    Package : org.game.controler

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.GameGrid;
import org.game.vue.Console;

public class Deminer {
	private Console console;
	private GameGrid gameModel;
	private GameController controls;

	private boolean debugMode;
	private boolean end;

	public Deminer() {
		this.controls = new GameController();
		this.console = new Console(this.controls);
		this.controls.addObserver(this.console);
		this.end = false;
	}

	public void init() {
		String inits = "";
		do {
			inits = this.console.getInitialisation();
		} while(!this.controls.manageInit(inits));

		this.gameModel = GameGenerator.generate(this.controls.getInits());
		this.console.display(this.gameModel);
	}

	public void update() {
		this.controls.manageInput(this.gameModel, this.console.getInstructions());
		this.end = controls.gameIsClosed();
	}

	public void close() {
		this.console.display(this.gameModel);
	}

	public void run() {
		init();
		do {
			update();
		} while(!this.end);
//		close();
	}
}
