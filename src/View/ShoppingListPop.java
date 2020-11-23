package View;

import Model.Recipe;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Kurtis
 */
public class ShoppingListPop extends JFrame {

    private ShoppingListPopPanel shoppingPanel;

    public ShoppingListPop() {
    }

    public ShoppingListPop(ArrayList<Recipe> recipes) {
        shoppingPanel = new ShoppingListPopPanel(recipes);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 500);
        setBackground(Color.BLUE);

        add(shoppingPanel);
        setVisible(true);

    }

    /**
     * @return the shoppingPanel
     */
    public ShoppingListPopPanel getShoppingPanel() {
        return shoppingPanel;
    }

    /**
     * @param shoppingPanel the shoppingPanel to set
     */
    public void setShoppingPanel(ShoppingListPopPanel shoppingPanel) {
        this.shoppingPanel = shoppingPanel;
    }

}
