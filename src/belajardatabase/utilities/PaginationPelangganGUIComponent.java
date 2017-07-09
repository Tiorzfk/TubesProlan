/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.utilities;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author ASEP
 */
public class PaginationPelangganGUIComponent {
    PaginationPelanggan pg = null;
    
    /* GUI component: label for displaying page position in pagination */
    private JLabel          label               = null;
    /* GUI component: combobox for displaying all available page */
    private JComboBox       comboBox            = null;
    /* combobox status: is it accept an action or pause */
    private boolean         comboBoxStatus      = true;
    
    public PaginationPelangganGUIComponent(PaginationPelanggan pagination) {
        this.pg = pagination;
    }
    
    public void init() {
        initComboBox();
    }
    
    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }
    
    public void update() {
        updateLabel();
        updateComboBox();
    }
    
    public void updateLabel() {
        int current = pg.getPageCount() > 0 ? pg.getCurrentPage() : 0;
        
        String text = "Halaman " + current + " dari " + pg.getPageCount();
        label.setText(text);
    }
    
    public void updateComboBox() {
        comboBoxStatus = COMBOBOX_PAUSE_ANY_ACTION;
        comboBox.setSelectedItem( Integer.toString(pg.getCurrentPage()) );
        comboBoxStatus = COMBOBOX_ACCEPT_ANY_ACTION;
    }

    public void initComboBox() {
        comboBoxStatus = COMBOBOX_PAUSE_ANY_ACTION;
        comboBox.removeAllItems();
        for (int i = 1; i <= pg.getPageCount(); i++) {
            comboBox.addItem( Integer.toString(i) );
        }
        comboBoxStatus = COMBOBOX_ACCEPT_ANY_ACTION; // resume to accept event
    }
    
    public void reinitComboBox() {
        initComboBox();
    }
    
    public boolean getComboBoxStatus() {
        return comboBoxStatus;
    }
    
    /* Since event 'itemStateChanged' also fired when
     * I removeall/add/set-selected item to combobox and make call to
     * updateTable, I have to make any trick.
     * 
     * And, here it is.
     *
     * see paginationComboBoxItemStateChanged method to see how this works.
     */
    public final static boolean COMBOBOX_ACCEPT_ANY_ACTION      = true;
    public final static boolean COMBOBOX_PAUSE_ANY_ACTION       = false;
}
