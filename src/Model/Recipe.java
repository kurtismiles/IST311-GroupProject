/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Kurtis
 */
public class Recipe {

    private String name;
    private String description;
    private String tags;
//  private String ingredients;
    private ArrayList<IngredientDescription> ingredients;

    public Recipe() {
    }

    public Recipe(String name, String description, ArrayList<IngredientDescription> ingredients, String tags) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.ingredients = ingredients;
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

}