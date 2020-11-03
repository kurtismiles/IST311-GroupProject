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
public class RecipeModel
{
    private RecipeList recipeData;
    private XML xm;
    
    public RecipeModel()
    {
        recipeData = new RecipeList();
    }

    /**
     * @return the recipeData
     */
    public RecipeList getRecipeData()
    {
        return recipeData;
    }

    /**
     * @param recipeData the recipeData to set
     */
    public void setRecipeData(RecipeList recipeData)
    {
        this.recipeData = recipeData;
    }
    
    public void writeRecipe(Recipe input)
    {
        xm.openWriterXML("recipelist.xml");
        xm.writeObject(input);
        xm.closeWriterXML();
    }
    
    public void refreshRecipeList()
    {
        recipeData = new RecipeList();
    }
    
}
