/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase;

import belajardatabase.pelanggan.pelangganForm;
import belajardatabase.mobil.*;
import belajardatabase.pelanggan.*;
import belajardatabase.penyewaan.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author ASEP
 */
public class mainWindow extends javax.swing.JFrame {

    interface myInterface {
        public int myNumber();
    }
    
    /**
     * Creates new form mainWindow
     */
    public mainWindow() {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m = p.matcher("45");
       
        System.out.println("tes = " + (m.find() == true ? "match" : "not match"));
         
        initComponents();
        javax.swing.JPanel en = new entry();

        this.setContentPane(en);
    }
    
    public void callMe(myInterface f) {
        System.out.println("My number is " + f.myNumber());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mobil_listingMenuItem = new javax.swing.JMenuItem();
        mobil_tambahMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuPelanggan_listing = new javax.swing.JMenuItem();
        menuPelanggan_tambah = new javax.swing.JMenuItem();
        menuPenyewaan_listing = new javax.swing.JMenu();
        penyeasd = new javax.swing.JMenuItem();
        menuPenyewaan_tambah = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(626, 666));
        setMinimumSize(new java.awt.Dimension(626, 666));
        setSize(new java.awt.Dimension(626, 666));

        jMenu1.setText("Mobil");

        mobil_listingMenuItem.setText("Listing");
        mobil_listingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobil_listingMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(mobil_listingMenuItem);

        mobil_tambahMenuItem.setText("Tambah");
        mobil_tambahMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobil_tambahMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(mobil_tambahMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Pelanggan");

        menuPelanggan_listing.setText("Listing");
        menuPelanggan_listing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPelanggan_listingActionPerformed(evt);
            }
        });
        jMenu3.add(menuPelanggan_listing);

        menuPelanggan_tambah.setText("Tambah");
        menuPelanggan_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPelanggan_tambahActionPerformed(evt);
            }
        });
        jMenu3.add(menuPelanggan_tambah);

        jMenuBar1.add(jMenu3);

        menuPenyewaan_listing.setText("Penyewaan");

        penyeasd.setText("Listing");
        penyeasd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penyeasdActionPerformed(evt);
            }
        });
        menuPenyewaan_listing.add(penyeasd);

        menuPenyewaan_tambah.setText("Tambah");
        menuPenyewaan_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenyewaan_tambahActionPerformed(evt);
            }
        });
        menuPenyewaan_listing.add(menuPenyewaan_tambah);

        jMenuBar1.add(menuPenyewaan_listing);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mobil_listingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobil_listingMenuItemActionPerformed
        javax.swing.JPanel en = new view2();

        this.setContentPane(en);
        updateLookAndFeel();
    }//GEN-LAST:event_mobil_listingMenuItemActionPerformed

    private void mobil_tambahMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobil_tambahMenuItemActionPerformed
        javax.swing.JPanel en = new entry();

        this.setContentPane(en);
        updateLookAndFeel();
    }//GEN-LAST:event_mobil_tambahMenuItemActionPerformed

    private void menuPelanggan_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPelanggan_tambahActionPerformed
        // TODO add your handling code here:
        javax.swing.JFrame en = new pelangganForm();

        this.setContentPane(en);
        updateLookAndFeel();
    }//GEN-LAST:event_menuPelanggan_tambahActionPerformed

    private void menuPelanggan_listingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPelanggan_listingActionPerformed
        // TODO add your handling code here:
        javax.swing.JFrame en = new pelangganTable();

        this.setContentPane(en);
        updateLookAndFeel();
    }//GEN-LAST:event_menuPelanggan_listingActionPerformed

    private void penyeasdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penyeasdActionPerformed
        // TODO add your handling code here:
        javax.swing.JPanel en = new belajardatabase.penyewaan.view(this);

        this.setContentPane(en);
        updateLookAndFeel();
    }//GEN-LAST:event_penyeasdActionPerformed

    private void menuPenyewaan_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenyewaan_tambahActionPerformed
        // TODO add your handling code here:
        javax.swing.JFrame en = new penyewaanForm();

        this.setContentPane(en);
        updateLookAndFeel();
    }//GEN-LAST:event_menuPenyewaan_tambahActionPerformed

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
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { 
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
                } catch (Exception ex) { 
                    ex.printStackTrace(); 
                }
                javax.swing.JFrame myFrame = new mainWindow();
                myFrame.setVisible(true);
                SwingUtilities.updateComponentTreeUI(myFrame);
            }
        });
    }
    
    private void updateLookAndFeel() {
        SwingUtilities.updateComponentTreeUI(getContentPane());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuPelanggan_listing;
    private javax.swing.JMenuItem menuPelanggan_tambah;
    private javax.swing.JMenu menuPenyewaan_listing;
    private javax.swing.JMenuItem menuPenyewaan_tambah;
    private javax.swing.JMenuItem mobil_listingMenuItem;
    private javax.swing.JMenuItem mobil_tambahMenuItem;
    private javax.swing.JMenuItem penyeasd;
    // End of variables declaration//GEN-END:variables
}
