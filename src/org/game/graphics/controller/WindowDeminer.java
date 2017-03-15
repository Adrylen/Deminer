/*
    Java Project
    Deminer
    Package : org.game.graphics

    Created by adrylen on 10/03/17.
*/

package org.game.graphics.controller;

import org.game.controller.GameController;
import org.game.controller.GameGenerator;
import org.game.graphics.view.Window;
import org.game.models.GameGrid;
import org.game.vue.Console;

public class WindowDeminer {
	private Console console;
	private GameController controller;
	private GameGrid gameModel;
	private Window window;

	public WindowDeminer() {
		this.gameModel = new GameGrid();
		this.controller = new GameController(this.gameModel);
		this.window = new Window("Deminer", 500, 500);
		this.console = new Console(this.gameModel);

		this.gameModel.addObserver(this.window);
		this.gameModel.addObserver(this.console);
	}

	private void init() {
		this.gameModel.setGrid(10,10).setPercent(10);
		GameGenerator.randomize(this.gameModel, 0, 0);

		this.window.setObservable(this.gameModel);
		this.window.useController(this.controller);
		this.window.main();

		this.gameModel.update();
	}

	private void loop() {

	}

	public void launch() {
		init();
		loop();
	}
}
