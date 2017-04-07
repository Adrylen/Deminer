package org.game.graphics.view.panel;

import org.game.controller.GameController;
import org.game.graphics.view.component.GraphicalCellView;
import org.game.models.GameGrid;

import java.awt.GridLayout;
import javax.swing.JPanel;

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
