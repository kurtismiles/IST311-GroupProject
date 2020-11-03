package Controller;

import Model.NavigationModel;
import Model.RecipeModel;
import Model.StarterModel;
import View.MainFrame;
import View.NavigationView;
import View.RecipeView;
import View.StarterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kurtis
 */
public class NavigationController {
 
        private NavigationModel navigationModel;
        private NavigationView navigationView;
    
        private StarterControl starterControl;
        private StarterModel starterModel;
        private StarterView starterView;
        
        private RecipeController recipeControl;
        private RecipeModel recipeModel;
        private RecipeView recipeView;
        
public NavigationController(){}        
        
        
public NavigationController(NavigationModel navigationModel, NavigationView navigationView)
{
    this.navigationModel = navigationModel;
    this.navigationView = navigationView;
    
    starterModel = new StarterModel();
    starterView = new StarterView();
    starterControl = new StarterControl(starterModel, starterView);
    
    recipeModel = new RecipeModel();
    recipeView = new RecipeView();
    recipeControl = new RecipeController(recipeModel, recipeView);
    
    navigationView.getMainframe().updateFrame(starterControl.getView().getLoginPanel());
    AddListeners();
}

public void AddListeners(){
    
        //Listener for submit button in LoginPanel
        starterControl.getView().getLoginPanel().getSubmit().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {  
                //if Username and Password are correct
                if (starterControl.getModel().Authorize(starterControl.getView().getLoginPanel().getUser().getText(), starterControl.getView().getLoginPanel().getPass().getText()))
                {
                    //print success message and move to MainPanel
                    System.out.println("Authoization Success. Taking you to new Panel");
                    navigationView.getMainframe().updateFrame(starterControl.getView().getMainPanel());
                } else 
                {
                    //print failed message
                    System.out.println("Authorization Failed. Try Again");
                }   
            } 
        });
        
    
        //MainPanel Recipe Button Listener
        starterControl.getView().getMainPanel().getB1().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {

                //pass control to RecipeController by updating mainframe displayed panel
                navigationView.getMainframe().updateFrame(recipeControl.getView().getRecipePanel());

                //back button listener in RecipePanel
                recipeControl.getView().getRecipePanel().getBackButton().addActionListener(new ActionListener()
                {
                    //pass control back to mainPanel
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        //pass control back to mainPanel
                        navigationView.getMainframe().updateFrame(starterControl.getView().getMainPanel());
                    }
                });
            }
        });
}


}


