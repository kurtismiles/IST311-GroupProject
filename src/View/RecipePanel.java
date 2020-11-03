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

public class RecipePanel extends JPanel
{

    private JButton back;
    private JButton create;

    public RecipePanel()
    {
        back = new JButton("back");
        add(back);

        create = new JButton("create");
        add(create);

    }
    
    /**
     * @return the back
     */
    public JButton getBackButton()
    {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBackButton(JButton back)
    {
        this.back = back;
    }

    public JButton getCreateButton()
    {
        return create;
    }

    public void setCreateButton(JButton create)
    {
        this.create = create;
    }
    
}
