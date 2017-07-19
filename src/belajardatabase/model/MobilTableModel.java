/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.model;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASEP
 */
public class MobilTableModel extends MyAbstractModel {
    public static final String      table        = "mobil";
    public static final int         dataPerPage  = 5;
    
    private final int  colnum = 8;
    private int rownum;
    private final String[] colname = {
        "No Polisi", // ditampilkan pada tabel
        "Merk", // ditampilkan pada tabel
        "Harga Sewa 12 Jam", // ditampilkan pada tabel
        "Harga Sewa 24 Jam", // ditampilkan pada tabel
        "Warna",
        "Tahun",
        "Denda per Jam",
        "Status"
    };
    private ArrayList<String[]> Result_Sets;
    
    public MobilTableModel() {
        super("*", table); // initiate @var sql properties of this class/instance
    }
    
    public void save(ResultSet rs) {
        Result_Sets = new ArrayList<String[]>();
        
        try {
            while (rs.next()) {
                String[] row = {
                    rs.getString("noPolisi"),
                    rs.getString("merk"),
                    "Tidak Tersedia",
                    rs.getString("hargaSewa24Jam"),
                    rs.getString("warna"),
                    rs.getString("tahun").substring(0, 4),
                    rs.getString("dendaPerJam"),
                    rs.getString("status")
                };
                Result_Sets.add(row);
            }
        } catch (SQLException e) {
            System.out.println("Error inside `save` method: "
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
        this.sql.select.select("count(noPolisi) as num_rows");
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
    
    /* constant property */
    public static final int STATUS_TERSEDIA = 0;
    public static final int STATUS_TIDAK_TERSEDIA = 1;
}