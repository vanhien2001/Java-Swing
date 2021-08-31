/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.Database;
import DTO.Service;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vanhi
 */
public class Service_BUS {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    
    
    public Service_BUS() {
    }
    public ArrayList<Service> SelectAll(){
        ArrayList<Service> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM service";
        try {
            Statement s = conn.createStatement();
//          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Service c = new Service();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("Name"));
                c.setDescription(rs.getString("Description"));
                c.setPrice(rs.getInt("Price"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    
    public Service SelectbyId(int id){
        Service c = new Service();
        String sql = "SELECT * FROM customer where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setId(rs.getInt("id"));
                c.setName(rs.getString("Name"));
                c.setDescription(rs.getString("Description"));
                c.setPrice(rs.getInt("Price"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    public boolean addService(Service s){
        
        String sql = "INSERT INTO `service`(`Name`,`Description`, `Price`)"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getDescription());
            ps.setInt(3, s.getPrice());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean editService(Service s,String name,String description,int price){
        
        String sql = "UPDATE `service` SET `Name`=?,`Description`=?,`Price`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, price);
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteService(Service s){
        
        String sql = "DELETE FROM service where id = ?";
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
