/*
    Java Project
    Deminer
    Package : org.game.models

    Created by adrylen on 08/03/17.
*/

package org.game.models;

public class GameGrid {
	private Case grid[][];

	public GameGrid(int rows, int cols) {
		this.grid = new Case[rows][cols];
	}

	public void setGrid(int rows, int cols) {
		this.grid = new Case[rows][cols];
	}

	public int getRows() {
		return this.grid.length;
	}

	public int getCols() {
		return this.grid[0].length;
	}

	public int getSize() {
		return this.grid.length * this.grid[0].length;
	}

	public Case[][] getGrid() {
		return this.grid;
	}

	public Case getCase(int i, int j) {
		return this.grid[i][j];
	}
}
