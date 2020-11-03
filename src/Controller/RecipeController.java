/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Recipe;
import Model.RecipeModel;
import View.RecipeView;
import View.RecipePanel;
import View.MainFrame;
import View.RecipePop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class RecipeController {
    
    private RecipeModel model;
    private RecipeView view;
    private MainFrame frame;
    private RecipePop popup;
    
    public RecipeController(MainFrame currentFrame)
    {
        model = new RecipeModel();
        view = new RecipeView(currentFrame);
        
        view.updatePanel(view.getRecipePanel());
        
        addListeners();
       
    }
    
    /**
     * @return the model
     */
    public RecipeModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(RecipeModel model) {
        this.model = model;
    }

    /**
     * @return the view
     */
    public RecipeView getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(RecipeView view) {
        this.view = view;
    }

    /**
     * @return the frame
     */
    public MainFrame getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }
    
    void addListeners()
    {     
        view.getRecipePanel().getCreateButton().addActionListener(new ActionListener()
        {
            @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        popup = new RecipePop(); 
                        
                        popup.getCreateBtn().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae)
                            {   
                                //checks to see if any RecipePop fields are empty
                                if (!popup.getNameText().getText().isEmpty() && !popup.getDescriptionText().getText().isEmpty() && !popup.getIngredientText().getText().isEmpty() && !popup.getTagsText().getText().isEmpty())
                                {
                                    model.writeRecipe(new Recipe(popup.getNameText().getText(), popup.getDescriptionText().getText(), popup.getIngredientText().getText(), popup.getTagsText().getText()));      
                                    popup.dispose();
                                }
                                //error message if one of the fields are empty
                                else
                                {
                                    System.out.println("Error: placeholder error message");
                                }
                                
                            }
                        });
                        
                        
                    }
            
        }
        );
          
    }
    
}
