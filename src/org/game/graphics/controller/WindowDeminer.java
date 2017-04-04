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
import org.game.models.NewGame;

public class WindowDeminer {
	private static GameController controller;
	private static GameGrid gameModel;
	private static NewGame actualLevel;
	private static Window window;

	public static void init() {
		window = new Window("Deminer", 1100, 700);
	}

	public static void create(NewGame level) {
		actualLevel = level;

		gameModel = new GameGrid();
		gameModel.setGrid(level.rows(), level.cols()).setMines(level.mines());

		controller = new GameController(gameModel);

		gameModel.addObserver(window);
		window.setObservable(gameModel);
		window.useController(controller);

		window.main();
		gameModel.update();
	}

	public static NewGame getActualLevel() {
		return actualLevel;
	}

	public static void launch() {
		init();
		create(NewGame.EXPERT);
	}
}
