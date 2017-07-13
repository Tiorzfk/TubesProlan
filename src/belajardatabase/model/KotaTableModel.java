/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.model;

import static belajardatabase.model.PelangganTableModel.table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASEP
 */
public class KotaTableModel extends MyAbstractModel {
    public static final String      table        = "kota";
    
    private int colnum = 2;
    private int rownum;
    private String[] colname = {
        "idKota",
        "namaKota",
    };
    private ArrayList<String[]> Result_Sets;
    
    public KotaTableModel() {
        super("*", table);
    }
    
    public void save(ResultSet rs) {
        Result_Sets = new ArrayList<String[]>();
        
        try {
            
            while (rs.next()) {
                String[] row = {
                    rs.getString("idKota"),
                    rs.getString("namaKota")
                };
                Result_Sets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error inside `kotaTableModel` method: "
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
    
    public String getNamaKotaById(int idKota) {
        ResultSet rs = null;
        String namaKota = "";
        
        try {
            sql.select.where("idKota", "=", idKota);
        
            rs = sql.select.execute();
            namaKota = rs.getString("namaKota");
        } catch (SQLException e) {
            System.out.println("Error inside `getNamaKotaById` method: "
                    + e.getMessage());
        } finally {
            sql.getConnection().close(rs);
        }
        
        
        return namaKota;
    }
    
    public int getIdKotaByNamaKota(String namaKota) {
        ResultSet rs = null;
        int idKota = -1;
        
        try {
            sql.select.where("namaKota", "=", namaKota);
        
            rs = sql.select.execute();
            idKota = rs.getInt("idKota");
        } catch (SQLException e) {
            System.out.println("Error inside `getIdKotaByNamaKota` method: "
                    + e.getMessage());
        } finally {
            sql.getConnection().close(rs);
        }
        
        
        return idKota;
    }
}
