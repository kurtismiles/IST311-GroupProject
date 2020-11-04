//COPYRIGHT (C) 2020 Avina Lin Yuki (Registered as Leslin Mathews). All Rights Reserved.
//@author Avina (Leslin) referred as Avina
//@email lum776@psu.edu
package View;

import java.awt.*;
import javax.swing.*;

public class RecipePanel extends JPanel {

    private JButton back;

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
        gbc[0].gridx = 1;
        gbc[0].gridy = 0;
        gbc[0].ipadx = 20;
        gbc[0].ipady = 20;
        ip[0].add(back, gbc[0]);
        gbc[0] = new GridBagConstraints();
        //---------------------------IP 2
        ip[2].setLayout(new GridBagLayout());
        JButton jb[] = new JButton[5];
        gbc[2].ipadx = 400;
        gbc[2].ipady = 70;
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JButton();
            gbc[2].gridy = i;
            ip[2].add(jb[i], gbc[2]);
        }
        ip[2].setBackground(Color.orange);
        //---------------------------IP 1
        ip[1].setLayout(new BorderLayout());
        ip[1].add(new JLabel("Search"), "North");
        ip[1].add(new JScrollBar(), "East");
        ip[1].add(ip[2], "Center");
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
    }

    public void addAllPanels() {

    }

    /**
     * @return the back
     */
    public JButton getBackButton() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBackButton(JButton back) {
        this.back = back;
    }
}
