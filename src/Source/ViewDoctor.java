package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewDoctor extends JFrame implements ActionListener
{
    String x[]={"Name","Username","DOB","Address","Phone","Email","City","Gender","Blood Group","Age","Clinic_No","Joining_Date","Specialization","Availability"};
    JButton b1,b2;
    String y[][] = new String[20][14];
    int i=0, j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf;
    JPanel p1,p2,p3;
    Font f,f1;
    int login_Id;

    ViewDoctor(int login_Id)
    {
        super("Doctors Information");
        setSize(1500,400);
        setLocation(1,1);
        this.login_Id=login_Id;

        f = new Font("Arial",Font.BOLD,15);

        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q ="SELECT * FROM doctors";
            ResultSet resultSet = obj.stm.executeQuery(q);
            while(resultSet.next())
            {
                y[i][j++]=resultSet.getString("name");
                y[i][j++]=resultSet.getString("username");
                y[i][j++]=resultSet.getString("dob");
                y[i][j++]=resultSet.getString("address");
                y[i][j++]=resultSet.getString("phone");
                y[i][j++]=resultSet.getString("email");
                y[i][j++]=resultSet.getString("city");
                y[i][j++]=resultSet.getString("gender");
                y[i][j++]=resultSet.getString("blood");
                y[i][j++]=resultSet.getString("age");
                y[i][j++]=resultSet.getString("clinic_no");
                y[i][j++]=resultSet.getString("joining_date");
                y[i][j++]=resultSet.getString("specialization");
                y[i][j++]=resultSet.getString("Availability");
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

            l1 = new JLabel("Doctor's Username");
            l2 = new JLabel("Delete or Edit any Doctor");
            l2.setHorizontalAlignment(JLabel.CENTER);

            l1.setForeground(Color.BLACK);
            l2.setForeground(Color.BLACK);
            l1.setFont(f1);
            l2.setFont(f1);

            b1 = new JButton("Delete Doctor's Record");
            b2 = new JButton("Edit Doctor's Record");

            b1.addActionListener(this);
            b2.addActionListener(this);

            b1.setBackground(Color.BLACK);
            b2.setBackground(Color.BLACK);

            b1.setForeground(Color.RED);
            b2.setForeground(Color.RED);

            b1.setFocusable(false);
            b2.setFocusable(false);

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
    public void actionPerformed(ActionEvent actionEvent) {
        String username = tf.getText();
        if (actionEvent.getSource() == b1)
        {
            if (username.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Fill the Doctor's Username","Incorrect Username",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                try
                {
                    ConnectionClass obj2 = new ConnectionClass();
                    String q1 = "DELETE FROM doctors WHERE username='"+username+"'";
                    obj2.stm.executeUpdate(q1);
                    String q2 = "UPDATE appointment SET appointment_status='Cancel' WHERE doctor_username='"+username+"' and appointment_status='Open'";
                    obj2.stm.executeUpdate(q2);
                    dispose();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
        else if (actionEvent.getSource() == b2) {
            if (username.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Fill the Doctor's Username","Incorrect Username",JOptionPane.INFORMATION_MESSAGE);            }
            else
            {
                new EditDoctor(username).setVisible(true);
            }
            }
        }

    /*public static void main(String[] args)
    {
        new ViewDoctor(1).setVisible(true);
    }*/
}
