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
	private static void addNeighbor(GameGrid gameGrid, int i, int j) {
		for(int a = i-1; a <= i+1; a++) {
			if(a < 0 || a >= gameGrid.getRows()) {
				continue;
			}
			for(int b = j-1; b <= j+1; b++) {
				if(b < 0 || b >= gameGrid.getCols()) {
					continue;
				} else if(a == i && b==j) {
					continue;
				}
				if(!gameGrid.getCase(a,b).isMined()) {
					gameGrid.getCase(a,b).addNeighbor();
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
