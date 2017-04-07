/**
 * +===========================================+
 * |      ISEN CIR3 JAVA PROJECT DEMINOR       |
 * +-------------------------------------------+
 * |                  MADE BY                  |
 * |               KIEFFER Sarah               |
 * |                     &                     |
 * |              MARTINEZ Adrien              |
 * +-------------------------------------------+
 * |               PUBLISHED ON                |
 * |               7 APRIL 2017                |
 * +===========================================+
 **/

/* Package */
package org.game.controller;

/* Project Imports */
import org.game.models.GameGrid;

/* Java Imports */
import java.util.Random;

/* Here we generate the Deminor model */
class GameGenerator {
	private static void addNeighbor(GameGrid gameGrid, int i, int j) {
		for(int a = i == 0 ? i : i-1; a <= (i == gameGrid.getRows()-1 ? i : i+1); ++a) {
			for(int b = j == 0 ? j : j-1; b <= (j == gameGrid.getCols()-1 ? j : j+1); ++b) {
				if(a == i && b==j) {
					continue;
				}
				if(!gameGrid.getCase(a,b).isMined()) {
					gameGrid.getCase(a,b).addNeighbor();
				}
			}
		}
	}

	static void randomize(GameGrid grid, int x, int y) {
		int buffer = grid.getMines();

		while(buffer > 0) {
			for(int i = 0; i < grid.getRows(); i++) {
				for(int j = 0; j < grid.getCols(); j++) {
					if((i == x && j == y) || (grid.getCase(i,j).isMined())) {
						continue;
					}
					if(new Random().nextInt(100) < grid.getPercent()) {
						grid.getCase(i,j).mine().resetNeighbors();
						addNeighbor(grid,i,j);
						buffer--;
					}
					if(buffer == 0) {
						return;
					}
				}
			}
		}
	}
}
