/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Ingredient;
import Model.Recipe;
import Model.IngredientDescription;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jordan
 */
public class RecipePop extends JFrame {

    private JTextField nameText;
    private JTextField descriptionText;
    private JTextField tagsText;
    private JButton addBtn;
    private JButton delBtn;

    private int y = 130;
    private int i = 0;

    private ArrayList<JComboBox> unitmenu = new ArrayList<>();
    private ArrayList<JComboBox> ingredientmenu = new ArrayList<>();
    private ArrayList<JTextField> quantity = new ArrayList<>();
    private String[] units;
    private JLabel tags_label;

    private JButton createBtn;
    private Recipe writeRecipe;
    
    private ArrayList<Ingredient> ingredientList;
    private ArrayList<String> ingredientNames;

    public RecipePop() {}
    
    public RecipePop(ArrayList<Ingredient> ingredientList) {
        writeRecipe = new Recipe();
        this.ingredientList = ingredientList;
        ingredientNames = new ArrayList<>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);

        setLayout(null);

        JLabel name_label = new JLabel("Recipe Name :");
        name_label.setBounds(90, 30, 250, 30);

        JLabel description_label = new JLabel("Description :");
        description_label.setBounds(90, 80, 250, 30);

        JLabel ingredients_label = new JLabel("Ingredients :");
        ingredients_label.setBounds(90, 130, 250, 30);

        this.tags_label = new JLabel("Tags :");
        this.tags_label.setBounds(90, 180, 250, 30);

        nameText = new JTextField();
        nameText.setBounds(220, 30, 490, 30);

        descriptionText = new JTextField();
        descriptionText.setBounds(220, 80, 490, 30);

        setupIngredients();

        this.addBtn = new JButton("+");
        this.addBtn.setBounds(220, 160, 60, 20);
        add(addBtn);

        this.delBtn = new JButton("-");
        this.delBtn.setBounds(280, 160, 60, 20);
        add(delBtn);

        tagsText = new JTextField();
        tagsText.setBounds(220, 180, 490, 30);

        createBtn = new JButton("Create");
        createBtn.setBounds(350, 280, 100, 30);

        add(name_label);
        add(description_label);
        add(ingredients_label);
        add(tags_label);
        add(nameText);
        add(descriptionText);
        add(tagsText);
        add(createBtn);
        setVisible(true);

    }

    /**
     * @return the nameText
     */
    public JTextField getNameText() {
        return nameText;
    }

    /**
     * @param nameText the nameText to set
     */
    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    /**
     * @return the descriptionText
     */
    public JTextField getDescriptionText() {
        return descriptionText;
    }

    /**
     * @param descriptionText the descriptionText to set
     */
    public void setDescriptionText(JTextField descriptionText) {
        this.descriptionText = descriptionText;
    }

    /**
     * @return the tagsText
     */
    public JTextField getTagsText() {
        return tagsText;
    }

    /**
     * @param tagsText the tagsText to set
     */
    public void setTagsText(JTextField tagsText) {
        this.tagsText = tagsText;
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
     * @return the writeRecipe
     */
    public Recipe getWriteRecipe() {
        return writeRecipe;
    }

    /**
     * @param writeRecipe the writeRecipe to set
     */
    public void setWriteRecipe(Recipe writeRecipe) {
        this.writeRecipe = writeRecipe;
    }

    public ArrayList<IngredientDescription> getIngredientData() {
//Add input checks
        ArrayList<IngredientDescription> data = new ArrayList<>();
        
        for (int i = 0; i < quantity.size(); i++)
        {
            int index = 0;
            
            for (int j = 0; j < ingredientList.size(); j++)
            {
                if (ingredientList.get(j).getName() == this.ingredientmenu.get(i).getSelectedItem())
                {
                    index = j;
                    break;
                }
                             
            }

            IngredientDescription descript = new IngredientDescription(Float.parseFloat(this.quantity.get(i).getText()),this.unitmenu.get(i).getSelectedItem().toString(), this.ingredientList.get(index)); 
            
            data.add(descript);
            
        }

        return data;
    }

    /**
     * @return the addBtn
     */
    public JButton getAddBtn() {
        return addBtn;
    }

    /**
     * @param addBtn the addBtn to set
     */
    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    /**
     * @return the delBtn
     */
    public JButton getDelBtn() {
        return delBtn;
    }

    /**
     * @param delBtn the delBtn to set
     */
    public void setDelBtn(JButton delBtn) {
        this.delBtn = delBtn;
    }

    public void setupIngredients() {
        this.units = new String[]{"oz", "cup", "lb", "tablespoon", "teaspoon", "g", "kg", "L"};
        
        for (int i = 0; i < ingredientList.size(); ++i)
        {
            ingredientNames.add(ingredientList.get(i).getName());
        }
 
        this.quantity.add(new JTextField());
        this.quantity.get(this.i).setBounds(220, y, 60, 30);
        add(this.quantity.get(this.i));

        this.unitmenu.add(new JComboBox(this.units));
        this.unitmenu.get(this.i).setBounds(220 + 60, y, 100, 30);
        add(this.unitmenu.get(this.i));

        this.ingredientmenu.add(new JComboBox(ingredientNames.toArray()));
        this.ingredientmenu.get(this.i).setBounds(220 + (60 + 100), y, 100, 30);
        add(this.ingredientmenu.get(this.i));
    }

    public void addIngredient() {
        if (i + 1 < 8) {
            i = ++i;
            this.quantity.add(new JTextField());
            this.quantity.get(this.i).setBounds(220, y = y + 30, 60, 30);
            add(this.quantity.get(this.i));

            this.unitmenu.add(new JComboBox(this.units));
            this.unitmenu.get(this.i).setBounds(220 + 60, y, 100, 30);
            add(this.unitmenu.get(this.i));

            this.ingredientmenu.add(new JComboBox(ingredientNames.toArray()));
            this.ingredientmenu.get(this.i).setBounds(220 + (60 + 100), y, 100, 30);
            add(this.ingredientmenu.get(this.i));

            this.getAddBtn().setBounds(220, y + 30, 60, 20);
            this.getDelBtn().setBounds(280, y + 30, 60, 20);

            this.tags_label.setBounds(90, y + 50, 250, 30);
            this.tagsText.setBounds(220, y + 50, 490, 30);

            createBtn.setBounds(350, y + 150, 100, 30);
        }
    }

    public void removeIngredient() {
        if (i - 1 >= 0) {
            y = y - 30;
            remove(this.quantity.get(this.i));

            remove(this.unitmenu.get(this.i));

            remove(this.ingredientmenu.get(this.i));

            this.getAddBtn().setBounds(220, y + 30, 60, 20);
            this.getDelBtn().setBounds(280, y + 30, 60, 20);
            this.tags_label.setBounds(90, y + 50, 250, 30);
            this.tagsText.setBounds(220, y + 50, 490, 30);

            createBtn.setBounds(350, y + 150, 100, 30);
            
            i = --i;
        }
    }

}
