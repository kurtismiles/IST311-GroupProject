/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Recipe;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Kurtis
 */
public class RecipePop extends JFrame
{

    private JTextField nameText;
    private JTextField descriptionText;
    private JTextField ingredientText;
    private JTextField tagsText;
    
    private JButton createBtn;
    private Recipe writeRecipe;
    
        
    public RecipePop()
    {      
        writeRecipe = new Recipe();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);

        setLayout(null);

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

        nameText = new JTextField();
        nameText.setBounds(220, 30, 490, 30);

        descriptionText = new JTextField();
        descriptionText.setBounds(220, 80, 490, 30);

        ingredientText = new JTextField();
        ingredientText.setBounds(220, 130, 490, 30);

        tagsText = new JTextField();
        tagsText.setBounds(220, 180, 490, 30);

        createBtn = new JButton("Create");
        createBtn.setBounds(350, 280, 100, 30);

        add(name_label);
        add(description_label);
        add(ingredients_label);
        add(tags_label);
        add(nameText);
        add(descriptionText);
        add(ingredientText);
        add(tagsText);
        add(createBtn);
        setVisible(true);

    }

    /**
     * @return the nameText
     */
    public JTextField getNameText() {
        return nameText;
    }

    /**
     * @param nameText the nameText to set
     */
    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    /**
     * @return the descriptionText
     */
    public JTextField getDescriptionText() {
        return descriptionText;
    }

    /**
     * @param descriptionText the descriptionText to set
     */
    public void setDescriptionText(JTextField descriptionText) {
        this.descriptionText = descriptionText;
    }

    /**
     * @return the ingredientText
     */
    public JTextField getIngredientText() {
        return ingredientText;
    }

    /**
     * @param ingredientText the ingredientText to set
     */
    public void setIngredientText(JTextField ingredientText) {
        this.ingredientText = ingredientText;
    }

    /**
     * @return the tagsText
     */
    public JTextField getTagsText() {
        return tagsText;
    }

    /**
     * @param tagsText the tagsText to set
     */
    public void setTagsText(JTextField tagsText) {
        this.tagsText = tagsText;
    }

    /**
     * @return the createBtn
     */
    public JButton getCreateBtn() {
        return createBtn;
    }

    /**
     * @param createBtn the createBtn to set
     */
    public void setCreateBtn(JButton createBtn) {
        this.createBtn = createBtn;
    }

    /**
     * @return the writeRecipe
     */
    public Recipe getWriteRecipe() {
        return writeRecipe;
    }

    /**
     * @param writeRecipe the writeRecipe to set
     */
    public void setWriteRecipe(Recipe writeRecipe) {
        this.writeRecipe = writeRecipe;
    }
    
    
}
