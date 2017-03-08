/*
    Java Project
    Deminer
    Package : org.game.controler

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.GameGrid;

public class Deminer {
	private GameGrid gameModel;
	private boolean debugMode;

	public void init() {
		this.gameModel = GameGenerator.generate();
	}

	public void update() {

	}

	public void render() {

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
		close();
	}
}
