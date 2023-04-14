package projet;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {


     public static Connection conn;
    connection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","14030192Xx)");
        }
        catch(Exception e )
        {

        }

    };
}
