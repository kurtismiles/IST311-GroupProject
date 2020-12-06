package Model;

/**
 *
 * @author Kurtis
 */
public class RecipeModel
{

    private RecipeList recipeData;
    
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
        recipeData.addRecipe(input);
        recipeData.saveXMLList();
        refreshRecipeList();
    }
    
    public void removeRecipe(Recipe input)
    {
        recipeData.removeRecipe(input);
        recipeData.saveXMLList();
        refreshRecipeList();
    }
    
    
    public void refreshRecipeList()
    {
        recipeData = new RecipeList();
    }

}
