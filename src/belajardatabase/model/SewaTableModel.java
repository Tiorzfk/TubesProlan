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
public class SewaTableModel extends AbstractTableModel {
    private int colnum = 6;
    private int rownum;
    private String[] colname = {
        "idSewaKunci",
        "tanggalSewa",
        "tanggalKembali",
        "totalBayar",
        "noKTP",
        "noPolisi"
    };
    private ArrayList<String[]> Result_Sets;

    public SewaTableModel(ResultSet rs) {
        Result_Sets = new ArrayList<String[]>();
        
        try {
            
            while (rs.next()) {
                String[] row = {
                    rs.getString("idSewaKunci"),
                    rs.getString("tanggalSewa"),
                    rs.getString("tanggalKembali"),
                    rs.getString("totalBayar"),
                    rs.getString("noKTP"),
                    rs.getString("noPolisi")
                };
                Result_Sets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error inside `SewaTableModel` method: "
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
