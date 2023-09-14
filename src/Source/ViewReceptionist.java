package Source;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewReceptionist extends JFrame implements ActionListener
{
    String x[]={"Name","Father's Name","UserName","Email","Phone","Qualification","City","Gender","Blood Group","Date of Birth","Age","Address","Joining Date"};
    JButton b1,b2;
    String y[][] = new String[20][14];
    int i=0, j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf;
    JPanel p1,p2,p3;
    Font f,f1;
    int login_Id;

    ViewReceptionist(int login_Id)
    {
        super("Receptionist's Information");
        setSize(1500,400);
        setLocation(1,1);

        this.login_Id=login_Id;

        f = new Font("Arial",Font.BOLD,15);

        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q ="SELECT * FROM receptionists";
            ResultSet resultSet = obj.stm.executeQuery(q);
            while(resultSet.next())
            {
                y[i][j++]=resultSet.getString("name");
                y[i][j++]=resultSet.getString("father_name");
                y[i][j++]=resultSet.getString("username");
                y[i][j++]=resultSet.getString("email");
                y[i][j++]=resultSet.getString("phone");
                y[i][j++]=resultSet.getString("qualification");
                y[i][j++]=resultSet.getString("city");
                y[i][j++]=resultSet.getString("gender");
                y[i][j++]=resultSet.getString("blood");
                y[i][j++]=resultSet.getString("dob");
                y[i][j++]=resultSet.getString("age");
                y[i][j++]=resultSet.getString("address");
                y[i][j++]=resultSet.getString("joining_date");
                i++;
                j=0;
            }
            t= new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(login_Id==4)
        {
            f1 = new Font("Arial",Font.BOLD,25);
            l1 = new JLabel("Receptionist's Username");
            l2 = new JLabel("Delete or Edit any Receptionist's Record");
            l2.setHorizontalAlignment(JLabel.CENTER);

            l1.setForeground(Color.BLACK);
            l2.setForeground(Color.BLACK);
            l1.setFont(f1);
            l2.setFont(f1);

            b1 = new JButton("Delete Receptionist's Record");
            b2 = new JButton("Edit Receptionist's Record");

            b1.setBackground(Color.BLACK);
            b2.setBackground(Color.BLACK);

            b1.setForeground(Color.RED);
            b2.setForeground(Color.RED);

            b1.addActionListener(this);
            b2.addActionListener(this);

            tf = new JTextField();
            tf.setFont(f);

            p1 = new JPanel();
            p1.setLayout(new GridLayout(1,1,10,10));
            p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1,4,10,10));
            p2.add(l1);
            p2.add(tf);
            p2.add(b1);
            p2.add(b2);

            p3 = new JPanel();
            p3.setLayout(new GridLayout(2,1,10,10));
            p3.add(p1);
            p3.add(p2);

            add(p3,"South");

        }

                add(sp);
    }
    public void actionPerformed(ActionEvent actionEvent)
    {
        String username = tf.getText();
        if(actionEvent.getSource()==b1)
        {
            if (username.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Fill the Receptionist's Username");
            }
            else
            {
                try
                {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 = "DELETE FROM receptionists WHERE username='"+username+"'";
                    obj1.stm.executeUpdate(q1);
                    setVisible(false);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
        else if(actionEvent.getSource()==b2)
        {
            if (username.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Fill the Receptionist's Username");
            }
            else
            {
                setVisible(false);
                new EditReceptionist(username,login_Id).setVisible(true);
            }
        }
    }

    /*public static void main(String[] args)
    {
        new ViewReceptionist().setVisible(true);
    }*/
}
