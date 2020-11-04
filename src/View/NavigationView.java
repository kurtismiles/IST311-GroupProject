/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Kurtis
 */
public class NavigationView
{
    private MainFrame mainframe;
    
    public NavigationView()
    {
        mainframe = new MainFrame();
    }

    /**
     * @return the mainframe
     */
    public MainFrame getMainframe() {
        return mainframe;
    }

    /**
     * @param mainframe the mainframe to set
     */
    public void setMainframe(MainFrame mainframe) {
        this.mainframe = mainframe;
    }
    
    
    
}
