/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.Database;
import DTO.Customer;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vanhi
 */
public class Customer_BUS {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    
    
    public Customer_BUS() {
    }
    public ArrayList<Customer> SelectAll(){
        ArrayList<Customer> list_staff = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("Name"));
                c.setSdt(rs.getString("Sdt"));
                c.setCmnd(rs.getString("Cmnd"));
                c.setAddress(rs.getString("Address"));
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    
    public Customer SelectbyId(int id){
        Customer c = new Customer();
        String sql = "SELECT * FROM customer where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("Name"));
            c.setSdt(rs.getString("Sdt"));
            c.setCmnd(rs.getString("Cmnd"));
            c.setAddress(rs.getString("Address"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    
    public int addCustomer(Customer s){
        
        String sql = "INSERT INTO `customer`(`Name`,`Sdt`, `Cmnd`, `Address`)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getSdt());
            ps.setString(3, s.getCmnd());
            ps.setString(4, s.getAddress());
            ps.executeUpdate();
            sql = "SELECT * FROM customer ORDER BY id DESC  LIMIT 1";
            try {
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                rs.next();
                return rs.getInt("id");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    public boolean editCustomer(Customer s,String name,String sdt,String cmnd,String address){
        
        String sql = "UPDATE `customer` SET `Name`=?,`Sdt`=?,`Cmnd`=?,`Address`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sdt);
            ps.setString(3, cmnd);
            ps.setString(4, address);
            ps.setInt(5, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteCustomer(Customer s){
        
        String sql = "DELETE FROM customer where id = ?";
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
