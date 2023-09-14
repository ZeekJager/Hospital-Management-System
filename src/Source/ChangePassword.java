package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ChangePassword extends JFrame implements ActionListener
{
    JFrame f;
    JPanel panel;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;

    ChangePassword(String adminname)
    {
        f= new JFrame("Change Password");
        f.setBackground(Color.BLACK);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);


        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Index.jpg"));
        Image i = img.getImage().getScaledInstance(580,350,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);
        f.add(l1);

        l2 = new JLabel("Change Password");
        l2.setBounds(198,30,500,50);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        l3 = new JLabel("User: "+adminname+"");
        l3.setBounds(260,75,500,30);
        l3.setFont(new Font("Arial",Font.BOLD,17));
        l3.setForeground(Color.RED);
        l1.add(l3);


        l4 = new JLabel("Old Password: ");
        l4.setBounds(130,120,150,30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        l5 = new JLabel("New Password: ");
        l5.setBounds(130,170,160,30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);

        t1 = new JTextField();
        t1.setBounds(310,120,150,30);
        l1.add(t1);

        p1 = new JPasswordField();
        p1.setBounds(310,170,150,30);
        l1.add(p1);

        b1 = new JButton("Change Password");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,220,150,40);
        l1.add(b1);

        b2 = new JButton("Close");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(310,220,150,40);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);



    }

    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==b1)
        {
            String old_pass = t1.getText();
            String new_pass = p1.getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                String admin_id1 ="SELECT admin_id FROM admin";

                String q = "UPDATE admin SET password='"+new_pass+"' WHERE admin_id='"+admin_id1+"' and password='"+old_pass+"'";
                int a1 = obj.stm.executeUpdate(q);
                if (a1==1)
                {
                    JOptionPane.showMessageDialog(null,"Your Password is Successfully Updated");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have Entered Wrong Old Password!!");
                }

            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
            }

        if(actionEvent.getSource()==b2)
        {
            this.f.setVisible(false);
        }
    }

 public static void main(String[] args)
    {
       // new ChangePassword("Zekarias").setVisible(true);
    }
}
