package Controller;

import Model.Ingredient;
import Model.IngredientModel;
import View.IngredientPop;
import View.IngredientView;
import View.MenuPop;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Kurtis
 * @editor Leslin (Avina)
 */
public class IngredientController {

    private IngredientModel model;
    private IngredientView view;
    private IngredientPop popup;
    private MenuPop menupop;

    private int sTrack = 0;

    public IngredientController() {
    }

    public IngredientController(IngredientModel model, IngredientView view) {
        this.model = model;
        this.view = view;

        scrollMod();
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

    private void addListeners() {
        //Action listener for Create Button in Ingredient Panel
        view.getIngredientPanel().getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //create a new IngredientPop
                popup = new IngredientPop();

                //add listener to create button in popup
                popup.getCreateBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //checks to see if any RecipePop fields are empty
                        if (!popup.getNameText().getText().isEmpty() && !popup.getDescriptionText().getText().isEmpty() && !popup.getTagsText().getText().isEmpty()) {
                            //if non are empty, create a new recipe
                            model.writeIngredient(new Ingredient(popup.getNameText().getText(), popup.getDescriptionText().getText(), popup.getTagsText().getText()));

                            //dispose popup frame
                            popup.dispose();

                            //refresh data in view recipe panel
                            view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());
                            scrollMod();

                        } //error message if one of the fields are empty
                        else {
                            System.out.println("Error: placeholder error message");
                        }

                    }
                });
            }

        });

        //Action Listener for JButtons in IngredientPanel
        for (int i = 0; i < view.getIngredientPanel().getJb().length; ++i) {
            view.getIngredientPanel().getJb(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    JButton currentButton = (JButton) ae.getSource();

                    int position = 0;

                    //find what position current button is in array
                    for (int j = 0; j < view.getIngredientPanel().getJb().length; j++) {
                        if (view.getIngredientPanel().getJb(j).equals(currentButton)) {
                            position = j;

                            //Delete function, work in progress
                            if (view.getIngredientPanel().getDelete().getBackground().equals(Color.orange)) {
//                                model.getIngredientData().removeIngredient(model.getIngredientData().getIngredientList().get(model.getIngredientData().getFirstLine() + position));
//                                
//                                model.getIngredientData().saveXMLList();
//                                
//                                model.refreshIngredientList();
//                                
//                                view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());

                            } else //try to create a new MenuPopup with Ingredient data
                            {
                                try {
                                    menupop = new MenuPop(model.getIngredientData().getIngredientList().get(model.getIngredientData().getFirstLine() + position));
                                } catch (Exception error) {
                                    System.out.println("Sorry I cant click that button");
                                }

                            }
                        }
                    }
                }

            });
        }

        //Save button in IngredientPanel, currently non functional
        view.getIngredientPanel().getSave().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            }
        });

        //Delete button in IngredientPanel, currently non functional
        view.getIngredientPanel().getDelete().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                //If button is already orange, reset background color
                if (view.getIngredientPanel().getDelete().getBackground().equals(Color.orange)) {
                    view.getIngredientPanel().getDelete().setBackground(new JButton().getBackground());
                } else //Set background button color to orange
                {
                    view.getIngredientPanel().getDelete().setBackground(Color.orange);
                }
            }
        });

        //Mouse scroll listener for Ingredient Panel
        view.getIngredientPanel().addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent we) {
                int scroll;

                //reduce scroll units to 1
                if (we.getUnitsToScroll() > 0) {
                    scroll = 1;
                } else {
                    scroll = -1;
                }

                //Check if out of bounds 
                if (model.getIngredientData().getFirstLine() + scroll < 0) {
                    //Do not scroll
                } else if (model.getIngredientData().getLastLine() + scroll >= model.getIngredientData().getIngredientList().size()) {
                    //Do not scroll
                } //if not out of bounds
                else {
                    //if scroll is positive increment recipedata lines
                    if (scroll > 0) {
//                        System.out.println("Mouse Scroll DOWN: " + scroll);
                        model.getIngredientData().setFirstLine(model.getIngredientData().getFirstLine() + 1);
                        model.getIngredientData().setLastLine(model.getIngredientData().getLastLine() + 1);
                        sTrack = sTrack + 1;
                    } //else scroll is negative and deincrement recipedata lines
                    else {
                        model.getIngredientData().setFirstLine(model.getIngredientData().getFirstLine() - 1);
                        model.getIngredientData().setLastLine(model.getIngredientData().getLastLine() - 1);
                        sTrack = sTrack - 1;
                    }

                    //update scroll wheel
                    view.getIngredientPanel().setScrollpos(scroll);

                    //update views datapanel with new line information
                    view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());
                }
            }
        });

        //Scrollbar adjustment listener for Ingredient Panel
        view.getIngredientPanel().getScroll().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                int scroll;

//                System.out.println(view.getIngredientPanel().getScroll().getValueIsAdjusting());
//                System.out.println(ae.getValue() + " sTrack =" + sTrack);
//                System.out.println("Unit:" + view.getIngredientPanel().getScroll().getUnitIncrement());
                if (view.getIngredientPanel().getScroll().getValueIsAdjusting() == Boolean.TRUE || view.getIngredientPanel().getScroll().getUnitIncrement() != 0) {

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
                    if (model.getIngredientData().getFirstLine() + scroll < 0) {
                        //Do not scroll
                    } else if (model.getIngredientData().getLastLine() + scroll >= model.getIngredientData().getIngredientList().size()) {
                        //Do not scroll
                    } //if not out of bounds
                    else {
                        //if scroll is positive increment recipedata lines
                        if (scroll > 0) {
                            model.getIngredientData().setFirstLine(model.getIngredientData().getFirstLine() + scroll);
                            model.getIngredientData().setLastLine(model.getIngredientData().getLastLine() + scroll);
                        } //else scroll is negative and deincrement recipedata lines
                        else {
                            model.getIngredientData().setFirstLine(model.getIngredientData().getFirstLine() + scroll);
                            model.getIngredientData().setLastLine(model.getIngredientData().getLastLine() + scroll);
                        }

                        //update views datapanel with new line information
                        view.getIngredientPanel().updateDataPanel(model.getIngredientData().getIngredientList(), model.getIngredientData().getFirstLine());
                    }
                }
            }
        });
    }

    private void scrollMod() {
        //Modify Scroll Limits
        if (view.getIngredientPanel().getJb().length < model.getIngredientData().getIngredientList().size()) {   //Negative numbers cause scroll max bug
            view.getIngredientPanel().getScroll().setMaximum(10 + Math.abs(view.getIngredientPanel().getJb().length - model.getIngredientData().getIngredientList().size()));
        } else {
            this.view.getIngredientPanel().getScroll().setMaximum(10);   //Blank scroll
        }
    }
}
