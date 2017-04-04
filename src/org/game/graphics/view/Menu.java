/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;

/**
 *
 * @author kieffersarah
 */
public class Menu extends JMenu{
    public Menu(String str){
        super(str);
        this.main();
    }
    
    public void main(){
        createSubMenu("New");
        createNewElement("Quit");
    }
    
    private void createSubMenu(String str){
        this.add(new SubMenu(str));
    }
    
    private void createNewElement(String str){
//        this.add(new JMenuItem(str));
        this.add(new JMenuItem(new AbstractAction(str) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        }));
    }
}
