/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Kurtis
 */
public class ShoppingListPopPanel extends JPanel {
 
    private JButton createBtn;
    
    public ShoppingListPopPanel()
    {
        
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
    
    
}
