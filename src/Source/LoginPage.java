package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener
{
    JFrame f;
    JPanel panel;
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    int loginID;

    LoginPage(int login_ID)
    {
        this.loginID = login_ID;
        f= new JFrame("Login Page");
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

        l2 = new JLabel("Login Page");
        l2.setBounds(198,30,500,50);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        l3 = new JLabel("Username: ");
        l3.setBounds(130,120,150,30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        l4 = new JLabel("Password: ");
        l4.setBounds(130,170,150,30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        t1 = new JTextField();
        t1.setBounds(310,120,150,30);
        l1.add(t1);

        p1 = new JPasswordField();
        p1.setBounds(310,170,150,30);
        l1.add(p1);

        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,220,150,40);
        b1.setFocusable(false);
        l1.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(310,220,150,40);
        b1.setFocusable(false);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);



    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==b1)
        {
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String name = t1.getText();
                String password = p1.getText();
                ResultSet resultSet;

                if (loginID==1)
                {
                    String q = "SELECT * FROM doctors WHERE username='"+name+"' and password='"+password+"'";
                    resultSet =  obj.stm.executeQuery(q);
                    if(resultSet.next())
                    {
                        String doctorname = resultSet.getString("name");
                        String doctor_id = resultSet.getString("doc_id");
                        String doctor_username = resultSet.getString("username");

                        System.out.println("Doctor Login");
                        f.dispose();
                        new DoctorHomePage(doctorname,loginID,doctor_username).setVisible(true);
                    }
                    else
                    {
                        f.setVisible(false);
                        JOptionPane.showMessageDialog(null,"You've entered wrong username or password","ERROR",JOptionPane.ERROR_MESSAGE);
                        f.setVisible(true);
                    }
                }
                else if (loginID==2)
                {
                    String q = "SELECT * FROM patients WHERE username='"+name+"' and password='"+password+"'";
                    resultSet =  obj.stm.executeQuery(q);
                    if(resultSet.next())
                    {
                        String patientname = resultSet.getString("name");
                        String pat_id = resultSet.getString("pat_id");
                        String pat_username= resultSet.getString("username");

                        System.out.println("Patient Login");
                        f.dispose();
                        new PatientHomePage(patientname,loginID,pat_username).setVisible(true);
                    }
                    else
                    {
                        f.setVisible(false);
                        JOptionPane.showMessageDialog(null,"You've entered wrong username or password","ERROR",JOptionPane.ERROR_MESSAGE);
                        f.setVisible(true);
                    }
                }
                else if (loginID==3)
                {
                    String q = "SELECT * FROM receptionists WHERE username='"+name+"' and password='"+password+"'";
                    resultSet =  obj.stm.executeQuery(q);
                    if(resultSet.next())
                    {
                        String receptionistname = resultSet.getString("name");
                        String rec_id = resultSet.getString("rec_id");
                        String rec_username= resultSet.getString("username");

                        System.out.println("Receptionist Login");
                        f.dispose();
                        new ReceptionistHomePage(receptionistname,loginID,rec_username).setVisible(true);
                    }
                    else
                    {
                        f.setVisible(false);
                        JOptionPane.showMessageDialog(null,"You've entered wrong username or password","ERROR",JOptionPane.ERROR_MESSAGE);
                        f.setVisible(true);
                    }
                }
                else if (loginID==4)
                {
                    String q = "SELECT * FROM admin WHERE username='"+name+"' and password='"+password+"'";
                    resultSet =  obj.stm.executeQuery(q);
                    if(resultSet.next())
                    {
                        String adminname = resultSet.getString("name");
                        String admin_id = resultSet.getString("admin_id");
                        String admin_username= resultSet.getString("username");

                        System.out.println("Admin Login");
                        f.dispose();
                        new AdminHomePage(adminname,loginID,admin_username,admin_id).setVisible(true);
                    }
                    else
                    {
                        f.setVisible(false);
                        JOptionPane.showMessageDialog(null,"You've entered wrong username or password","ERROR",JOptionPane.ERROR_MESSAGE);
                        f.setVisible(true);
                    }

                }

            }
            catch(Exception Ex)
            {
                Ex.printStackTrace();
            }

        }
        if(event.getSource()==b2)
        {
            f.dispose();
            new Index();
        }
    }
    /*public static void main(String[] args)
    {
     new LoginPage(int login_ID);
    }*/
}
