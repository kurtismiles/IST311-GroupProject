package View;

import Model.Ingredient;
import Model.Recipe;
import Model.IngredientDescription;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jordan, Avina (Leslin)
 */
public class RecipePopPanel extends JPanel {

    private JTextField nameText;
    private JTextField descriptionText;
    private JTextField tagsText;
    private JButton addBtn;
    private JButton delBtn;
    
    private JButton categoryAdd;
    private JButton categoryDel;

    private int y = 130;
    private int x = 220;
    private int i = 0;
    private int j = 0;

    private ArrayList<JComboBox> unitmenu = new ArrayList<>();
    private ArrayList<JComboBox> ingredientmenu = new ArrayList<>();
    private ArrayList<JComboBox> categorymenu = new ArrayList<>();
    private ArrayList<JTextField> quantity = new ArrayList<>();
    private String[] units;
    private String[] categoryNames;
    private JLabel tags_label;
    private JLabel category_label;

    private JButton createBtn;
    private Recipe writeRecipe;

    private ArrayList<Ingredient> ingredientList;
    private ArrayList<String> ingredientNames;

    public RecipePopPanel() {
    }

    public RecipePopPanel(ArrayList<Ingredient> ingredientList) {

        super();
        setLayout(null);

        writeRecipe = new Recipe();
        this.ingredientList = ingredientList;
        ingredientNames = new ArrayList<>();

        JLabel name_label = new JLabel("Recipe Name :");
        name_label.setBounds(90, 30, 250, 30);

        JLabel description_label = new JLabel("Description :");
        description_label.setBounds(90, 80, 250, 30);

        JLabel ingredients_label = new JLabel("Ingredients :");
        ingredients_label.setBounds(90, 130, 250, 30);

        this.tags_label = new JLabel("Tags :");
        this.tags_label.setBounds(90, 180, 250, 30);
        
        this.category_label = new JLabel("Categories :");
        this.category_label.setBounds(90, 230, 250, 30);

        nameText = new JTextField();
        nameText.setBounds(220, 30, 490, 30);

        descriptionText = new JTextField();
        descriptionText.setBounds(220, 80, 490, 30);

        setupIngredients();
        setupCategories();

        this.addBtn = new JButton("+");
        this.addBtn.setBounds(220, 160, 60, 20);
        add(addBtn);

        this.delBtn = new JButton("-");
        this.delBtn.setBounds(280, 160, 60, 20);
        add(delBtn);
        
        this.categoryAdd = new JButton("+");
        this.categoryAdd.setBounds(220, 260, 60, 20);
        add(categoryAdd);
        
        this.categoryDel = new JButton("-");
        this.categoryDel.setBounds(280, 260, 60, 20);
        add(categoryDel);
        

        tagsText = new JTextField();
        tagsText.setBounds(220, 180, 490, 30);

        createBtn = new JButton("Create");
        createBtn.setBounds(350, 310, 100, 30);

        add(name_label);
        add(description_label);
        add(ingredients_label);
        add(tags_label);
        add(category_label);
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

        for (int i = 0; i < quantity.size(); i++) {
            int index = 0;

            for (int j = 0; j < ingredientList.size(); j++) {
                if (ingredientList.get(j).getName() == this.ingredientmenu.get(i).getSelectedItem()) {
                    index = j;
                    break;
                }

            }

            IngredientDescription descript = new IngredientDescription(Float.parseFloat(this.quantity.get(i).getText()), this.unitmenu.get(i).getSelectedItem().toString(), this.ingredientList.get(index));

            data.add(descript);

        }

        return data;
    }
    
