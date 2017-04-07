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
package org.game.graphics.events;

/* Project Imports */
import org.game.controller.GameController;
import org.game.graphics.engine.WindowDeminer;
import org.game.graphics.view.component.GraphicalCellView;

/* Java Imports */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* Swing Imports */
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/* Here we check the Mouse events to update the controller */
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
