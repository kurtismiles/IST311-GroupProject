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
import View.MenuPop;
import View.RecipePop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class RecipeController {
    
    private RecipeModel model;
    private RecipeView view;
    private RecipePop popup;
    private MenuPop menupop;
    
    public RecipeController(){}
    
    public RecipeController(RecipeModel model, RecipeView view)
    {
        this.model = model;
        this.view = view;
        addListeners();
        
        view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine(), model.getRecipeData().getLastLine());
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
                                    
                                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine(), model.getRecipeData().getLastLine());
                                    
                                }
                                //error message if one of the fields are empty
                                else
                                {
                                    System.out.println("Error: placeholder error message");
                                }
                                
                            }
                        });     
                    }
        });
                   
        for(int i = 0; i < view.getRecipePanel().getJb().length; ++i)
        {
            view.getRecipePanel().getJb(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
//                    menupop = new MenuPop();
                    
                    
                }
            });
        }        
       
        
        view.getRecipePanel().getSave().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
            }
        });
        view.getRecipePanel().getDelete().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
            }
        });
        view.getRecipePanel().addMouseWheelListener(new MouseWheelListener()
        {
            public void mouseWheelMoved(MouseWheelEvent we)
            {
                int scroll = we.getUnitsToScroll();
                System.out.println(scroll);
                view.getRecipePanel().setScrollpos(scroll);
                
                
                
                
                view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine()+scroll, model.getRecipeData().getLastLine()+scroll);
            }
        });
    }
    
}
