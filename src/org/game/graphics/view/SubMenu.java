/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author kieffersarah
 */
public class SubMenu extends JMenu{
    
    public SubMenu(String str){
        super(str);
        this.main();
    }
    
    public void main(){
        this.createNewElement("Beginner");
        this.createNewElement("Intermediate");
        this.createNewElement("Expert");
        this.createNewElement("Custom");
    }
    
    private void createNewElement(String str){
        this.add(new JMenuItem(str));
    }
}
