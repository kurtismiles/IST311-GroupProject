/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.IngredientDescription;
import Model.Recipe;
import Model.RecipeList;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kurtis
 */
public class ShoppingListPopPanel extends JPanel {

    private JButton createBtn;

    private ArrayList<JComboBox> recipeMenu;
    private ArrayList<Recipe> recipeList;
    private ArrayList<JLabel> labels;

    public ShoppingListPopPanel() {

//        super();
//        setLayout(null);
        this.recipeList = new ArrayList<>();
        this.recipeMenu = new ArrayList<>();
        this.labels = new ArrayList<>();
        setupRecipeList();
        
        for(int i = 0; i<this.recipeMenu.size();i++){
            this.recipeMenu.get(i).setBounds(200, 200+(i*30), 100, 30);
        add(this.recipeMenu.get(i));
        }
        

    }
    
    public ShoppingListPopPanel(ArrayList<Recipe> recipeList) {

        this.recipeList = recipeList;

    }

    /**
     * @return the createBtn
     */
    public JButton getCreateBtn() {
        return createBtn;
    }

    /**
     * @param createBtn the createBtn to set
     */
    public void setCreateBtn(JButton createBtn) {
        this.createBtn = createBtn;
    }

    /**
     * @return the recipeMenu
     */
    public ArrayList<JComboBox> getRecipeMenu() {
        return recipeMenu;
    }

    /**
     * @param recipeMenu the recipeMenu to set
     */
    public void setRecipeMenu(ArrayList<JComboBox> recipeMenu) {
        this.recipeMenu = recipeMenu;
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

    /**
     * @return the labels
     */
    public ArrayList<JLabel> getLabels() {
        return labels;
    }

    /**
     * @param labels the labels to set
     */
    public void setLabels(ArrayList<JLabel> labels) {
        this.labels = labels;
    }

    //setup recipe entry display
    public void setupRecipeList() {
        for (int i = 0; i < this.recipeList.get(i).getIngredients().size(); ++i) {
            this.recipeMenu.add(new JComboBox(this.recipeList.toArray()));
        }
    }

}
