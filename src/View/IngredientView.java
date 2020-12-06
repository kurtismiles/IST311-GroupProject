package View;

/**
 *
 * @author Kurtis
 */
public class IngredientView {

    private IngredientPanel ingredientPanel;

    public IngredientView()
    {
        ingredientPanel = new IngredientPanel();
    }

    /**
     * @return the ingredientPanel
     */
    public IngredientPanel getIngredientPanel() {
        return ingredientPanel;
    }

    /**
     * @param ingredientPanel the ingredientPanel to set
     */
    public void setIngredientPanel(IngredientPanel ingredientPanel) {
        this.ingredientPanel = ingredientPanel;
    }
    
}
