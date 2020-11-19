/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Kurtis
 */
public class ShoppingListView {
    
    private ShoppingListPanel shoppingPanel;

    public ShoppingListView()
    {
        shoppingPanel = new ShoppingListPanel();
    }

    /**
     * @return the shoppingPanel
     */
    public ShoppingListPanel getShoppingPanel() {
        return shoppingPanel;
    }

    /**
     * @param shoppingPanel the shoppingPanel to set
     */
    public void setShoppingPanel(ShoppingListPanel shoppingPanel) {
        this.shoppingPanel = shoppingPanel;
    }
}
