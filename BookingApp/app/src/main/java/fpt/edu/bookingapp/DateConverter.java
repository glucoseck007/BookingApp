package fpt.edu.bookingapp;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class DateConverter {
    static SimpleDateFormat spfDate = new SimpleDateFormat("dd-MM-yyyy");
    static SimpleDateFormat spfDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static Date toDate(String date) throws ParseException {
        // chuyển kiểu String -> Date
        return spfDate.parse(date);
    }

    public static String toStringDate(Date date){
        // chuyển kiểu Date -> String
        return spfDate.format(date);
    }

    public static Date toDateTime(String dateTime) throws ParseException {
        // chuyển kiểu String -> DateTime
        return spfDateTime.parse(dateTime);
    }

    public static String toStringDateTime(Date dateTime){
        // chuyển kiểu DateTime -> String
        return spfDateTime.format(dateTime);
    }
}
