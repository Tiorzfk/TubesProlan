/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.penyewaan;

import belajardatabase.model.KotaTableModel;
import belajardatabase.model.MobilTableModel;
import belajardatabase.model.PelangganTableModel;
import belajardatabase.model.PenyewaanTableModel;
import static belajardatabase.utilities.DateUtility.*;
import java.sql.ResultSet;
import java.text.ParseException;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASEP
 */
public class Pengembalian extends javax.swing.JPanel {
    MobilTableModel mobilModel = null;
    PelangganTableModel pelangganModel = null;
    PenyewaanTableModel penyewaanModel = null;
    
    javax.swing.JFrame frame = null;
    private int idSewa = -1;
    
    /**
     * Creates new form pengembalian
     */
    public Pengembalian(javax.swing.JFrame frame, int idSewa) {
        this.frame = frame;
        this.idSewa = idSewa;
        
        initComponents();
        initModel();
        try {
            init();
            initDataDetailMobil();
            initDataDetailPelanggan();
            initDataDetailPenyewaan();
        } catch (Exception e) {
            System.out.println("Error inside `pengembalian` : "
                    + e.getMessage());
        }
    }
    
    public void initModel() {
        mobilModel = new MobilTableModel();
        pelangganModel = new PelangganTableModel();
        penyewaanModel = new PenyewaanTableModel();
    }
    
    public void init() throws Exception {
        ResultSet rs = null;
        
        // init penyewaan
        penyewaanModel.sql.select.where("idSewa", "=", idSewa);
        rs = penyewaanModel.sql.select.execute();
        penyewaanModel.save(rs);
        penyewaanModel.sql.getConnection().close(rs);

        if (penyewaanModel.getRowCount() != 1) {
            throw new Exception("ERROR: sewa dengan id "
                    + idSewa + " tidak ditemukan");
        }
        
        // init mobil
        String noPolisi = penyewaanModel.getValueAt(0, 1).toString();
        mobilModel.sql.select.where("noPolisi", "=", noPolisi);
        rs = mobilModel.sql.select.execute();
        mobilModel.save(rs);
        mobilModel.sql.getConnection().close(rs);
        
        // init pelanggan
        String noKTP = penyewaanModel.getValueAt(0, 2).toString();
        pelangganModel.sql.select.where("noKTP", "=", noKTP);
        rs = pelangganModel.sql.select.execute();
        pelangganModel.save(rs);
        pelangganModel.sql.getConnection().close(rs);
    }
    
    public void initDataDetailMobil() {
        String noPolisi = mobilModel.getValueAt(0, 0).toString();
        String merk = mobilModel.getValueAt(0, 1).toString();
        String warna = mobilModel.getValueAt(0, 4).toString();
        String tahun = mobilModel.getValueAt(0, 5).toString();
        String hargaSewa12Jam = mobilModel.getValueAt(0, 2).toString();
        String hargaSewa24Jam = mobilModel.getValueAt(0, 3).toString();
        String dendaPerJam = mobilModel.getValueAt(0, 6).toString();
        String status = mobilModel.getValueAt(0, 7).toString();
        
        noPolisiField.setText(noPolisi);
        merkField.setText(merk);
        warnaField.setText(warna);
        tahunField.setText(tahun);
        hargaSewa12JamField.setText(hargaSewa12Jam);
        hargaSewa24JamField.setText(hargaSewa24Jam);
        dendaPerJamField.setText(dendaPerJam);
    }
    
