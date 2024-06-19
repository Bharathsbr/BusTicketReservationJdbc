
package BusRes;
import java.sql.*;
public class BusJdbc {
    private static final String url="jdbc:mysql://localhost:3306/BusReservation";
    private static final String username="root";
    private static final String password="bharath@S21";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
