package Model;

import com.sun.tools.javac.util.StringUtils;
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
    private String builder;

    public Recipe() {
    }

    public Recipe(String name, String description, ArrayList<IngredientDescription> ingredients, String tags, ArrayList<String> categories) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.ingredients = ingredients;
        this.rating = -1;
        this.favorite = false;
        this.categories = new HashMap();
        this.categories.put("Sweet", false);
        this.categories.put("Spicy", false);
        this.categories.put("Salty", false);
        this.categories.put("Sour", false);
        this.categories.put("Bitter", false);
        this.categories.put("Breakfast", false);
        this.categories.put("Lunch", false);
        this.categories.put("Dinner", false);
        
        
        for (int i = 0; i < categories.size(); ++i)
        {
            if(this.categories.containsKey(categories.get(i)))
            {
                this.categories.replace(categories.get(i), true);
            }
        }

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

    // Returns a string representation of selected categories
    public String categoriesToString()
    {
        builder = new String();
        
        this.categories.forEach((k,v) -> {if(v.equals(true))
        {
            System.out.println(k.toString());
            builder = builder.concat(k.toString() + ", " );
            
        }
        });
        
        builder = builder.trim();
        return builder.substring(0, builder.length() - 1);
        
        
    }

        
}