    public ArrayList<String> getCategoryData()
    {
        ArrayList<String> categoryNames = new ArrayList<>();
        
        for (int i = 0; i < categorymenu.size(); i++)
        {
            categoryNames.add(this.categorymenu.get(i).getSelectedItem().toString());
        }
        
        return categoryNames;
        
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
        /**
     * @return the categoryAdd
     */
    public JButton getCategoryAdd() {
        return categoryAdd;
    }

    /**
     * @param categoryAdd the categoryAdd to set
     */
    public void setCategoryAdd(JButton categoryAdd) {
        this.categoryAdd = categoryAdd;
    }

    /**
     * @return the categoryDel
     */
    public JButton getCategoryDel() {
        return categoryDel;
    }

    /**
     * @param categoryDel the categoryDel to set
     */
    public void setCategoryDel(JButton categoryDel) {
        this.categoryDel = categoryDel;
    }
    

    //setup ingredient entry display
    public void setupIngredients() {
        this.units = new String[]{"oz", "cup", "lb", "tablespoon", "teaspoon", "g", "kg", "L", "mL"};

        for (int i = 0; i < ingredientList.size(); ++i) {
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

    //add ingredient button function
    public void addIngredient() {
        if (i < 7) {
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

            this.addBtn.setBounds(220, y + 30, 60, 20);
            this.delBtn.setBounds(280, y + 30, 60, 20);
            
            this.getCategoryAdd().setBounds(220, y + 130, 60, 20);
            this.getCategoryDel().setBounds(280, y + 130, 60, 20);
            
            this.tags_label.setBounds(90, y + 50, 250, 30);
            this.tagsText.setBounds(220, y + 50, 490, 30);
            
            this.category_label.setBounds(90, y + 100, 250, 30);
            
            for (int i = 0; i < categorymenu.size(); ++i)
            {
                categorymenu.get(i).setBounds(categorymenu.get(i).getX(), y + 100, 100, 30);
            }

            createBtn.setBounds(350, y + 180, 100, 30);
            repaint();
            validate();
        }
    }

    //remove ingredient button function
    public void removeIngredient() {
        if (i > 0) {
            y = y - 30;

            
            remove(this.quantity.get(this.i));
            this.quantity.remove(this.i);

            remove(this.unitmenu.get(this.i));
            this.unitmenu.remove(this.i);

            remove(this.ingredientmenu.get(this.i));
            this.ingredientmenu.remove(this.i);

            this.getAddBtn().setBounds(220, y + 30, 60, 20);
            this.getDelBtn().setBounds(280, y + 30, 60, 20);
            this.tags_label.setBounds(90, y + 50, 250, 30);
            this.tagsText.setBounds(220, y + 50, 490, 30);
            this.getCategoryAdd().setBounds(220, y + 130, 60, 20);
            this.getCategoryDel().setBounds(280, y + 130, 60, 20);
            
            this.category_label.setBounds(90, y + 100, 250, 30);
            
            for (int i = 0; i < categorymenu.size(); ++i)
            {
                categorymenu.get(i).setBounds(categorymenu.get(i).getX(), y + 100, 100, 30);
            }

            createBtn.setBounds(350, y + 180, 100, 30);

            i = --i;
            repaint();
            validate();
        }
    }
    
    
    //setup ingredient entry display
    public void setupCategories() {
        this.categoryNames = new String[]{"Sweet", "Spicy", "Salty", "Sour", "Bitter", "Breakfast", "Lunch" , "Dinner"};
        
        this.categorymenu.add(new JComboBox(categoryNames));
        this.categorymenu.get(this.j).setBounds(220, y + 100, 100, 30);
        add(this.categorymenu.get(this.j));
    }

    //add ingredient button function
    public void addCategory() {
        if (j < 4) {
            j += 1;

            this.categorymenu.add(new JComboBox(categoryNames));
            this.categorymenu.get(this.j).setBounds(x += 100, (y + 100), 100, 30);
            add(this.categorymenu.get(this.j));
            
            repaint();
            validate();
        }
    }

    //remove ingredient button function
    public void removeCategory() {
        if (j > 0) {
            x -= 100;
            
            remove(this.categorymenu.get(this.j));
            this.categorymenu.remove(this.j);

            j -= 1;
            repaint();
            validate();
        }
    }

}
