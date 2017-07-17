/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.penyewaan;

import belajardatabase.model.MobilTableModel;
import belajardatabase.model.PenyewaanTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASEP
 */
public class Delete {
    public static void delete(int idSewa, javax.swing.JFrame frame) {
        PenyewaanTableModel model = new PenyewaanTableModel();
        
        model.sql.select.where("idSewa", "=", idSewa);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);
        model.sql.getConnection().close(rs);
        
        model.sql.delete.where("idSewa", idSewa);
        boolean success = model.sql.delete.execute();
        
        if (success) {
            String noPolisi = model.getValueAt(0, 1).toString();
            makeMobilTersedia(noPolisi); 
            
            JOptionPane.showMessageDialog(
                    frame,
                    "Berhasil menghapus data penyewaan"
            );
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Gagal menghapus data penyewaan",
                    "Penghapusan",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }
    
    public static void makeMobilTersedia(String noPolisi) {
        MobilTableModel model = new MobilTableModel();
        
        model.sql.update.where("noPolisi", noPolisi);
        model.sql.update.set("status", MobilTableModel.STATUS_TERSEDIA);
        model.sql.update.execute();
    }
}
