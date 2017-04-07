package org.game.graphics.events;

import org.game.controller.GameController;
import org.game.graphics.engine.WindowDeminer;
import org.game.graphics.view.component.GraphicalCellView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class MouseEventListener extends MouseAdapter {
	private final GameController controller;

	public MouseEventListener(GameController controller) {
		this.controller = controller;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.controller == null) {
			WindowDeminer.create(WindowDeminer.getActualLevel());
		} else {
			if (((JButton) e.getSource()).isEnabled()) {
				this.controller.updateModel(
					((GraphicalCellView) e.getSource()).getCase(),
					SwingUtilities.isLeftMouseButton(e)
				);
			} else {
				if (e.getClickCount() == 2) {
					this.controller.showNeighbors(((GraphicalCellView) e.getSource()).getCase());
				}
			}
		}
	}
}
