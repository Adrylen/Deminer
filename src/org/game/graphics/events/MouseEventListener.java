/*
    Java Project
    Deminer
    Package : org.game.graphics.events

    Created by adrylen on 10/03/17.
*/

package org.game.graphics.events;

import org.game.controller.GameController;
import org.game.graphics.view.GraphicalCellView;
import org.game.models.Case;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class MouseEventListener extends MouseAdapter {
	private final GameController controller;

	public MouseEventListener(GameController controller) {
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {
//		StringBuilder builder = new StringBuilder();
//		System.out.println("Case : " + ((GraphicalCellView)e.getSource()).getCase());
//		System.out.println("Click : " + isLeftMouseButton(e));
//		System.out.println("Click : " + isRightMouseButton(e));
		Case gameCase = ((GraphicalCellView) e.getSource()).getCase();
		boolean show = (isLeftMouseButton(e)) ? true : false;
		this.controller.updateModel(gameCase, show);
	}
}
