/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipeapp;


import Controller.NavigationController;
import Model.NavigationModel;
import View.NavigationView;

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
        NavigationModel model = new NavigationModel();
        NavigationView view = new NavigationView();
        NavigationController controller = new NavigationController(model, view);

    }

}
