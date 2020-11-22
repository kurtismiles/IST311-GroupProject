/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.IngredientModel;
import Model.Recipe;
import Model.RecipeModel;
import Model.ShoppingList;
import Model.ShoppingListModel;
import View.MenuPop;
import View.RecipePop;
import View.RecipeView;
import View.ShoppingListPop;
import View.ShoppingListView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;

/**
 *
 * @author Kurtis
 */
public class ShoppingListController
{
    private ShoppingListModel model;
    private ShoppingListView view;
    
    private ShoppingListPop popup;
    private MenuPop menupop;
    

    public ShoppingListController(){}
    
    public ShoppingListController(ShoppingListModel model, ShoppingListView view)
    {
        this.model = model;
        this.view = view;
        
        addListeners();
        
        //view.getShoppingPanel().updateDataPanel(model.getShoppingListData().getShoppingListList(), model.getShoppingListData().getFirstLine());
    }
    
    /**
     * @return the model
     */
    public ShoppingListModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(ShoppingListModel model) {
        this.model = model;
    }

    /**
     * @return the view
     */
    public ShoppingListView getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(ShoppingListView view) {
        this.view = view;
    }

    private void addListeners()
    {     
        
        //Action listener for Create Button in Recipe Panel
        view.getShoppingPanel().getCreateButton().addActionListener(new ActionListener()
        {
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {   
                        //create a new recipepop
                        //ingredientModel.refreshIngredientList();
                        popup = new ShoppingListPop();
                        
                        //add listener to create button in recipepop
                        popup.getShoppingPanel().getCreateBtn().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae)
                            {   
                                //checks to see if any RecipePop fields are empty
//                                if (!popup.getShoppingPanel().getNameText().getText().isEmpty() && !popup.getShoppingPanel().getDescriptionText().getText().isEmpty()
//                                       && !popup.getShoppingPanel().getIngredientData().isEmpty() && !popup.getShoppingPanel().getTagsText().getText().isEmpty())
//                                {
//                                    //if non are empty, create a new recipe
//                                    model.writeShoppingList(new ShoppingList(popup.getShoppingPanel().getNameText().getText(), popup.getShoppingPanel().getDescriptionText().getText(),
//                                            popup.getShoppingPanel().getIngredientData(), popup.getShoppingPanel().getTagsText().getText()));
//                                    
//                                    //dispose popup frame
//                                    popup.dispose();
//                                    
//                                    //refresh data in view recipe panel
//                                    view.getShoppingPanel().updateDataPanel(model.getShoppingListData().getShoppingListList(), model.getShoppingListData().getFirstLine());
//                                    
//                                }
                                //error message if one of the fields are empty
//                                else
//                                {
//                                    System.out.println("Error: placeholder error message");
//                                }
                                
                            }
                        });
                    }

        });
            
        //Action Listener for JButtons in RecipePanel
        
        for(int i = 0; i < view.getShoppingPanel().getJb().length; ++i)
        {
            view.getShoppingPanel().getJb(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    JButton currentButton = (JButton) ae.getSource();
                    
                    int position = 0;
                    
                    //find what position current button is in array
                    for (int j = 0; j < view.getShoppingPanel().getJb().length; ++j)
                    {
                        if (view.getShoppingPanel().getJb(j).equals(currentButton))
                        {
                            position = j;
                            break;
                        }
                    }
                    
                    //create a new menu popup with recipe data from button pressed
                    menupop = new MenuPop(model.getShoppingListData().getShoppingListList().get(model.getShoppingListData().getFirstLine() + position));   
                    
                }
            });
        }   
        
        view.getShoppingPanel().getSave().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
            }
        });
        view.getShoppingPanel().getDelete().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
                
            }
        });
        
        //Mouse scroll listener for Recipe Panel
        view.getShoppingPanel().addMouseWheelListener(new MouseWheelListener()
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
                view.getShoppingPanel().setScrollpos(scroll);
                
                //Check if out of bounds 
                if (model.getShoppingListData().getFirstLine()+scroll < 0)
                {
                    //Do not scroll
                }
                else if (model.getShoppingListData().getLastLine()+scroll >= model.getShoppingListData().getShoppingListList().size())
                {
                    //Do not scroll
                } 
                //if not out of bounds
                else
                {
                    //if scroll is positive increment recipedata lines
                    if (scroll > 0)
                    {
                        model.getShoppingListData().setFirstLine(model.getShoppingListData().getFirstLine()+1);
                        model.getShoppingListData().setLastLine(model.getShoppingListData().getLastLine()+1);
                    }
                    
                    //else scroll is negative and deincrement recipedata lines
                    else
                    {
                       model.getShoppingListData().setFirstLine(model.getShoppingListData().getFirstLine()-1);
                       model.getShoppingListData().setLastLine(model.getShoppingListData().getLastLine()-1); 
                    }
                    
                    //update views datapanel with new line information
                    view.getShoppingPanel().updateDataPanel(model.getShoppingListData().getShoppingListList(), model.getShoppingListData().getFirstLine());
                }
            }
        });

    }
    
}
