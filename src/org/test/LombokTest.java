/*
 *   Java Project
 *   Project
 *   Package : org.test
 *   Created by adrylen on 05/04/17.
*/

package org.test;

public class LombokTest {
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(5);
		p.setY(3);
		System.out.println(p.getX());
		System.out.println(p.getY());
		System.out.println(p.toString());
	}
}
