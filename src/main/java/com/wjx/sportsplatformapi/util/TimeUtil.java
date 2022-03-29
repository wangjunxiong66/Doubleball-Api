package com.wjx.sportsplatformapi.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {

    //  获取当前时间
    public String CurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        return date;
    }

    // 获取指定天数之后的日期
    public String DayLater( int num){
        Calendar calendar = new GregorianCalendar() ;
        calendar.setTime(new Date());
        calendar.add(calendar.DATE, num );
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String dayLater = sdf.format(calendar.getTime());
        return dayLater;
    }

}
