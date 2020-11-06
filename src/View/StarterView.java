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
    private LoginPanel loginPanel;
    private MainPanel mainPanel;

    public StarterView()
    {
        loginPanel = new LoginPanel();
        mainPanel = new MainPanel();
    }

    public LoginPanel getLoginPanel()
    {
        return loginPanel;
    }

    public void setLoginPanel(LoginPanel inputLogin)
    {
        this.loginPanel = inputLogin;
    }

    public MainPanel getMainPanel()
    {
        return mainPanel;
    }

    public void setMainPanel(MainPanel inputMain)
    {
        this.mainPanel = inputMain;
    }

}
