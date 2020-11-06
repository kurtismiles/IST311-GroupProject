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
import javax.swing.JButton;
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
                                    
                                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
                                    
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
                    
                    JButton currentButton = (JButton) ae.getSource();
                    
                    int position = 0;
                    for (int j = 0; j < view.getRecipePanel().getJb().length; ++j)
                    {
                        if (view.getRecipePanel().getJb(j).equals(currentButton))
                        {
                            position = j;
                            break;
                        }
                    }

                    menupop = new MenuPop(model.getRecipeData().getRecipeList().get(model.getRecipeData().getFirstLine() + position));   
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
                int scroll;
                if(we.getUnitsToScroll() > 0)
                {
                    scroll = 1;
                }
                else
                {
                    scroll = -1;
                }
                
                view.getRecipePanel().setScrollpos(scroll);
                if (model.getRecipeData().getFirstLine()+scroll < 0)
                {
                    //Do not scroll
                }
                else if (model.getRecipeData().getLastLine()+scroll >= model.getRecipeData().getRecipeList().size())
                {
                    //Do not scroll
                } else
                {
                    if (scroll > 0)
                    {
                        model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine()+1);
                        model.getRecipeData().setLastLine(model.getRecipeData().getLastLine()+1);
                    }
                    else
                    {
                       model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine()-1);
                       model.getRecipeData().setLastLine(model.getRecipeData().getLastLine()-1); 
                    }
                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
                }
            }
        });

    }
    
}
