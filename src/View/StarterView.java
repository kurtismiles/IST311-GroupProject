/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JPanel;

/**
 *
 * @author Kurtis
 */
public class StarterView
{
    private MainFrame mainFrame;
    private LoginPanel loginPanel;
    
    public StarterView()
    {
        mainFrame = new MainFrame();
        loginPanel = new LoginPanel();
    }
    
    public MainFrame getMainFrame()
    {
        return mainFrame;
    }
    
    public void setMainFrame(MainFrame inputFrame)
    {
        this.mainFrame = inputFrame;
    }
    
    public LoginPanel getLoginPanel()
    {
        return loginPanel;
    }
    
    public void setLoginPanel(LoginPanel inputLogin)
    {
        this.loginPanel = inputLogin;
    }
    
    public void updatePanel(JPanel updatePanel)
    {
        mainFrame.updateFrame(updatePanel);
    }
}
