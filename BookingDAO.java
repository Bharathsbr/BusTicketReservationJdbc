package BusRes;
import java.sql.*;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busno, Date date) throws SQLException {
        String query="Select count(Passenger_name) from Booking where Bus_no=? and travel_date=?";
        Connection con=BusJdbc.getConnection();
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,busno);
        java.sql.Date sqldate= new java.sql.Date(date.getTime());
        ps.setDate(2,sqldate);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addInformation(Booking booking) throws SQLException {
        String query="Insert into booking values (?,?,?);";
        Connection con=BusJdbc.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqld=new java.sql.Date(booking.date.getTime());
        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busno);
        pst.setDate(3,sqld);
        pst.executeUpdate();
    }
}
