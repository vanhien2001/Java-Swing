/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

//import java.util.Date;
import BUS.Customer_BUS;
import BUS.Room_BUS;
import BUS.Staff_BUS;
import DTO.Booking;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vanhi
 */
public class NewClass {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    Customer_BUS customer = new Customer_BUS();
    Staff_BUS staff = new Staff_BUS();
    Room_BUS room = new Room_BUS();
    
    
    public NewClass() {
        ArrayList<Booking> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM booking";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Booking c = new Booking();
                c.setId(rs.getInt("id"));
                c.setCustomer(customer.SelectbyId(rs.getInt("id_customer")));
                c.setRoom(room.SelectbyId(rs.getInt("id_room")));
                c.setTimestamp(rs.getTimestamp("Date"));
                c.setStaff(staff.SelectbyId(rs.getInt("id_staff")));
                c.setPayed(rs.getBoolean("Payed"));
                System.out.println("--------------------");
                System.out.println(c.getTimestamp());
                System.out.println(c.getTimestamp().getYear());
                System.out.println(c.getTimestamp().getMonth());
                System.out.println(c.getTimestamp().getDay());
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {  
        new NewClass();
        Timestamp d = new Timestamp(System.currentTimeMillis());
        System.out.println(d.toString());
    }
}
