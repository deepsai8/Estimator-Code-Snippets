/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 31950280
 */
import java.sql.*;
import javax.swing.*;
public class JConnection {
    Connection conn = null; 
    public static Connection ConnecrDb(){
       try{
           Class.forName("org.sqlite.JDBC");
           //Full path may be entered in place of "Estimation.sqlite" below
           Connection conn = DriverManager.getConnection("jdbc:sqlite:Estimation.sqlite");
           //JOptionPane.showMessageDialog(null,"Connection Established");
           return conn;
        }  
       catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
           return null;
        }
       
    }
}
