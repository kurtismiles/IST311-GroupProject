/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RecipeModel;
import View.RecipeView;
import View.RecipePanel;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RecipeController {
    
    private RecipeModel model;
    private RecipeView view;
    private MainFrame frame;
    
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
        
    }
    
}
