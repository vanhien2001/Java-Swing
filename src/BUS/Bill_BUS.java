/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.Database;
import DTO.Booking;
import DTO.Customer;
import DTO.Bill;
import DTO.Staff;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vanhi
 */
public class Bill_BUS {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    Booking_BUS booking_BUS = new Booking_BUS();
    Staff_BUS staff = new Staff_BUS();
    
    
    public Bill_BUS() {
    }
    public ArrayList<Bill> SelectAll(){
        ArrayList<Bill> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM bill";
        try {
            Statement s = conn.createStatement();
//          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Bill c = new Bill();
                c.setId(rs.getInt("id"));
                c.setBooking(booking_BUS.SelectbyId(rs.getInt("id_booking")));
                c.setPrice(rs.getInt("Price"));
                c.setStaff(staff.SelectbyId(rs.getInt("id_staff")));
                c.setTimestamp(rs.getTimestamp("Date"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    
        public Bill SelectbyId(int id){
        Bill c = new Bill();
        String sql = "SELECT * FROM bill where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
                c.setId(rs.getInt("id"));
                c.setBooking(booking_BUS.SelectbyId(rs.getInt("id_booking")));
                c.setPrice(rs.getInt("Price"));
                c.setStaff(staff.SelectbyId(rs.getInt("id_staff")));
                c.setTimestamp(rs.getTimestamp("Date"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    
    public boolean addBill(Bill s){
        
        String sql = "INSERT INTO `bill`(`id_booking`,`Price`,`id_staff`)"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getBooking().getId());
            ps.setInt(2, s.getPrice());
            ps.setInt(3, s.getStaff().getId());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean editBill(Bill s,Booking booking,int price,Staff staff){
        
        String sql = "UPDATE `bill` SET `id_booking`=?,`Price`=?,`id_staff`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,booking.getId() );
            ps.setInt(2, price);
            ps.setInt(3, staff.getId());
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteBill(Bill s){
        
        String sql = "DELETE FROM bill where id = ?";
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
