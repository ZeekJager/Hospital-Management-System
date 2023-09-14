package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorHomePage extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1;
    JMenuBar m1;
    JMenu men1,men2,men3,men4,men5,men8;
    JMenuItem ment2,ment4,ment6,ment8,ment9,ment10,ment14;
    Font f1,f2,f3;
    public String doctorname;
    int login_Id;
    String p_username;
    String admin_Id;

    DoctorHomePage(String doctorname, int login_Id, String p_username)
    {
        super("Doctor Homepage");
        setLocation(0,0);
        setSize(1300,730);
        this.doctorname=doctorname;
        this.login_Id=login_Id;
        this.p_username=p_username;
        this.admin_Id=admin_Id;

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Icons/IndexDoc.jpg"));
        Image img = ic.getImage().getScaledInstance(1300,730,Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        l1 = new JLabel(ic1);
        l1.setBounds(0,0,1300,730);
        l1.setLayout(null);
        add(l1);

        f1 =new Font("Lucida Fax",Font.BOLD,20);
        f2= new Font("Gadugi",Font.BOLD,35);
        f3 = new Font("MS UI Gothic", Font.BOLD,18);

        m1 =new JMenuBar();
        setJMenuBar(m1);
        //l1.add(m1);


        men1 = new JMenu("Doctor");
        m1.add(men1);


        ment2 = new JMenuItem("View Doctor");

        men1.add(ment2);

        men2 = new JMenu("Patient");
        m1.add(men2);

        ment4 = new JMenuItem("View Patient");
        men2.add(ment4);

        men3 = new JMenu("Receptionist");
        m1.add(men3);

        ment6 = new JMenuItem("View Receptionist");
        men3.add(ment6);

        men4 = new JMenu("Appointment");
        m1.add(men4);

        ment8 = new JMenuItem("View Appointment");
        men4.add(ment8);

        men5 = new JMenu("Hello, Doctor("+doctorname+")");
        m1.add(men5);

        ment9 = new JMenuItem("My Profile");
        ment10 = new JMenuItem("Change Password");
        men5.add(ment9);
        men5.add(ment10);


        men8 = new JMenu("Exit");
        m1.add(men8);
        ment14 = new JMenuItem("Exit");
        men8.add(ment14);

        men1.setFont(f1);
        men2.setFont(f1);
        men3.setFont(f1);
        men4.setFont(f1);
        men5.setFont(f1);
        men8.setFont(f1);

        ment2.setFont(f3);
        ment4.setFont(f3);
        ment6.setFont(f3);
        ment8.setFont(f3);
        ment9.setFont(f3);
        ment10.setFont(f3);
        ment14.setFont(f3);

        m1.setBackground(Color.BLACK);

        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men8.setForeground(Color.RED);

        ment2.setForeground(Color.GREEN);
        ment4.setForeground(Color.GREEN);
        ment6.setForeground(Color.GREEN);
        ment8.setForeground(Color.GREEN);
        ment9.setForeground(Color.GREEN);
        ment14.setForeground(Color.RED);

        ment2.setBackground(Color.BLACK);
        ment4.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment8.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment14.setBackground(Color.BLACK);


        ment2.addActionListener(this);
        ment4.addActionListener(this);
        ment6.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment14.addActionListener(this);



    }
    public void actionPerformed(ActionEvent e)
    {

        String command = e.getActionCommand();
        if (command.equals("View Doctor"))
        {
            new ViewDoctor(login_Id).setVisible(true);
        }
        else if (command.equals("View Patient"))
        {
            new ViewPatient(p_username,login_Id).setVisible(true);
        }
        else if (command.equals("View Receptionist"))
        {
            new ViewReceptionist(login_Id).setVisible(true);
        }
        else if (command.equals("View Appointment"))
        {
            new ViewAppointment(p_username,login_Id).setVisible(true);
        }
        else if (command.equals("My Profile"))
        {
            new CheckMyProfile(admin_Id,login_Id).setVisible(true);
        }
        else if (command.equals("Change Password"))
        {
            new ChangePassword(doctorname).setVisible(true);
        }
        else if (command.equals("Exit"))
        {
            this.setVisible(false);
            new Index();
        }

    }
    public static void main(String[] args)
    {

       //new DoctorHomePage("Zekarias").setVisible(true);
    }
}
