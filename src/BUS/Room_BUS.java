/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.Database;
import DTO.Room;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vanhi
 */
public class Room_BUS {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    
    
    public Room_BUS() {
    }
    public ArrayList<Room> SelectAll(){
        ArrayList<Room> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM room";
        try {
            Statement s = conn.createStatement();
//          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Room c = new Room();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("Name"));
                c.setBed(rs.getInt("Bed"));
                c.setPrice(rs.getInt("Price"));
                c.setVip(rs.getBoolean("Vip"));
                c.setBooked(rs.getBoolean("Booked"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    public Room SelectbyId(int id){
        Room c = new Room();
        String sql = "SELECT * FROM room where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("Name"));
            c.setBed(rs.getInt("Bed"));
            c.setPrice(rs.getInt("Price"));
            c.setVip(rs.getBoolean("Vip"));
            c.setBooked(rs.getBoolean("Booked"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    
    public boolean addRoom(Room s){
        
        String sql = "INSERT INTO `room`(`Name`,`Bed`, `Price`, `Vip`,`Booked`)"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getBed());
            ps.setInt(3, s.getPrice());
            ps.setBoolean(4, s.isVip());
            ps.setBoolean(5, s.isBooked());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean editRoom(Room s,String name,int bed,int price,boolean vip,boolean booked){
        
        String sql = "UPDATE `room` SET `Name`=?,`Bed`=?,`Price`=?,`Vip`=? , `Booked`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, bed);
            ps.setInt(3, price);
            ps.setBoolean(4, vip);
            ps.setBoolean(5, booked);
            ps.setInt(6, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteRoom(Room s){
        
        String sql = "DELETE FROM room where id = ?";
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
