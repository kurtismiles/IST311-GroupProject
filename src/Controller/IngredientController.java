package Controller;

import Model.Ingredient;
import Model.IngredientModel;
import Model.Recipe;
import View.IngredientPop;
import View.IngredientView;
import View.MenuPop;
import View.RecipePop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Kurtis
 */
public class IngredientController {
    
    private IngredientModel model;
    private IngredientView view;
    private IngredientPop popup;
    
    private MenuPop menupop;
    
    public IngredientController(){}
    
    public IngredientController(IngredientModel model, IngredientView view)
    {
       this.model = model;
       this.view = view;
       
       addListeners();
       
       view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());
    }

    /**
     * @return the model
     */
    public IngredientModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(IngredientModel model) {
        this.model = model;
    }

    /**
     * @return the view
     */
    public IngredientView getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(IngredientView view) {
        this.view = view;
    }

        
    private void addListeners()
    {
                //Action listener for Create Button in Recipe Panel
        view.getIngredientPanel().getCreateButton().addActionListener(new ActionListener()
        {
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {   
                        //create a new recipepop
                        popup = new IngredientPop();
                        
                        //add listener to create button in recipepop
                        popup.getCreateBtn().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae)
                            {   
                                //checks to see if any RecipePop fields are empty
                                if (!popup.getNameText().getText().isEmpty() && !popup.getDescriptionText().getText().isEmpty() && !popup.getTagsText().getText().isEmpty())
                                {
                                    //if non are empty, create a new recipe
                                    model.writeIngredient(new Ingredient(popup.getNameText().getText(), popup.getDescriptionText().getText(), popup.getTagsText().getText()));
                                    
                                    //dispose popup frame
                                    popup.dispose();
                                    
                                    //refresh data in view recipe panel
                                    view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());
                                    
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
        
                    //Action Listener for JButtons in RecipePanel
        for(int i = 0; i < view.getIngredientPanel().getJb().length; ++i)
        {
            view.getIngredientPanel().getJb(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    JButton currentButton = (JButton) ae.getSource();
                    
                    int position = 0;
                    
                    //find what position current button is in array
                    for (int j = 0; j < view.getIngredientPanel().getJb().length; ++j)
                    {
                        if (view.getIngredientPanel().getJb(j).equals(currentButton))
                        {
                            position = j;
                            break;
                        }
                    }
                    
                    //create a new menu popup with recipe data from button pressed
                    menupop = new MenuPop(model.getIngredientData().getIngredientList().get(model.getIngredientData().getFirstLine() + position));   
                }
            });
        }  
        
        view.getIngredientPanel().getSave().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
           
            }
        });
        view.getIngredientPanel().getDelete().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
                 
            }
        });
        
        
    }
}
