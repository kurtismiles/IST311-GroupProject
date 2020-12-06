package Controller;

import Model.IngredientModel;
import Model.Recipe;
import Model.RecipeModel;
import View.RecipeView;
import View.MenuPop;
import View.RecipePop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JButton;

/**
 *
 * @author Kurtis
 * @editors Leslin (Avina)
 */
public class RecipeController {

    private RecipeModel model;
    private RecipeView view;
    private RecipePop popup;
    private MenuPop menupop;

    private IngredientModel ingredientModel;

    private int sTrack = 0;

    public RecipeController() {
    }

    public RecipeController(RecipeModel model, RecipeView view, IngredientModel ingredientModel) {
        this.model = model;
        this.view = view;

        this.ingredientModel = ingredientModel;

        scrollMod();
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

    private void addListeners() {

        //Action listener for Create Button in Recipe Panel
        view.getRecipePanel().getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //create a new recipepop
                ingredientModel.refreshIngredientList();
                popup = new RecipePop(ingredientModel.getIngredientData().getIngredientList());

                //add listener to create button in recipepop
                popup.getRecipePanel().getCreateBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //checks to see if any RecipePop fields are empty
                        if (!popup.getRecipePanel().getNameText().getText().isEmpty() && !popup.getRecipePanel().getDescriptionText().getText().isEmpty()
                                && !popup.getRecipePanel().getIngredientData().isEmpty() && !popup.getRecipePanel().getTagsText().getText().isEmpty()) {
                            //if non are empty, create a new recipe
                            model.writeRecipe(new Recipe(popup.getRecipePanel().getNameText().getText(), popup.getRecipePanel().getDescriptionText().getText(),
                                    popup.getRecipePanel().getIngredientData(), popup.getRecipePanel().getTagsText().getText(), popup.getRecipePanel().getCategoryData()));

                            //dispose popup frame
                            popup.dispose();

                            //refresh data in view recipe panel
                            view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
                            scrollMod();

                        } //error message if one of the fields are empty
                        else {
                            System.out.println("Error: placeholder error message");
                        }

                    }
                });
                popup.getRecipePanel().getAddBtn().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        popup.getRecipePanel().addIngredient();
                    }
                });

                popup.getRecipePanel().getDelBtn().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        popup.getRecipePanel().removeIngredient();
                    }
                });
                
                popup.getRecipePanel().getCategoryAdd().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        popup.getRecipePanel().addCategory();
                    }
                });
                
                popup.getRecipePanel().getCategoryDel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        popup.getRecipePanel().removeCategory();
                    }
                });
                
            }

        });

        //Action Listener for JButtons in RecipePanel
        for (int i = 0; i < view.getRecipePanel().getJb().length; ++i) {
            view.getRecipePanel().getJb(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    JButton currentButton = (JButton) ae.getSource();

                    int position = 0;

                    //find what position current button is in array
                    for (int j = 0; j < view.getRecipePanel().getJb().length; ++j) {
                        if (view.getRecipePanel().getJb(j).equals(currentButton)) {
                            position = j;
                            break;
                        }
                    }

                    try {
                        //create a new menu popup with recipe data from button pressed
                        menupop = new MenuPop(model.getRecipeData().getRecipeList().get(model.getRecipeData().getFirstLine() + position));

                        //Recipe pop panel double recipe portion button
                        menupop.getPopPanel().getX2().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                menupop.getPopPanel().setMultiplier(menupop.getPopPanel().getMultiplier() * 2);
                                menupop.getPopPanel().update();
                            }
                        });
                        //Recipe pop panel reset recipe portion button
                        menupop.getPopPanel().getReset().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                menupop.getPopPanel().setMultiplier(1);
                                menupop.getPopPanel().update();
                            }
                        });
                        //Recipe pop panel halve recipe portion button
                        menupop.getPopPanel().getHalf().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                menupop.getPopPanel().setMultiplier(menupop.getPopPanel().getMultiplier() / 2);
                                menupop.getPopPanel().update();
                            }
                        });
                        menupop.getPopPanel().getFavorite().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                if (!menupop.getPopPanel().getReadRecipe().getFavorite()) {
                                    menupop.getPopPanel().getReadRecipe().setFavorite(true);
                                } else {
                                    menupop.getPopPanel().getReadRecipe().setFavorite(false);
                                }
                                System.out.println(menupop.getPopPanel().getReadRecipe().getFavorite());
                                model.getRecipeData().saveXMLList();
                                menupop.getPopPanel().favoriteRefresh();
                            }

                        });

                        for (int i = 0; i < menupop.getPopPanel().getRatings().length; i++) {
                            int pos = i;
                            menupop.getPopPanel().getRatings()[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    menupop.getPopPanel().getReadRecipe().setRating(pos);
                                    menupop.getPopPanel().rateRefresh();
                                    model.getRecipeData().saveXMLList();
                                }
                            });
                        }
                    } catch (Exception error) {
                        System.out.println("Sorry I cant click that button");
                        System.out.println(error);
                    }

                }
            });
        }
        //Recipe panel save recipe button
        view.getRecipePanel().getSave().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });
        //Recipe panel delete recipe button
        view.getRecipePanel().getDelete().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });

        //Mouse scroll listener for Ingredient Panel
        view.getRecipePanel().addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent we) {
                int scroll;

                //reduce scroll units to 1
                if (we.getUnitsToScroll() > 0) {
                    scroll = 1;
                } else {
                    scroll = -1;
                }

                //Check if out of bounds 
                if (model.getRecipeData().getFirstLine() + scroll < 0) {
                    //Do not scroll
                } else if (model.getRecipeData().getLastLine() + scroll >= model.getRecipeData().getRecipeList().size()) {
                    //Do not scroll
                } //if not out of bounds
                else {
                    //if scroll is positive increment recipedata lines
                    if (scroll > 0) {
//                        System.out.println("Mouse Scroll DOWN: " + scroll);
                        model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine() + 1);
                        model.getRecipeData().setLastLine(model.getRecipeData().getLastLine() + 1);
                        sTrack = sTrack + 1;
                    } //else scroll is negative and deincrement recipedata lines
                    else {
                        model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine() - 1);
                        model.getRecipeData().setLastLine(model.getRecipeData().getLastLine() - 1);
                        sTrack = sTrack - 1;
                    }

                    //update scroll wheel
                    view.getRecipePanel().setScrollpos(scroll);

                    //update views datapanel with new line information
                    view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
                }
            }
        });

        //Scrollbar adjustment listener for Ingredient Panel
        view.getRecipePanel().getScroll().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                int scroll;

