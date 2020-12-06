package View;

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
