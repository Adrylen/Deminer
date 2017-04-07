package org.game.graphics.view.component;

import org.game.controller.GameController;
import org.game.graphics.events.MouseEventListener;
import org.game.models.Case;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/* This part is for the appearance of the buttons */
public class GraphicalCellView extends JButton {
    private Case gameCase;

    public GraphicalCellView(Case gameCase, GameController controller){
        super();
        this.gameCase = gameCase;

        this.changeIcon();
        this.addMouseListener(new MouseEventListener(controller));
    }

    public Case getCase() {
	    return this.gameCase;
    }

    private Color updateColor() {
    	if(gameCase.isHidden()) {
    		return null;
	    }
    	switch(gameCase.getNeighbors()) {
		    case 1: return Color.BLUE;
		    case 2: return Color.GREEN;
		    case 3: return Color.RED;
		    case 4: return Color.ORANGE;
		    case 5: return Color.MAGENTA;
		    case 6: return Color.CYAN;
		    case 7: return Color.YELLOW;
		    case 8: return Color.BLACK;
		    default: return null;
	    }
    }

    public void changeIcon(){
	    try {
	    	ImageIcon img = null;
		    int size = this.getWidth() < this.getHeight() ? this.getWidth() : this.getHeight();
		    if(this.gameCase.isMarkedAsMined()) {
			    img = new ImageIcon(ImageIO.read(new File("assets/images/flag.png"))
				    .getScaledInstance(size, size, Image.SCALE_DEFAULT));
		    } else if(this.gameCase.isMarkedAsIndeterminate()) {
				img = new ImageIcon(ImageIO.read(new File("assets/images/null.png"))
					.getScaledInstance(size, size, Image.SCALE_DEFAULT));
		    }
		    this.setIcon(img);
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
        if((this.gameCase.getSymbol() > '0' && this.gameCase.getSymbol() <= '9') || (!this.gameCase.isHidden() && !this.gameCase.isMined() && !this.gameCase.hasNeighbors())) {
        	this.setEnabled(false);
        }
    }

    // ©Copyright BEQUART Valentin
	@Override
	public void paintComponent(Graphics g)
	{
        super.paintComponent(g);

		FontMetrics matrics = g.getFontMetrics();
		int x = (this.getWidth() - matrics.stringWidth(gameCase.getSymbol()+""))/2,
			y = (this.getHeight() - matrics.getHeight())/2 + matrics.getAscent();

        g.setColor(this.updateColor());
        g.drawString(gameCase.getSymbol()+"", x, y);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}
}
