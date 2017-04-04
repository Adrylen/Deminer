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
	private static Console console;
	private static GameController controller;
	private static GameGrid gameModel;
	private static Window window;

	public static void init() {
		gameModel = new GameGrid();
		controller = new GameController(gameModel);
		window = new Window("Deminer", 600, 500);
		console = new Console(gameModel);

		gameModel.addObserver(window);
		gameModel.addObserver(console);
	}

	public static void create() {
		gameModel.setGrid(10,10).setPercent(10);
		//GameGenerator.randomize(gameModel, 0, 0);

		window.setObservable(gameModel);
		window.useController(controller);
		window.main();

		gameModel.update();
	}
        
        public static Window getWindow() {
            return window;
        }
}
