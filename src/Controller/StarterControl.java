/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.StarterView;
import Model.StarterModel;

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

        //view.updatePanel(view.getLoginPanel());
        view.updatePanel(view.getMainPanel());
    }
    
}
