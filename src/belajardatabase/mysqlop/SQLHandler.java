/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mysqlop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASEP
 */
public class SQLHandler {
    public SelectSQL select = null;
    public UpdateSQL update = null;
    public DeleteSQL delete = null;
    public InsertSQL insert = null;
    
    /**
     * Constuctor
     * @param select is the first SELECT sql statement, you can change it later
     * @param table  is database table
     */
    public SQLHandler(String selectSQL, String table) {
        initDBConnection();
        
        select = new SelectSQL(mdbc, stmt, selectSQL, table);
        update = new UpdateSQL(mdbc, stmt, table);
        delete = new DeleteSQL(mdbc, stmt, table);
        insert = new InsertSQL(mdbc, stmt, table);
    }
    
    public void initDBConnection() {
        mdbc = new MyDBConnection();
        mdbc.init();
        Connection conn = mdbc.getMyConnection();
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error inside `initDBConnection` : "
                    + e.getMessage());
        }
    }
    
    /**
     * call this when you not needed the DB connection
     * 
     */
    public void closeDBConnection() {
        mdbc.close(stmt);
        mdbc.destroy();
    }
    
    public MyDBConnection getConnection() {
        return mdbc;
    }

    public MyDBConnection mdbc;
    private Statement stmt;
}











