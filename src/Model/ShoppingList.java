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
public class ShoppingList
{
    private String name;
    private ArrayList<Recipe> recipeList;
    private ArrayList<IngredientDescription> ingredientList;
    
    ShoppingList(){}
    
    ShoppingList(String name)
    {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the recipeList
     */
    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }

    /**
     * @param recipeList the recipeList to set
     */
    public void setRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    /**
     * @return the ingredientList
     */
    public ArrayList<IngredientDescription> getIngredientList() {
        return ingredientList;
    }

    /**
     * @param ingredientList the ingredientList to set
     */
    public void setIngredientList(ArrayList<IngredientDescription> ingredientList) {
        this.ingredientList = ingredientList;
    }
    
    
}
