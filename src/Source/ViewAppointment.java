package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewAppointment extends JFrame implements ActionListener
{
    String x[]={"App_ID","UserName","Name","Father's Name","Email","Phone","Marital Status","City","Gender","Blood Group","Age","Date of Birth","Specialization Needed","Doc_Username","App_Date","App_Time","App_Status"};
    JButton b1,b2;
    String y[][] = new String[20][17];
    int i=0, j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf;
    JPanel p1,p2,p3;
    Font f,f1;
    String q;

    ViewAppointment(String username , int login_Id)
    {
        super("Appointment Information");
        setSize(1500,400);
        setLocation(1,1);

        f = new Font("Arial", Font.BOLD,15);

        try
        {
            ConnectionClass obj = new ConnectionClass();

            if (login_Id==1){
                q ="SELECT * FROM appointments WHERE doctor_username='"+username+"'";
            }
            else if (login_Id==2){
                q ="SELECT * FROM appointments WHERE p_username='"+username+"'";
            }
            else {
                q ="SELECT * FROM appointments";
            }

            ResultSet resultSet = obj.stm.executeQuery(q);
            while(resultSet.next())
            {
                y[i][j++]=resultSet.getString("app_id");
                y[i][j++]=resultSet.getString("p_username");
                y[i][j++]=resultSet.getString("name");
                y[i][j++]=resultSet.getString("father_name");
                y[i][j++]=resultSet.getString("email");
                y[i][j++]=resultSet.getString("phone");
                y[i][j++]=resultSet.getString("marital_status");
                y[i][j++]=resultSet.getString("city");
                y[i][j++]=resultSet.getString("gender");
                y[i][j++]=resultSet.getString("blood");
                y[i][j++]=resultSet.getString("age");
                y[i][j++]=resultSet.getString("dob");
                y[i][j++]=resultSet.getString("spec_needed");
                y[i][j++]=resultSet.getString("doc_username");
                y[i][j++]=resultSet.getString("app_Date");
                y[i][j++]=resultSet.getString("app_Time");
                y[i][j++]=resultSet.getString("app_Status");
                i++;
                j=0;
            }
            t= new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t);
        add(sp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f1 = new Font("Arial",Font.BOLD,30);

        l1 = new JLabel("Complete or Cancel Appointment Status");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.BLACK);

        l2 = new JLabel("Appointment ID");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);


        b1 = new JButton("Complete Appointment");
        b2 = new JButton("Cancel Appointment");

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);

        b1.setForeground(Color.RED);
        b2.setForeground(Color.RED);

        b1.addActionListener(this);
        b2.addActionListener(this);

        tf = new JTextField();
        tf.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,4,10,10));
        p2.add(l2);
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
        String app_id = tf.getText();
        if(actionEvent.getSource()==b1)
        {
            if (app_id.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Fill the Appointment ID");
            }
            else
            {
                try
                {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 = "UPDATE appointments SET app_status='Complete' WHERE app_id='"+app_id+"'";
                    int a = obj1.stm.executeUpdate(q1);
                    if (a==1)
                    {
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Appointment ID not found!!");
                    }

                }
                catch (Exception exception1)
                {
                    exception1.printStackTrace();
                }
            }
        }
        else if(actionEvent.getSource()==b2)
        {
            if (app_id.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Fill the Receptionist's Username");
            }
            else
            {
                try
                {
                    ConnectionClass obj2 = new ConnectionClass();
                    String q2 = "UPDATE appointments SET app_status='Cancelled' WHERE app_id='"+app_id+"'";
                    int a = obj2.stm.executeUpdate(q2);
                    if (a==1)
                    {
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Appointment ID not found!!");
                    }

                }
                catch (Exception exception2)
                {
                    exception2.printStackTrace();
                }
            }
        }
    }

   /* public static void main(String[] args)
    {
        new ViewAppointment().setVisible(true);
    }*/

}
