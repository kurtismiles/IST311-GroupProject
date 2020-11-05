//COPYRIGHT (C) 2020 Avina Lin Yuki (Registered as Leslin Mathews). All Rights Reserved.
//@author Avina (Leslin) referred as Avina
//@email lum776@psu.edu
package View;

import Model.Recipe;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class RecipePanel extends JPanel {

    private JButton back;
    private JButton create;
    
    private JPanel dataPanel;
    JButton[] jb;
    
    public RecipePanel() {
        
        setLayout(new GridBagLayout());
        JPanel ip[] = new JPanel[3];
        GridBagConstraints gbc[] = new GridBagConstraints[ip.length];
        for (int i = 0; i < ip.length; i++) {
            ip[i] = new JPanel();
            gbc[i] = new GridBagConstraints();
        }
        //---------------------------Inner Panel Layouts
        ip[0].setLayout(new GridBagLayout());
        //---------------------------Back Button
        back = new JButton("back");
        create = new JButton("create");
        gbc[0].gridx = 1;
        gbc[0].gridy = 0;
        gbc[0].ipadx = 20;
        gbc[0].ipady = 20;
        ip[0].add(back, gbc[0]);
        gbc[0] = new GridBagConstraints();
        //---------------------------IP 2
        initializeDataPanel();
        
        
        dataPanel.setBackground(Color.orange);
        //---------------------------IP 1
        ip[1].setLayout(new BorderLayout());
        ip[1].add(new JLabel("Search"), "North");
        ip[1].add(new JScrollBar(), "East");
        ip[1].add(dataPanel, "Center");
        //---------------------------IP 0
        gbc[0].gridy = 1;
        ip[0].add(new JLabel("Recipes"), gbc[0]);
        gbc[1].gridy = 2;
        gbc[1].ipadx = 40;
        gbc[1].ipady = 50;
        ip[1].setBackground(Color.pink);
        ip[0].add(ip[1], gbc[1]);
        gbc[0].gridy = 3;
        ip[0].add(new JButton("Last Line"), gbc[0]);
        //ip[0].add(new JButton("Button 2"), gbc[0]);
        //ip[0].add(new JButton("Button 3"), gbc[0]);
        //---------------------------Final
        add(ip[0]);
        add(create);
    }
    /**
     * @return the back
     */
    public JButton getBackButton()
    {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBackButton(JButton back)
    {
        this.back = back;
    }

    public JButton getCreateButton()
    {
        return create;
    }

    public void setCreateButton(JButton create)
    {
        this.create = create;
    }
    
    public void initializeDataPanel()
    {
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        GridBagConstraints pos = new GridBagConstraints();
        pos.ipadx = 400;
        pos.ipady = 70;
        
        jb = new JButton[5];
        for (int i = 0; i < jb.length; i++) {
        jb[i] = new JButton();
        pos.gridy = i;
        dataPanel.add(jb[i], pos);
        }
        
    }
    
    public void updateDataPanel(ArrayList<Recipe> recipeList, int firstLine, int lastLine)
    {
        
        int displayLine = firstLine;
        
        if (recipeList.size() < 5)
        {
            for (int i = 0; i < recipeList.size(); ++i)
            {
            jb[i].setText(recipeList.get(i).getName()); 
            }
        } else 
        {
                    
        for (int i = 0; i < 5 ; ++i)
        {
            jb[i].setText(recipeList.get(displayLine).getName());
            ++displayLine;
        }
        }    
    }
}
