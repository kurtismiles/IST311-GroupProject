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
public class IngredientList implements Scrollable, XMLData {

    private ArrayList<Ingredient> ingredientList;

    private int totalLines;
    private int firstLine;
    private int lastLine;

    public IngredientList() {
        ingredientList = new ArrayList<>();
        totalLines = 5;
        firstLine = 0;
        lastLine = 4;

        loadXMLList();
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
    
    //retreives ingredientList ArrayList from ingredients.xml
    @Override
    public void loadXMLList() {
        try {
            XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("ingredients.xml")));
            setIngredientList((ArrayList<Ingredient>) de.readObject());
            de.close();

        } catch (Exception xx) {
            System.out.println("Unable to load XML file");
        }
    }

    //saves ingredientList ArrayList to ingredients.xml
    @Override
    public void saveXMLList() {
        try {
            XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("ingredients.xml")));
            xe.writeObject(getIngredientList());
            xe.close();

        } catch (Exception xx) {
            System.out.println("Unable to save XML file");
        }
    }
    
    //===================================
    //========= Class Methods ===========
    //===================================
    
    //adds a new ingredient to IngredientList ArrayList
    public void addIngredient(Ingredient input) {
        getIngredientList().add(input);
    }

    //removes a ingredient from IngredientList ArrayList
    public void removeIngredient(Ingredient input) {
        getIngredientList().remove(input);
    }

}
