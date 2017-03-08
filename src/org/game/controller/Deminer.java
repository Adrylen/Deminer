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
	private GameGrid gameModel;
	private boolean debugMode;

	private boolean end;

	public void init() {
		this.gameModel = GameGenerator.generate();
		this.end = false;
	}

	public void update() {
		//GameController.manageInput("");

		this.end = true;
	}

	public void render() {
		Console.display(this.gameModel);
	}

	public void close() {
		render();
	}

	public void run() {
		init();
		do {
			render();
			update();
		} while(!this.end);
//		close();
	}
}
