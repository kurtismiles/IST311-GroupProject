package View;

/**
 *
 * @author Kurtis
 */
public class RecipeView {

    private RecipePanel recipePanel;

    public RecipeView() {
        recipePanel = new RecipePanel();
    }

    /**
     * @return the recipePanel
     */
    public RecipePanel getRecipePanel() {
        return recipePanel;
    }

    /**
     * @param recipePanel the recipePanel to set
     */
    public void setRecipePanel(RecipePanel recipePanel) {
        this.recipePanel = recipePanel;
    }

}
