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

    public JButton getClickMe() {
        return clickMe;
    }

    public void setClickMe(JButton clickMe) {
        this.clickMe = clickMe;
    }

    public JTextField getUsern() {
        return usern;
    }

    public void setUsern(JTextField usern) {
        this.usern = usern;
    }

    public JTextField getPassw() {
        return passw;
    }

    public void setPassw(JTextField passw) {
        this.passw = passw;
    }
}
