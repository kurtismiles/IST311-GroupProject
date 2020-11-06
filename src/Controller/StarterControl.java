/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.StarterView;
import Model.StarterModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kurtis
 */
public class StarterControl
{
    private StarterView view;
    private StarterModel model;

    public StarterControl()
    {
        //empty constructor
    }

    public StarterControl(StarterModel model, StarterView view)
    {
        this.model = model;
        this.view = view;

    }

    /**
     * @return the view
     */
    public StarterView getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(StarterView view) {
        this.view = view;
    }

    /**
     * @return the model
     */
    public StarterModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(StarterModel model) {
        this.model = model;
    }
}
