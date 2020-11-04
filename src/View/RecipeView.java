/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Recipe;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Kurtis
 */
public class RecipeView
{

    private RecipePanel recipePanel;

    public RecipeView()
    {
        recipePanel = new RecipePanel();
    }

    /**
     * @return the recipePanel
     */
    public RecipePanel getRecipePanel()
    {
        return recipePanel;
    }

    /**
     * @param recipePanel the recipePanel to set
     */
    public void setRecipePanel(RecipePanel recipePanel)
    {
        this.recipePanel = recipePanel;
    }

    

}
