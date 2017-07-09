/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajardatabase.penyewaan;

import belajardatabase.mysqlop.MyDBConnection;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 *
 * @author Tio
 */
public class penyewaanForm extends javax.swing.JFrame {

    /**
     * Creates new form pelangganForm
     */
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    public penyewaanForm() {
        mdbc = new MyDBConnection();
        mdbc.init();
        Connection conn =mdbc.getMyConnection();
        try {
           stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error inside `insertTable` : " + e.getMessage());
        }
        
        initComponents();
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        mdbc.close(stmt);
        mdbc.destroy();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        cb_mobil = new javax.swing.JComboBox<>();
        dataDetailPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        field_no_polis = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        field_sewa24 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        field_merk = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        field_sewa12 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        field_warna = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        field_dendaperjam = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        field_tahun = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_pelanggan = new javax.swing.JComboBox<>();
        dataDetailPanel2 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        field_no_ktp = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        field_pekerjaan = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        field_nama = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        field_alamat = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        field_jk = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        field_kota = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        field_tgl_lahir = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        field_telepon = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        field_no_hp = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        field_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_lama = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        sewaMenu = new javax.swing.JMenu();
        sewaTambahMenuItem = new javax.swing.JMenuItem();
        sewaListingMenuItem = new javax.swing.JMenuItem();
        mobilMenu = new javax.swing.JMenu();
        mobilTambahMenuItem = new javax.swing.JMenuItem();
        mobilListingMenuItem = new javax.swing.JMenuItem();
        keluarMenu = new javax.swing.JMenu();
        keluarKeluarMenuItem = new javax.swing.JMenuItem();
        keluarLogoutMenuItem = new javax.swing.JMenuItem();
        pelangganMenu = new javax.swing.JMenu();
        pelangganTambahMenuItem = new javax.swing.JMenuItem();
        pelangganListingMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("pelangganFrame"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Penyewaan Mobil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(388, 300));

        jLabel1.setText("Pilih Mobil");

        jButton1.setText("Simpan");
        jButton1.setName("btn_simpan"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.setName("btn_reset"); // NOI18N
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        cb_mobil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        cb_mobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_mobilItemStateChanged(evt);
            }
        });
        cb_mobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_mobilMouseClicked(evt);
            }
        });

        dataDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Mobil"));
        dataDetailPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataDetailPanel.setMinimumSize(new java.awt.Dimension(367, 163));
        dataDetailPanel.setLayout(new java.awt.GridLayout(5, 5, 30, 10));

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel8.setText("No. Polis");
        jPanel4.add(jLabel8);

        field_no_polis.setEditable(false);
        field_no_polis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_no_polisActionPerformed(evt);
            }
        });
        jPanel4.add(field_no_polis);

        dataDetailPanel.add(jPanel4);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel9.setText("Harga Sewa 24 Jam");
        jPanel3.add(jLabel9);

        field_sewa24.setEditable(false);
        jPanel3.add(field_sewa24);

        dataDetailPanel.add(jPanel3);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel10.setText("Merk");
        jPanel5.add(jLabel10);

        field_merk.setEditable(false);
        field_merk.setToolTipText("");
        jPanel5.add(field_merk);

        dataDetailPanel.add(jPanel5);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel16.setText("Harga Sewa 12 Jam");
        jPanel11.add(jLabel16);

        field_sewa12.setEditable(false);
        jPanel11.add(field_sewa12);

        dataDetailPanel.add(jPanel11);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel12.setText("Warna");
        jPanel8.add(jLabel12);

        field_warna.setEditable(false);
        jPanel8.add(field_warna);

        dataDetailPanel.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel11.setText("Denda Per Jam ");
        jPanel9.add(jLabel11);

        field_dendaperjam.setEditable(false);
        jPanel9.add(field_dendaperjam);

        dataDetailPanel.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel14.setText("Tahun");
        jPanel10.add(jLabel14);

        field_tahun.setEditable(false);
        jPanel10.add(field_tahun);

        dataDetailPanel.add(jPanel10);

        jPanel12.setLayout(new java.awt.GridLayout(1, 2, 10, 0));
        dataDetailPanel.add(jPanel12);

        jPanel13.setLayout(new java.awt.GridLayout(1, 2, 10, 0));
        dataDetailPanel.add(jPanel13);

        jPanel14.setLayout(new java.awt.GridLayout(1, 2, 10, 0));
        dataDetailPanel.add(jPanel14);

        jLabel2.setText("Pilih Pelanggan");

        cb_pelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Pilih No KTP---" }));
        cb_pelanggan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_pelangganItemStateChanged(evt);
            }
        });

        dataDetailPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Informasi"));
        dataDetailPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataDetailPanel2.setMinimumSize(new java.awt.Dimension(367, 163));
        dataDetailPanel2.setLayout(new java.awt.GridLayout(5, 5, 30, 10));

        jPanel23.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel22.setText("No. KTP");
        jPanel23.add(jLabel22);

        field_no_ktp.setEditable(false);
        field_no_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_no_ktpActionPerformed(evt);
            }
        });
        jPanel23.add(field_no_ktp);

        dataDetailPanel2.add(jPanel23);

        jPanel24.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel23.setText("Pekerjaan");
        jPanel24.add(jLabel23);

        field_pekerjaan.setEditable(false);
        jPanel24.add(field_pekerjaan);

        dataDetailPanel2.add(jPanel24);

        jPanel25.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel24.setText("Nama");
        jPanel25.add(jLabel24);

        field_nama.setEditable(false);
        jPanel25.add(field_nama);

        dataDetailPanel2.add(jPanel25);

        jPanel26.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel25.setText("Alamat");
        jPanel26.add(jLabel25);

        field_alamat.setEditable(false);
        jPanel26.add(field_alamat);

        dataDetailPanel2.add(jPanel26);

        jPanel27.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel26.setText("Jenis Kelamin");
        jPanel27.add(jLabel26);

        field_jk.setEditable(false);
        jPanel27.add(field_jk);

        dataDetailPanel2.add(jPanel27);

        jPanel28.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel13.setText("Kota");
        jPanel28.add(jLabel13);

        field_kota.setEditable(false);
        jPanel28.add(field_kota);

        dataDetailPanel2.add(jPanel28);

        jPanel29.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel27.setText("Tanggal Lahir");
        jPanel29.add(jLabel27);

        field_tgl_lahir.setEditable(false);
        jPanel29.add(field_tgl_lahir);

        dataDetailPanel2.add(jPanel29);

        jPanel30.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel15.setText("Telepon");
        jPanel30.add(jLabel15);

        field_telepon.setEditable(false);
        jPanel30.add(field_telepon);

        dataDetailPanel2.add(jPanel30);

        jPanel31.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel28.setText("No. HP");
        jPanel31.add(jLabel28);

        field_no_hp.setEditable(false);
        jPanel31.add(field_no_hp);

        dataDetailPanel2.add(jPanel31);

        jPanel32.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel17.setText("Email");
        jPanel32.add(jLabel17);

        field_email.setEditable(false);
        jPanel32.add(field_email);

        dataDetailPanel2.add(jPanel32);

        jLabel3.setText("Lama Sewa");

        cb_lama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "24 Jam", "12 Jam" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_reset))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel1)
                                        .addGap(42, 42, 42)
                                        .addComponent(cb_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(dataDetailPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel3)
                                .addGap(32, 32, 32)
                                .addComponent(cb_lama, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cb_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dataDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dataDetailPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_lama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btn_reset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sewaMenu.setText("Sewa");

        sewaTambahMenuItem.setText("Tambah");
        sewaTambahMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewaTambahMenuItemActionPerformed(evt);
            }
        });
        sewaMenu.add(sewaTambahMenuItem);

        sewaListingMenuItem.setText("Listing");
        sewaMenu.add(sewaListingMenuItem);

        jMenuBar1.add(sewaMenu);

        mobilMenu.setText("Mobil");

        mobilTambahMenuItem.setText("Tambah");
        mobilTambahMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobilTambahMenuItemActionPerformed(evt);
            }
        });
        mobilMenu.add(mobilTambahMenuItem);

        mobilListingMenuItem.setText("Listing");
        mobilMenu.add(mobilListingMenuItem);

        jMenuBar1.add(mobilMenu);

        keluarMenu.setText("Keluar");

        keluarKeluarMenuItem.setText("Keluar");
        keluarKeluarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarKeluarMenuItemActionPerformed(evt);
            }
        });
        keluarMenu.add(keluarKeluarMenuItem);

        keluarLogoutMenuItem.setText("Logout");
        keluarMenu.add(keluarLogoutMenuItem);

        jMenuBar1.add(keluarMenu);

        pelangganMenu.setText("Pelanggan");

        pelangganTambahMenuItem.setText("Tambah");
        pelangganTambahMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelangganTambahMenuItemActionPerformed(evt);
            }
        });
        pelangganMenu.add(pelangganTambahMenuItem);

        pelangganListingMenuItem.setText("Listing");
        pelangganMenu.add(pelangganListingMenuItem);

        jMenuBar1.add(pelangganMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sewaTambahMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewaTambahMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sewaTambahMenuItemActionPerformed

    private void mobilTambahMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobilTambahMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobilTambahMenuItemActionPerformed

    private void keluarKeluarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarKeluarMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keluarKeluarMenuItemActionPerformed

    private void pelangganTambahMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelangganTambahMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pelangganTambahMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //waktu
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String now = dateFormat.format(date);
        
        //pelanggan
        String no_ktp = field_no_ktp.getText();
        
        //mobil
        String no_polis = field_no_polis.getText();
        
        //lama
        String lama = (String) cb_lama.getSelectedItem();
        
        String def = "0000-00-00 00:00:00";
        
        int harga = 0;
        if(lama == "24 Jam") {
            harga = Integer.parseInt(field_sewa24.getText());
        }else{
            harga = Integer.parseInt(field_sewa12.getText());
        }
        
        mdbc = new MyDBConnection();
        mdbc.init();
        Connection conn =mdbc.getMyConnection();
        String insertStr;
        
        try {
            insertStr = "INSERT INTO sewa (tanggalSewa, tanggalKembali, totalBayar, noKTP, noPolisi) VALUES ("
                    + quotate(now) + ","
                    + quotate(def) +","
                    + harga + ","
                    + quotate(no_ktp) + ","
                    + quotate(no_polis)
                    + ")";
            
            int done = stmt.executeUpdate(insertStr);
            
            JOptionPane.showMessageDialog(null, "Berhasil menyewa mobil");
        
            reset();
            
            initComponents();
        } catch (Exception e) {
            System.out.println("Error in `sendButtonActionPerformed` : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mdbc = new MyDBConnection();
        mdbc.init();
        Connection conn =mdbc.getMyConnection();
        try {
            
            String query = "SELECT * FROM mobil";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
             
            while (rs.next()) {      
                String kota = rs.getString("merk");
                cb_mobil.addItem(kota);
            }
             
        } catch (SQLException e) {
            System.out.println("Error in `combobox kota` : " + e.getMessage());
        }
        try {
            
            String query = "SELECT * FROM pelanggan";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
             
            while (rs.next()) {      
                String kota = rs.getString("noKTP");
                cb_pelanggan.addItem(kota);
            }
             
        } catch (SQLException e) {
            System.out.println("Error in `combobox kota` : " + e.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void field_no_polisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_no_polisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_no_polisActionPerformed

    private void cb_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_mobilMouseClicked
        // TODO add your handling code here:
          
    }//GEN-LAST:event_cb_mobilMouseClicked

    private void cb_mobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_mobilItemStateChanged
        // TODO add your handling code here:
        String mobil = (String) cb_mobil.getSelectedItem();
            
            try {
                PreparedStatement pst = null;
                mdbc = new MyDBConnection();
                mdbc.init();
                Connection conn =mdbc.getMyConnection();
                String query = "SELECT * FROM mobil WHERE merk = '"
                        + mobil + "'";
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery(query);
                rs.next();
                
                field_no_polis.setText(rs.getString("noPolisi"));
                field_merk.setText(rs.getString("merk"));
                field_warna.setText(rs.getString("warna"));
                field_tahun.setText(rs.getString("tahun"));
                field_sewa24.setText(rs.getString("hargaSewa24Jam"));
                field_sewa12.setText(rs.getString("hargaSewa12Jam"));
                field_dendaperjam.setText(rs.getString("dendaPerJam"));
                mdbc.close(rs);
            } catch (SQLException e) {
                System.out.println("Error inside `viewTableMouseClicked` : "
                    + e.getMessage());
            }
    }//GEN-LAST:event_cb_mobilItemStateChanged

    private void field_no_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_no_ktpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_no_ktpActionPerformed

    private void cb_pelangganItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_pelangganItemStateChanged
        // TODO add your handling code here:
        String noKTP = (String) cb_pelanggan.getSelectedItem();
            
            try {
                PreparedStatement pst = null;
                mdbc = new MyDBConnection();
                mdbc.init();
                Connection conn =mdbc.getMyConnection();
                String query = "SELECT noKTP,nama,jenisKelamin,tanggalLahir,pekerjaan,alamat,namaKota,telepon,handphone,email FROM pelanggan INNER JOIN kota on kota.idKota = pelanggan.idKota WHERE noKTP = '"
                        + noKTP + "'";
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery(query);
                rs.next();
                
                int jenkel = Integer.parseInt(rs.getString("jenisKelamin"));
                field_no_ktp.setText(rs.getString("noKTP"));
                field_nama.setText(rs.getString("nama"));
                field_tgl_lahir.setText(rs.getString("tanggalLahir"));
                field_pekerjaan.setText(rs.getString("pekerjaan"));
                field_alamat.setText(rs.getString("alamat"));
                field_kota.setText(rs.getString("namaKota"));
                field_telepon.setText(rs.getString("telepon"));
                field_email.setText(rs.getString("email"));
                field_no_hp.setText(rs.getString("handphone"));
                
                if (jenkel  == 1) {
                    field_jk.setText("Perempuan");
                }else{
                    field_jk.setText("Laki-laki");
                }
                mdbc.close(rs);
            } catch (SQLException e) {
                System.out.println("Error inside `viewTableMouseClicked` : "
                    + e.getMessage());
            }
    }//GEN-LAST:event_cb_pelangganItemStateChanged
    public void reset() {
        field_no_polis.setText("");
        field_merk.setText("");
        field_tahun.setText("");
        field_sewa24.setText("");
        field_dendaperjam.setText("");
        field_sewa12.setText("");
        field_warna.setText("");
        
        field_no_ktp.setText("");
        field_nama.setText("");
        field_tgl_lahir.setText("");
        field_pekerjaan.setText("");
        field_alamat.setText("");
        field_telepon.setText("");
        field_email.setText("");
        field_no_hp.setText("");
        field_kota.setText("");
    }
       
    public String quotate(String content) {
        return "'" + content + "'";
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(penyewaanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penyewaanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penyewaanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penyewaanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penyewaanForm().setVisible(true);
            }
        });
    }
    
    private MyDBConnection mdbc;
    private java.sql.Statement stmt;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_lama;
    private javax.swing.JComboBox<String> cb_mobil;
    private javax.swing.JComboBox<String> cb_pelanggan;
    private javax.swing.JPanel dataDetailPanel;
    private javax.swing.JPanel dataDetailPanel2;
    private javax.swing.JTextField field_alamat;
    private javax.swing.JTextField field_dendaperjam;
    private javax.swing.JTextField field_email;
    private javax.swing.JTextField field_jk;
    private javax.swing.JTextField field_kota;
    private javax.swing.JTextField field_merk;
    private javax.swing.JTextField field_nama;
    private javax.swing.JTextField field_no_hp;
    private javax.swing.JTextField field_no_ktp;
    private javax.swing.JTextField field_no_polis;
    private javax.swing.JTextField field_pekerjaan;
    private javax.swing.JTextField field_sewa12;
    private javax.swing.JTextField field_sewa24;
    private javax.swing.JTextField field_tahun;
    private javax.swing.JTextField field_telepon;
    private javax.swing.JTextField field_tgl_lahir;
    private javax.swing.JTextField field_warna;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JMenuItem keluarKeluarMenuItem;
    private javax.swing.JMenuItem keluarLogoutMenuItem;
    private javax.swing.JMenu keluarMenu;
    private javax.swing.JMenuItem mobilListingMenuItem;
    private javax.swing.JMenu mobilMenu;
    private javax.swing.JMenuItem mobilTambahMenuItem;
    private javax.swing.JMenuItem pelangganListingMenuItem;
    private javax.swing.JMenu pelangganMenu;
    private javax.swing.JMenuItem pelangganTambahMenuItem;
    private javax.swing.JMenuItem sewaListingMenuItem;
    private javax.swing.JMenu sewaMenu;
    private javax.swing.JMenuItem sewaTambahMenuItem;
    // End of variables declaration//GEN-END:variables
}
