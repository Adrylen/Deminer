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
package org.game.models;

/* Java Imports */
import java.util.Observable;

/* This is the grid of the Deminor.
* It permits to create a Deminor with
* the right size and number of mines.
*/
public class GameGrid extends Observable {
	private Case grid[][];
	private int percent;
	private int mines;

	public GameGrid setGrid(int rows, int cols) {
		this.grid = new Case[rows][cols];
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.grid[i][j] = new Case();
			}
		}
		return this;
	}

	public GameGrid setPercent(int percent) {
		this.percent = percent;
		this.mines = (int)(this.getSize() * this.percent / 100.0);
		return this;
	}

	public void setMines(int mines) {
		this.mines = mines;
		this.percent = (int)(this.mines * 100.0 / this.getSize());
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

	public int getMines() {
		return this.mines;
	}

	private int getSize() {
		return this.grid.length * this.grid[0].length;
	}

	public Case[][] getGrid() {
		return this.grid;
	}

	public Case getCase(int i, int j) {
		return this.grid[i][j];
	}

	public int[] getCasePosition(Case gameCase) {
		for(int i = 0; i < this.getRows(); i++) {
			for(int j = 0; j < this.getCols(); j++) {
				if(this.grid[i][j] == gameCase) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}

	public int getNumberOfMines() {
		int number = 0;
		for(Case[] row : this.grid) {
			for(Case gameCase : row) {
				if(gameCase.isMarkedAsMined()) {
					number++;
				}
			}
		}
		return this.mines - number;
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
