package Controller;

import Model.Ingredient;
import Model.IngredientModel;
import Model.Recipe;
import View.IngredientPop;
import View.IngredientView;
import View.MenuPop;
import View.RecipePopPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
                    for (int j = 0; j < view.getIngredientPanel().getJb().length; j++)
                    {
                        if (view.getIngredientPanel().getJb(j).equals(currentButton))
                        {
                            position = j;
                            
                            if (view.getIngredientPanel().getDelete().getBackground().equals(Color.orange))
                            {
//                                model.getIngredientData().removeIngredient(model.getIngredientData().getIngredientList().get(model.getIngredientData().getFirstLine() + position));
//                                
//                                model.getIngredientData().saveXMLList();
//                                
//                                model.refreshIngredientList();
//                                
//                                view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());
                                

                            }
                            
                            
                            else
                            {
                                
                                try{menupop = new MenuPop(model.getIngredientData().getIngredientList().get(model.getIngredientData().getFirstLine() + position));}
                                catch(Exception error)
                                {
                                System.out.println("Sorry I cant click that button");
                                }

                            }
     
                        }
                        
                      
                        
                       
                    
                                
//                        else 
//                        {
//                            JOptionPane.showMessageDialog(view.getIngredientPanel(),"No ingredients found","Error", JOptionPane.ERROR_MESSAGE); 
//                            break;
// 
//                        }

                    }
                    // added the ability to highlight JButtons while Delete is highlighted
                    
//                    for (int k = 0; k < view.getIngredientPanel().getJb().length; k++)
//                    {
//                        if (view.getIngredientPanel().getDelete().getBackground().equals(Color.orange))
//                        {
//                            view.getIngredientPanel().getJb(k).);
//             
//                        } 
//                
//                        else 
//                        {
//                            view.getIngredientPanel().getDelete().setBackground(Color.orange); 
//                        
//                        }
//                        
//                        
//                        
//                    }
//                    
                    // create a new pop up error for empty buttons in ingredients 
//                    for (int k = 2; k < view.getIngredientPanel().getJb().length; k++)
//                    {
//                        if (view.getIngredientPanel().getJb(k).equals(currentButton))
//                        {
//                            position = k;
//                            
//                            JOptionPane.showMessageDialog(view.getIngredientPanel(),"No ingredients found","Error", JOptionPane.ERROR_MESSAGE); 
//                        }  
//                    }
                }
                
            });
        }  
        
        
        
        view.getIngredientPanel().getSave().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
                //view.getIngredientPanel().getDelete().setBackground(Color.gray);
                
                
            }
        });
        
        
        view.getIngredientPanel().getDelete().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
             

                if (view.getIngredientPanel().getDelete().getBackground().equals(Color.orange))
                {
                    view.getIngredientPanel().getDelete().setBackground(new JButton().getBackground());
                    
             
                } 
                
                else {
                    
                    view.getIngredientPanel().getDelete().setBackground(Color.orange); 

                }
                
                
                        
//                for (int i = 0; i < view.getIngredientPanel().getJb().length; ++i)
//                {
//                    view.getIngredientPanel().getJb(i).addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent ae){
//
//                                if ()
//                            
//                            }
//                     
//                    });
//           
//                }

//                for (int j = 0; j < 10; j++)
//                {
//                    for (int i = 0; i < view.getIngredientPanel().getDelete(); i++) {   //this doesnt work inside inner classes
//                        if (ae.getSource() == view.getIngredientPanel().getJb()[i]) {
//                            for (int eraser = 0; eraser < view.getIngredientPanel().getJb().length; eraser++) {
//                                
//                            }
//                            view.getJb()[i].setBackground(Color.orange);
//                            
//                            //System.out.println(i);   //tester
//                            break;
//                        }
//                    }
                    
                    
//                }
                 
            }
        });
        
        
         
        //Mouse scroll listener for Recipe Panel
        view.getIngredientPanel().addMouseWheelListener(new MouseWheelListener()
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
                view.getIngredientPanel().setScrollpos(scroll);
                
                //Check if out of bounds 
                if (model.getIngredientData().getFirstLine()+scroll < 0)
                {
                    //Do not scroll
                }
                else if (model.getIngredientData().getLastLine()+scroll >= model.getIngredientData().getIngredientList().size())
                {
                    //Do not scroll
                } 
                //if not out of bounds
                else
                {
                    //if scroll is positive increment recipedata lines
                    if (scroll > 0)
                    {
                        model.getIngredientData().setFirstLine(model.getIngredientData().getFirstLine()+1);
                        model.getIngredientData().setLastLine(model.getIngredientData().getLastLine()+1);
                    }
                    
                    //else scroll is negative and deincrement recipedata lines
                    else
                    {
                       model.getIngredientData().setFirstLine(model.getIngredientData().getFirstLine()-1);
                       model.getIngredientData().setLastLine(model.getIngredientData().getLastLine()-1); 
                    }
                    
                    //update views datapanel with new line information
                    view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());
                }
            }
        });
        
        
    }
}
