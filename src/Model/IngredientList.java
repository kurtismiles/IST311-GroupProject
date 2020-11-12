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
public class IngredientList {
    
    
    private ArrayList<Ingredient> ingredientList;
   
    private int totalLines;
    private int firstLine;
    private int lastLine;
    
    
    public IngredientList()
    {
       ingredientList = new ArrayList<>();
       loadXMLList();
       
       totalLines = 5;
       firstLine = 0;
       lastLine = 4;
       
    }
    
    
    /**
     * @return the ingredientList
     */
    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    /**
     * @param ingredientList the ingredientList to set
     */
    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * @return the totalLines
     */
    public int getTotalLines() {
        return totalLines;
    }

    /**
     * @param totalLines the totalLines to set
     */
    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    /**
     * @return the firstLine
     */
    public int getFirstLine() {
        return firstLine;
    }

    /**
     * @param firstLine the firstLine to set
     */
    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    /**
     * @return the lastLine
     */
    public int getLastLine() {
        return lastLine;
    }

    /**
     * @param lastLine the lastLine to set
     */
    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }

 
    //retreives recipeList ArrayList from recipes.xml
    void loadXMLList()
    {          
        try
        {
          XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("ingredients.xml")));
            setIngredientList((ArrayList<Ingredient>) de.readObject());
          de.close();
                
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
    
    //saves recipeList ArrayList to recipes.xml
    void saveXMLList()
    {
        try
        {
          XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("ingredients.xml")));
          xe.writeObject(getIngredientList());
          xe.close();
                
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
         
    //adds a new recipe to RecipeList ArrayList
    public void addIngredient(Ingredient input)
    {
        getIngredientList().add(input);
    }
      
    //removes a recipe from RecipeList ArrayList
    public void removeIngredient(Ingredient input)
    {
        getIngredientList().remove(input);
    }

    
}
