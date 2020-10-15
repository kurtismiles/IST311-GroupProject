/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;

public class LoginPanel extends JPanel
{
    private JButton clickMe;
    
    public LoginPanel()
    {
        clickMe = new JButton("TESTING: CLICK ME");
        add(clickMe);
    }
}
