/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.utilities;

import belajardatabase.model.MobilTableModel;
import belajardatabase.mysqlop.SQLHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import belajardatabase.model.MyAbstractModel;
import javax.swing.JComboBox;

/**
 *
 * @author ASEP
 */
public class PaginationPelanggan {
    /* model that used by JTable for displaying data */
    private MyAbstractModel model               = null;
    /* number of items per page */
    private int             pageLength          = -1;
    
    /* current page */
    private int currentPage = -1;
    /* number of pages available in pagination */
    private int pageCount   = -1;
    
    /**
     * this is just for easy-to-read purpose
     * 
     * for example,
     *      if you change sql in model then execute it
     *      pagination also need to update their @var current_page, and
     *      @var pageCount. So, you will call updatePagination() method after
     *      that. This is more easy-to-read:
     *          
     *          model.sql.where("noPolisi=123");
     *          ResultSet rs = model.execute();
     *          model.save(rs);
     * 
     *          pagination.isSQLChanged.updatePagination();
     *          
     *      rather than:
     *          ``
     *          model.sql.where("noPolisi=123");
     *          ResultSet rs = model.execute();
     *          model.save(rs);
     *          
     *          pagination.updatePagination();
     * 
     *
     */
    public PaginationPelanggan isSQLChanged = this;
    public PaginationPelangganGUIComponent GUIComponent = null;
    
    public PaginationPelanggan() {
        GUIComponent = new PaginationPelangganGUIComponent(this);
    }
    
    public void init() {
        updatePagination();
            GUIComponent.init();
    }
    
    public void setModel(MyAbstractModel model) {
        this.model = model;
    }
    
    public void setPageLength(int dataPerPage) {
        this.pageLength = dataPerPage;
    }
    
    public int movePrevious() {
       currentPage -= 1;
       
       if (currentPage >= 1) return getNewOffset(currentPage);
       
       currentPage = 1;
       return getNewOffset(currentPage);
    }
    
    public int moveNext() {
       currentPage += 1;
       
       
       if (currentPage <= pageCount) return getNewOffset(currentPage);
       
       currentPage = pageCount;
       return getNewOffset(currentPage);
    }
    
    public int jumpToFirst() {
        currentPage = 1;
        return getNewOffset(currentPage);
    }
    
    public int jumpToLast() {
        currentPage = pageCount;
        return getNewOffset(currentPage);
    }
    
    public int jumpTo(int pageTarget) {
        currentPage = pageTarget;
        return getNewOffset(currentPage);
    }
    
    /** recomended to use as below:
     * 
     *      pagination.isSQLChange.updatePagination();
     * 
     * @return new offset
     */
    public int updatePagination() {
        currentPage = 1; // even when record of result query is empty
        
        countPageCount(); // if SQL change, the page count also.
        
        GUIComponent.updateComboBox();
        
        return getNewOffset(currentPage);
    }
    
    private int getNewOffset(int newCurrentPage) {
        int newOffset = pageLength * (currentPage - 1);
        
        return newOffset;
    }
    
    private void countPageCount() {
        // [1] backup
        String tmp_select   = (String) model.sql.select.get("select");
        int tmp_limit       = (int) model.sql.select.get("limit");
        int tmp_offset      = (int) model.sql.select.get("offset");
        
        // [2] change
        model.sql.select.select("count(noKTP) as num_rows");
        model.sql.select.removeLimit();
        ResultSet rs = model.sql.select.execute();
        
        int pageCount = -1;
        try {
            rs.next();
            int num_rows = rs.getInt("num_rows");
            
            System.out.println("numrows = " + num_rows);
            
            pageCount = (int) Math.ceil(num_rows / (double) pageLength);
        } catch (SQLException e) {
                System.out.println("Error inside `getPageCount` method: "
                    + e.getMessage());
        } finally {
            model.sql.mdbc.close(rs);
            
            // [3] recover
            model.sql.select.select(tmp_select);
            model.sql.select.limit(tmp_limit);
            model.sql.select.offset(tmp_offset);
        }
        
        this.pageCount = pageCount;
    }
    
    public int getPageCount() {
        return pageCount;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
}
