package Controller;

import Model.IngredientModel;
import Model.Recipe;
import View.IngredientPop;
import View.IngredientView;
import View.RecipePop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kurtis
 */
public class IngredientController {
    
    private IngredientModel model;
    private IngredientView view;
    private IngredientPop popup;
    
    public IngredientController(){}
    
    public IngredientController(IngredientModel model, IngredientView view)
    {
       this.model = model;
       this.view = view;
       
       addListeners();
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
                        
//                        //add listener to create button in recipepop
//                        popup.getCreateBtn().addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent ae)
//                            {   
//                                //checks to see if any RecipePop fields are empty
//                                if (!popup.getNameText().getText().isEmpty() && !popup.getDescriptionText().getText().isEmpty() && !popup.getIngredientText().getText().isEmpty() && !popup.getTagsText().getText().isEmpty())
//                                {
//                                    //if non are empty, create a new recipe
//                                    model.writeIngredient(new Ingredient(popup.getNameText().getText(), popup.getDescriptionText().getText(), popup.getIngredientText().getText(), popup.getTagsText().getText()));
//                                    
//                                    //dispose popup frame
//                                    popup.dispose();
//                                    
//                                    //refresh data in view recipe panel
//                                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
//                                    
//                                }
//                                //error message if one of the fields are empty
//                                else
//                                {
//                                    System.out.println("Error: placeholder error message");
//                                }
//                                
//                            }
//                        });     
                    }

        });
        
        
    }
}
