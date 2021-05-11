/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.Database;
import DTO.Booking;
import DTO.Customer;
import DTO.Room;
import DTO.Staff;
import GUI.Main;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vanhi
 */
public class Booking_BUS {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    Customer_BUS customer = new Customer_BUS();
    Staff_BUS staff = new Staff_BUS();
    Room_BUS room = new Room_BUS();
    
    
    public Booking_BUS() {
    }
    public ArrayList<Booking> SelectAll(){
        ArrayList<Booking> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM booking";
        try {
            Statement s = conn.createStatement();
//          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Booking c = new Booking();
                c.setId(rs.getInt("id"));
                c.setCustomer(customer.SelectbyId(rs.getInt("id_customer")));
                c.setRoom(room.SelectbyId(rs.getInt("id_room")));
                c.setTimestamp(rs.getTimestamp("Date"));
                c.setStaff(staff.SelectbyId(rs.getInt("id_staff")));
                c.setPayed(rs.getBoolean("Payed"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    
        public Booking SelectbyId(int id){
        Booking c = new Booking();
        String sql = "SELECT * FROM booking where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setId(rs.getInt("id"));
                c.setCustomer(customer.SelectbyId(rs.getInt("id_customer")));
                c.setRoom(room.SelectbyId(rs.getInt("id_room")));
                c.setTimestamp(rs.getTimestamp("Date"));
                c.setStaff(staff.SelectbyId(rs.getInt("id_staff")));
                c.setPayed(rs.getBoolean("Payed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    public ArrayList<Booking> SelectbyKeyword(String keyword){
        ArrayList<Booking> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM `booking` b INNER JOIN customer c on b.id_customer=c.id INNER JOIN room r on b.id_room=r.id INNER JOIN staff s ON b.id_staff=s.id WHERE c.Name LIKE ? OR c.Sdt LIKE ? OR c.Cmnd LIKE ? OR c.Address LIKE ? OR r.Name LIKE ? OR s.Name LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");
            ps.setString(6, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Booking c = new Booking();
                c.setId(rs.getInt("id"));
                c.setCustomer(new Customer_BUS().SelectbyId(rs.getInt("id_customer")));
                c.setRoom(new Room_BUS().SelectbyId(rs.getInt("id_room")));
                c.setTimestamp(rs.getTimestamp("Date"));
                c.setStaff(new Staff_BUS().SelectbyId(rs.getInt("id_staff")));
                c.setPayed(rs.getBoolean("Payed"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    
    public boolean addBooking(Booking s){
        int id = new Customer_BUS().addCustomer(s.getCustomer());
        String sql = "INSERT INTO `booking`(`id_customer`, `id_room`,`id_staff`,`Payed`)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, s.getRoom().getId());
            ps.setInt(3, s.getStaff().getId());
            ps.setBoolean(4, s.getPayed());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean editBooking(Booking s,Customer customer , Boolean payed){
        new Customer_BUS().editCustomer(s.getCustomer(), customer.getName(), customer.getSdt(), customer.getCmnd(), customer.getAddress());
        String sql = "UPDATE `booking` SET `Payed`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1,payed);
            ps.setInt(2, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteBooking(Booking s){
        new Use_service_BUS().deleteByid_customer(s.getCustomer().getId());
        String sql = "DELETE FROM booking where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

}
