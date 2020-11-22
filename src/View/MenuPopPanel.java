package View;

import Model.Ingredient;
import Model.Recipe;
import Model.ShoppingList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
    private JLabel[][] ingredientMenu;
    private JLabel tagsMenu;

    private JButton x2;
    private JButton reset;
    private JButton half;
    private float multiplier;

    private Image image;

    public MenuPopPanel() {
    }

    public MenuPopPanel(Recipe recipeInput) {
        super();
        setLayout(null);

        image = (new ImageIcon("Images/ViewPopBackground.jpg")).getImage();
        this.multiplier = 1;
        this.readRecipe = recipeInput;

        JLabel logo = new JLabel(this.readRecipe.getName());
        logo.setBounds(350, 5, 250, 30);
        logo.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));

        JLabel menuDescription_label = new JLabel("Description: ");
        menuDescription_label.setBounds(150, 55, 250, 30);
        menuDescription_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        JLabel menuIngredient_label = new JLabel("Ingredients: ");
        menuIngredient_label.setBounds(150, 105, 250, 30);
        menuIngredient_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        JLabel menuTags_label = new JLabel("Tags: ");
        menuTags_label.setBounds(150, 125 + (25 * this.readRecipe.getIngredients().size()), 250, 30);
        menuTags_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        descriptionMenu = new JLabel(this.readRecipe.getDescription());
        descriptionMenu.setBounds(300, 55, 490, 30);

        ingredientMenu = new JLabel[3][this.readRecipe.getIngredients().size()];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.readRecipe.getIngredients().size(); j++) {
                ingredientMenu[i][j] = new JLabel();
            }
        }


        tagsMenu = new JLabel(this.readRecipe.getTags());
        tagsMenu.setBounds(300, 125 + (25 * this.readRecipe.getIngredients().size()), 490, 30); //25 dif

        this.x2 = new JButton("x 2");
        this.reset = new JButton("Reset");
        this.half = new JButton("1/2");
        this.half.setBounds(300, 125 + (25 * this.readRecipe.getIngredients().size() + 30), 60, 30);
        this.reset.setBounds(360, 125 + (25 * this.readRecipe.getIngredients().size() + 30), 100, 30);
        this.x2.setBounds(460, 125 + (25 * this.readRecipe.getIngredients().size()) + 30, 60, 30);
        add(x2);
        add(reset);
        add(half);

        add(logo);
        add(menuDescription_label);
        add(menuIngredient_label);
        add(menuTags_label);
        add(descriptionMenu);

        for (int i = 0; i < this.readRecipe.getIngredients().size(); i++) {
            ingredientMenu[0][i] = new JLabel(Float.toString(this.readRecipe.getIngredients().get(i).getNumber()));
            ingredientMenu[0][i].setBounds(300, 105 + (25 * i), 55, 30);
            ingredientMenu[1][i] = new JLabel(this.readRecipe.getIngredients().get(i).getUnit());
            ingredientMenu[1][i].setBounds(355, 105 + (25 * i), 80, 30);
            ingredientMenu[2][i] = new JLabel(this.readRecipe.getIngredients().get(i).getIngredient().getName());
            ingredientMenu[2][i].setBounds(430, 105 + (25 * i), 385, 30);
            for (int j = 0; j < 3; j++) {
                add(ingredientMenu[j][i]);
            }

        }

        add(tagsMenu);
    }

    public MenuPopPanel(Ingredient ingredientInput) {
        
        super();
        setLayout(null);

        image = (new ImageIcon("Images/ViewPopBackground.jpg")).getImage();

        JLabel logo = new JLabel(ingredientInput.getName());
        logo.setBounds(350, 5, 250, 30);
        logo.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));

        JLabel menuDescription_label = new JLabel("Description: ");
        menuDescription_label.setBounds(150, 55, 250, 30);
        menuDescription_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        JLabel menuTags_label = new JLabel("Tags: ");
        menuTags_label.setBounds(150, 105, 250, 30);
        menuTags_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        descriptionMenu = new JLabel(ingredientInput.getDescription());
        descriptionMenu.setBounds(300, 55, 490, 30);

        tagsMenu = new JLabel(ingredientInput.getTags());
        tagsMenu.setBounds(300, 105, 490, 30);

        add(logo);
        add(menuDescription_label);
        add(menuTags_label);
        add(descriptionMenu);
        add(tagsMenu);

    }
    
    public MenuPopPanel(ShoppingList shoppingListInput) {
    
        super();
        setLayout(null);
        
        image = (new ImageIcon("Images/ViewPopBackground.jpg")).getImage();
        
        JLabel logo = new JLabel(this.readRecipe.getName());
        logo.setBounds(350, 5, 250, 30);
        logo.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        
        JLabel menuDescription_label = new JLabel("Description: ");
        menuDescription_label.setBounds(150, 55, 250, 30);
        menuDescription_label.setFont(new Font("Times New Roman", Font.BOLD, 16));

        JLabel menuTags_label = new JLabel("Tags: ");
        menuTags_label.setBounds(150, 105, 250, 30);
        menuTags_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        descriptionMenu = new JLabel();
        descriptionMenu.setBounds(300, 55, 490, 30);

        tagsMenu = new JLabel();
        tagsMenu.setBounds(300, 105, 490, 30);
        
        add(logo);
        add(menuDescription_label);
        add(menuTags_label);
        add(descriptionMenu);
        add(tagsMenu);
 
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

    /**
     * @return the x2
     */
    public JButton getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(JButton x2) {
        this.x2 = x2;
    }

    /**
     * @return the reset
     */
    public JButton getReset() {
        return reset;
    }

    /**
     * @param reset the reset to set
     */
    public void setReset(JButton reset) {
        this.reset = reset;
    }

    /**
     * @return the half
     */
    public JButton getHalf() {
        return half;
    }

    /**
     * @param half the half to set
     */
    public void setHalf(JButton half) {
        this.half = half;
    }

    /**
     * @return the multiplier
     */
    public float getMultiplier() {
        return multiplier;
    }

    /**
     * @param multiplier the multiplier to set
     */
    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void update() {
        for (int i = 0; i < this.readRecipe.getIngredients().size(); i++) {
            ingredientMenu[0][i].setText(Float.toString(this.readRecipe.getIngredients().get(i).getNumber()*this.multiplier));
        }
        repaint();
        revalidate();
    }

}
