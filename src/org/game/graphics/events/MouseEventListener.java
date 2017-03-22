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

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseEventListener extends MouseAdapter {
	private final GameController controller;

	public MouseEventListener(GameController controller) {
		this.controller = controller;
	}

	public void mouseClicked(MouseEvent e) {
		if(((JButton) e.getSource()).isEnabled()) {
			boolean show = (SwingUtilities.isLeftMouseButton(e)) ? true : false;
			this.controller.updateModel(((GraphicalCellView) e.getSource()).getCase(), show);
		} else {
			if (e.getClickCount() == 2) {
				System.out.println("double clicked");
				this.controller.showNeighbors(((GraphicalCellView) e.getSource()).getCase());
			}
		}
	}
}
