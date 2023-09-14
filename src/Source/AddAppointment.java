package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;

public class AddAppointment extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JPanel p1,p2,p3;
    Font f,f1;
    Choice ch1, ch2, ch3;
    String q;

    AddAppointment(){
        super("Add Appointment");
        setLocation(450,10);
        setSize(740,730);

        f = new Font("Arial", Font.BOLD,25);
        f1= new Font("Arial",Font.BOLD,18);

        ch1 = new Choice();
        ch2 = new Choice();
        ch3 = new Choice();

        ch3.add("10AM");
        ch3.add("11AM");
        ch3.add("12AM");
        ch3.add("1AM");
        ch3.add("2AM");
        ch3.add("3AM");
        ch3.add("4AM");
        ch3.add("5AM");

        try
        {
            ConnectionClass obj = new ConnectionClass();
            q = "SELECT username FROM patients";
            ResultSet resultSet = obj.stm.executeQuery(q);
            while (resultSet.next())
            {
                ch1.add(resultSet.getString("username"));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        l1 = new JLabel("Add Appointment");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Father Name");
        l6 = new JLabel("Phone");
        l7 = new JLabel("Marital Stats");
        l8 = new JLabel("City");
        l9 = new JLabel("Gender");
        l10 = new JLabel("Blood");
        l11= new JLabel("Age");
        l13 = new JLabel("Date of Birth");
        l14 = new JLabel("Specialization Needed");
        l15 = new JLabel("Check Doctor Availability");
        l16 = new JLabel("Select Doctor");
        l17 = new JLabel("Appointment Date");
        l18 = new JLabel("Appointment Time");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11 = new JTextField();
        t12 = new JTextField();

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t8.setEditable(false);
        t9.setEditable(false);
        t10.setEditable(false);

        b1 = new JButton("Book Appointment");
        b2 = new JButton("Back");
        b3 = new JButton("Check");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.RED);
        b3.setBackground(Color.BLACK);

        l1.setHorizontalAlignment(JLabel.CENTER);

        l1.setFont(f);

        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l13.setFont(f1);
        l14.setFont(f1);
        l15.setFont(f1);
        l16.setFont(f1);
        l17.setFont(f1);
        l18.setFont(f1);

        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);

        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);
        t10.setFont(f1);
        t11.setFont(f1);
        t12.setFont(f1);

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(17,2,10,10));

        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(t1);
        p2.add(l4);
        p2.add(t2);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);
        p2.add(l7);
        p2.add(t5);
        p2.add(l8);
        p2.add(t6);
        p2.add(l9);
        p2.add(t7);
        p2.add(l10);
        p2.add(t8);
        p2.add(l11);
        p2.add(t9);
        p2.add(l13);
        p2.add(t10);
        p2.add(l14);
        p2.add(t11);
        p2.add(l15);
        p2.add(b3);
        p2.add(l16);
        p2.add(ch2);
        p2.add(l17);
        p2.add(t12);
        p2.add(l18);
        p2.add(ch3);
        p2.add(b1);
        p2.add(b2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/Appointment.png"));
        Image i1 = img.getImage().getScaledInstance(300,500,Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l12 = new JLabel(img1);

        p3.add(l12);
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);

        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try
                {
                    ConnectionClass obj2 = new ConnectionClass();
                    String username = ch1.getSelectedItem();
                    String q1 = "SELECT * FROM PATIENTS WHERE USERNAME='"+username+"'";
                    ResultSet resultSet1 = obj2.stm.executeQuery(q1);
                    while(resultSet1.next())
                    {
                        t1.setText(resultSet1.getString("name"));
                        t2.setText(resultSet1.getString("email"));
                        t3.setText(resultSet1.getString("father_name"));
                        t4.setText(resultSet1.getString("phone"));
                        t5.setText(resultSet1.getString("marital_status"));
                        t6.setText(resultSet1.getString("city"));
                        t7.setText(resultSet1.getString("gender"));
                        t8.setText(resultSet1.getString("blood"));
                        t9.setText(resultSet1.getString("age"));
                        t10.setText(resultSet1.getString("dob"));
                        t11.setText(resultSet1.getString("spec_needed"));
                    }
                }
                catch (Exception exception1)
                {
                exception1.printStackTrace();
                }

            }
        });


    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b3)
        {
            ch2.removeAll();
            try
            {
                ConnectionClass obj3 = new ConnectionClass();
                String q2 = "SELECT * FROM doctors WHERE specialization='"+t11.getText()+"' and availability='Yes'";
                ResultSet resultSet3 = obj3.stm.executeQuery(q2);
                while(resultSet3.next())
                {
                    ch2.add(resultSet3.getString("username"));
                }
            }
            catch (Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        if(e.getSource()==b1)
        {
            String p_username = ch1.getSelectedItem();
            String name = t1.getText();
            String email = t2.getText();
            String father_name = t3.getText();
            String phone = t4.getText();
            String marital_status = t5.getText();
            String city=t6.getText();
            String gender=t7.getText();
            String blood=t8.getText();
            String age=t9.getText();
            String dob=t10.getText();
            String spec_needed =t11.getText();
            String doc_username= ch2.getSelectedItem();
            String app_Date = t12.getText();
            String app_Time = ch3.getSelectedItem();
            String app_Status = "Open";
            Random random = new Random();
            String app_id =""+Math.abs(random.nextInt() % 100000);

            try
            {
                ConnectionClass obj4 = new ConnectionClass();
                String q4 ="INSERT INTO appointments(app_id,p_username,name,father_name,email,phone,marital_status,city,gender,blood,age,dob,spec_needed,doc_username,app_Date,app_Time,app_Status) VALUES ('"+app_id+"','"+p_username+"','"+name+"','"+father_name+"','"+email+"','"+phone+"','"+marital_status+"','"+city+"','"+gender+"','"+blood+"','"+age+"','"+dob+"','"+spec_needed+"','"+doc_username+"','"+app_Date+"','"+app_Time+"','"+app_Status+"')";
                int a =obj4.stm.executeUpdate(q4);
                if(a==1)
                {
                    JOptionPane.showMessageDialog(null, "Your Appointment Successfully Booked!");
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please, Fill all details carefully!!");
                }
            }
            catch (Exception exception3)
            {
                exception3.printStackTrace();
            }
        }
        if (e.getSource()==b2)
        {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new AddAppointment().setVisible(true);
    }
}
