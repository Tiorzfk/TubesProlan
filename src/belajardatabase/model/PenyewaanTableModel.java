/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.model;

import static belajardatabase.model.PenyewaanTableModel.table;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASEP
 */
public class PenyewaanTableModel extends MyAbstractModel {
    public static final String      table        = "sewa";
    public static final int         dataPerPage  = 5;
    
    private int colnum = 6;
    private int rownum;
    private String[] colname = {
        "idSewa",
        "noPolisi",
        "noKTP",
        "tanggalSewa",
        "tanggalKembali",
        "totalBayar"
    };
    private ArrayList<String[]> Result_Sets;

    public PenyewaanTableModel() {
        super("*", table);
    }
    
    public void save(ResultSet rs) {
        Result_Sets = new ArrayList<String[]>();
        
        try {
            
            while (rs.next()) {
                String[] row = {
                    rs.getString("idSewa"),
                    rs.getString("noPolisi"),
                    rs.getString("noKTP"),
                    rs.getString("tanggalSewa"),
                    rs.getString("tanggalKembali"),
                    rs.getString("totalBayar")
                };
                Result_Sets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error inside `PenyewaanTableModel` method: "
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
    
    @Override
    public String getColumnName(int index) {
        return colname[index];
    }
    public int getNumberOfPage() {
        // [1] backup
        String tmp_select   = (String) this.sql.select.get("select");
        int tmp_limit       = (int) this.sql.select.get("limit");
        int tmp_offset      = (int) this.sql.select.get("offset");
        
        // [2] change
        this.sql.select.select("count(idSewa) as num_rows");
        this.sql.select.removeLimit();
        ResultSet rs = this.sql.select.execute();
        
        int num_page = -1;
        try {
            rs.next();
            int num_rows = rs.getInt("num_rows");
            
            num_page = (int) Math.ceil(num_rows / (double) this.dataPerPage);
        } catch (SQLException e) {
                System.out.println("Error inside `getNumberOfPageByLimit` method: "
                    + e.getMessage());
        } finally {
            this.sql.mdbc.close(rs);
            
            // [3] recover
            this.sql.select.select(tmp_select);
            this.sql.select.limit(tmp_limit);
            this.sql.select.offset(tmp_offset);
        }
        
        return num_page;
    }
}
