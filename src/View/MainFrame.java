package View;

import javax.swing.*;

/**
 *
 * @author Kurtis
 */
public class MainFrame extends JFrame {

    private JPanel currentPanel;

    public MainFrame() {
        super("Recipe Application");
        setupLayoutForMacs();
        currentPanel = new JPanel();
        add(currentPanel);
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);

        setVisible(true);
    }

    private void setupLayoutForMacs() {
        //On some MACs it might be necessary to have the statement below 
        //for the background color of the button to appear    
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //------------------------------------------------------
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(JPanel inputPanel) {
        this.currentPanel = inputPanel;
    }

    public void updateFrame(JPanel updatePanel) {
        remove(currentPanel);
        this.currentPanel = updatePanel;
        add(currentPanel);
        repaint();
        validate();
    }
}
