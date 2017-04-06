/*
 *   Java Project
 *   Project
 *   Package : org.game.models
 *   Created by adrylen on 06/04/17.
*/

package org.game.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Scores implements Serializable {
	private static final String filename = "assets/scores/scores.ser";
	public static final int LENGTH = 5;

	private String[] pseudos;
	private int[] scores;

	public Scores() {
		pseudos = new String[5];
		scores = new int[5];
		Arrays.fill(scores, Integer.MAX_VALUE);
	}

	public String getPseudo(int i) {
		return pseudos[i];
	}

	public int getScore(int i) {
		return scores[i];
	}

	public Scores updateScores(String newWinner, int newScore) {
		int id = LENGTH-1;
		while(scores[id] > newScore) {
			id--;
			if(id < 0) {
				break;
			}
		}
		if(id < LENGTH-1) {
			for(int i = id+1; i <= LENGTH; ++i) {
				String str = pseudos[i];
				int tmp = scores[i];

				pseudos[i] = newWinner;
				scores[i] = newScore;

				newWinner = str;
				newScore = tmp;
			}
		}
		return this;
	}

	public static Scores read() {
		ObjectInputStream ois = null;
		Scores scores = null;
		try(final FileInputStream file = new FileInputStream(filename)) {
			ois = new ObjectInputStream(file);
			scores = (Scores) ois.readObject();
		} catch(FileNotFoundException e) {
			System.out.println("Serialisation initialized");
			return new Scores();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return scores;
	}

	public static void write(Scores scores) {
		ObjectOutputStream oos = null;
		try(final FileOutputStream file = new FileOutputStream(filename)) {
			oos = new ObjectOutputStream(file);
			oos.writeObject(scores);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
