/*
 *   Java Project
 *   Project
 *   Package : org.game.models
 *   Created by adrylen on 29/03/17.
*/

package org.game.models;

//import org.jetbrains.annotations.Contract;

public enum NewGame {
	BEGINNER(9,9,10),
	INTERMEDIATE(16,16,40),
	EXPERT(16,30,99),
	CUSTOM(-1,-1,-1);

	private int rows, cols, mines;

	NewGame(int rows, int cols, int mines) {
		this.rows = rows;
		this.cols = cols;
		this.mines = mines;
	}

	public int rows() {
		return this.rows;
	}

	public int cols() {
		return this.cols;
	}

	public int mines() {
		return this.mines;
	}
}
