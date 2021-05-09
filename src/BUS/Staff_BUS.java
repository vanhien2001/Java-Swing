/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.Database;
import DTO.Staff;
import GUI.Main;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vanhi
 */
public class Staff_BUS {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    
    
    public Staff_BUS() {
    }
    public ArrayList<Staff> SelectAll(){
        ArrayList<Staff> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM staff";
        try {
            Statement s = conn.createStatement();
//          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Staff c = new Staff();
                c.setId(rs.getInt("id"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setName(rs.getString("Name"));
                c.setSdt(rs.getString("Sdt"));
                c.setCmnd(rs.getString("Cmnd"));
                c.setAddress(rs.getString("Address"));
                c.setPosition(rs.getString("Position"));
                c.setManager(rs.getBoolean("Manager"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    public Staff SelectbyId(int id){
        Staff c = new Staff();
        String sql = "SELECT * FROM staff where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setId(rs.getInt("id"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setName(rs.getString("Name"));
                c.setSdt(rs.getString("Sdt"));
                c.setCmnd(rs.getString("Cmnd"));
                c.setAddress(rs.getString("Address"));
                c.setPosition(rs.getString("Position"));
                c.setManager(rs.getBoolean("Manager"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    public Staff SelectbyUsername(String username,String password){
        Staff c = null;
        String sql = "SELECT * FROM staff where Username =  ? and Password =  ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Staff();
                c.setId(rs.getInt("id"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setName(rs.getString("Name"));
                c.setSdt(rs.getString("Sdt"));
                c.setCmnd(rs.getString("Cmnd"));
                c.setAddress(rs.getString("Address"));
                c.setPosition(rs.getString("Position"));
                c.setManager(rs.getBoolean("Manager"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    public ArrayList<Staff> SelectbyKeyword(String keyword){
        ArrayList<Staff> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM staff where Name LIKE ? OR Sdt LIKE ? OR Cmnd LIKE ? OR Address LIKE ? OR Position LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Staff c = new Staff();
                c.setId(rs.getInt("id"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setName(rs.getString("Name"));
                c.setSdt(rs.getString("Sdt"));
                c.setCmnd(rs.getString("Cmnd"));
                c.setAddress(rs.getString("Address"));
                c.setPosition(rs.getString("Position"));
                c.setManager(rs.getBoolean("Manager"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }

    public boolean addStaff(Staff s){
        
        String sql = "INSERT INTO `staff`(`Username`,`Password`,`Name`,`Sdt`, `Cmnd`, `Address`, `Position`,`Manager`)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getUsername());
            ps.setString(2, s.getPassword());
            ps.setString(3, s.getName());
            ps.setString(4, s.getSdt());
            ps.setString(5, s.getCmnd());
            ps.setString(6, s.getAddress());
            ps.setString(7, s.getPosition());
            ps.setBoolean(8, s.isManager());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean editStaff(Staff s,String name,String sdt,String cmnd,String address,String position,boolean manager){
        
        String sql = "UPDATE `staff` SET `Name`=?,`Sdt`=?,`Cmnd`=?,`Address`=?,`Position`=?,`Manager`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sdt);
            ps.setString(3, cmnd);
            ps.setString(4, address);
            ps.setString(5, position);
            ps.setBoolean(6, manager);
            ps.setInt(7, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean ChangePass(Staff s,String pass){
        
        String sql = "UPDATE `staff` SET `Password`=?WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setInt(2, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteStaff(Staff s){
        
        String sql = "DELETE FROM staff where id = ?";
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
