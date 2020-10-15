/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JButton clickMe;
    private JTextField usern;
    private JTextField passw;

    public LoginPanel() {
        //setLayout(new GridLayout(3, 2));
        usern = new JTextField("Food");
        passw = new JTextField("Key");
        JLabel uselbl = new JLabel("Username:");
        JLabel passlbl = new JLabel("Password:");
        clickMe = new JButton("TESTING: CLICK ME");
        add(uselbl);
        add(usern);
        add(passlbl);
        add(passw);
        add(clickMe);
    }

    /**
     * @return the clickMe
     */
    public JButton getClickMe() {
        return clickMe;
    }

    /**
     * @param clickMe the clickMe to set
     */
    public void setClickMe(JButton clickMe) {
        this.clickMe = clickMe;
    }

    /**
     * @return the usern
     */
    public JTextField getUsern() {
        return usern;
    }

    /**
     * @param usern the usern to set
     */
    public void setUsern(JTextField usern) {
        this.usern = usern;
    }

    /**
     * @return the passw
     */
    public JTextField getPassw() {
        return passw;
    }

    /**
     * @param passw the passw to set
     */
    public void setPassw(JTextField passw) {
        this.passw = passw;
    }
}
