/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import org.game.graphics.controller.WindowDeminer;
import org.game.models.NewGame;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;

/**
 *
 * @author kieffersarah
 */
public class SubMenu extends JMenu {
    private NewGameFrame custom = null;
    
    public SubMenu(String str){
        super(str);
        this.main();
    }
    
    public void main(){
        this.createNewLevel("Beginner");
        this.createNewLevel("Intermediate");
        this.createNewLevel("Expert");
        this.createCustomMenu("Custom");
    }
    
    private void createCustomMenu(String str){
       this.add(new JMenuItem(new AbstractAction(str){
           @Override
           public void actionPerformed(ActionEvent e){
               if(custom == null){
                   custom = new NewGameFrame("custom");
               WindowDeminer.getWindow().getContentPane().add(custom);
               custom.main();
               }
               else{
                   custom.setVisible(true);
               }
           }
       }));
    }

    private void createNewLevel(String str) {
	    JMenuItem menu = new JMenuItem(new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent actionEvent) {
		    	switch(str) {
				    case "Beginner" : WindowDeminer.create(NewGame.BEGINNER); break;
				    case "Intermediate" : WindowDeminer.create(NewGame.INTERMEDIATE); break;
				    case "Expert" : WindowDeminer.create(NewGame.EXPERT); break;
			    }
		    }
	    });
	    menu.setText(str);
	    this.add(menu);
    }
}
