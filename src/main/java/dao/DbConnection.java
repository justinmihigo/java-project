package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    
    public static Connection connect()
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/growthpulse", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        
        return con;
    }
    
}
