package View;

import Model.Ingredient;
import Model.Recipe;
import Model.ShoppingList;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author jordan
 */
public class MenuPop extends JFrame {

    private Recipe readRecipe;
    private Ingredient readIngredient;
    private ShoppingList readShoppingList;

    private MenuPopPanel popPanel;

    public MenuPop() {
    }

    public MenuPop(Recipe recipeInput) {
        this.readRecipe = recipeInput;
        popPanel = new MenuPopPanel(getReadRecipe());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 550);
        setBackground(Color.BLUE);

        add(popPanel);
        setVisible(true);

    }

    public MenuPop(Ingredient ingredientInput) {
        this.readIngredient = ingredientInput;
        popPanel = new MenuPopPanel(getReadIngredient());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);
        setBackground(Color.BLUE);

        add(popPanel);
        setVisible(true);
    }

    public MenuPop(ShoppingList shoppingListInput) {
        this.readShoppingList = shoppingListInput;
        popPanel = new MenuPopPanel(getReadShoppingList());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);
        setBackground(Color.BLUE);

        add(popPanel);
        setVisible(true);
    }

    public Recipe getReadRecipe() {
        return readRecipe;
    }

    public void setReadRecipe(Recipe readRecipe) {
        this.readRecipe = readRecipe;
    }

    /**
     * @return the readIngredient
     */
    public Ingredient getReadIngredient() {
        return readIngredient;
    }

    /**
     * @param readIngredient the readIngredient to set
     */
    public void setReadIngredient(Ingredient readIngredient) {
        this.readIngredient = readIngredient;
    }

    /**
     * @return the popPanel
     */
    public MenuPopPanel getPopPanel() {
        return popPanel;
    }

    /**
     * @param popPanel the popPanel to set
     */
    public void setPopPanel(MenuPopPanel popPanel) {
        this.popPanel = popPanel;
    }

    /**
     * @return the readShoppingList
     */
    public ShoppingList getReadShoppingList() {
        return readShoppingList;
    }

    /**
     * @param readShoppingList the readShoppingList to set
     */
    public void setReadShoppingList(ShoppingList readShoppingList) {
        this.readShoppingList = readShoppingList;
    }
}
