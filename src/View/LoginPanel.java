package View;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel
{

    private JButton submit;
    private JTextField user;
    private JTextField pass;

    public LoginPanel()
    {
        //-----------------------------Color
        Color cake = new Color(255, 253, 219);
        Color sblue = new Color(187, 244, 255);
        //Color icing = new Color(0, 0, 0);
        //------------------------------
        setLayout(new BorderLayout());
        //setBackground(Color.darkGray);   //loading tester
        user = new JTextField("Sam@yahoo.com", 30);  //remove login info later
        pass = new JTextField("Puppies", 30);
        JLabel userlbl = new JLabel("Username:");
        JLabel passlbl = new JLabel("Password: ");
        submit = new JButton("Submit");
        //-----------------------------Grid Padding
        JPanel gridCPnl = new JPanel();
        gridCPnl.setLayout(new GridLayout(3, 3));
        JPanel[] gridinCPnl = new JPanel[8];
        for (int i = 0; i < gridinCPnl.length; i++)
        {
            gridinCPnl[i] = new JPanel();
            gridinCPnl[i].setPreferredSize(new Dimension(2, 2));
            gridinCPnl[i].setBackground(sblue);
        }
        //-----------------------------CenterPanel
        JPanel CPnl = new JPanel();
        int Cpnlsize = 3;
        CPnl.setLayout(new GridLayout(Cpnlsize, 1));
        CPnl.setBackground(Color.orange);
        JPanel[] innerCPnl = new JPanel[Cpnlsize];
        for (int i = 0; i < innerCPnl.length; i++)
        {
            innerCPnl[i] = new JPanel();
            innerCPnl[i].setBackground(Color.white);
        }
        innerCPnl[0].setBackground(cake);
        JLabel login = new JLabel("Login");
        //login.setFont(new Font("Helvetica", Font.BOLD, 48));
        innerCPnl[0].setLayout(new GridBagLayout());
        innerCPnl[0].add(login);
        //-----------------------------User+Pass
        JPanel ups = new JPanel();
        ups.setLayout(new GridLayout(2, 1));
        JPanel usr = new JPanel();
        usr.add(userlbl);
        usr.add(user);
        usr.setBackground(Color.white);
        JPanel pwd = new JPanel();
        pwd.add(passlbl);
        pwd.add(pass);
        pwd.setBackground(Color.white);
        ups.add(usr);
        ups.add(pwd);
        innerCPnl[1].add(ups);
        //-----------------------------
        //innerCPnl[2].setLayout(new GridBagLayout());
        innerCPnl[2].add(submit);
        for (int i = 0; i < innerCPnl.length; i++)
        {
            CPnl.add(innerCPnl[i]);
        }
        //add(CPnl, "Center");
        //-----------------------------Grid Padding Sequence
        for (int i = 0; i < gridinCPnl.length; i++)
        {
            gridCPnl.add(gridinCPnl[i]);
            if (i == 3)
            {
                gridCPnl.add(CPnl);
            }
        }
        add(gridCPnl, "Center");
        //-----------------------------Left-Hand User List
        /*int num = 10;
        int displaylimit = 10;
        JButton[] jb = new JButton[num];
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JButton(String.format("%d", i));
            jb[i].setBackground(Color.white);
        }
        JPanel pnl = new JPanel();
        pnl.setBackground(Color.white);
        pnl.setLayout(new GridLayout(displaylimit, 3));
        for (int i = 0; i < displaylimit; i++) {
            pnl.add(jb[i]);
            pnl.add(new JLabel());
        }
        add(pnl, "West");*/
        //-----------------------------North Border
        JPanel north = new JPanel();
        north.setLayout(new GridLayout(4, 1));
        JLabel[] jlbl = new JLabel[4];
        for (int i = 0; i < jlbl.length; i++)
        {
            jlbl[i] = new JLabel(" ");
            north.add(jlbl[i]);
        }
        //-----------------------------
        north.setBackground(sblue);
        add(north, "North");
    }

    public JButton getSubmit()
    {
        return submit;
    }

    public void setClickMe(JButton submit)
    {
        this.submit = submit;
    }

    public JTextField getUser()
    {
        return user;
    }

    public void setUser(JTextField user)
    {
        this.user = user;
    }

    public JTextField getPass()
    {
        return pass;
    }

    public void setPass(JTextField pass)
    {
        this.pass = pass;
    }
}
