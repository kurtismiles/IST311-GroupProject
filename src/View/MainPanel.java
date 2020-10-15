/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author Kurtis
 */
public class MainPanel extends JPanel
{
  
   private ArrayList<JButton> jbs;
   private JButton b1;
   private JButton b2;
   private JButton b3;
    
    public MainPanel()
    {
      
        jbs = new ArrayList<JButton>();
        GridLayout gr = new GridLayout(1, 3);
        setLayout(gr);
       
       
            b1 = new JButton("Recipes");
            b1.setFont(new Font("Courier", Font.PLAIN, 18));
            b1.setBackground(Color.lightGray);
            b1.setForeground(Color.BLACK);
            jbs.add(b1);
            add(b1); 
            
        
            b2 = new JButton("Ingredients");
            b2.setFont(new Font("Courier", Font.PLAIN, 18));
            b2.setBackground(Color.lightGray);
            b2.setForeground(Color.BLACK);
            jbs.add(b2);
            add(b2); 
      
       
            b3 = new JButton("shopping");
            b3.setFont(new Font("Courier", Font.PLAIN, 18));
            b3.setBackground(Color.lightGray);
            b3.setForeground(Color.BLACK);
            jbs.add(b3);
            add(b3);
    }

    public ArrayList<JButton> getJbs()
    {
        return jbs;
    }

    public void setJbs(ArrayList<JButton> jbs)
    {
        this.jbs = jbs;
    }

    public JButton getB1()
    {
        return b1;
    }

    public void setB1(JButton b1)
    {
        this.b1 = b1;
    }

    public JButton getB2()
    {
        return b2;
    }

    public void setB2(JButton b2)
    {
        this.b2 = b2;
    }

    public JButton getB3()
    {
        return b3;
    }

    public void setB3(JButton b3)
    {
        this.b3 = b3;
    }

    
    
    
   

  

    
}
