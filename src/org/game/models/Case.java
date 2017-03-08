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

	public Case() {
		this.hidden = true;
		this.mined = false;
		this.markedAsMined = false;
		this.markedAsIndeterminate = false;

		this.neighbors = 0;
		this.symbol = '#';
	}

	public void show() {
		this.hidden = false;
		this.markedAsMined = false;
		this.markedAsIndeterminate = false;
		this.symbol = this.mined ? 'x' : this.neighbors != 0 ? (char)(this.neighbors+'0') : '.';
	}

	public void mine() {
		this.mined = true;
	}

	public void markAsMined() {
		this.markedAsMined = true;
		this.markedAsIndeterminate = false;
		this.symbol = '!';
	}

	public void markAsIndeterminate() {
		this.markedAsMined = false;
		this.markedAsIndeterminate = true;
		this.symbol = '?';
	}

	public void unmark() {
		this.markedAsMined = false;
		this.markedAsIndeterminate = false;
		this.symbol = '#';
	}

	public void addNeighbor() {
		this.neighbors++;
	}

	public void setNeighbors(int neighbors) {
		this.neighbors = neighbors;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
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
