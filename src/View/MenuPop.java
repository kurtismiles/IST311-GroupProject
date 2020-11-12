package View;

import Model.Ingredient;
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
    private Ingredient readIngredient;
    private MenuPopPanel popPanel;
    
    public MenuPop()
    {}
     
    public MenuPop(Recipe recipeInput)
    {
        this.readRecipe = recipeInput;
        popPanel = new MenuPopPanel(readRecipe);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);
        setBackground(Color.BLUE);
        
        add(popPanel);
        setVisible(true);
        
    }
    
    public MenuPop(Ingredient ingredientInput)
    {
        this.readIngredient = ingredientInput;
        popPanel = new MenuPopPanel(readIngredient);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);
        setBackground(Color.BLUE);
        
        add(popPanel);
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
}
