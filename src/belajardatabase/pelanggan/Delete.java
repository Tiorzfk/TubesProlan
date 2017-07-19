/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.pelanggan;

import belajardatabase.mobil.*;
import belajardatabase.model.MobilTableModel;
import belajardatabase.model.PelangganTableModel;
import belajardatabase.model.PenyewaanTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASEP
 */
public class Delete {
    
    public static void delete(String noKTP, javax.swing.JFrame frame) {
        PelangganTableModel model = new PelangganTableModel();
        
        if (penyewaanRelatedToPelanggan(noKTP) > 0) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Tidak bisa menghapus pelanggan yang pernah/sedang melakukan sewa"
                    + "\nKecuali semua riwayat sewa berkaitan denganpelanggan inidihapus"
            );
        } else {
            model.sql.delete.where("noKTP", noKTP);
            boolean success = model.sql.delete.execute();
            String pesan = "Penghapusan gagal";

            if (success) pesan = "Penghapusan berhasil";

            JOptionPane.showMessageDialog(frame, pesan);
        }
    }
    
    public static int penyewaanRelatedToPelanggan(String noKTP) {
        PenyewaanTableModel model = new PenyewaanTableModel();
        
        model.sql.select.where("noKTP", "=", noKTP);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);
        model.sql.getConnection().close(rs);
        
        return model.getRowCount();
    }
}
