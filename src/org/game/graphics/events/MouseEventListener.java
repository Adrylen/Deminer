/*
    Java Project
    Deminer
    Package : org.game.graphics.events

    Created by adrylen on 10/03/17.
*/

package org.game.graphics.events;

import org.game.graphics.view.GraphicalCellView;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventListener extends MouseAdapter {
	public void mouseClicked(MouseEvent e) {
		StringBuilder builder = new StringBuilder();
		System.out.println("Case : " + ((GraphicalCellView)e.getSource()).getCase());
		System.out.println("Click : " + (e.getModifiers() == InputEvent.BUTTON1_MASK));
		System.out.println("Click : " + (e.getModifiers() == InputEvent.BUTTON3_MASK));
	}
}
