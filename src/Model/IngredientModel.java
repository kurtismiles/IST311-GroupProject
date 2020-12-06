package Model;

/**
 *
 * @author Kurtis
 */
public class IngredientModel {

    private IngredientList ingredientData;

    public IngredientModel() {
        ingredientData = new IngredientList();
    }

    /**
     * @return the ingredientData
     */
    public IngredientList getIngredientData() {
        return ingredientData;
    }

    /**
     * @param ingredientData the ingredientData to set
     */
    public void setIngredientData(IngredientList ingredientData) {
        this.ingredientData = ingredientData;
    }

    public void writeIngredient(Ingredient input) {
        ingredientData.addIngredient(input);
        ingredientData.saveXMLList();
        refreshIngredientList();
    }

    public void removeIngredient(Ingredient input) {
        ingredientData.removeIngredient(input);
        ingredientData.saveXMLList();
        refreshIngredientList();
    }

    public void refreshIngredientList() {
        ingredientData = new IngredientList();
    }

}
