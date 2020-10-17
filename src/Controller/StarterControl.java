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

        view.updatePanel(view.getLoginPanel());
        
        addListeners();
    }
    
    void addListeners()
    {
        view.getLoginPanel().getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println();
                authorize(view.getLoginPanel().getUsern().getText(), view.getLoginPanel().getPassw().getText());
            }
        });
    }
    
    void authorize(String username, String password)
    {
        boolean match = model.Authorize(username, password);
        if (match)
        {
            //view.updatePanel(view.getMainPanel());
            System.out.println("Authoization Success. Taking you to new Panel");
        }
        else
        {
            System.out.println("Authorization Failed. Try Again");
        }
    }
    
}
