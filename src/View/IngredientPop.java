package View;

import Model.Ingredient;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Kurtis
 */
public class IngredientPop extends JFrame {

    private JTextField nameText;
    private JTextField descriptionText;

    private JTextField tagsText;

    private JButton createBtn;
    private Ingredient writeIngredient;

    public IngredientPop() {
        super();

        writeIngredient = new Ingredient();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 100, 800, 400);

        setLayout(null);

        JLabel name_label = new JLabel("Ingredient :");
        name_label.setBounds(90, 30, 250, 30);

        JLabel description_label = new JLabel("Description :");
        description_label.setBounds(90, 80, 250, 30);

        JLabel tags_label = new JLabel("Tags :");
        tags_label.setBounds(90, 130, 250, 30);

        nameText = new JTextField();
        nameText.setBounds(220, 30, 490, 30);

        descriptionText = new JTextField();
        descriptionText.setBounds(220, 80, 490, 30);

        tagsText = new JTextField();
        tagsText.setBounds(220, 130, 490, 30);

        createBtn = new JButton("Create");
        createBtn.setBounds(350, 280, 100, 30);

        add(name_label);
        add(description_label);
        add(tags_label);
        add(nameText);
        add(descriptionText);
        add(tagsText);
        add(createBtn);
        setVisible(true);
    }

    public JTextField getNameText() {
        return nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JTextField getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(JTextField descriptionText) {
        this.descriptionText = descriptionText;
    }

    public JTextField getTagsText() {
        return tagsText;
    }

    public void setTagsText(JTextField tagsText) {
        this.tagsText = tagsText;
    }

    public JButton getCreateBtn() {
        return createBtn;
    }

    public void setCreateBtn(JButton createBtn) {
        this.createBtn = createBtn;
    }

    public Ingredient getWriteIngredient() {
        return writeIngredient;
    }

    public void setWriteIngredient(Ingredient writeIngredient) {
        this.writeIngredient = writeIngredient;
    }

}
