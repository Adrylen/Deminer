package org.game.graphics.engine;

import org.game.controller.GameController;
import org.game.graphics.view.Window;
import org.game.models.GameGrid;
import org.game.models.NewGame;

/* Here we initialize the graphical version */
public class WindowDeminer {
	private static NewGame actualLevel;
	private static Window window;

	private static boolean templateLevel = false;

	private static int[] levelData;

	private static void init() {
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

		GameGrid gameModel = new GameGrid();
		gameModel.setGrid(levelData[0],levelData[1]).setMines(levelData[2]);
		gameModel.addObserver(window);

		GameController controller = new GameController(gameModel);

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
}
