package Model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Kurtis
 */
public class RecipeList implements Scrollable, XMLData {

    private ArrayList<Recipe> recipeList;

    private int totalLines;
    private int firstLine;
    private int lastLine;

    public RecipeList() {
        recipeList = new ArrayList<>();
        totalLines = 5;
        firstLine = 0;
        lastLine = 4;

        loadXMLList();
    }
    
    /**
     * @return the recipeList
     */
    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }

    /**
     * @param recipeList the recipeList to set
     */
    public void setRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
    
    //===================================================================
    //========= Methods Implemented from Scrollable Interface ===========
    //===================================================================
    
    /**
     * @return the totalLines
     */
    @Override
    public int getTotalLines() {
        return totalLines;
    }

    /**
     * @param totalLines the totalLines to set
     */
    @Override
    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    /**
     * @return the firstLine
     */
    @Override
    public int getFirstLine() {
        return firstLine;
    }

    /**
     * @param firstLine the firstLine to set
     */
    @Override
    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    /**
     * @return the lastLine
     */
    @Override
    public int getLastLine() {
        return lastLine;
    }

    /**
     * @param lastLine the lastLine to set
     */
    @Override
    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }

    //================================================================
    //========= Methods Implemented from XMLData Interface ===========
    //================================================================
    
    //retreives recipeList ArrayList from recipes.xml
    @Override
    public void loadXMLList() {
        try {
            XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("recipes.xml")));
            setRecipeList((ArrayList<Recipe>) de.readObject());
            de.close();

        } catch (Exception xx) {
            System.out.println("Unable to load XML file");
        }
    }

    //saves recipeList ArrayList to recipes.xml
    @Override
    public void saveXMLList() {
        try {
            XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("recipes.xml")));
            xe.writeObject(getRecipeList());
            xe.close();

        } catch (Exception xx) {
            System.out.println("Unable to save XML file");
        }
    }
    
    //===================================
    //========= Class Methods ===========
    //===================================
    
    //adds a new recipe to RecipeList ArrayList
    public void addRecipe(Recipe input) {
        getRecipeList().add(input);
    }

    //removes a recipe from RecipeList ArrayList
    public void removeRecipe(Recipe input) {
        getRecipeList().remove(input);
    }

}
