/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.StarterView;
import Model.StarterModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kurtis
 */
public class StarterControl
{
    private StarterView view;
    private StarterModel model;
    
    private RecipeController recipeControl;
    
   
    public StarterControl()
    {
        //empty constructor
    }
    
    public StarterControl(StarterModel model, StarterView view)
    {
        this.model = model;
        this.view = view;

        view.updatePanel(view.getLoginPanel());
        
        addListeners();
    }
    
    void addListeners()
    {
        view.getLoginPanel().getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println();
                authorize(view.getLoginPanel().getUser().getText(), view.getLoginPanel().getPass().getText());
            }
        });
        
        //MainPanel Recipe Button Listener
        view.getMainPanel().getB1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                //passes control to RecipeController
                recipeControl = new RecipeController(view.getMainFrame());
                
                //back button listener in RecipePanel
                recipeControl.getView().getRecipePanel().getBackButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                       view.getMainFrame().updateFrame(view.getMainPanel());
                    }
                });
                
            }
        });
        
        
        
        
        
        
    }
    
    void authorize(String username, String password)
    {
        boolean match = model.Authorize(username, password);
        if (match)
        {
            view.updatePanel(view.getMainPanel());
            System.out.println("Authoization Success. Taking you to new Panel");
        }
        else
        {
            System.out.println("Authorization Failed. Try Again");
        }
    }
}
