/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.model;

import belajardatabase.mysqlop.SQLHandler;
import java.sql.ResultSet;
import javax.swing.table.AbstractTableModel;

/**
 * Every model class have @var sql properties and extend from
 * AbstractTableModel abstract class. But if I need to use that properties
 * for every model in another class, I can't access it.
 * So, I have to make a 'contract'
 *
 * In the end, every model must extend this instead of
 * AbstractTableModel abstract class.
 * 
 * @author ASEP
 */
public abstract class MyAbstractModel extends AbstractTableModel {
    public SQLHandler sql;
    
    public MyAbstractModel(String selectSQL, String table) {
        this.sql = new SQLHandler(selectSQL, table);
    }
    
    public abstract void save(ResultSet rs);
}
