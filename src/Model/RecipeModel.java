/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

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
        System.out.println(input);
        
        try
        {
           XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("recipes.xml")));
           xe.writeObject(input);
           xe.close();
           
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
    
    public void refreshRecipeList()
    {
        recipeData = new RecipeList();
    }

}
