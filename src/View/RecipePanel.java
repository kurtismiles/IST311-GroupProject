/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RecipePanel extends JPanel {
   
    private JButton back;
    private JButton create;
    private JFrame ourFrame = new JFrame("Create");
    
    public RecipePanel()
    {
        back = new JButton("back");
        add(back);
        
        ourFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ourFrame.setBounds(200, 100, 400, 200);
		
		Container container = ourFrame.getContentPane();
		container.setLayout(null);
		
		JLabel logo = new JLabel("Create a New Recipe");
		logo.setBounds(60,5,250,30);
		
		JLabel name_label = new JLabel("Name :");
		name_label.setBounds(20,30,250,30);
		
		JLabel description_label = new JLabel("Description :");
		description_label.setBounds(20,60,250,30);
                
                JLabel ingredients_label = new JLabel("Ingredients :");
		ingredients_label.setBounds(20,90,250,30);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(65,30,250,30);
		
		JTextField emailText = new JTextField();
		emailText.setBounds(65, 60, 250, 30);
		
                JTextField ingredientText = new JTextField();
		ingredientText.setBounds(65, 90, 250, 30);
                
		JButton subBtn  = new JButton("Subscribe");
		subBtn.setBounds(150,120,100,30);
		
                container.add(logo);
                container.add(name_label);
                container.add(description_label);
                container.add(ingredients_label);
                container.add(nameText);
                container.add(emailText);
                container.add(ingredientText);
                container.add(subBtn);
                ourFrame.setVisible(true);
    }
    
    

    /**
     * @return the back
     */
    public JButton getBackButton() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBackButton(JButton back) {
        this.back = back;
    }
}
