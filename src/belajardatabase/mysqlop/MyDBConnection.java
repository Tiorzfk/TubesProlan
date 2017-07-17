/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mysqlop;

import java.sql.*;

/**
 *
 * @author ASEP
 */
public class MyDBConnection {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/penyewaan_mobil?zeroDateTimeBehavior=convertToNull";
    private String username = "root";
    private String password = "";
    private Connection conn = null;
    
    public void myDBConnection() {
        // empty
    }
    
    public void init() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public Connection getMyConnection() {
        return conn;
    }
    
    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("Error inside `close` method : "
                        + e.getMessage());
            }
        }
    }
    
    public void close(java.sql.Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Error inside `close` method : "
                        + e.getMessage());
            }
        }
    }
    
    public void destroy() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error inside `destroy` method : "
                        + e.getMessage());
            }
        }
    }
} 
