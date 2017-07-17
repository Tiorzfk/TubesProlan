/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mobil;

import belajardatabase.model.MobilTableModel;
import belajardatabase.model.PenyewaanTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASEP
 */
public class Delete {
    
    public static void delete(String noPolisi, javax.swing.JFrame frame) {
        MobilTableModel model = new MobilTableModel();
        
        if (penyewaanRelatedToNoPolisi(noPolisi) > 0) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Tidak bisa menghapus mobil yang pernah/sedang disewakan"
                    + "\nKecuali semua riwayat sewa berkaitan dengan No. Polisi ini dihapus"
            );
        } else {
            model.sql.delete.where("noPolisi", noPolisi);
            boolean success = model.sql.delete.execute();
            String pesan = "Penghapusan gagal";

            if (success) pesan = "Penghapusan berhasil";

            JOptionPane.showMessageDialog(frame, pesan);
        }
    }
    
    public static int penyewaanRelatedToNoPolisi(String noPolisi) {
        PenyewaanTableModel model = new PenyewaanTableModel();
        
        model.sql.select.where("noPolisi", "=", noPolisi);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);
        model.sql.getConnection().close(rs);
        
        return model.getRowCount();
    }
}
