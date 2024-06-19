package BusRes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("Welcome to ABC Travels");
        System.out.println("------------------------------------------");
        System.out.println("Buses available for Coimbatore to Chennai");
        System.out.println("Bus Information");

        BusDAO bus=new BusDAO();
        try {
            bus.displayBusInfo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int userin=1;
        while(userin==1){
            System.out.println("Enter 1 to Book , Enter 2 to Exit");
            userin= sc.nextInt();
            if(userin==1){
                Booking booking=new Booking();
                if(booking.isAvailable()){
                    BookingDAO book=new BookingDAO();
                    book.addInformation(booking);
                    System.out.println("-----------------------------------------");
                    System.out.println("Booking is confirmed");
                    System.out.println("-----------------------------------------");
                    System.out.println("-----------------------------------------");
                }else{
                    System.out.println("-----------------------------------------");
                    System.out.println("Sorry the bus is not available. Please book another bus");
                    System.out.println("-----------------------------------------");
                }
            }else{
                break;
            }
        }

    }
}