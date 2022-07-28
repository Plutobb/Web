package com.example.mopo.Utils;

import java.text.SimpleDateFormat;

public class TimeUtil {
    public static String getNowTime(){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }
}
