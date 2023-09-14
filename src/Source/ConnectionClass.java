package Source ;
import java.sql.*;
public class ConnectionClass {
    Connection connection;
    Statement stm;

    ConnectionClass(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("Jdbc:mysql://localhost:3306/hospital", "root", "root");
            stm = connection.createStatement();
            if(connection.isClosed())
            {
                System.out.println("Connection Closed");
            }
            else
            {
                System.out.println("Connection Created");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new ConnectionClass();
    }

}
