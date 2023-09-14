package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckMyProfile extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    public int login_Id;
    String q,q1,q2;
    ResultSet resultSet,resultSet1,resultSet3;
    String admin_Id;
    CheckMyProfile(String admin_Id, int login_Id)
    {

        this.login_Id=login_Id;
        this.admin_Id=admin_Id;
        try{
            ConnectionClass obj = new ConnectionClass();
            if (login_Id==1)
            {
                q= "SELECT * FROM doctors WHERE doc_id='"+admin_Id+"'";
                resultSet =obj.stm.executeQuery(q);
            }
            else if (login_Id==2)
            {
                q= "SELECT * FROM patients WHERE pat_id='"+admin_Id+"'";
                resultSet =obj.stm.executeQuery(q);
            }
            else if (login_Id==3)
            {
                q= "SELECT * FROM receptionists WHERE rec_id='"+admin_Id+"'";
                resultSet =obj.stm.executeQuery(q);
            }
            else if (login_Id==4)
            {
                q= "SELECT * FROM patients WHERE admin_id='"+admin_Id+"'";
                resultSet =obj.stm.executeQuery(q);
            }

            if(resultSet.next()) {

                f = new JFrame("My Profile");
                f.setBackground(Color.WHITE);
                f.setLayout(null);

                l1 = new JLabel();
                l1.setBounds(0, 0, 900, 600);
                l1.setLayout(null);

                ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Hospital.jpg"));
                Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i1);
                l1.setIcon(img1);

                l2 = new JLabel("Edit My Details");
                l2.setBounds(280, 30, 500, 50);
                l2.setFont(new Font("Arial", Font.BOLD, 30));
                l2.setForeground(Color.BLACK);
                l1.add(l2);
                f.add(l1);

                l3 = new JLabel("My ID");
                l3.setBounds(50, 150, 150, 30);
                l3.setFont(new Font("Arial", Font.BOLD, 20));
                l3.setForeground(Color.BLACK);
                l1.add(l3);

                t1 = new JTextField();
                t1.setBounds(200, 150, 150, 30);
                t1.setEditable(false);
                l1.add(t1);

                l4 = new JLabel("Username");
                l4.setBounds(450, 150, 200, 30);
                l4.setFont(new Font("Arial", Font.BOLD, 20));
                l4.setForeground(Color.BLACK);
                l1.add(l4);

                t2 = new JTextField();
                t2.setBounds(600, 150, 150, 30);
                t2.setEditable(false);
                l1.add(t2);

                l5 = new JLabel("Name");
                l5.setBounds(50, 200, 100, 30);
                l5.setFont(new Font("Arial", Font.BOLD, 20));
                l5.setForeground(Color.BLACK);
                l1.add(l5);

                t3 = new JTextField();
                t3.setBounds(200, 200, 150, 30);
                t3.setEditable(false);
                l1.add(t3);

                l6 = new JLabel("Age");
                l6.setBounds(450, 200, 200, 30);
                l6.setFont(new Font("Arial", Font.BOLD, 20));
                l6.setForeground(Color.BLACK);
                l1.add(l6);

                t4 = new JTextField();
                t4.setBounds(600, 200, 150, 30);
                l1.add(t4);

                l7 = new JLabel("Phone");
                l7.setBounds(50, 250, 100, 30);
                l7.setFont(new Font("Arial", Font.BOLD, 20));
                l7.setForeground(Color.BLACK);
                l1.add(l7);

                t5 = new JTextField();
                t5.setBounds(200, 250, 150, 30);
                l1.add(t5);

                l8 = new JLabel("City");
                l8.setBounds(450, 250, 100, 30);
                l8.setFont(new Font("Arial", Font.BOLD, 20));
                l8.setForeground(Color.BLACK);
                l1.add(l8);

                t6 = new JTextField();
                t6.setBounds(600, 250, 150, 30);
                l1.add(t6);

                l9 = new JLabel("Email");
                l9.setBounds(50, 300, 100, 30);
                l9.setFont(new Font("Arial", Font.BOLD, 20));
                l9.setForeground(Color.BLACK);
                l1.add(l9);

                t7 = new JTextField();
                t7.setBounds(200, 300, 150, 30);
                l1.add(t7);

                l10 = new JLabel("Gender");
                l10.setBounds(450, 300, 100, 30);
                l10.setFont(new Font("Arial", Font.BOLD, 20));
                l10.setForeground(Color.BLACK);
                l1.add(l10);

                t8 = new JTextField();
                t8.setBounds(600, 300, 150, 30);
                t8.setEditable(false);
                l1.add(t8);


                try {
                    ConnectionClass obj1 = new ConnectionClass();

                    if (login_Id==1)
                    {
                        q1= "SELECT * FROM doctors WHERE doc_id='"+admin_Id+"'";
                        resultSet1 =obj1.stm.executeQuery(q1);
                    }
                    else if (login_Id==2)
                    {
                        q1= "SELECT * FROM patients WHERE pat_id='"+admin_Id+"'";
                        resultSet1 =obj1.stm.executeQuery(q1);
                    }
                    else if (login_Id==3)
                    {
                        q1= "SELECT * FROM receptionists WHERE rec_id='"+admin_Id+"'";
                        resultSet1 =obj1.stm.executeQuery(q1);
                    }
                    else if (login_Id==4)
                    {
                        q1= "SELECT * FROM patients WHERE admin_id='"+admin_Id+"'";
                        resultSet1 =obj1.stm.executeQuery(q1);
                    }

                    while (resultSet1.next()) {

                        if (login_Id==1)
                        {
                            t1.setText(resultSet1.getString("doc_id"));
                        }
                        else if (login_Id==2)
                        {
                            t1.setText(resultSet1.getString("pat_id"));
                        }
                        else if (login_Id==3)
                        {
                            t1.setText(resultSet1.getString("rec_id"));
                        }
                        else if (login_Id==4)
                        {
                            t1.setText(resultSet1.getString("admin_id"));
                        }

                        t2.setText(resultSet1.getString("username"));
                        t3.setText(resultSet1.getString("name"));
                        t4.setText(resultSet1.getString("age"));
                        t5.setText(resultSet1.getString("phone"));
                        t6.setText(resultSet1.getString("city"));
                        t7.setText(resultSet1.getString("email"));
                        t8.setText(resultSet1.getString("gender"));

                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }


                b1 = new JButton("Update");
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
                b1.setBounds(250, 350, 150, 40);
                l1.add(b1);

                b2 = new JButton("Cancel");
                b2.setBackground(Color.RED);
                b2.setForeground(Color.WHITE);
                b2.setBounds(450, 350, 150, 40);
                l1.add(b2);

                b1.addActionListener(this);
                b2.addActionListener(this);

                f.setVisible(true);
                f.setSize(900, 450);
                f.setLocation(300, 100);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else {
                JOptionPane.showMessageDialog(null,"Record not found, please fill the right Admin ID !!");
                this.setVisible(false);
            }
        }
        catch (Exception ex1)
        {
            ex1.printStackTrace();
        }

    }
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==b1)
        {
            String ad_id = t1.getText();
            String age = t4.getText();
            String phone = t5.getText();
            String city=t6.getText();
            String email = t7.getText();

            try
            {
                ConnectionClass obj2 = new ConnectionClass();
                if (login_Id==4)
                {
                    q2 ="UPDATE admin SET age='"+age+"',phone='"+phone+"',city='"+city+"',email='"+email+"' WHERE admin_id ='"+ad_id+"'";
                    obj2.stm.executeUpdate(q2);
                }
                else if(login_Id==3)
                {
                    q2 ="UPDATE receptionists SET age='"+age+"',phone='"+phone+"',city='"+city+"',email='"+email+"' WHERE rec_id ='"+ad_id+"'";
                    obj2.stm.executeUpdate(q2);
                }
                else if(login_Id==2)
                {
                    q2 ="UPDATE patients SET age='"+age+"',phone='"+phone+"',city='"+city+"',email='"+email+"' WHERE pat_id ='"+ad_id+"'";
                    obj2.stm.executeUpdate(q2);
                }
                else if(login_Id==1)
                {
                    q2 ="UPDATE doctors SET age='"+age+"',phone='"+phone+"',city='"+city+"',email='"+email+"' WHERE doc_id ='"+ad_id+"'";
                    obj2.stm.executeUpdate(q2);
                }

                //obj2.stm.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Details Successfully Updated!");
                f.setVisible(false);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(actionEvent.getSource()==b2)
        {
            f.setVisible(false);
        }
    }

/*    public static void main(String[] args)
    {
        new CheckMyProfile("88726",3);
    }*/
}
