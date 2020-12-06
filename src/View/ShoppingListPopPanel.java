package View;

import Model.Recipe;
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
    private JButton addBtn;
    private JButton delBtn;

    private ArrayList<JComboBox> recipeMenu;
    private ArrayList<Recipe> recipeList;
    private ArrayList<String> recipeNames;

    private ArrayList<JLabel> labels;

    private JTextField shoppingName;

    public ShoppingListPopPanel() {
//        super();      
    }

    public ShoppingListPopPanel(ArrayList<Recipe> recipeList) {
        setLayout(null);

        this.recipeList = recipeList;

        this.recipeMenu = new ArrayList<>();
        this.recipeNames = new ArrayList<>();
        this.labels = new ArrayList<>();

        this.createBtn = new JButton("Create");
        this.addBtn = new JButton("+");
        this.delBtn = new JButton("-");

        JLabel shopLabelName = new JLabel("Shopping List Name:");
        shopLabelName.setBounds(50, 50, 120, 30);

        JLabel recipeLabel = new JLabel("Recipes Included:");
        recipeLabel.setBounds(50, 90, 160, 30);

        this.shoppingName = new JTextField();
        this.shoppingName.setBounds(180, 50, 160, 30);
        setupRecipeList();

        add(shopLabelName);
        add(this.shoppingName);
        add(recipeLabel);
        checkMenu();

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

    /**
     * @return the shoppingname
     */
    public JTextField getShoppingName() {
        return shoppingName;
    }

    /**
     * @param shoppingname the shoppingname to set
     */
    public void setShoppingName(JTextField shoppingname) {
        this.shoppingName = shoppingname;
    }

    /**
     * @return the recipeNames
     */
    public ArrayList<String> getRecipeNames() {
        return recipeNames;
    }

    /**
     * @param recipeNames the recipeNames to set
     */
    public void setRecipeNames(ArrayList<String> recipeNames) {
        this.recipeNames = recipeNames;
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

    //setup recipe entry display
    public void setupRecipeList() {
        for (int i = 0; i < this.recipeList.size(); ++i) {
            this.recipeNames.add(this.recipeList.get(i).getName());
        }
        this.recipeMenu.add(new JComboBox(this.recipeNames.toArray()));

    }

    //setup recipe entry display
    public ArrayList<Recipe> returnSelected() {
        ArrayList<Recipe> food = new ArrayList<>();
        for (int i = 0; i < this.recipeMenu.size(); i++) {
            int index = 0;

            for (int j = 0; j < recipeList.size(); j++) {

                if (recipeList.get(j).getName() == this.recipeMenu.get(i).getSelectedItem().toString()) {
                    index = j;
                    break;

                }

            }

            food.add(this.recipeList.get(index));

        }

        return food;

//        for (int i = 0; i < this.recipeList.get(i).getIngredients().size(); ++i) {
//            this.recipeMenu.add(new JComboBox(this.recipeList.toArray()));
//        }
    }

//    public boolean validateBoxes() {
//        for (int i = 0; i < this.recipeMenu.size(); ++i) {
//            this.recipeMenu.get(i).getSelectedItem().;
//        }
//        return boolean;
//    }
    public void checkMenu() {
        for (int i = 0; i < this.recipeMenu.size(); i++) {
            this.recipeMenu.get(i).setBounds(180, 90 + (i * 30), 160, 30);
            add(this.recipeMenu.get(i));
            if (i == this.recipeMenu.size() - 1) {
                this.addBtn.setBounds(180, 90 + (i * 30) + 40, 60, 20);
                add(this.addBtn);
                this.delBtn.setBounds(240, 90 + (i * 30) + 40, 60, 20);
                add(this.delBtn);
                this.createBtn.setBounds(180, 90 + (i * 30) + 70, 100, 30);
                add(this.createBtn);
            }
        }
    }

    //add ingredient button function
    public void addIngredient() {
        if (this.recipeMenu.size() < 8) {
            this.recipeMenu.add(new JComboBox(this.recipeNames.toArray()));
            checkMenu();
            repaint();
            revalidate();
        }
    }

    //remove ingredient button function
    public void delIngredient() {
        if (this.recipeMenu.size() >= 0) {
            remove(this.recipeMenu.get(this.recipeMenu.size() - 1));
            this.recipeMenu.remove(this.recipeMenu.size() - 1);
            checkMenu();
            repaint();
            revalidate();
        }
    }

}
