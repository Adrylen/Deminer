/*
    Java Project
    Deminer
    Package : org.game.graphics

    Created by adrylen on 10/03/17.
*/

package org.game.graphics.controller;

import org.game.controller.GameController;
import org.game.graphics.view.Window;
import org.game.models.GameGrid;

public class WindowDeminer {
	private GameController controller;
	private GameGrid gameModel;
	private Window window;

	public WindowDeminer() {
		this.window = new Window("Deminer");
		this.gameModel = new GameGrid();
		this.controller = new GameController(this.gameModel);
		this.window.main();
	}

	public void launch() {

	}
}
