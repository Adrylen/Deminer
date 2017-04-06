/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import org.game.controller.GameController;
import org.game.graphics.events.MouseEventListener;
import org.game.models.Case;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author kieffersarah
 */
public class GraphicalCellView extends JButton {
    private Case gameCase;
    private MouseEventListener action;
    private Icon mine = new ImageIcon("deminer.png");

    public GraphicalCellView(Case gameCase, GameController controller){
        super(/*new StringBuilder().append(gameCase.getSymbol()).toString()*/);
        this.gameCase = gameCase;
        this.action = new MouseEventListener(controller);

        this.changeIcon();
        this.addMouseListener(action);
    }

    public Case getCase() {
	    return this.gameCase;
    }

    public Color updateColor() {
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
//    	if(this.gameCase.isMarkedAsMined()) {
//		    try {
//		    	Image img = ImageIO.read(new File("assets/images/flag.png"));
//			    this.setIcon(new ImageIcon());
//		    } catch (IOException e) {
//			    e.printStackTrace();
//		    }
//	    }
//    	if(this.gameCase.isMined() && !this.gameCase.isHidden()) {
//
//	    }
        if((this.gameCase.getSymbol() > '0' && this.gameCase.getSymbol() <= '9') || (!this.gameCase.isHidden() && !this.gameCase.isMined() && !this.gameCase.hasNeighbors())) {
        	this.setEnabled(false);
        }
    }

    // © Copyright BEQUART Valentin
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
