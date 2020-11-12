/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Recipe;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


/**
 *
 * @author jordan
 */
public class MenuPop extends JFrame
{
    
    private Recipe readRecipe;
    private Image menuimage;
    
    private JLabel logo;
    
    private JLabel descriptionMenu;
    private JLabel ingredientMenu;
    private JLabel tagsMenu;
  
    public MenuPop()
    {}
    
    
    public MenuPop(Recipe recipeInput)
    {
        this.readRecipe = recipeInput;
        
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);
        setBackground(Color.BLUE);

        setLayout(null);
        
        JLabel logo = new JLabel(recipeInput.getName());
        logo.setBounds(350,5,250,30);
        logo.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        
        JLabel menuDescription_label = new JLabel("Description: ");
        menuDescription_label.setBounds(150, 55, 250, 30);
        menuDescription_label.setFont(new Font("Times New Roman",Font.BOLD, 16));
        
        JLabel menuIngredient_label = new JLabel("Ingredients: ");
        menuIngredient_label.setBounds(150, 105, 250, 30);
        menuIngredient_label.setFont(new Font("Times New Roman",Font.BOLD, 16));

        JLabel menuTags_label = new JLabel("Tags: ");
        menuTags_label.setBounds(150, 155, 250, 30);
        menuTags_label.setFont(new Font("Times New Roman",Font.BOLD, 16));
        
        descriptionMenu = new JLabel(recipeInput.getDescription());
        descriptionMenu.setBounds(300, 55, 490, 30);
        
        ingredientMenu = new JLabel(recipeInput.getIngredients());
        ingredientMenu.setBounds(300, 105, 490, 30);
        
        tagsMenu = new JLabel(recipeInput.getTags());
        tagsMenu.setBounds(300, 155, 490, 30);
        
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
