/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ingredient;
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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class RecipeController {
    
    private RecipeModel model;
    private RecipeView view;
    private RecipePop popup;
    private MenuPop menupop;
    
    private ArrayList<Ingredient> ingredientList;
    
    public RecipeController(){}
    
    public RecipeController(RecipeModel model, RecipeView view, ArrayList<Ingredient> ingredientList)
    {
        this.model = model;
        this.view = view;
        
        this.ingredientList = ingredientList;
        
        addListeners();
        
        view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
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

    private void addListeners()
    {     
        
        //Action listener for Create Button in Recipe Panel
        view.getRecipePanel().getCreateButton().addActionListener(new ActionListener()
        {
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {   
                        //create a new recipepop
                        popup = new RecipePop(ingredientList);
                        
                        //add listener to create button in recipepop
                        popup.getCreateBtn().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae)
                            {   
                                //checks to see if any RecipePop fields are empty
                                if (!popup.getNameText().getText().isEmpty() && !popup.getDescriptionText().getText().isEmpty() && !popup.getIngredientData().isEmpty() && !popup.getTagsText().getText().isEmpty())
                                {
                                    //if non are empty, create a new recipe
                                    model.writeRecipe(new Recipe(popup.getNameText().getText(), popup.getDescriptionText().getText(), popup.getIngredientData(), popup.getTagsText().getText()));
                                    
                                    //dispose popup frame
                                    popup.dispose();
                                    
                                    //refresh data in view recipe panel
                                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
                                    
                                }
                                //error message if one of the fields are empty
                                else
                                {
                                    System.out.println("Error: placeholder error message");
                                }
                                
                            }
                        });
                        popup.getAddBtn().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                popup.addIngredient();
                            }
                        });
                        
                        popup.getDelBtn().addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                                popup.removeIngredient();
                            }
                        });
                    }

        });
            
        //Action Listener for JButtons in RecipePanel
        for(int i = 0; i < view.getRecipePanel().getJb().length; ++i)
        {
            view.getRecipePanel().getJb(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    JButton currentButton = (JButton) ae.getSource();
                    
                    int position = 0;
                    
                    //find what position current button is in array
                    for (int j = 0; j < view.getRecipePanel().getJb().length; ++j)
                    {
                        if (view.getRecipePanel().getJb(j).equals(currentButton))
                        {
                            position = j;
                            break;
                        }
                    }
                    
                    //create a new menu popup with recipe data from button pressed
                    menupop = new MenuPop(model.getRecipeData().getRecipeList().get(model.getRecipeData().getFirstLine() + position));   
                menupop.getX2.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae){
                    menupop.setMultiplier(menupop.getMultiplier()*(float)2);
                    menupop.update();
                    }
                });
                menupop.getReset.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae){
                    menupop.setMultiplier(1);
                    menupop.update();
                    }
                });
                menupop.getHalf.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae){
                    menupop.setMultiplier(menupop.getMultiplier()/2);
                    menupop.update();
                    }
                });
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
        
        //Mouse scroll listener for Recipe Panel
        view.getRecipePanel().addMouseWheelListener(new MouseWheelListener()
        {
            public void mouseWheelMoved(MouseWheelEvent we)
            {
                int scroll;
                
                //reduce scroll units to 1
                if(we.getUnitsToScroll() > 0)
                {
                    scroll = 1;
                }
                else
                {
                    scroll = -1;
                }
                
                //update scroll wheel
                view.getRecipePanel().setScrollpos(scroll);
                
                //Check if out of bounds 
                if (model.getRecipeData().getFirstLine()+scroll < 0)
                {
                    //Do not scroll
                }
                else if (model.getRecipeData().getLastLine()+scroll >= model.getRecipeData().getRecipeList().size())
                {
                    //Do not scroll
                } 
                //if not out of bounds
                else
                {
                    //if scroll is positive increment recipedata lines
                    if (scroll > 0)
                    {
                        model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine()+1);
                        model.getRecipeData().setLastLine(model.getRecipeData().getLastLine()+1);
                    }
                    
                    //else scroll is negative and deincrement recipedata lines
                    else
                    {
                       model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine()-1);
                       model.getRecipeData().setLastLine(model.getRecipeData().getLastLine()-1); 
                    }
                    
                    //update views datapanel with new line information
                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
                }
            }
        });

        
    }
    
}
