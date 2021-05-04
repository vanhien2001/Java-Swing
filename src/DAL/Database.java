/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.Customer;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author vanhi
 */
public class Database {
    public Connection conn = null;
    
    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
            System.out.println("Connect sucessfully !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean Excute(String sql){
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        
            return false;
        }
    }
        
//    public ResultSet ExcuteResult(String sql){
//        ResultSet rs = null;
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            return rs = ps.executeQuery();
//        } catch (Exception e) {
//            e.printStackTrace();
//        
//            return rs;
//    }
//    
//    public ArrayList<Customer> SelectAll1(){
//        ArrayList<Customer> list_customer = new ArrayList<>();
//        String sql = "SELECT * FROM customer";
//        try {
//            Statement s = conn.createStatement();
//         PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = s.executeQuery(sql);
//            while(rs.next()){
//                Customer c = new Customer();
//                c.setName(rs.getString("Name"));
//                c.setSdt(rs.getString("Sdt"));
//                c.setCmnd(rs.getString("Cmnd"));
//                c.setAddress(rs.getString("Address"));
//                list_customer.add(c);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return list_customer;
//    }
    
//    public boolean addCustomer(Customer s){
//        
//        String sql = "INSERT INTO `customer`(`Name`, `Cmnd`, `address`, `Sdt`)"
//                + "VALUES(?,?,?,?)";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, s.getName());
//            ps.setString(2, s.getCmnd());
//            ps.setString(3, s.getAddress());
//            ps.setString(4, s.getSdt());
//            
//            return ps.executeUpdate() > 0;
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return false;
//    }
    
//    public static void main(String[] args) {
//        new Database();
//    }
}
