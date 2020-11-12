package View;

import Model.Ingredient;
import Model.Recipe;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kurtis
 */
public class MenuPopPanel extends JPanel {

    private Recipe readRecipe;
    private JLabel logo;

    private JLabel descriptionMenu;
    private JLabel ingredientMenu;
    private JLabel tagsMenu;

    private Image image;

    public MenuPopPanel(){}

    public MenuPopPanel(Recipe recipeInput) {
        super();
        setLayout(null);
        
        image = (new ImageIcon("Images/ViewPopBackground.jpg")).getImage();
        
        JLabel logo = new JLabel(recipeInput.getName());
        logo.setBounds(350, 5, 250, 30);
        logo.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));

        JLabel menuDescription_label = new JLabel("Description: ");
        menuDescription_label.setBounds(150, 55, 250, 30);
        menuDescription_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        JLabel menuIngredient_label = new JLabel("Ingredients: ");
        menuIngredient_label.setBounds(150, 105, 250, 30);
        menuIngredient_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        JLabel menuTags_label = new JLabel("Tags: ");
        menuTags_label.setBounds(150, 155, 250, 30);
        menuTags_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

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
    }
    
    public MenuPopPanel(Ingredient ingredientInput)
    {
        super();
    }

    /**
     * @return the readRecipe
     */
    public Recipe getReadRecipe() {
        return readRecipe;
    }

    /**
     * @param readRecipe the readRecipe to set
     */
    public void setReadRecipe(Recipe readRecipe) {
        this.readRecipe = readRecipe;
    }

    /**
     * @return the logo
     */
    public JLabel getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(JLabel logo) {
        this.logo = logo;
    }

    /**
     * @return the descriptionMenu
     */
    public JLabel getDescriptionMenu() {
        return descriptionMenu;
    }

    /**
     * @param descriptionMenu the descriptionMenu to set
     */
    public void setDescriptionMenu(JLabel descriptionMenu) {
        this.descriptionMenu = descriptionMenu;
    }

    /**
     * @return the ingredientMenu
     */
    public JLabel getIngredientMenu() {
        return ingredientMenu;
    }

    /**
     * @param ingredientMenu the ingredientMenu to set
     */
    public void setIngredientMenu(JLabel ingredientMenu) {
        this.ingredientMenu = ingredientMenu;
    }

    /**
     * @return the tagsMenu
     */
    public JLabel getTagsMenu() {
        return tagsMenu;
    }

    /**
     * @param tagsMenu the tagsMenu to set
     */
    public void setTagsMenu(JLabel tagsMenu) {
        this.tagsMenu = tagsMenu;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
