/*
    Java Project
    Deminer
    Package : org.game.models

    Created by adrylen on 08/03/17.
*/

package org.game.models;

public class Case {
	private boolean hidden;
	private boolean mined;
	private boolean markedAsMined;
	private boolean markedAsIndeterminate;

	private int neighbors;
	private char symbol;

	Case() {
		this.hidden = true;
		this.mined = false;
		this.markedAsMined = false;
		this.markedAsIndeterminate = false;

		this.neighbors = 0;
		this.symbol = Character.MIN_VALUE;
	}

	public Case show() {
		this.hidden = false;
		this.markedAsMined = false;
		this.markedAsIndeterminate = false;
		this.symbol = this.mined ? 'x' : this.neighbors != 0 ? (char)(this.neighbors+'0') : Character.MIN_VALUE;
		return this;
	}

	public Case mine() {
		this.mined = true;
		return this;
	}

	public Case markAsMined() {
		this.markedAsMined = true;
		this.markedAsIndeterminate = false;
		this.symbol = Character.MIN_VALUE;
		return this;
	}

	public Case markAsIndeterminate() {
		this.markedAsMined = false;
		this.markedAsIndeterminate = true;
		this.symbol = Character.MIN_VALUE;
		return this;
	}

	public Case unmark() {
		this.markedAsMined = false;
		this.markedAsIndeterminate = false;
		this.symbol = Character.MIN_VALUE;
		return this;
	}

	public Case addNeighbor() {
		this.neighbors++;
		return this;
	}

	public Case resetNeighbors() {
		this.neighbors = 0;
		return this;
	}

	public Case setSymbol(char symbol) {
		this.symbol = symbol;
		return this;
	}

	public boolean isHidden() {
		return this.hidden;
	}

	public boolean isMined() {
		return this.mined;
	}

	public boolean isMarkedAsMined() {
		return this.markedAsMined;
	}

	public boolean isMarkedAsIndeterminate() {
		return this.markedAsIndeterminate;
	}

	public boolean hasNeighbors() {
		return this.neighbors != 0;
	}

	public int getNeighbors() {
		return this.neighbors;
	}

	public char getSymbol() {
		return this.symbol;
	}
}
