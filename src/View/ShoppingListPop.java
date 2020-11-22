/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Ingredient;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Kurtis
 */
public class ShoppingListPop extends JFrame {
    
    private ShoppingListPopPanel shoppingPanel;
    
    //public ShoppingListPop(){}
    
    public ShoppingListPop()
    {
        shoppingPanel = new ShoppingListPopPanel();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 500);
        setBackground(Color.BLUE);
       
        add(shoppingPanel);
        setVisible(true);
      
    }

    /**
     * @return the shoppingPanel
     */
    public ShoppingListPopPanel getShoppingPanel() {
        return shoppingPanel;
    }

    /**
     * @param shoppingPanel the shoppingPanel to set
     */
    public void setShoppingPanel(ShoppingListPopPanel shoppingPanel) {
        this.shoppingPanel = shoppingPanel;
    }
    
}
