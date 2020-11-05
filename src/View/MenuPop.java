/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Recipe;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author jordan
 */
public class MenuPop extends JFrame
{
    
    private Recipe readRecipe;
    
    private JLabel logo;
    
    private JLabel descriptionMenu;
    private JLabel ingredientMenu;
    private JLabel tagsMenu;
  
    public MenuPop(Recipe recipeInput)
    {
        this.readRecipe = recipeInput;
        
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);

        setLayout(null);
        
        JLabel logo = new JLabel("Recipe Name");
        logo.setBounds(350,5,250,30);
        
        JLabel menuDescription_label = new JLabel("Description");
        menuDescription_label.setBounds(90, 30, 250, 30);

        JLabel menuIngredient_label = new JLabel("Ingredients");
        menuIngredient_label.setBounds(90, 80, 250, 30);

        JLabel menuTags_label = new JLabel("Tags");
        menuTags_label.setBounds(90, 130, 250, 30);
        
        descriptionMenu = new JLabel();
        descriptionMenu.setBounds(220, 30, 490, 30);
        
        ingredientMenu = new JLabel();
        ingredientMenu.setBounds(220, 80, 490, 30);
        
        tagsMenu = new JLabel();
        tagsMenu.setBounds(220, 130, 490, 30);
        
        add(logo);
        add(menuDescription_label);
        add(menuIngredient_label);
        add(menuTags_label);
        add(descriptionMenu);
        add(ingredientMenu);
        add(tagsMenu);
        setVisible(true);
        
    }

    public Recipe getReadRecipe()
    {
        return readRecipe;
    }

    public void setReadRecipe(Recipe readRecipe)
    {
        this.readRecipe = readRecipe;
    }

    public JLabel getLogo()
    {
        return logo;
    }

    public void setLogo(JLabel logo)
    {
        this.logo = logo;
    }

    public JLabel getDescriptionMenu()
    {
        return descriptionMenu;
    }

    public void setDescriptionMenu(JLabel descriptionMenu)
    {
        this.descriptionMenu = descriptionMenu;
    }

    public JLabel getIngredientMenu()
    {
        return ingredientMenu;
    }

    public void setIngredientMenu(JLabel ingredientMenu)
    {
        this.ingredientMenu = ingredientMenu;
    }

    public JLabel getTagsMenu()
    {
        return tagsMenu;
    }

    public void setTagsMenu(JLabel tagsMenu)
    {
        this.tagsMenu = tagsMenu;
    }
    
    
    
    
    
    
    
    
}
