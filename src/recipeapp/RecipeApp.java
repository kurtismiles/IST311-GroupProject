/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipeapp;

import Controller.StarterControl;
import View.StarterView;
import Model.StarterModel;

/**
 *
 * @author Kurtis
 */
public class RecipeApp
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        StarterModel model = new StarterModel();
        StarterView view = new StarterView();
        StarterControl controller = new StarterControl(model, view);
        
        
        
        
    }
    
    
}
