/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.Database;
import DTO.Booking;
import DTO.Customer;
import DTO.Use_service;
import DTO.Service;
import GUI.Main;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author vanhi
 */
public class Use_service_BUS {
    Connection conn = new Database().conn;
    DefaultTableModel model;
    Customer_BUS customer = new Customer_BUS();
    Service_BUS service = new Service_BUS();
    Booking_BUS booking_BUS = new Booking_BUS();
    
    
    public Use_service_BUS() {
    }
    
    public ArrayList<Use_service> SelectAll(){
        ArrayList<Use_service> list_staff = new ArrayList<>();
        String sql = "SELECT *,b.id id_booking FROM `use_service` us INNER JOIN booking b ON us.id_customer=b.id_customer GROUP BY us.id_customer; ";
        try {
            Statement s = conn.createStatement();
//          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Use_service c = new Use_service();
                c.setId(rs.getInt("id"));
                c.setCustomer(customer.SelectbyId(rs.getInt("id_customer")));
                c.setBooking(booking_BUS.SelectbyId(rs.getInt("id_booking")));
                int id = rs.getInt("id_customer");
                ArrayList<Timestamp> days = new ArrayList<>();
                ArrayList<Service> list_service = new ArrayList<>();
                String sql1 = "SELECT * FROM `use_service` us INNER JOIN service s on us.id_service = s.id WHERE us.id_customer=?;";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql1);
                    ps.setInt(1, id);
                    ResultSet rs1 = ps.executeQuery();
                    while(rs1.next()){
                        days.add(rs1.getTimestamp("Date"));
                        Service f = new Service();
                        f.setId(rs1.getInt("id_service"));
                        f.setName(rs1.getString("Name"));
                        f.setDescription(rs1.getString("Description"));
                        f.setPrice(rs1.getInt("Price"));
                        list_service.add(f);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c.setDate(days);
                c.setList_service(list_service);
                list_staff.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_staff;
    }
    
    public Use_service SelectbyIdCustomer(int id){
        Use_service c = new Use_service();
        String sql = "SELECT *,b.id id_booking FROM `use_service` us INNER JOIN booking b ON us.id_customer=b.id_customer where us.id_customer = ? GROUP BY us.id_customer; ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                c.setId(rs.getInt("id"));
                c.setCustomer(customer.SelectbyId(rs.getInt("id_customer")));
                c.setBooking(booking_BUS.SelectbyId(rs.getInt("id_booking")));
                ArrayList<Timestamp> days = new ArrayList<>();
                ArrayList<Service> list_service = new ArrayList<>();
                String sql1 = "SELECT * FROM `use_service` us INNER JOIN service s on us.id_service = s.id WHERE us.id_customer=?;";
                try {
                    PreparedStatement ps1 = conn.prepareStatement(sql1);
                    ps1.setInt(1, id);
                    ResultSet rs1 = ps1.executeQuery();
                    while(rs1.next()){
                        days.add(rs1.getTimestamp("Date"));
                        Service f = new Service();
                        f.setId(rs1.getInt("id_service"));
                        System.out.println(id);
                        f.setName(rs1.getString("Name"));
                        System.out.println("2");
                        f.setDescription(rs1.getString("Description"));
                        f.setPrice(rs1.getInt("Price"));
                        list_service.add(f);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c.setDate(days);
                c.setList_service(list_service);
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    
    
    public Use_service SelectbyId(int id){
        Use_service c = new Use_service();
        String sql = "SELECT * FROM use_service where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setId(rs.getInt("id"));
                c.setCustomer(customer.SelectbyId(rs.getInt("id_customer")));
                ArrayList<Service> list_service = new ArrayList<>();
                ArrayList<Timestamp> days = new ArrayList<>();
                String sql1 = "SELECT * FROM `use_service` us INNER JOIN service s on us.id_service = s.id WHERE us.id_customer=?;";
                try {
                    PreparedStatement ps1 = conn.prepareStatement(sql1);
                    ResultSet rs1 = ps1.executeQuery();
                    while(rs1.next()){
                        days.add(rs1.getTimestamp("Date"));
                        Service f = new Service();
                        f.setId(rs1.getInt("id_service"));
                        f.setName(rs1.getString("Name"));
                        f.setDescription(rs1.getString("Description"));
                        f.setPrice(rs1.getInt("Price"));
                        list_service.add(f);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c.setDate(days);
                c.setList_service(list_service);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
    
    
    
    public boolean addUse_service(Use_service s){
        for (int i = 0; i < s.getList_service().size(); i++) {
            String sql = "INSERT INTO `use_service`(`id_customer`,`id_service`)"
                + "VALUES(?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, s.getCustomer().getId());
                ps.setInt(2, s.getList_service().get(i).getId());
            
                return ps.executeUpdate() > 0;
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return false;
    }
    
    public boolean editUse_service(Use_service s,Customer customer,Service service,int days){
        
        String sql = "UPDATE `use_service` SET `id_customer`=?,`id_service`=? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,customer.getId() );
            ps.setInt(1,service.getId() );
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteUse_serviceALL(Use_service s){
        
        String sql = "DELETE FROM use_service where id_customer = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getCustomer().getId());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean deleteByid_customer(int id){
        
        String sql = "DELETE FROM use_service where id_customer = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteUse_service(Use_service s,int id, Timestamp time){
        
        String sql = "DELETE FROM use_service where id_customer = ? and id_service= ? and Date = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getCustomer().getId());
            ps.setInt(2, id);
            ps.setTimestamp(3, time);
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

}
