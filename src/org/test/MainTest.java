/*
 *   Java Project
 *   Project
 *   Package : org.test
 *   Created by adrylen on 05/04/17.
*/

package org.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainTest {
	private static Scores score = new Scores();
	private static String filename = "assets/scores/scores.ser";

	private static void write() {
		ObjectOutputStream oos = null;
		try {
			final FileOutputStream file = new FileOutputStream(filename);
			oos = new ObjectOutputStream(file);
			oos.writeObject(score);
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

	private static void read() {
		ObjectInputStream ois = null;
		try {
			final FileInputStream file = new FileInputStream(filename);
			ois = new ObjectInputStream(file);

			Scores tmp = (Scores) ois.readObject();
			System.out.println("IN SCORES : "+tmp.getX());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	}

	public static void main(String[] args) {
		score.setX(1);
		write();read();
		score.setX(3);
		write();
		score.setX(2);
		write();read();
	}
}
