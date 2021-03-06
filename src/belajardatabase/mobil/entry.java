/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mobil;

import belajardatabase.model.MobilTableModel;
import belajardatabase.mysqlop.InsertSQL;
import belajardatabase.utilities.ActionValidator;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASEP
 */
public class entry extends javax.swing.JPanel {
    MobilTableModel model       = null;
    //InputValidator  validator   = null;

    /**
     * Creates new form entry
     */
    public entry() {
        initComponents();
        initModel();
        //initValidator();
    }
    
    public void initModel() {
        model = new MobilTableModel();
    }
    
    public void initValidator() {   
        /* validator = new InputValidator();
        
        try {
            validator.field(noPolisiField, "No Polisi");
            validator.addRule("required", true);
     
            validator.end();
            
            validator.field(merkField, "merk");
            validator.addRule("required", true);
            validator.addRule("valid_input", "alphanumeric_only");
            validator.end();

            validator.field(warnaField, "Warna");
            validator.addRule("required", true);
            validator.addRule("valid_input", "character_only");
            validator.end();

            validator.field(tahunField, "Tahun");
            validator.addRule("required", true);
            validator.addRule("valid_input", "numeric_only");
            validator.end();

            validator.field(tahunField, "Tahun");
            validator.addRule("required", true);
            validator.addRule("valid_input", "numeric_only");
            validator.end();

            validator.field(hargaSewa12JamField, "Harga Sewa 12 Jam");
            validator.addRule("required", true);
            validator.addRule("valid_input", "numeric_only");
            validator.end();

            validator.field(hargaSewa24JamField, "Harga Sewa 24 Jam");
            validator.addRule("required", true);
            validator.addRule("valid_input", "numeric_only");
            validator.end();

            validator.field(dendaPerJamField, "Denda Per Jam");
            validator.addRule("required", true);
            validator.addRule("valid_input", "numeric_only");
            validator.end();

            validator.field(statusComboBox, "Status");
            validator.addRule("required", true);
            validator.addRule("valid_input", new String[] {
                "Tersedia",
                "Tidak Tersedia"
            });
            validator.end();
            
        } catch (Exception e) {
            System.out.println("Error insisde `initValidator`: " + e.getMessage());
        }
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        noPolisiField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        merkField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        warnaField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tahunField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hargaSewa12JamField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        hargaSewa24JamField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dendaPerJamField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        simpanButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTextPane = new javax.swing.JTextPane();

        setMaximumSize(new java.awt.Dimension(626, 666));
        setMinimumSize(new java.awt.Dimension(626, 666));
        setPreferredSize(new java.awt.Dimension(626, 666));

        fieldPanel.setLayout(new java.awt.GridLayout(9, 2, 10, 5));

        jLabel1.setText("No. Polisi");
        fieldPanel.add(jLabel1);
        fieldPanel.add(noPolisiField);

        jLabel2.setText("Merk");
        fieldPanel.add(jLabel2);
        fieldPanel.add(merkField);

        jLabel3.setText("Warna");
        fieldPanel.add(jLabel3);
        fieldPanel.add(warnaField);

        jLabel4.setText("Tahun");
        fieldPanel.add(jLabel4);
        fieldPanel.add(tahunField);

        jLabel5.setText("Harga Sewa 12 Jam");
        fieldPanel.add(jLabel5);
        fieldPanel.add(hargaSewa12JamField);

        jLabel6.setText("Harga Sewa 24 Jam");
        fieldPanel.add(jLabel6);
        fieldPanel.add(hargaSewa24JamField);

        jLabel7.setText("Denda Per Jam");
        fieldPanel.add(jLabel7);
        fieldPanel.add(dendaPerJamField);

        jLabel8.setText("Status");
        fieldPanel.add(jLabel8);

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tersedia", "Tidak Tersedia" }));
        fieldPanel.add(statusComboBox);

        jLabel9.setText("just a gap holder");
        fieldPanel.add(jLabel9);

        simpanButton.setText("SIMPAN");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        fieldPanel.add(simpanButton);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Tambah Mobil");

        messageTextPane.setEditable(false);
        jScrollPane2.setViewportView(messageTextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(fieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(fieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        /*
        if (validator.verifyAll() == false) {
            messageTextPane.setText(validator.getMessage());
            return;
        }
        */
        
        model.sql.insert.reset();
        model.sql.insert.value("noPolisi", noPolisiField.getText());
        model.sql.insert.value("merk", merkField.getText());
        model.sql.insert.value("warna", warnaField.getText());
        model.sql.insert.value("tahun", tahunField.getText());
        model.sql.insert.value("hargaSewa12Jam", hargaSewa12JamField.getText());
        model.sql.insert.value("hargaSewa24Jam", hargaSewa24JamField.getText());
        model.sql.insert.value("dendaPerJam", dendaPerJamField.getText());
        model.sql.insert.value("status", statusComboBox
                .getSelectedItem().toString() == "Tersedia" ?
                MobilTableModel.STATUS_TERSEDIA :
                MobilTableModel.STATUS_TIDAK_TERSEDIA
        );
        model.sql.insert.execute();
    }//GEN-LAST:event_simpanButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dendaPerJamField;
    private javax.swing.JPanel fieldPanel;
    private javax.swing.JTextField hargaSewa12JamField;
    private javax.swing.JTextField hargaSewa24JamField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField merkField;
    private javax.swing.JTextPane messageTextPane;
    private javax.swing.JTextField noPolisiField;
    private javax.swing.JButton simpanButton;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JTextField tahunField;
    private javax.swing.JTextField warnaField;
    // End of variables declaration//GEN-END:variables
}