    public void initDataDetailPelanggan() {
        String noKTP = pelangganModel.getValueAt(0, 0).toString();
        String nama = pelangganModel.getValueAt(0, 1).toString();
        String tanggalLahir = pelangganModel.getValueAt(0, 2).toString();
        String pekerjaan = pelangganModel.getValueAt(0, 3).toString();
        String alamat = pelangganModel.getValueAt(0, 4).toString();
        String jenisKelamin = pelangganModel.getValueAt(0, 5).toString();
        String idKota = pelangganModel.getValueAt(0, 6).toString();
        String telepon = pelangganModel.getValueAt(0, 7).toString();
        String handphone = pelangganModel.getValueAt(0, 8).toString();
        String email = pelangganModel.getValueAt(0, 9).toString();
        
        int jenkel = Integer.valueOf(jenisKelamin);
        KotaTableModel kotaModel = new KotaTableModel();
        String namaKota = kotaModel.getNamaKotaById(
                Integer.valueOf(idKota)
        );

        noKTPField.setText(noKTP);
        namaField.setText(nama);
        if (jenkel == PelangganTableModel.PRIA) {
            jenisKelaminField.setText("Laki-laki");
        } else {
            jenisKelaminField.setText("Perempuan");
        }
        tanggalLahirField.setText(tanggalLahir);
        pekerjaanField.setText(pekerjaan);
        alamatField.setText(alamat);
        kotaField.setText(namaKota);
        teleponField.setText(telepon);
        noHPField.setText(handphone);
        emailField.setText(email);
    }
    
    public void initDataDetailPenyewaan() {
        String tanggalSewa = penyewaanModel.getValueAt(0, 3).toString();
        String batasKembali = penyewaanModel.getValueAt(0, 4).toString();
        
        String tanggalSewaHari = getDayFromDateString(tanggalSewa, "dd-MM-yyyy");
        String tanggalSewaBulan = getMonthFromDateString(tanggalSewa, "dd-MM-yyyy");
        String tanggalSewaTahun = getYearFromDateString(tanggalSewa, "dd-MM-yyyy");
        tglSewaHariField.setText(tanggalSewaHari);
        tglSewaBulanField.setText(tanggalSewaBulan);
        tglSewaTahunField.setText(tanggalSewaTahun);
        
        String batasKembaliHari = getDayFromDateString(batasKembali, "dd-MM-yyyy");
        String batasKembaliBulan = getMonthFromDateString(batasKembali, "dd-MM-yyyy");
        String batasKembaliTahun = getYearFromDateString(batasKembali, "dd-MM-yyyy");
        tglBatasKembaliHariField.setText(batasKembaliHari);
        tglBatasKembaliBulanField.setText(batasKembaliBulan);
        tglBatasKembaliTahunField.setText(batasKembaliTahun);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tglSewaHariField = new javax.swing.JTextField();
        tglSewaBulanField = new javax.swing.JTextField();
        tglSewaTahunField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        tglBatasKembaliHariField = new javax.swing.JTextField();
        tglBatasKembaliBulanField = new javax.swing.JTextField();
        tglBatasKembaliTahunField = new javax.swing.JTextField();
        dataDetailPanel2 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        noKTPField = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pekerjaanField = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        alamatField = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jenisKelaminField = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        kotaField = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        tanggalLahirField = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        teleponField = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        noHPField = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        dataDetailPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        noPolisiField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        hargaSewa24JamField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        merkField = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        hargaSewa12JamField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        warnaField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        dendaPerJamField = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tahunField = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tglKembaliHariField = new javax.swing.JTextField();
        tglKembaliBulanField = new javax.swing.JTextField();
        tglKembaliTahunField = new javax.swing.JTextField();
        hitungButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(626, 666));
        setMinimumSize(new java.awt.Dimension(626, 666));
        setPreferredSize(new java.awt.Dimension(626, 666));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Penyewaan"));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        jLabel3.setText("Tanggal Sewa");
        jPanel1.add(jLabel3);

        jPanel6.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        tglSewaHariField.setEditable(false);
        tglSewaHariField.setText("HH");
        jPanel6.add(tglSewaHariField);

        tglSewaBulanField.setEditable(false);
        tglSewaBulanField.setText("MM");
        jPanel6.add(tglSewaBulanField);

        tglSewaTahunField.setEditable(false);
        tglSewaTahunField.setText("YYYY");
        jPanel6.add(tglSewaTahunField);

        jPanel1.add(jPanel6);

        jLabel2.setText("Batas Pengembalian");
        jPanel1.add(jLabel2);

