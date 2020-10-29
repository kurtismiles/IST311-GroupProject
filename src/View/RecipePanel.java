/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;
import javax.swing.JPanel;


public class RecipePanel extends JPanel {
   
    private JButton back;
    
    public RecipePanel()
    {
        back = new JButton("back");
        add(back);
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
