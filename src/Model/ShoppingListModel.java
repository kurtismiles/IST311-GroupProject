/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Kurtis
 */
public class ShoppingListModel {

    private ShoppingListList shoppingListData;

    public ShoppingListModel() {
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

    public void writeShoppingList(ShoppingList input) {
        getShoppingListData().addShoppingList(input);
        getShoppingListData().saveXMLList();
        refreshShoppingListList();
    }

    public void removeShoppingList(ShoppingList input) {
        getShoppingListData().removeShoppingList(input);
        getShoppingListData().saveXMLList();
        refreshShoppingListList();
    }

    public void refreshShoppingListList() {
        setShoppingListData(new ShoppingListList());
    }

    public ArrayList<IngredientDescription> buildShoppingList(ArrayList<Recipe> recipes)
    {
        ArrayList<IngredientDescription> id = new ArrayList<>();
        for (int i = 0; i < recipes.size(); i++) {
            for (int j = 0; j < recipes.get(i).getIngredients().size(); j++) {

                id.add(recipes.get(i).getIngredients().get(j));
                

            }
        }
        
        return id;

    }

}
