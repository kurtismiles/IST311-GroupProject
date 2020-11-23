package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Kurtis
 */
public class MainPanel extends JPanel
{

    private Image image1;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;

    public MainPanel()
    {

        JPanel Background = new JPanel();

        FlowLayout fl = new FlowLayout(1);
        setLayout(fl);

        JPanel frame = new JPanel(new BorderLayout());
        frame.setLayout(fl);

        image1 = (new ImageIcon("Images/FoodBackground.jpg")).getImage();
        
        b1 = new JButton("Recipes");
        b1.setAlignmentY(CENTER_ALIGNMENT);
        b1.setFont(new Font("Courier", Font.PLAIN, 18));
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setForeground(Color.BLACK);
        frame.add(b1);
        add(b1);

        b2 = new JButton("Ingredients");
        b2.setBounds(100, 100, 500, 500);
        b2.setFont(new Font("Courier", Font.PLAIN, 18));
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setForeground(Color.BLACK);
        frame.add(b2);
        add(b2);

        b3 = new JButton("ShoppingList");
        b3.setFont(new Font("Courier", Font.PLAIN, 18));
        b3.setBackground(Color.LIGHT_GRAY);
        b3.setForeground(Color.BLACK);
        frame.add(b3);
        add(b3);

        b4 = new JButton("Settings");
        b4.setFont(new Font("Courier", Font.PLAIN, 18));
        b4.setBackground(Color.LIGHT_GRAY);
        b4.setForeground(Color.BLACK);
        frame.add(b4);
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
    
    public Image getImage1()
    {
        return image1;
    }

    public void setImage1(Image image1)
    {
        this.image1 = image1;
    }

    //Paints a background image
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image1, 0, 0, null);
    }
}
