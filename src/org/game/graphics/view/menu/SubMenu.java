package org.game.graphics.view.menu;

import org.game.graphics.engine.WindowDeminer;
import org.game.graphics.view.frame.NewGameFrame;
import org.game.models.NewGame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

class SubMenu extends JMenu {
    private NewGameFrame custom = null;
    
    SubMenu(String str){
        super(str);
        this.main();
    }
    
    private void main(){
        this.createNewLevel("Beginner");
        this.createNewLevel("Intermediate");
        this.createNewLevel("Expert");
        this.createCustomMenu();
    }
    
    private void createCustomMenu(){
       this.add(new JMenuItem(new AbstractAction("Custom"){
           @Override
           public void actionPerformed(ActionEvent e){
               if(custom == null){
                    custom = new NewGameFrame("custom");
                    custom.main();
               }
               else{
                    custom.setVisible(true);
               }
           }
       }));
    }

    private void createNewLevel(String str) {
    	JMenuItem menu = new JMenuItem();

    	menu.setAction(new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent actionEvent) {
		    	switch(str) {
				    case "Beginner" : WindowDeminer.create(NewGame.BEGINNER); break;
				    case "Intermediate" : WindowDeminer.create(NewGame.INTERMEDIATE); break;
				    case "Expert" : WindowDeminer.create(NewGame.EXPERT); break;
			    }
		    }
	    });

	    menu.setAccelerator(KeyStroke.getKeyStroke(
		    str.equals("Beginner") ? KeyEvent.VK_B :
			str.equals("Intermediate") ? KeyEvent.VK_I :
			KeyEvent.VK_E,
	        KeyEvent.CTRL_DOWN_MASK
	    ));

    	menu.setText(str);
	    this.add(menu);
    }
}
