/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

import org.game.models.GameGrid;

import java.util.Random;

public class GameGenerator {
	private final int MIN_ROWS = 10;
	private final int MIN_COLS = 10;
	private final int MIN_PERCENT = 10;
	private GameGrid grid;

	private void addNeighbors(int i, int j) {
		for(int a = i-1; a <= i+1; a++) {
			if(a < 0 || a >= this.grid.getRows()) {
				continue;
			}
			for(int b = j-1; b <= j+1; b++) {
				if(b < 0 || b >= this.grid.getCols()) {
					continue;
				}
				this.grid.getCase(a,b).addNeighbor();
			}
		}
	}

	private void randomize(int percent) {
		int buffer = (int)(this.grid.getSize() * percent / 100.0);

		while(buffer > 0) {
			for(int i = 0; i < this.grid.getRows(); i++) {
				for(int j = 0; j < this.grid.getCols(); i++) {
					if(new Random().nextInt(100) < percent) {
						this.grid.getCase(i,j).mine();
						this.grid.getCase(i,j).setNeighbors(0);
						this.addNeighbors(i,j);
					}
					if(buffer == 0) {
						return;
					}
				}
			}
		}
	}

	public GameGrid generate(int rows, int cols, int percent) {
		this.grid = new GameGrid(rows, cols);
		this.randomize(percent);
		return this.grid;
	}

	public GameGrid generate() {
		return this.generate(MIN_ROWS, MIN_COLS, MIN_PERCENT);
	}
}
