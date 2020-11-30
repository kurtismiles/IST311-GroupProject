package Controller;

import Model.RecipeModel;
import Model.ShoppingList;
import Model.ShoppingListModel;
import View.MenuPop;
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
public class ShoppingListController {

    private ShoppingListModel model;
    private ShoppingListView view;
    private RecipeModel recipeModel;

    private ShoppingListPop popup;
    private MenuPop menupop;

    public ShoppingListController() {
    }

    public ShoppingListController(ShoppingListModel model, ShoppingListView view, RecipeModel recipeModel) {
        this.model = model;
        this.view = view;
        this.recipeModel = recipeModel;

        scrollMod();
        addListeners();

        view.getShoppingPanel().updateDataPanel(model.getShoppingListData().getShoppingListList(), model.getShoppingListData().getFirstLine());
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

    private void addListeners() {

        //Action listener for Create Button in ShoppingList Panel
        view.getShoppingPanel().getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //create a new recipepop
                //ingredientModel.refreshIngredientList();
                popup = new ShoppingListPop(recipeModel.getRecipeData().getRecipeList());

                //add listener to create button in shoppinglist pop
                popup.getShoppingPanel().getCreateBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //checks to see if any ShoppingListPop fields are empty
                        if (!popup.getShoppingPanel().getShoppingName().getText().isEmpty()) {
                            //if non are empty, create a new shopping list
                            model.writeShoppingList(new ShoppingList(popup.getShoppingPanel().getShoppingName().getText(), popup.getShoppingPanel().returnSelected(), model.buildShoppingList(popup.getShoppingPanel().returnSelected())));

                            //dispose popup frame
                            popup.dispose();

                            //refresh data in view recipe panel
                            view.getShoppingPanel().updateDataPanel(model.getShoppingListData().getShoppingListList(), model.getShoppingListData().getFirstLine());
                            scrollMod();

                        }//error message if one of the fields are empty
                        else {
                            System.out.println("Error: placeholder error message");
                        }

                    }
                });

                //Action listener for Add ShoppingList Button in ShoppingList Pop Panel
                popup.getShoppingPanel().getAddBtn().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        popup.getShoppingPanel().addIngredient();
                    }
                });

                //Action listener for Delete ShoppingList Button in ShoppingList Pop Panel
                popup.getShoppingPanel().getDelBtn().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        popup.getShoppingPanel().delIngredient();
                    }
                });
            }

        });

        //Action Listener for JButtons in ShoppingPanel
        for (int i = 0; i < view.getShoppingPanel().getJb().length; ++i) {
            view.getShoppingPanel().getJb(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    JButton currentButton = (JButton) ae.getSource();

                    int position = 0;

                    //find what position current button is in array
                    for (int j = 0; j < view.getShoppingPanel().getJb().length; ++j) {
                        if (view.getShoppingPanel().getJb(j).equals(currentButton)) {
                            position = j;
                            break;
                        }
                    }

                    //create a new menu popup with data from button pressed  
                    try {
                        menupop = new MenuPop(model.getShoppingListData().getShoppingListList().get(model.getShoppingListData().getFirstLine() + position));
                    } catch (Exception error) {
                        System.out.println("Sorry I cant click that button");
                    }
                }
            });
        }

        view.getShoppingPanel().getSave().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });
        view.getShoppingPanel().getDelete().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });

        //Mouse scroll listener for ShoppingPanel
        view.getShoppingPanel().addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent we) {
                int scroll;

                //reduce scroll units to 1
                if (we.getUnitsToScroll() > 0) {
                    scroll = 1;
                } else {
                    scroll = -1;
                }

                //update scroll wheel
                view.getShoppingPanel().setScrollpos(scroll, model.getShoppingListData().getShoppingListList().size());

                //Check if out of bounds 
                if (model.getShoppingListData().getFirstLine() + scroll < 0) {
                    //Do not scroll
                } else if (model.getShoppingListData().getLastLine() + scroll >= model.getShoppingListData().getShoppingListList().size()) {
                    //Do not scroll
                } //if not out of bounds
                else {
                    //if scroll is positive increment data lines
                    if (scroll > 0) {
                        model.getShoppingListData().setFirstLine(model.getShoppingListData().getFirstLine() + 1);
                        model.getShoppingListData().setLastLine(model.getShoppingListData().getLastLine() + 1);
                    } //else scroll is negative and deincrement data lines
                    else {
                        model.getShoppingListData().setFirstLine(model.getShoppingListData().getFirstLine() - 1);
                        model.getShoppingListData().setLastLine(model.getShoppingListData().getLastLine() - 1);
                    }

                    //update views datapanel with new line information
                    view.getShoppingPanel().updateDataPanel(model.getShoppingListData().getShoppingListList(), model.getShoppingListData().getFirstLine());
                }
            }
        });

    }

    private void scrollMod() {
        //Modify Scroll Limits
        if (this.view.getShoppingPanel().getJb().length < this.model.getShoppingListData().getShoppingListList().size()) {   //Negative numbers cause scroll max bug
            this.view.getShoppingPanel().getScroll().setMaximum(10 + Math.abs(this.view.getShoppingPanel().getJb().length - this.model.getShoppingListData().getShoppingListList().size()));
        } else {
            this.view.getShoppingPanel().getScroll().setMaximum(10);   //Blank scroll
        }
    }

}
