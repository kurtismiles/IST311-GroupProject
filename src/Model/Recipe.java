package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Kurtis
 */
public class Recipe {

    private String name;
    private String description;
    private String tags;
    private ArrayList<IngredientDescription> ingredients;
    private int rating;
    private boolean favorite;
    private HashMap categories;

    public Recipe() {
    }

    public Recipe(String name, String description, ArrayList<IngredientDescription> ingredients, String tags) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.ingredients = ingredients;
        this.rating = -1;
        this.favorite = false;
        categories = new HashMap();
        categories.put("Sweet", false);
        categories.put("Spicy", false);
        categories.put("Salty", false);
        categories.put("Sour", false);
        categories.put("Bitter", false);
        categories.put("Breakfast", false);
        categories.put("Lunch", false);
        categories.put("Dinner", false);

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @return the ingredients
     */
    public ArrayList<IngredientDescription> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(ArrayList<IngredientDescription> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the favorite
     */
    public boolean getFavorite() {
        return favorite;
    }

    /**
     * @param favorite the favorite to set
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    /**
     * @return the categories
     */
    public HashMap getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(HashMap categories) {
        this.categories = categories;
    }

}
