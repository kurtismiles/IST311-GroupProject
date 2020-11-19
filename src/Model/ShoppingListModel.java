/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kurtis
 */
public class ShoppingListModel {
    
    private ShoppingListList shoppingListData;
    
    public ShoppingListModel()
    {
        shoppingListData = new ShoppingListList();    
    }

        /**
     * @return the shoppingListData
     */
    public ShoppingListList getShoppingListData() {
        return shoppingListData;
    }

    /**
     * @param shoppingListData the shoppingListData to set
     */
    public void setShoppingListData(ShoppingListList shoppingListData) {
        this.shoppingListData = shoppingListData;
    }
    
    public void writeShoppingList(ShoppingList input)
    {
        getShoppingListData().addShoppingList(input);
        getShoppingListData().saveXMLList();
        refreshShoppingListList();
    }
    
    public void removeShoppingList(ShoppingList input)
    {
        getShoppingListData().removeShoppingList(input);
        getShoppingListData().saveXMLList();
        refreshShoppingListList();
    }
    
    
    public void refreshShoppingListList()
    {
        setShoppingListData(new ShoppingListList());
    }


}
