package Model;

public class IngredientDescription {

    private float number;
    private String unit;
    private Ingredient ingredient;

    public IngredientDescription() {
    }

    public IngredientDescription(float number, String unit, Ingredient ingredient) {
        this.number = number;
        this.unit = unit;
        this.ingredient = ingredient;
        
    }

    /**
     * @return the number
     */
    public float getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(float number) {
        this.number = number;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the ingredient
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * @param ingredient the ingredient to set
     */
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
