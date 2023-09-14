package Source;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewPatient extends JFrame implements ActionListener
{
    String x[]={"Name","Father's Name","UserName","Email","Phone","Marital Status","City","Gender","Blood Group","Date of Birth","Age","Address","Specialization Needed"};
    JButton b1,b2;
    String y[][] = new String[20][14];
    int i=0, j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf;
    JPanel p1,p2,p3;
    Font f,f1;
    String p_username;
    int login_Id;
    String q;

    ViewPatient(String p_username, int login_Id)
    {
        super("Patient's Information");
        setSize(1500,400);
        setLocation(1,1);

        this.p_username=p_username;
        this.login_Id=login_Id;

        f = new Font("Arial",Font.BOLD,15);

        try
        {
            ConnectionClass obj = new ConnectionClass();
            if(login_Id==2)
            {
                q ="SELECT * FROM patients WHERE username='"+p_username+"'";
            }
            else {
                q ="SELECT * FROM patients";
            }

            ResultSet resultSet = obj.stm.executeQuery(q);
            while(resultSet.next())
            {
                y[i][j++]=resultSet.getString("name");
                y[i][j++]=resultSet.getString("father_name");
                y[i][j++]=resultSet.getString("username");
                y[i][j++]=resultSet.getString("email");
                y[i][j++]=resultSet.getString("phone");
                y[i][j++]=resultSet.getString("marital_status");
                y[i][j++]=resultSet.getString("city");
                y[i][j++]=resultSet.getString("gender");
                y[i][j++]=resultSet.getString("blood");
                y[i][j++]=resultSet.getString("dob");
                y[i][j++]=resultSet.getString("age");
                y[i][j++]=resultSet.getString("address");
                y[i][j++]=resultSet.getString("spec_needed");
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
        add(sp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f1 = new Font("Arial",Font.BOLD,25);
        l1 = new JLabel("Patient's Username");
        l2 = new JLabel("Delete or Edit any Patient's Record");
        l2.setHorizontalAlignment(JLabel.CENTER);

        l1.setForeground(Color.BLACK);
        l2.setForeground(Color.BLACK);
        l1.setFont(f1);
        l2.setFont(f1);

        b1 = new JButton("Delete Patient's Record");
        b2 = new JButton("Edit Patient's Record");

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
        add(sp);
    }
    public void actionPerformed(ActionEvent actionEvent)
    {
        String username = tf.getText();
        if(actionEvent.getSource()==b1)
        {
            if (username.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Fill the Patient's Username");
            }
            else
            {
                try
                {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 = "DELETE FROM patients WHERE username='"+username+"'";
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
                        JOptionPane.showMessageDialog(null, "Please Fill the Patient's Username");
                    }
                    else
                    {
                        setVisible(false);
                        new EditPatient(username).setVisible(true);
                    }
                }
    }

   /* public static void main(String[] args)
    {
        new ViewPatient().setVisible(true);
    }*/
}
