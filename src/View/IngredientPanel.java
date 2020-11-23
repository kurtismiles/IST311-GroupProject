//COPYRIGHT (C) 2020 Avina Lin Yuki (Registered as Leslin Mathews). All Rights Reserved.
//@authors Avina (Leslin) referred as Avina, Kurtis
//@email lum776@psu.edu
package View;

import Model.Ingredient;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class IngredientPanel extends JPanel {

    private JButton back;
    private JButton create;
    private JButton delete, save;
    private JScrollBar scroll;
    private Image background;
    private JPanel dataPanel;
    JButton[] jb;

    public IngredientPanel() {

        background = (new ImageIcon("Images/RecipePanelBackground.png")).getImage();

        setLayout(new GridBagLayout());
        JPanel ip[] = new JPanel[6];
        GridBagConstraints gbc[] = new GridBagConstraints[2];
        for (int i = 0; i < ip.length; i++) {
            ip[i] = new JPanel();
        }
        for (int i = 0; i < gbc.length; i++) {
            gbc[i] = new GridBagConstraints();
        }
        //---------------------------Inner Panel Layouts
        ip[0].setLayout(new GridBagLayout());
        //---------------------------Initialize Back+Create Button
        back = new JButton("back");
        create = new JButton("Create");
        //---------------------------IP 2
        initializeDataPanel();
        dataPanel.setBackground(Color.orange);
        //---------------------------IP 1
        ip[1].setLayout(new BorderLayout());
        JLabel search = new JLabel("Search/Sort");
        search.setPreferredSize(new Dimension(10, 40));
        ip[1].add(search, "North");
        this.scroll = new JScrollBar();
        ip[1].add(this.scroll, "East");
        ip[1].add(dataPanel, "Center");
        //---------------------------IP 5
        gbc[0].gridx = 0;
        gbc[1].gridx = 0;
        ip[5].add(new JLabel("Ingredients"), gbc[1]);
        gbc[1].gridx = 1;
        JLabel spacing5 = new JLabel();
        spacing5.setPreferredSize(new Dimension(400, 40));
        ip[5].add(spacing5, gbc[1]);
        gbc[1].gridx = 2;
        ip[5].add(back, gbc[1]);
        ip[5].setBackground(Color.white);
        ip[0].add(ip[5], gbc[0]);
        //---------------------------IP 0
        gbc[1].gridy = 2;
        gbc[1].ipadx = 40;
        gbc[1].ipady = 40;
        ip[1].setBackground(Color.pink);
        gbc[0].gridy = 1;
        ip[0].add(ip[1], gbc[0]);
        //---------------------------IP 3
        ip[3].setLayout(new GridBagLayout());
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 0;
        this.save = new JButton("Save");
        ip[3].add(this.save, gbc[1]);
        //---------------------------Spacing Label 1
        gbc[1].gridx = 1;
        JLabel spacing1 = new JLabel();
        spacing1.setPreferredSize(new Dimension(300, 40));
        ip[3].add(spacing1, gbc[1]);
        //---------------------------Create Button
        gbc[1].gridx = 2;
        ip[3].add(create, gbc[1]);
        //---------------------------Spacing Label 2
        gbc[1].gridx = 3;
        JLabel spacing2 = new JLabel();
        spacing2.setPreferredSize(new Dimension(20, 40));
        ip[3].add(spacing2, gbc[1]);
        //---------------------------Delete Button
        gbc[1].gridx = 4;
        this.delete = new JButton("Delete");
        ip[3].add(this.delete, gbc[1]);
        gbc[0].gridy = 4;
        ip[3].setBackground(Color.white);
        ip[0].add(ip[3], gbc[0]);
        //---------------------------Final
        gbc[0] = new GridBagConstraints();
        gbc[0].ipadx = 20;
        gbc[0].ipady = 20;
        ip[0].setBackground(Color.white);
        ip[0].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        add(ip[0], gbc[0]);
        // Create was here
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

    public JButton getCreateButton() {
        return create;
    }

    public void setCreateButton(JButton create) {
        this.create = create;
    }

    /**
     * @return the jb
     */
    public JButton[] getJb() {
        return jb;
    }

    /**
     * @return the jb in jb[] at input
     */
    public JButton getJb(int input) {
        return jb[input];
    }

    /**
     * @param jb the jb to set
     */
    public void setJb(JButton[] jb) {
        this.jb = jb;
    }

    /**
     * @return the delete
     */
    public JButton getDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    /**
     * @return the save
     */
    public JButton getSave() {
        return save;
    }

    /**
     * @param save the save to set
     */
    public void setSave(JButton save) {
        this.save = save;
    }

    /**
     * @return the scroll
     */
    public JScrollBar getScroll() {
        return scroll;
    }

    public void setScrollpos(int pos) {
        this.scroll.setValue(this.scroll.getValue() + pos);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public void initializeDataPanel() {
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        GridBagConstraints pos = new GridBagConstraints();
        jb = new JButton[5];
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JButton();
            jb[i].setPreferredSize(new Dimension(500, 100));
            pos.gridy = i;
            dataPanel.add(jb[i], pos);
        }

    }

    public void updateDataPanel(ArrayList<Ingredient> ingredientList, int firstLine) {

        int displayLine = firstLine;

        if (ingredientList.size() < 5) {
            for (int i = 0; i < ingredientList.size(); ++i) {
                jb[i].setText(ingredientList.get(i).getName());
            }
        } else {

            for (int i = 0; i < 5; ++i) {
                jb[i].setText(ingredientList.get(displayLine).getName());
                ++displayLine;
            }
        }

    }

}
