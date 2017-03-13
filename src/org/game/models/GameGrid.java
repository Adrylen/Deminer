/*
    Java Project
    Deminer
    Package : org.game.models

    Created by adrylen on 08/03/17.
*/

package org.game.models;

import java.util.Observable;

public class GameGrid extends Observable {
	private Case grid[][];
	private int percent;

	public GameGrid setGrid(int rows, int cols) {
		this.grid = new Case[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				this.grid[i][j] = new Case();
			}
		}
		return this;
	}

	public GameGrid setPercent(int percent) {
		this.percent = percent;
		return this;
	}

	public int getRows() {
		return this.grid.length;
	}

	public int getCols() {
		return this.grid[0].length;
	}

	public int getPercent() {
		return this.percent;
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

	public int getNumberUnmarkedMines() {
		int number = 0;
		for(Case[] row : this.grid) {
			for(Case gameCase : row) {
				if(!gameCase.isMarkedAsMined() && !gameCase.isMarkedAsIndeterminate()) {
					number++;
				}
			}
		}
		return number;
	}

	public void toggleDebug() {
		setChanged();
		notifyObservers(true);
	}

	public void update() {
		setChanged();
		notifyObservers(this);
	}
}
