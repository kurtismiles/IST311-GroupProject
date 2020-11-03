/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Kurtis
 */
public class MainFrame extends JFrame
{

    private JPanel currentPanel;

    public MainFrame()
    {
        super("Recipe Application");
        setupLayoutForMacs();
        currentPanel = new JPanel();
        add(currentPanel);
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
    }

    private void setupLayoutForMacs()
    {
        //On some MACs it might be necessary to have the statement below 
        //for the background color of the button to appear    
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //------------------------------------------------------
    }

    public JPanel getCurrentPanel()
    {
        return currentPanel;
    }

    public void setCurrentPanel(JPanel inputPanel)
    {
        this.currentPanel = inputPanel;
    }

    public void updateFrame(JPanel updatePanel)
    {
        remove(currentPanel);
        this.currentPanel = updatePanel;
        add(currentPanel);
        repaint();
        validate();
    }
}
