/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;

/**
 *
 * @author Kurtis
 */
public class RecipeView {
    
    private RecipePanel recipePanel;
    private MainFrame mainFrame;
    
    public RecipeView()
    {
    }
    
    public RecipeView(MainFrame currentFrame)
    {
        recipePanel = new RecipePanel();
        mainFrame = currentFrame;
        
    }

    /**
     * @return the recipePanel
     */
    public RecipePanel getRecipePanel() {
        return recipePanel;
    }

    /**
     * @param recipePanel the recipePanel to set
     */
    public void setRecipePanel(RecipePanel recipePanel) {
        this.recipePanel = recipePanel;
    }

    /**
     * @return the mainFrame
     */
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * @param mainFrame the mainFrame to set
     */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
        
    public void updatePanel(JPanel updatePanel)
    {
        getMainFrame().updateFrame(updatePanel);
    }
    
}
