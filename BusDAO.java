package BusRes;
import java.sql.*;

public class BusDAO {

    Connection con;

    {
        try {
            con = BusJdbc.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayBusInfo() throws SQLException {
        String query="Select * from Bus";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);

        while(rs.next()){
            System.out.println("-----------------------------------------");
            System.out.println("Bus Number: "+rs.getInt(1));
            if(rs.getInt(2)==1){
                System.out.println("Is AC: "+"Yes");
            }else{
                System.out.println("Is AC: "+"No");
            }
            System.out.println("Capacity: "+rs.getInt(3));
            System.out.println("-----------------------------------------");
        }

    }

    public int getCapacity(int busno) throws SQLException {
        String query="Select Capacity from Bus where BusNumber="+busno;
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
