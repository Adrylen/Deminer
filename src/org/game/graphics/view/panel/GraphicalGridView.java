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
package org.game.graphics.view.panel;

/* Project Imports */
import org.game.controller.GameController;
import org.game.graphics.view.component.GraphicalCellView;
import org.game.models.GameGrid;

/* Java Imports */
import java.awt.GridLayout;

/* Swing Imports */
import javax.swing.JPanel;

/* Here we set the diffent buttons of the grid
* at the right place thanks to a GridLayout.
* Each button reffers to a case from the model
*/
public class GraphicalGridView extends JPanel{
	private GameGrid grid;

	public GraphicalGridView(GameGrid grid, GameController controller){
		this.grid = grid;
		int rows = grid.getRows();
		int cols = grid.getCols();
		this.setLayout(new GridLayout(rows, cols));
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				this.add(new GraphicalCellView(grid.getCase(i,j), controller));
			}
		}
	}

	public GraphicalCellView getButton(int i, int j) {
		int nb = this.grid.getCols()*i + j;
		return (GraphicalCellView) this.getComponent(nb);
	}
}
