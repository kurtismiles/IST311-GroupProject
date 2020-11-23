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
    
    public ShoppingList(){}
    
    public ShoppingList(String name, ArrayList<Recipe> recipeList, ArrayList<IngredientDescription> ingredientList)
    {
        this.name = name;
        this.recipeList = recipeList;
        this.ingredientList = ingredientList;
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
