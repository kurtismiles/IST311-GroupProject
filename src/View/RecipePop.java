package View;

import Model.Ingredient;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Kurtis
 */
public class RecipePop extends JFrame {

    private RecipePopPanel recipePanel;
    private ArrayList<Ingredient> ingredientList;

    public RecipePop() {
    }

    public RecipePop(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
        recipePanel = new RecipePopPanel(this.ingredientList);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 500);
        setBackground(Color.BLUE);

        add(recipePanel);
        setVisible(true);

    }

    /**
     * @return the recipePanel
     */
    public RecipePopPanel getRecipePanel() {
        return recipePanel;
    }

    /**
     * @param recipePanel the recipePanel to set
     */
    public void setRecipePanel(RecipePopPanel recipePanel) {
        this.recipePanel = recipePanel;
    }
}
