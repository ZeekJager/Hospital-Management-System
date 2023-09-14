package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3,b4;
    public int loginID;
    Index()
    {
        f = new JFrame("Index Page");
        f.setLayout(null);

        l1= new JLabel();
        l1.setBounds(0,0,800,570);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/index5.jpg"));
        Image image = img.getImage().getScaledInstance(800,570,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(image);
        l1.setIcon(img1);
        f.add(l1);

        l2= new JLabel("HiLCoE Medical Group");
        l2.setBounds(70,315,500,30);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        l3= new JLabel("Provide best quality healthcare for you!");
        l3.setBounds(86,340,500,30);
        l3.setFont(new Font("Arial",Font.BOLD,14));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        b1 = new JButton("Doctor");
        b1.setBounds(50,390,150,40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        l1.add(b1);

        b2 = new JButton("Patient");
        b2.setBounds(220,390,150,40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        l1.add(b2);

        b3 = new JButton("Receptionist");
        b3.setBounds(50,450,150,40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFocusable(false);
        l1.add(b3);

        b4 = new JButton("Admin");
        b4.setBounds(220,450,150,40);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFocusable(false);
        l1.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);


        f.setSize(800,570);
        f.setLocation(300,100);
        f.setResizable (false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource()==b1)
        {
            loginID = 1;
            f.dispose();
            new LoginPage(loginID);
        }
        if(event.getSource()==b2)
        {
            loginID = 2;
            f.dispose();
            new LoginPage(loginID);
        }
        if(event.getSource()==b3)
        {
            loginID =3;
            f.dispose();
            new LoginPage(loginID);
        }
        if(event.getSource()==b4)
        {
            loginID =4;
            f.dispose();
            new LoginPage(loginID);
        }
    }

    public static void main(String[] args)
    {
        new Index();
    }

}
