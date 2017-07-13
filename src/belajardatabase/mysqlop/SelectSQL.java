/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mysqlop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Handler for SELECT sql statement
 * @author ASEP
 */
public class SelectSQL {
    private String _select = "";
    private String _from = "";
    private String _where = "1=1";
    private int _limit = -1;
    private int _offset = -1;
    
    public SelectSQL(
            MyDBConnection mdbc,
            Statement stmt,
            String selectSQL,
            String table
    ) {
        this.mdbc = mdbc;
        this.stmt = stmt;
        
        select(selectSQL);
        from(table);
    }
    
    public void select(String select) {
        this._select = select;
    }
    
    public void from(String table) {
        this._from = table;
    }
    
    public void limit(int dataPerPage) {
        this._limit = dataPerPage;
    }
    
    public void offset(int offset) {
        this._offset = offset;
    }
    
    public void removeLimit() {
        this._limit = -1;
        this._offset = -1;
    }
    
    /* In case you need these properties */
    public Object get(String prop) {
        switch (prop) {
            case "select": return (Object) this._select;
            case "from": return (Object) this._from;
            case "where": return (Object) this._where;
            case "limit": return (Object) this._limit;
            case "offset": return (Object) this._offset;
        }       
        return null;
    }
    
    /**
     * Reset the SQL SELECT query, so you can create new one.
     */
    public void reset() {
        this._where = "1=1";
        this._limit = -1;
    }
    
    /**
     * Start the segment sign.
     * This is useful when using with removeWhereBySegment() method
     * 
     * The example output is:
     *      AND /# EXAMPLE START #/ (
     * 
     * Note: I change `*` to be `#` to avoid error in java comment
     * 
     * @param sign 
     */
    public void whereSegmentStart(String sign) {
        this._where += " AND /* " + sign + " START */ (";
    }
    
    /**
     * End the segment sign
     * 
     * The example output is:
     *      ) /# EXAMPLE END #/ 
     * 
     *
     * Note: I change `*` to be `#` to avoid error in java comment
     * 
     * @param sign 
     */
    public void whereSegmentEnd(String sign) {
        this._where += ") /* " + sign + " END */ ";
    }
    
    /**
     * Example:
     *      WHERE merk = "toyota" AND /# CON START #/ (status = 0) /# CON END #/
     * Then to remove CON segment, just call removeWhereBySegmentSign("CON").
     * The result is:
     *      WHERE merk = "toyota"
     * 
     * Note: I change `*` to be `#` to avoid error in java comment
     * 
     * @param sign 
     */
    public void removeWhereBySegmentSign(String sign) {
        int startIndex = this._where
                .indexOf(" AND /* " + sign + " START */ (");
        int endIndex = this._where
                .indexOf(") /* " + sign + " END */ ");
        
        int segmentEndLength = (") /* " + sign + " END */ ").length();
        endIndex += segmentEndLength;
        
        if (startIndex == -1 || endIndex == -1) return;
        
        // gets the where query owned by current segment
        String target = this._where.substring(startIndex, endIndex);
        
        // remove
        this._where = this._where.replace(target, "");
    }
    
    /**
     * just once called for every WHERE SELECT SQL and,
     * every Grouping WHERE SELECT SQL
     *
     * Example:
     *      where('dendaPerJam', '>=', 150000);
     * will generating query as:
     *       .. WHERE dendaPerJam >= 150000
     * for Grouping WHERE SQL example, see method `whereGroupingStart`
     */
    public void where(String column, String operator, Object value) {
        System.out.println("where = " + this._where);
        if (this._where.equals("1=1")) {
            System.out.println("hello world");
            this._where += " AND ";
        }
        
        if (value instanceof Integer) {
            addWhere(column, operator, (int) value, null);
        }
        if (value instanceof String) {
            addWhere(column, operator, (String) value, null);
        }
    }
    
    /**
     * Add to WHERE SELECT SQL with prefixed by AND sql operator
     * Example:
     *      andWhere("dendaPerJam", ">=", 150000);
     * will generating query as:
     *      .. AND dendaPerJam >= 150000
     */
    public void andWhere(String column, String operator, Object value) {
        if (value instanceof Integer) {
            addWhere(column, operator, (int) value, "AND");
        }
        if (value instanceof String) {
            addWhere(column, operator, (String) value, "AND");
        }
    }
    
    /**
     * Add to WHERE SELECT SQL with prefixed by OR sql operator
     * Example:
     *      orWhere("dendaPerJam", ">=", 150000);
     * will generating query as:
     *      .. OR dendaPerJam >= 150000
     */
    public void orWhere(String column, String operator, Object value) {
        if (value instanceof Integer) {
            addWhere(column, operator, (int) value, "OR");
        }
        if (value instanceof String) {
            addWhere(column, operator, (String) value, "OR");
        }
    }
    
    /**
     * Starting the Grouping WHERE SELECT SQL
     * Example:
     *      whereGroupingStart("AND");
     * will generating query as:
     *      .. AND ( ..
     * as you can see, you must calling where() method after that
     */
    public void whereGroupingStart(String booleanOperator) {
        this._where += " " + booleanOperator + " " + "(";
    }
    
    /**
     * Close the Grouping WHERE SELECT SQL
     */
    public void whereGroupingEnd() {
        this._where += ")";
    }
    
    /**
     * @param column
     * @param operator
     * @param value
     * @param booleanOperator 
     */
    private void addWhere(
            String column,
            String operator,
            int value,
            String booleanOperator
    ) {
        if (booleanOperator != null) {
            this._where += " " + booleanOperator + " ";
        }
        this._where += column + " " + operator + " " + value;
    }
    
    /**
     * @param column
     * @param operator
     * @param value
     * @param booleanOperator 
     */
    private void addWhere(
            String column,
            String operator,
            String value,
            String booleanOperator
    ) {
        if (booleanOperator != null) {
            this._where += " " + booleanOperator + " ";
        }
        this._where += column + " " + operator + " \"" + value + "\"";
    }
    
    public ResultSet execute() {
        ResultSet rs = null;
        
        try {
            String query = combineClause();
            
            System.out.println("Executed SQL is " + query);
            
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error inside `getResultFromMobil` : "
                + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inside `combineClause` : "
                + e.getMessage());
        }
        
        return rs;
    }
    
    /**
     * Return complete SQL statement that can be send to database
     * @return query
     * @throws Exception 
     */
    private String combineClause() throws Exception {
        if (_select.equals("") || _from.equals("")) {
            throw new Exception("select property can't be empty");
        }
        if ((_limit > -1 && _offset == -1) || (_limit == -1 && _offset > -1)) {
            throw new Exception("limit/offset is set but another is not");
        }
        
        String query = "";
        query       += " SELECT " + _select;
        query       += " FROM " + _from;
        if (!_where.equals("")) query += " WHERE " + _where;
        if (_limit > -1) query += " LIMIT " + _limit + " OFFSET " + _offset;
        
        return query;
    }
    
    private MyDBConnection mdbc;
    private Statement stmt;
}
