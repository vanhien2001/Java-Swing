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
}
