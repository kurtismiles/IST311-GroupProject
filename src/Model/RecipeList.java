/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RecipeList
{
    private ArrayList<Recipe> recipeList;
   
    private int totalLines;
    private int firstLine;
    private int lastLine;
    
    
    public RecipeList()
    {
       recipeList = new ArrayList<>();
       loadXMLList();
       
       totalLines = 5;
       firstLine = 0;
       lastLine = 4;
       
    }

    /**
     * @return the recipeList
     */
    public ArrayList<Recipe> getRecipeList() 
    {
        return recipeList;
    }

    /**
     * @param recipeList the recipeList to set
     */
    public void setRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
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
          XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("recipes.xml")));
            setRecipeList((ArrayList<Recipe>) de.readObject());
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
          XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("recipes.xml")));
          xe.writeObject(getRecipeList());
          xe.close();
                
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
         
    //adds a new recipe to RecipeList ArrayList
    public void addRecipe(Recipe input)
    {
        getRecipeList().add(input);
    }
      
    //removes a recipe from RecipeList ArrayList
    public void removeRecipe(Recipe input)
    {
        getRecipeList().remove(input);
    }


}