        jPanel7.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        tglBatasKembaliHariField.setEditable(false);
        tglBatasKembaliHariField.setText("HH");
        jPanel7.add(tglBatasKembaliHariField);

        tglBatasKembaliBulanField.setEditable(false);
        tglBatasKembaliBulanField.setText("MM");
        jPanel7.add(tglBatasKembaliBulanField);

        tglBatasKembaliTahunField.setEditable(false);
        tglBatasKembaliTahunField.setText("YYYY");
        jPanel7.add(tglBatasKembaliTahunField);

        jPanel1.add(jPanel7);

        dataDetailPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Informasi"));
        dataDetailPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataDetailPanel2.setMinimumSize(new java.awt.Dimension(367, 163));
        dataDetailPanel2.setLayout(new java.awt.GridLayout(5, 5, 30, 10));

        jPanel23.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel22.setText("No. KTP");
        jPanel23.add(jLabel22);

        noKTPField.setEditable(false);
        noKTPField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noKTPFieldActionPerformed(evt);
            }
        });
        jPanel23.add(noKTPField);

        dataDetailPanel2.add(jPanel23);

        jPanel24.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel23.setText("Pekerjaan");
        jPanel24.add(jLabel23);

        pekerjaanField.setEditable(false);
        jPanel24.add(pekerjaanField);

        dataDetailPanel2.add(jPanel24);

        jPanel25.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel24.setText("Nama");
        jPanel25.add(jLabel24);

        namaField.setEditable(false);
        jPanel25.add(namaField);

        dataDetailPanel2.add(jPanel25);

        jPanel26.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel25.setText("Alamat");
        jPanel26.add(jLabel25);

        alamatField.setEditable(false);
        jPanel26.add(alamatField);

        dataDetailPanel2.add(jPanel26);

        jPanel27.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel26.setText("Jenis Kelamin");
        jPanel27.add(jLabel26);

        jenisKelaminField.setEditable(false);
        jPanel27.add(jenisKelaminField);

        dataDetailPanel2.add(jPanel27);

        jPanel28.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel13.setText("Kota");
        jPanel28.add(jLabel13);

        kotaField.setEditable(false);
        jPanel28.add(kotaField);

        dataDetailPanel2.add(jPanel28);

        jPanel29.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel27.setText("Tanggal Lahir");
        jPanel29.add(jLabel27);

        tanggalLahirField.setEditable(false);
        jPanel29.add(tanggalLahirField);

        dataDetailPanel2.add(jPanel29);

        jPanel30.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel15.setText("Telepon");
        jPanel30.add(jLabel15);

        teleponField.setEditable(false);
        jPanel30.add(teleponField);

        dataDetailPanel2.add(jPanel30);

        jPanel31.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel28.setText("No. HP");
        jPanel31.add(jLabel28);

        noHPField.setEditable(false);
        jPanel31.add(noHPField);

        dataDetailPanel2.add(jPanel31);

        jPanel32.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel17.setText("Email");
        jPanel32.add(jLabel17);

        emailField.setEditable(false);
        jPanel32.add(emailField);

        dataDetailPanel2.add(jPanel32);

        dataDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Mobil"));
        dataDetailPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataDetailPanel.setMinimumSize(new java.awt.Dimension(367, 163));
        dataDetailPanel.setLayout(new java.awt.GridLayout(4, 4, 30, 10));

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel8.setText("No. Polisi");
        jPanel4.add(jLabel8);

        noPolisiField.setEditable(false);
        noPolisiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPolisiFieldActionPerformed(evt);
            }
        });
        jPanel4.add(noPolisiField);

        dataDetailPanel.add(jPanel4);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel9.setText("Harga Sewa 24 Jam");
        jPanel3.add(jLabel9);

        hargaSewa24JamField.setEditable(false);
        jPanel3.add(hargaSewa24JamField);

        dataDetailPanel.add(jPanel3);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel10.setText("Merk");
        jPanel5.add(jLabel10);

        merkField.setEditable(false);
        merkField.setToolTipText("");
        jPanel5.add(merkField);

        dataDetailPanel.add(jPanel5);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel16.setText("Harga Sewa 12 Jam");
        jPanel11.add(jLabel16);

        hargaSewa12JamField.setEditable(false);
        jPanel11.add(hargaSewa12JamField);

        dataDetailPanel.add(jPanel11);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel12.setText("Warna");
        jPanel8.add(jLabel12);

        warnaField.setEditable(false);
        jPanel8.add(warnaField);

        dataDetailPanel.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel11.setText("Denda Per Jam ");
        jPanel9.add(jLabel11);

        dendaPerJamField.setEditable(false);
        jPanel9.add(dendaPerJamField);

        dataDetailPanel.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel14.setText("Tahun");
        jPanel10.add(jLabel14);

        tahunField.setEditable(false);
        jPanel10.add(tahunField);

        dataDetailPanel.add(jPanel10);

        jPanel12.setLayout(new java.awt.GridLayout(1, 2, 10, 0));
        dataDetailPanel.add(jPanel12);

        jLabel1.setText("Tanggal Pengembalian Kendaraan");

        tglKembaliHariField.setText("HH");
        tglKembaliHariField.setPreferredSize(new java.awt.Dimension(22, 20));

        tglKembaliBulanField.setText("MM");

        tglKembaliTahunField.setText("TTTT");
        tglKembaliTahunField.setPreferredSize(new java.awt.Dimension(22, 20));

        hitungButton.setText("HITUNG TOTAL BIAYA");
        hitungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataDetailPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataDetailPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(hitungButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(tglKembaliHariField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tglKembaliBulanField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tglKembaliTahunField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataDetailPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tglKembaliHariField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglKembaliBulanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglKembaliTahunField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hitungButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void noKTPFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noKTPFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noKTPFieldActionPerformed

    private void noPolisiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPolisiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noPolisiFieldActionPerformed

    private void hitungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungButtonActionPerformed
        String tanggalKembaliHari = tglKembaliHariField.getText();
        String tanggalKembaliBulan = tglKembaliBulanField.getText();
        String tanggalKembaliTahun = tglKembaliTahunField.getText();
        String tanggalKembali = tanggalKembaliHari
                + "-" +tanggalKembaliBulan
                + "-" + tanggalKembaliTahun;
        
        javax.swing.JPanel en = new belajardatabase.penyewaan
                .PengembalianDanBayar(frame, idSewa, tanggalKembali);

        frame.setContentPane(en);
        SwingUtilities.updateComponentTreeUI(frame.getContentPane());
    }//GEN-LAST:event_hitungButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatField;
    private javax.swing.JPanel dataDetailPanel;
    private javax.swing.JPanel dataDetailPanel2;
    private javax.swing.JTextField dendaPerJamField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField hargaSewa12JamField;
    private javax.swing.JTextField hargaSewa24JamField;
    private javax.swing.JButton hitungButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jenisKelaminField;
    private javax.swing.JTextField kotaField;
    private javax.swing.JTextField merkField;
    private javax.swing.JTextField namaField;
    private javax.swing.JTextField noHPField;
    private javax.swing.JTextField noKTPField;
    private javax.swing.JTextField noPolisiField;
    private javax.swing.JTextField pekerjaanField;
    private javax.swing.JTextField tahunField;
    private javax.swing.JTextField tanggalLahirField;
    private javax.swing.JTextField teleponField;
    private javax.swing.JTextField tglBatasKembaliBulanField;
    private javax.swing.JTextField tglBatasKembaliHariField;
    private javax.swing.JTextField tglBatasKembaliTahunField;
    private javax.swing.JTextField tglKembaliBulanField;
    private javax.swing.JTextField tglKembaliHariField;
    private javax.swing.JTextField tglKembaliTahunField;
    private javax.swing.JTextField tglSewaBulanField;
    private javax.swing.JTextField tglSewaHariField;
    private javax.swing.JTextField tglSewaTahunField;
    private javax.swing.JTextField warnaField;
    // End of variables declaration//GEN-END:variables
}
