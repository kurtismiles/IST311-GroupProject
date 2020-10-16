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
  
   
   private JButton b1;
   private JButton b2;
   private JButton b3;
   private JButton b4;
    
    public MainPanel()
    {
      
        
        GridLayout gr = new GridLayout(1, 4);
        setLayout(gr);
       
       
            b1 = new JButton("Recipes");
            b1.setFont(new Font("Courier", Font.PLAIN, 18));
            b1.setBackground(Color.LIGHT_GRAY);
            b1.setForeground(Color.BLACK);
            add(b1); 
            
        
            b2 = new JButton("Ingredients");
            b2.setFont(new Font("Courier", Font.PLAIN, 18));
            b2.setBackground(Color.LIGHT_GRAY);
            b2.setForeground(Color.BLACK);          
            add(b2); 
      
       
            b3 = new JButton("ShoppingList");
            b3.setFont(new Font("Courier", Font.PLAIN, 18));
            b3.setBackground(Color.LIGHT_GRAY);
            b3.setForeground(Color.BLACK);
            add(b3);
            
            b4 = new JButton("Settings");
            b4.setFont(new Font("Courier", Font.PLAIN, 18));
            b4.setBackground(Color.LIGHT_GRAY);
            b4.setForeground(Color.BLACK);
            add(b4);
            
            
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
    
    public JButton getB4()
    {
        return b4;
    }

    public void setB4(JButton b4)
    {
        this.b4 = b4;
    }

    
    
    
   

  

    
}
