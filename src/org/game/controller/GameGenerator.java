/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.GameGrid;

import java.util.Random;

class GameGenerator {
	private static final int MIN_ROWS = 10;
	private static final int MIN_COLS = 10;
	private static final int MIN_PERCENT = 10;
	private static GameGrid grid;

	private static void addNeighbors(int i, int j) {
		for(int a = i-1; a <= i+1; a++) {
			if(a < 0 || a >= grid.getRows()) {
				continue;
			}
			for(int b = j-1; b <= j+1; b++) {
				if(b < 0 || b >= grid.getCols()) {
					continue;
				}
				grid.getCase(a,b).addNeighbor();
			}
		}
	}

	private static void randomize(int percent) {
		int buffer = (int)(grid.getSize() * percent / 100.0);

		while(buffer > 0) {
			for(int i = 0; i < grid.getRows(); i++) {
				for(int j = 0; j < grid.getCols(); i++) {
					if(new Random().nextInt(100) < percent) {
						grid.getCase(i,j).mine();
						grid.getCase(i,j).setNeighbors(0);
						addNeighbors(i,j);
					}
					if(buffer == 0) {
						return;
					}
				}
			}
		}
	}

	public static GameGrid generate(int rows, int cols, int percent) {
		grid = new GameGrid(rows, cols);
		randomize(percent);
		return grid;
	}

	public static GameGrid generate() {
		return generate(MIN_ROWS, MIN_COLS, MIN_PERCENT);
	}
}
