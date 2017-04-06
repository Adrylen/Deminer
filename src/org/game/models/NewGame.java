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
	EXPERT(16,30,99);

	private int rows, cols, mines;

	NewGame(int rows, int cols, int mines) {
		this.rows = rows;
		this.cols = cols;
		this.mines = mines;
	}

//	@Contract(pure = true)
	public int rows() {
		return this.rows;
	}

//	@Contract(pure = true)
	public int cols() {
		return this.cols;
	}

//	@Contract(pure = true)
	public int mines() {
		return this.mines;
	}
}
