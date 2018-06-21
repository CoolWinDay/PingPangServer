package com.pingpang.grade.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtils {
    public static String stringWithDate(Date date) {
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            return format.format(date);
        }
        return "";
    }
}
