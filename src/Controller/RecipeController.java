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
import java.awt.event.*;
import javax.swing.JOptionPane;


public class RecipeController {
    
    private RecipeModel model;
    private RecipeView view;
    private RecipePop popup;
    
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
        }
        );
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
                int scroll;
                if(we.getUnitsToScroll() > 0)
                {
                    scroll = 1;
                }
                else
                {
                    scroll = -1;
                }
                
                
                
                
                
                System.out.println(scroll);
                view.getRecipePanel().setScrollpos(scroll);
                if (model.getRecipeData().getFirstLine()+scroll < 0)
                {
                    System.out.println("Tooo far up");
//                    firstLine = 0;
//                    lastLine = firstLine + jb.length;
                }
                else if (model.getRecipeData().getLastLine()+scroll >= model.getRecipeData().getRecipeList().size())
                {
                    System.out.println("Tooo far down "+ model.getRecipeData().getLastLine());
//                    lastLine = recipeList.size();
//                    firstLine = lastLine - jb.length;
                } else
                {
                    if(scroll > 0)
                    {
                        model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine()+1);
                        model.getRecipeData().setLastLine(model.getRecipeData().getLastLine()+1);
                    }
                    else
                    {
                       model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine()-1);
                        model.getRecipeData().setLastLine(model.getRecipeData().getLastLine()-1); 
                    }
                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine(), model.getRecipeData().getLastLine());
                }
            }
        });
    }
    
}
