/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.Case;
import org.game.models.GameGrid;

import java.util.Random;

public class GameGenerator {
	private static void checkNeighbors(GameGrid gameModel) {
		for(int i = 0; i < gameModel.getRows(); ++i) {
			for(int j = 0; j < gameModel.getCols(); ++j) {
				if(!gameModel.getCase(i,j).isMined()) {
					int mines = 0;
					for(int a = i-1; a <= i+1; ++a) {
						for(int b = j-1; b <= j+1; ++b) {
							if(a < 0 || a == gameModel.getRows() || b < 0 || b == gameModel.getCols()) {
								continue;
							} else {
								if(gameModel.getCase(a,b).isMined()) {
									mines++;
								}
							}
						}
					}
					gameModel.getCase(i,j).setNeighbors(mines);
				}
			}
		}
	}

	public static void randomize(GameGrid grid, int x, int y) {
		int buffer = grid.getMines();

		while(buffer > 0) {
			for(int i = 0; i < grid.getRows(); i++) {
				for(int j = 0; j < grid.getCols(); j++) {
					if(i == x && j == y) {
						continue;
					}
					if(new Random().nextInt(100) < grid.getPercent()) {
						grid.getCase(i,j).mine().resetNeighbors();
						buffer--;
					}
					if(buffer == 0) {
						checkNeighbors(grid);
						return;
					}
				}
			}
		}
		checkNeighbors(grid);
	}
}
