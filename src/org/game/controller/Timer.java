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
package org.game.controller;

/* Java Imports */
import java.util.Observable;
import java.util.TimerTask;

/* Interface Imports */
import java.util.Observer;

/* Here we control the timer while the game
* is running, and we fix the score of
* the player if he wins.
*/
public class Timer extends Observable {
	private java.util.Timer timer;

	private boolean started;
	private int time;

	public Timer(Observer obs) {
		started = false;
		time = 0;
		addObserver(obs);
	}

	public void start() {
		if(!started) {
			started = true;
			timer = new java.util.Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					++time;
					setChanged();
					notifyObservers();
				}
			}, 30, 1000);
		}
	}

	public void stop() {
		timer.cancel();
	}

	public void reset() {
		time = 0;
		started = false;
		setChanged();
		notifyObservers();
	}

	public int getTime() {
		return time;
	}
}
