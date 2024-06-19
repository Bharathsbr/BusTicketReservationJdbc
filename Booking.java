package BusRes;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busno;
    Date date;
    Scanner s=new Scanner(System.in);
    Booking(){
        System.out.println("Enter passenger name:");
        passengerName=s.next();
        System.out.println("Enter bus number:");
        busno=s.nextInt();
        System.out.println("Enter date dd-mm-yyyy:");
        String d=s.next();
        SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
        try {
            date=format.parse(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAvailable() throws SQLException {
        BusDAO bus=new BusDAO();
        int capacity=bus.getCapacity(busno);
        BookingDAO booking=new BookingDAO();
        int booked=booking.getBookedCount(busno,date);
        return booked<capacity;
    }
}
