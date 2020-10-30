/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RecipePanel extends JPanel
{

    private JButton back;
    private JButton create;
    private JFrame PopupFrame = new JFrame("Create");

    public RecipePanel()
    {
        back = new JButton("back");
        add(back);

        create = new JButton("create");
        add(create);

        PopupFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        PopupFrame.setBounds(250, 100, 800, 400);

        Container container = PopupFrame.getContentPane();
        container.setLayout(null);

        //JLabel logo = new JLabel("Create a New Recipe");
        //logo.setBounds(350,5,250,30);
        JLabel name_label = new JLabel("Recipe Name :");
        name_label.setBounds(90, 30, 250, 30);

        JLabel description_label = new JLabel("Description :");
        description_label.setBounds(90, 80, 250, 30);

        JLabel ingredients_label = new JLabel("Ingredients :");
        ingredients_label.setBounds(90, 130, 250, 30);

        JLabel tags_label = new JLabel("Tags :");
        tags_label.setBounds(90, 180, 250, 30);

        JTextField nameText = new JTextField();
        nameText.setBounds(220, 30, 490, 30);

        JTextField descriptionText = new JTextField();
        descriptionText.setBounds(220, 80, 490, 30);

        JTextField ingredientText = new JTextField();
        ingredientText.setBounds(220, 130, 490, 30);

        JTextField tagsText = new JTextField();
        tagsText.setBounds(220, 180, 490, 30);

        JButton createBtn = new JButton("Create");
        createBtn.setBounds(350, 280, 100, 30);

        //container.add(logo);
        container.add(name_label);
        container.add(description_label);
        container.add(ingredients_label);
        container.add(tags_label);
        container.add(nameText);
        container.add(descriptionText);
        container.add(ingredientText);
        container.add(tagsText);
        container.add(createBtn);
        PopupFrame.setVisible(true);
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

    public JFrame getPopupFrame()
    {
        return PopupFrame;
    }

    public void setPopupFrame(JFrame PopupFrame)
    {
        this.PopupFrame = PopupFrame;
    }

}
