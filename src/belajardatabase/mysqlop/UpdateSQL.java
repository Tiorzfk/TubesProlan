/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mysqlop;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Handler for UPDATE sql statement
 * @author ASEP
 */
public class UpdateSQL {
    private String table = "";
    private String _set = null;
    private String _where = "";
    
    public UpdateSQL(MyDBConnection mdbc, Statement stmt, String table) {
        this.table = table;
        
        this.mdbc = mdbc;
        this.stmt = stmt;
    }
    
    /**
     * Reset the SQL UPDATE query, so you can create new one.
     */
    public void reset() {
        _set = null;
        _where = "";
    }
    
    /**
     * Add SET statement
     * Example:
     *      setUpdate("dendaPerJam", 150000);
     *      setUpdate("merk", "Avanza");
     * will generating query as:
     *      .. SET dendaPerJam = 150000, status = "Avanza"
     */
    public void set(String column, Object value) {
        if (_set == null)
        {
            if (value instanceof Integer) {
                this._set = " SET " + column + " = " + value;
            }
            if (value instanceof String ) {
                this._set = " SET " + column + " = \"" + value + "\"";
            }
        }
        else
        {
            setAgain(column, value);
        }
    }
    
    private void setAgain(String column, Object value) {
        if (value instanceof Integer) {
            this._set += ", " + column + " = " + value;
        }
        if (value instanceof String ) {
            this._set += ", " + column + " = \"" + value + "\"";
        }
    }
    
    /**
     * Add WHERE clause to UPDATE statement
     */
    public void where(String column, Object value) { 
        if (value instanceof Integer) {
            this._where = " WHERE " + column + " = " + value;
        }
        if (value instanceof String ) {
            this._where = " WHERE " + column + " = \"" + value + "\"";
        }
    }
    
    /**
     * Execute UPDATE statement
     */
    public void execute() {
        try {
            String query = "UPDATE " + table + _set + _where;
            stmt.executeUpdate(query);
        } catch (SQLException e) { 
            System.out.println("Error inside `execute` : "
                + e.getMessage());
        }
    }
    
    private MyDBConnection mdbc;
    private Statement stmt;
}
