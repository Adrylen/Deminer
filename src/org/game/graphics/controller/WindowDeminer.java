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

	private static boolean templateLevel = false;

	private static int[] levelData;

	public static void init() {
		window = new Window("Deminer", 1100, 700);
	}

	public static void create(NewGame level) {
		actualLevel = level;
		if(actualLevel == NewGame.CUSTOM) {
			create(levelData);
		} else {
			templateLevel = true;
			create(new int[]{level.rows(), level.cols(), level.mines()});
		}
	}

	public static void create(int[] level) {
		if(!templateLevel) {
			actualLevel = NewGame.CUSTOM;
		}
		templateLevel = false;
		levelData = level;

		gameModel = new GameGrid();
		gameModel.setGrid(levelData[0],levelData[1]).setMines(level[2]);

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
		create(NewGame.BEGINNER);
	}
        
	public static Window getWindow() {
            return window;
        }
}
