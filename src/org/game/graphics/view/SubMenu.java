/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.graphics.view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.game.graphics.controller.WindowDeminer;

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
        this.createCustomMenu("Custom");
    }
    
    private void createCustomMenu(String str){
       this.add(new JMenuItem(new AbstractAction(str){
           @Override
           public void actionPerformed(ActionEvent e){
               NewGameFrame custom = new NewGameFrame("custom",200,300);
               WindowDeminer.getWindow().getContentPane().add(custom);
               custom.main();
           }
       }));
        
    }
    
    private void createNewElement(String str){
        this.add(new JMenuItem(str));
    }
}
