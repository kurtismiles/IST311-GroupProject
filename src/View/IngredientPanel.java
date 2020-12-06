//COPYRIGHT (C) 2020 Avina Lin Yuki (Registered as Leslin Mathews). All Rights Reserved.
//@authors Avina (Leslin) referred as Avina, Kurtis
//@email lum776@psu.edu
package View;

import Model.Ingredient;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class IngredientPanel extends JPanel {

    private JButton back;
    private JButton create;
    private JButton delete, save;
    private JButton[] jb;

    private JScrollBar scroll;
    private Image background;

    private JPanel dataPanel;
    private JPanel ip[];

    private GridBagConstraints position;
    private JLabel space[];

    public IngredientPanel() {

        background = (new ImageIcon("Images/RecipePanelBackground.png")).getImage();

        setLayout(new GridBagLayout());
        initializer();
        paintGun();

        for (int i = 0; i < this.ip.length; i++) {
            if (i != 2) {
                this.ip[i].setLayout(new GridBagLayout());
            }
        }

        setupTop();
        setupMiddle();
        setupBottom();
        resetPosition();
        this.position.gridy = 0;
        this.ip[0].add(ip[3], this.position);
        this.position.gridy = 1;
        this.ip[0].add(ip[2], this.position);
        this.position.gridy = 2;
        this.position.ipadx = 40;
        this.position.ipady = 40;
        this.ip[0].add(ip[1], this.position);

        //---------------------------Final
        resetPosition();
        this.position.ipadx = 20;
        this.position.ipady = 20;

        add(this.ip[0], this.position);
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
//        resetPosition();
        this.dataPanel = new JPanel();
        this.dataPanel.setLayout(new GridBagLayout());
        this.jb = new JButton[5];
        for (int i = 0; i < this.jb.length; i++) {
            this.jb[i] = new JButton();
            this.jb[i].setPreferredSize(new Dimension(500, 100));
            this.position.gridy = i;
            this.dataPanel.add(this.jb[i], this.position);
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

    private void resetPosition() {
        this.position = new GridBagConstraints();
    }

    private void initializer() {   //image in constructor
        this.ip = new JPanel[4];
        for (int i = 0; i < this.ip.length; i++) {
            this.ip[i] = new JPanel();
        }

        this.space = new JLabel[3];
        for (int i = 0; i < this.space.length; i++) {
            this.space[i] = new JLabel();
        }

        this.scroll = new JScrollBar();

        this.save = new JButton("Save");
        this.back = new JButton("back");
        this.create = new JButton("Create");
        this.delete = new JButton("Delete");

        resetPosition();

        initializeDataPanel();
    }

    private void setupBottom() {   //IP 1
        resetPosition();
        //---------------------------Save Button
        this.position.gridx = 0;
        ip[1].add(this.save, this.position.gridx);

        //---------------------------Spacing Label 1
        this.position.gridx = 1;
        this.space[0].setPreferredSize(new Dimension(300, 40));
        this.ip[1].add(this.space[0], this.position.gridx);

        //---------------------------Create Button
        this.position.gridx = 2;
        this.ip[1].add(this.create, this.position.gridx);

        //---------------------------Spacing Label 2
        this.position.gridx = 3;
        this.space[1].setPreferredSize(new Dimension(20, 40));
        this.ip[1].add(this.space[1], this.position);

        //---------------------------Delete Button
        this.position.gridx = 4;
        this.ip[1].add(this.delete, this.position);
    }

    private void setupMiddle() {   //IP 2
        resetPosition();
        this.ip[2].setLayout(new BorderLayout());
        JLabel search = new JLabel("Search/Sort");
        search.setPreferredSize(new Dimension(10, 40));
        ip[2].add(search, "North");
        ip[2].add(this.scroll, "East");
        ip[2].add(this.dataPanel, "Center");
    }

    private void setupTop() {   //IP 3
        resetPosition();
        this.position.gridx = 0;
        
        JLabel title = new JLabel("Ingredients");
        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 36));
        ip[3].add(title, this.position);
        
        
        this.position.gridx = 1;
        space[2].setPreferredSize(new Dimension(400, 40));
        ip[3].add(space[2], this.position);
        this.position.gridx = 2;
        
        ip[3].add(back, this.position);
    }

    private void paintGun() {
        this.dataPanel.setBackground(Color.orange);
        this.ip[1].setBackground(Color.white);
        this.ip[2].setBackground(Color.pink);
        this.ip[3].setBackground(Color.white);
        this.ip[0].setBackground(Color.white);
        this.ip[0].setBorder(BorderFactory.createLineBorder(Color.black, 3));
    }
}
