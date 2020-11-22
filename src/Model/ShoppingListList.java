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
public class ShoppingListList implements XMLData, Scrollable {

 private ArrayList<ShoppingList> shoppingListList;
   
    private int totalLines;
    private int firstLine;
    private int lastLine;
    
    
    public ShoppingListList()
    {
       shoppingListList = new ArrayList<>();
       loadXMLList();
       
       totalLines = 5;
       firstLine = 0;
       lastLine = 4;    
    }
    
    
    /**
     * @return the shoppingListList
     */
    public ArrayList<ShoppingList> getShoppingListList() {
        return shoppingListList;
    }

    /**
     * @param shoppingListList the shoppingListList to set
     */
    public void setShoppingListList(ArrayList<ShoppingList> shoppingListList) {
        this.shoppingListList = shoppingListList;
    }
    
    
    //=========Methods Implemented from Scrollable Interface===========
    
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

 
    //retreives recipeList ArrayList from recipes.xml
    @Override
    public void loadXMLList()
    {          
        try
        {
          XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("shopping.xml")));
            setShoppingListList((ArrayList<ShoppingList>) de.readObject());
          de.close();
                
        } catch (Exception xx)
        {
            System.out.println("Unable to load XML file");
        }
    }
    
    //saves recipeList ArrayList to recipes.xml
    @Override
    public void saveXMLList()
    {
        try
        {
          XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("shopping.xml")));
          xe.writeObject(getShoppingListList());
          xe.close();
                
        } catch (Exception xx)
        {
            System.out.println("Unable to save XML file");
        }
    }
         
    //adds a new recipe to RecipeList ArrayList
    public void addShoppingList(ShoppingList input)
    {
        getShoppingListList().add(input);
    }
      
    //removes a recipe from RecipeList ArrayList
    public void removeShoppingList(ShoppingList input)
    {
        getShoppingListList().remove(input);
    }
    
}
