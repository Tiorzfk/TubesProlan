/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mysqlop;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASEP
 */
public class InsertSQL {
    private String table = "";
    private String columns = "";
    private String values = "";
    
    public InsertSQL(MyDBConnection mdbc, Statement stmt, String table) {
        this.table = table;
        
        this.mdbc = mdbc;
        this.stmt = stmt;
    }
    
    public void reset() {
        columns = "";
        values = "";
    }
    
    /**
     * Add value
     * 
     * @param column
     * @param value 
     */
    public void value(String column, String value) {
        columns += column + ", ";
        values  += "'" + value + "', ";
    }
    
    /**
     * Add value
     * 
     * @param column
     * @param value 
     */
    public void value(String column, int value) {
        columns += column + ", ";
        values  += value + ", ";
    }
    
    /**
     * VALUES SQL statement
     * 123
     * @return 
     */
    private String getValues() {
        // substring is for exclude the last comma separator
        return "(" + values.substring(0, values.length()-2) + ")";
    }
    
    /**
     * output: (columnn1, column2, ...)
     * @return 
     */
    private String getColumns() {
        return "(" + columns.substring(0, columns.length()-2) + ")";
    }
    
    /**
     * Execute UPDATE statement
     */
    public boolean execute() {
        try {
            String query = "INSERT INTO " + table + " " + getColumns()
                    + " VALUES " + getValues();
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) { 
            System.out.println("Error inside `execute` : "
                + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    private MyDBConnection mdbc;
    private Statement stmt;
}
