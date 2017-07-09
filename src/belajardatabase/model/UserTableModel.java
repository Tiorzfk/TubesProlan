/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.model;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASEP
 */
public class UserTableModel extends AbstractTableModel {
    private int colnum = 2;
    private int rownum;
    private String[] colname = {
        "username",
        "password"
    };
    private ArrayList<String[]> Result_Sets;
    
    public UserTableModel(ResultSet rs) {
        Result_Sets = new ArrayList<String[]>();
        
        try {
            
            while (rs.next()) {
                String[] row = {
                    rs.getString("username"),
                    rs.getString("password")
                };
                Result_Sets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error inside `UserTableModel` method: "
                    + e.getMessage());
        }
    }

    @Override
    public int getRowCount() {
        return Result_Sets.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = Result_Sets.get(rowIndex);
        return row[columnIndex];
    }
}