//                System.out.println(view.getIngredientPanel().getScroll().getValueIsAdjusting());
//                System.out.println(ae.getValue() + " sTrack =" + sTrack);
//                System.out.println("Unit:" + view.getIngredientPanel().getScroll().getUnitIncrement());
                if (view.getRecipePanel().getScroll().getValueIsAdjusting() == Boolean.TRUE || view.getRecipePanel().getScroll().getUnitIncrement() != 0) {

                    //Scroll units to current/final position
                    if (ae.getValue() > sTrack) {
                        scroll = ae.getValue() - sTrack;
                        sTrack = ae.getValue();
//                        System.out.println("Adjustment Scroll DOWN: " + scroll);
                    } else {
                        scroll = ae.getValue() - sTrack;
                        sTrack = ae.getValue();
//                        System.out.println("Adjustment Scroll UP: " + scroll);
                    }

                    //Check if out of bounds 
                    if (model.getRecipeData().getFirstLine() + scroll < 0) {
                        //Do not scroll
                    } else if (model.getRecipeData().getLastLine() + scroll >= model.getRecipeData().getRecipeList().size()) {
                        //Do not scroll
                    } //if not out of bounds
                    else {
                        //if scroll is positive increment recipedata lines
                        if (scroll > 0) {
                            model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine() + scroll);
                            model.getRecipeData().setLastLine(model.getRecipeData().getLastLine() + scroll);
                        } //else scroll is negative and deincrement recipedata lines
                        else {
                            model.getRecipeData().setFirstLine(model.getRecipeData().getFirstLine() + scroll);
                            model.getRecipeData().setLastLine(model.getRecipeData().getLastLine() + scroll);
                        }

                        //update views datapanel with new line information
                        view.getRecipePanel().updateDataPanel(model.getRecipeData().getRecipeList(), model.getRecipeData().getFirstLine());
                    }
                }
            }
        });
    }

    private void scrollMod() {
        //Modify Scroll Limits
        if (this.view.getRecipePanel().getJb().length < this.model.getRecipeData().getRecipeList().size()) {   //Negative numbers cause scroll max bug
            this.view.getRecipePanel().getScroll().setMaximum(10 + Math.abs(this.view.getRecipePanel().getJb().length - this.model.getRecipeData().getRecipeList().size()));
        } else {
            this.view.getRecipePanel().getScroll().setMaximum(10);   //Blank scroll
        }
    }
}
