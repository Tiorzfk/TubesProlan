/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mysqlop;

import java.sql.SQLException;
import java.sql.Statement;

class DeleteSQL {
    private String table = "";
    private String _where = "";
    
    public DeleteSQL(MyDBConnection mdbc, Statement stmt, String table) {
        this.table = table;
        
        this.mdbc = mdbc;
        this.stmt = stmt;
    }
    
    /**
     * Add WHERE clause to DELETE statement
     */
    public void where(String column, Object value) { 
        if (value instanceof Integer) {
            this._where = " WHERE " + column + " = " + value;
        }
        if (value instanceof String ) {
            this._where = " WHERE " + column + " = \"" + value + "\"";
        }
    }
    
    public void execute() {
         try {
            String query = "DELETE FROM " + table + _where;
            stmt.executeUpdate(query);
        } catch (SQLException e) { 
            System.out.println("Error inside `execute` : "
                + e.getMessage());
        }
    }
    
    private MyDBConnection mdbc;
    private Statement stmt;
}
