package com.blue.eyes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liuhai
 * @date 2018-10-11 14:47
 * @description 日期工具类
 */
public class DateUtil {

    /**
     * String转date
     * @param sdate
     * @param pattern
     * @return
     */
    public static Date stringToDate(String sdate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * date转string
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取前几个月所有的月份
     *
     * @param curDate    当前月份，格式：yyyyMM
     * @param step       获取前几个月长度，前 3 个月就输入 3
     * @param includeCur 是否包含当前月份（1：包含，0：不包含）
     * @param format     返回的月份格式
     * @return
     */
    public static List<String> getBeforeMonths(String curDate, int step, int includeCur, String format) {
        List<String> monthes = new ArrayList<String>();
        if (includeCur == 1) {
            monthes.add(getBeforeMonth(curDate, 0, format));
        }
        for (int i = 1; i <= step; i++) {
            monthes.add(getBeforeMonth(curDate, i, format));
        }
        return monthes;
    }

    /**
     * 获取月份前第几个月的月份
     *
     * @param curDate 当前月
     * @param step    获取前第几个月，前第 3 个月就输入 3
     * @param format  返回的月份格式
     * @return
     */
    public static String getBeforeMonth(String curDate, int step, String format) {
        Date date = stringToDate(curDate, format);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -step);
        String fromDate = sdf.format(cal.getTime());
        return fromDate;
    }

    /**
     * 获取时间段内的所有月份
     * @param startDate 起始时间，格式 yyyyMM
     * @param endDate   截至时间，格式 yyyyMM
     * @param format    返回的月份格式
     * @return
     */
    public static List<String> getBetweenMonths(String startDate, String endDate, String format) {
        List<String> monthes = new ArrayList<String>();
        //开始年份
        int startYear = Integer.valueOf(startDate.substring(0, 4));
        //开始月份
        int startMonth = Integer.valueOf(startDate.substring(4, 6));
        //截至年份
        int endYear = Integer.valueOf(endDate.substring(0, 4));
        //截至月份
        int endMonth = Integer.valueOf(endDate.substring(4, 6));

        //同年份
        if (startYear == endYear) {
            addMonth(monthes, startMonth, endMonth, startYear);
        } else {
            //不同年份
            for (int year = startYear; year <= endYear; year++) {
                if (year == startYear) {
                    addMonth(monthes, startMonth, 12, year);
                } else if (year == endYear) {
                    addMonth(monthes, 1, endMonth, year);
                } else {
                    addMonth(monthes, 1, 12, year);
                }
            }
        }
        return monthes;
    }

    /**
     * 添加月份（同年）
     * @param monthes    月份集合
     * @param startMonth 起始月份
     * @param endMonth   终止月份
     * @param year       年份
     */
    private static void addMonth(List<String> monthes, int startMonth, int endMonth, int year) {
        String month = "";
        for (int i = startMonth; i <= endMonth; i++) {
            month = i + "";
            if (i < 10) {
                month = "0" + month;
            }
            monthes.add(year + "" + month);
        }
    }

    /**
     * 当月帐期
     * @param i
     * @return
     */
    public static String dateTime(int i) {
        //当前月份
        SimpleDateFormat date = new SimpleDateFormat("yyyyMM");
        //当前几号
        SimpleDateFormat date1 = new SimpleDateFormat("dd");
        //判断当前时间是否大于5号 大于等于取本月帐期  小于取上月
        int time = Integer.parseInt(date1.format(new Date()));
        if (time >= i) {
            return date.format(new Date());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // calendar.add(Calendar.YEAR, -1);//当前时间减去一年，即一年前的时间    
        calendar.add(Calendar.MONTH, -1);//当前时间前去一个月，即一个月前的时间  
        return date.format(calendar.getTime());
    }

    /**
     * 返回日期月份,当前日期往后推6个月
     * @param data  日期   new Date()
     * @param month 月份   6月份
     * @return
     */
    public static Date getDateMonth(Date data, int month) {
        if (data != null && month > 0) {
            Calendar c = Calendar.getInstance();
            c.setTime(data);
            c.add(Calendar.MONTH, month);
            return c.getTime();
        }
        return null;
    }

    public static boolean sameDate(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        //fmt.setTimeZone(new TimeZone()); // 如果需要设置时间区域，可以在这里设置
        return fmt.format(d1).equals(fmt.format(d2));
    }

    /**
     * 获取time毫秒后的时间
     * @param time
     * @return
     */
    public static Date getDate(int time, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, time);
        return calendar.getTime();
    }

    /**
     * 获取两个日期之间间隔月数
     * @param startDate 较小的日期
     * @param endDate 较大的日期
     * @return
     */
    public static Integer getIntervalMonth(Date startDate, Date endDate){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(endDate);
        c2.setTime(startDate);
        if(c1.getTimeInMillis() < c2.getTimeInMillis()){
            return 0;
        }
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
        int yearInterval = year1 - year2;        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2){
            yearInterval --;        // 获取月数差值
        }
        int monthInterval =  (month1 + 12) - month2  ;
        if(day1 < day2){
            monthInterval --;
        }
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }

    /**
     * mongo 日期查询isodate
     * @param dateStr
     * @return
     */
    public static Date dateToISODate(String dateStr){
        Date date;
        //T代表后面跟着时间，Z代表UTC统一时间
        if(dateStr.length() == 10){
            date = stringToDate(dateStr, "yyyy-MM-dd");
        }else if(dateStr.length() == 13){
            date = stringToDate(dateStr, "yyyy-MM-dd HH");
        }else if(dateStr.length() == 16){
            date = stringToDate(dateStr, "yyyy-MM-dd HH:mm");
        }else{
            date = stringToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        }
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
        String isoDate = format.format(date);
        try {
            return format.parse(isoDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
