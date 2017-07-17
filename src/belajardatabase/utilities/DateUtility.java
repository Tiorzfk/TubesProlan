/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.utilities;

import belajardatabase.model.KotaTableModel;
import belajardatabase.mysqlop.SelectSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 *
 * @author ASEP
 */
public class DateUtility {
    public static String getDayFromDateString(String dateString, String dateStringFormat) {
        String result = "";
        
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat(dateStringFormat, Locale.US);
            Date date = (Date) inputFormat.parse(dateString);
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd", Locale.US);
            result = outputFormat.format(date);
        } catch (ParseException e) {
            System.out.println("Error inside `getDayFromDateString`: "
                + e.getMessage());
        }
        return result;
    }
    
    public static String getMonthFromDateString(String dateString, String dateStringFormat) {
        String result = "";
        
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat(dateStringFormat, Locale.US);
            Date date = (Date) inputFormat.parse(dateString);
            SimpleDateFormat outputFormat = new SimpleDateFormat("MM", Locale.US);
            result = outputFormat.format(date);
        } catch (ParseException e) {
            System.out.println("Error inside `getMonthFromDateString`: "
                + e.getMessage());
        }
        return result;
    }
    
    public static String getYearFromDateString(String dateString, String dateStringFormat) {
        String result = "";
        
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat(dateStringFormat, Locale.US);
            Date date = (Date) inputFormat.parse(dateString);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy", Locale.US);
            result = outputFormat.format(date);
        } catch (ParseException e) {
            System.out.println("Error inside `getYearFromDateString`: "
                + e.getMessage());
        }
        return result;
    }
    
    public static int getDifferenceBetweenTwoDate(
            String date1String,
            String date2String,
            String dateStringFormat
    ) {
        int day = -1;
        String mysqlDateFormat = "yyyy-MM-dd";
        date1String = convertDateStringToAnotherformat(date1String,
                dateStringFormat, mysqlDateFormat);
        date2String = convertDateStringToAnotherformat(date2String,
                dateStringFormat, mysqlDateFormat);
        
        // model spesifiknya tidak penting, yang penting bisa mengeksekusi query
        // untuk menghitung interval hari dari dua tanggal
        KotaTableModel model = new KotaTableModel();
        model.sql.select.select(
            "DATEDIFF('" + date1String + "', '" + date2String + "') AS day"
        );
        model.sql.select.where("namaKota", "=", "Jakarta");
        ResultSet rs = model.sql.select.execute();
        
        try {            
            if (rs.next()) {
                day = rs.getInt("day");
            } else {
                // jika tidak ada Jakarta, ganti.
                System.out.println("Error: didalam getDifferenceBetweenTwoDate,"
                    + "Jakarta tidak ditemukan");
            }
        } catch (SQLException e) {
            System.out.println("Error inside `getDifferenceBetweenTwoDate`: "
                    + e.getMessage());
        }
        model.sql.getConnection().close(rs);
        
        return day;
    }
    
    public static String convertDateStringToAnotherformat(
            String dateString,
            String dateStringOldFormat,
            String dateStringNewFormat
    ) {
        String result = "";
        
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat(dateStringOldFormat, Locale.US);
            Date date = (Date) inputFormat.parse(dateString);
            SimpleDateFormat outputFormat = new SimpleDateFormat(dateStringNewFormat, Locale.US);
            result = outputFormat.format(date);
        } catch (ParseException e) {
            System.out.println("Error inside `parseDate`: "
                + e.getMessage());
        }
        return result;
    }
    
    public static String convertToMysqlDate(
            String dateString,
            String dateStringFormat
    ) {
        String mysqlDateFormat = "yyyy-MM-dd";
        return convertDateStringToAnotherformat(dateString, dateStringFormat, mysqlDateFormat);
    }
}
