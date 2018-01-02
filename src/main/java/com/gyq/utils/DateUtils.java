package com.gyq.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期处理.
 *
 * @auther gaoyaqiu
 */
public class DateUtils {

    private DateUtils(){}

    /**
     * 格式化时间
     *
     * @param time
     * @param fmt  ,fmt为空的时候，默认是yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatTime(Timestamp time, String fmt) {
        if (time != null) {
            if (fmt == null) fmt = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
            return myFormat.format(time);
        } else {
            return "";
        }
    }

    /**
     * 将string类型转换成Long类型
     *
     * @param strDateTime
     * @return
     */
    public static Long formatDateString(String strDateTime) throws ParseException {
        return formatDateString(strDateTime, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param strDateTime
     * @param fmt
     * @return
     * @throws ParseException
     */
    public static Long formatDateString(String strDateTime, String fmt) throws ParseException {
        if (strDateTime == null || "".equals(strDateTime)) {
            return null;
        } else {
            SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
            Date myDate = myFormat.parse(strDateTime.trim());
            return myDate.getTime();
        }
    }

    /**
     * 格式化 时间
     *
     * @param strDateTime
     * @return
     */
    public static Long formatDate(String strDateTime) throws ParseException {
        return formatDateString(strDateTime, "yyyy-MM-dd");
    }

    /**
     * 格式化毫秒数 时间
     *
     * @param time
     * @param fmt  fmt为空的时候，默认是yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatTime(Long time, String fmt) {
        return formatTime(getTime(time), fmt);
    }

    /**
     * 获取当前 时间
     *
     * @return
     */
    public static Timestamp getTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    public static Timestamp getTimefmt() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    public static Timestamp getTimeString() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取今天开始时间
     * yyyy-MM-dd 00:00:00
     *
     * @return
     */
    public static Timestamp getDateFirst() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取今天最后一秒时间
     * yyyy-MM-dd 23:59:59
     *
     * @return
     */
    public static Timestamp getDateLast() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取今天 日期
     *
     * @return
     */
    public static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 获取 今天的月份
     * 返回格式 yyyyMM
     *
     * @return
     */
    static String getMonth() {
        return formatDate(getTime(), "yyyyMM");
    }

    /**
     * 根据毫秒数 获取当前时间
     *
     * @param time
     * @return
     */
    static Timestamp getTime(Long time) {
        return new Timestamp(time);
    }

    /**
     * 根据毫秒数 格式化成 时间格式
     *
     * @param time
     * @param fmt
     * @return
     */
    public static String formatDate(Long time, String fmt) {
        return formatDate(getTime(time), fmt);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param fmt  ,fmt为空，默认是 yyyy-MM-dd
     * @return
     */
    public static String formatDate(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        if (fmt == null) fmt = "yyyy-MM-dd";
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(date);
    }

    /**
     * 和当前时间比较，简洁显示
     * 1小时之前，显示到分钟；24小时之前显示到小时；1个月前显示到天
     *
     * @param time
     * @return
     */
    static String simpleRangeTime(Long time) {
        Long cTime = getTime().getTime() - time;
        if (cTime < 60000l) return "刚刚";
        if (cTime < 3600000l) return Math.floor(cTime / (1000.0 * 60)) + "分钟前";
        if (cTime < 86400000l) return Math.floor(cTime / (1000.0 * 60 * 60)) + "小时前";
        if (cTime < 2592000000l) return Math.floor(cTime / (1000.0 * 60 * 60 * 24)) + "天前";
        else return "很久以前";
    }

    /**
     * 判断是否是48小时之前
     *
     * @param time
     * @return
     */
    public static Boolean beforeTime48h(Long time) {
        Long cTime = getTime().getTime() - time;
        return cTime < 172800000l;
    }

    public static Boolean beforeTime24h(Long time) {
        Long cTime = getTime().getTime() - time;
        return cTime < 86400000;
    }

    public static Boolean beforeTime1min(Long time) {
        Long cTime = getTime().getTime() - time;
        return cTime < 60000;
    }


	/**
     * 判断是否是指定毫秒之前的 (例如48小时之前)
     * @param time
     * @return
     */
    public static Boolean beforeTimeMills(Long time, Long specifyTime) {
        Long cTime = getTime().getTime() - time;
        return cTime < specifyTime;
    }


    /**
     * 转换成时间 字符串格式必须为 yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd
     *
     * @return
     * @throws ParseException
     */
    public static Date parseToDate(String val) throws ParseException {
        Date date = null;
        if (val != null && val.trim().length() != 0 && !val.trim().toLowerCase().equals("null")) {
            val = val.trim();
            if (val.length() > 10) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = sdf.parse(val);
            }
            if (val.length() <= 10) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(val);
            }
        }
        return date;
    }


    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的 00:00:00 时间
     *
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateFirst(String timeString) throws Exception {
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString, "yyyy-MM-dd");
        }
    }

    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的 23:59:59 时间
     *
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateLast(String timeString) throws Exception {
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 自定义格式的字符串转换成日期
     *
     * @param timeString
     * @param fmt
     * @return
     * @throws Exception
     */
    public static Timestamp getTime(String timeString, String fmt) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Timestamp.valueOf(myFormat.format(date));
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return myFormat.format(new Date());
    }

    /**
     * 获取当前时间戳(毫秒)
     * @return
     */
    public static Long getCurrentTimeMills(){
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间戳(秒)
     * @return
     */
    public static Long getCurrentTimeSecond(){
        return System.currentTimeMillis() / 1000;
    }

	/**
     * 获取系统当前时间 自定义格式
     * @param fmt 自定义格式
     * @return
     */
    public static String getDateTimeFormat(String fmt) {
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(new Date());
    }

	/**
	 * 获取七天前日期
	 * @return
	 * @throws ParseException
	 */
	public static Long getSevenDayAgoDateStr() throws Exception{

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, - 7);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTimeInMillis();
	}

    /**
     * 获取前N天的开始时间戳(毫秒)
     *
     * @param day 几天
     * @return
     */
    public static Long getDaysBeforeBeginTime(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, - day);

        return getResetTime(c.getTime(), 0, 0, 0).getTime();
    }

    /**
     * 获取重置指定日期的时分秒后的时间
     *
     * @param date
     *            指定日期
     * @param hour
     *            指定小时
     * @param minute
     *            指定分钟
     * @param second
     *            指定秒
     * @return 返回重置时分秒后的时间
     */
    public static Date getResetTime(Date date, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, minute);
        cal.set(Calendar.MINUTE, second);
        return cal.getTime();
    }

	/**
     * 获取重置指定日期的时分秒毫秒后的时间
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @param milliSecond
     * @return
     */
    public static Date getResetTime(Date date, int hour, int minute, int second, int milliSecond) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, minute);
        cal.set(Calendar.MINUTE, second);
        cal.set(Calendar.MILLISECOND, milliSecond);
        return cal.getTime();
    }

    /**
     * 返回指定日期的起始时间
     *
     * @param date
     *            指定日期（例如2014-08-01）
     * @return 返回起始时间（例如2014-08-01 00:00:00）
     */
    public static Date getIntegralStartTime(Date date) {
        return getResetTime(date, 0, 0, 0);
    }

    /**
     * 返回指定日期的结束时间
     *
     * @param date
     *            指定日期（例如2014-08-01）
     * @return 返回结束时间（例如2014-08-01 23:59:59）
     */
    public static Date getIntegralEndTime(Date date) {
        return getResetTime(date, 23, 59, 59);
    }

    /**
     * 获取时间date1与date2相差的秒数
     *
     * @param date1
     *            起始时间
     * @param date2
     *            结束时间
     * @return 返回相差的秒数
     */
    public static int getOffsetSeconds(Date date1, Date date2) {
        int seconds = (int) ((date2.getTime() - date1.getTime()) / 1000);
        return seconds;
    }

    /**
     * 获取时间date1与date2相差的分钟数
     *
     * @param date1
     *            起始时间
     * @param date2
     *            结束时间
     * @return 返回相差的分钟数
     */
    public static int getOffsetMinutes(Date date1, Date date2) {
        return getOffsetSeconds(date1, date2) / 60;
    }

    /**
     * 获取时间date1与date2相差的小时数
     *
     * @param date1
     *            起始时间
     * @param date2
     *            结束时间
     * @return 返回相差的小时数
     */
    public static int getOffsetHours(Date date1, Date date2) {
        return getOffsetMinutes(date1, date2) / 60;
    }

    /**
     * 获取时间date1与date2相差的天数数
     *
     * @param date1
     *            起始时间
     * @param date2
     *            结束时间
     * @return 返回相差的天数
     */
    public static int getOffsetDays(Date date1, Date date2) {
        return getOffsetHours(date1, date2) / 24;
    }

    /**
     * 获取前一个工作日
     *
     * @return 返回前一个工作日
     */
    public static Date getPrevWorkday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cal.add(Calendar.DAY_OF_MONTH, -2);
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        return getIntegralStartTime(cal.getTime());
    }

	/**
     * 获取前一天
     * @return
     */
    public static Date getPrevday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
        return getIntegralStartTime(cal.getTime());
    }

	/**
	 * long转date
	 * @param lg
	 * @return
	 */
	public static Date longToDate(Long lg) {
		return new Date(lg);
	}

	/**
	 * 加几天
	 * @param c
	 * @param days
	 * @return
	 */
	public static long plus(Calendar c, int days) {
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + days);
		return c.getTimeInMillis();
	}

	/**
     * 根据开始时间和结束时间返回时间段内的时间戳集合
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<Long> getDatesBetweenTwoDateTime(long beginDate, long endDate) {
        List<Long> resList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(longToDate(beginDate));

        while (beginDate <= endDate) {
            resList.add(beginDate);
            beginDate = beginDate+86400000;
        }

        return resList;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的日期集合
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<Date> getDaysBetweenTwoDateTime(Date beginDate, Date endDate) {
        List<Date> dateList = new ArrayList();
        dateList.add(beginDate);
        Calendar beginCalendar = Calendar.getInstance();

        beginCalendar.setTime(beginDate);        // 使用给定的 Date 设置此 Calendar 的时间
        Calendar calEnd = Calendar.getInstance();

        calEnd.setTime(endDate); // 使用给定的 Date 设置此 Calendar 的时间

        while (endDate.after(beginCalendar.getTime())) {      // 测试此日期是否在指定日期之后
            beginCalendar.add(Calendar.DAY_OF_MONTH, 1);     // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            dateList.add(beginCalendar.getTime());
        }

        return dateList;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的日期集合
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<Date> getDaysBetweenTwoLongTime(long beginDate, long endDate) throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String formate = "yyyy-MM-dd";

        String beginStringDate = formatTime(beginDate, formate);
        String endStringDate = formatTime(endDate, formate);

        Date beginDateDate = sdf.parse(beginStringDate);
        Date endDateDate = sdf.parse(endStringDate);

        List<Date> dateList = getDaysBetweenTwoDateTime(beginDateDate, endDateDate);

        return dateList;
    }

    /**
     * 获取一天的开始时间.
     *
     * @param millis
     * @return
     */
    public static long getDayStart(long millis) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(millis);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        return cal.getTimeInMillis();
    }


    /**
     * 获取一天的结束时间.
     *
     * @param millis
     * @return
     */
    public static long getDayEnd(long millis) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(millis);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,999);
        return cal.getTimeInMillis();
    }

    /**
     * 获取一周的开始时间.
     *
     * @param millis
     * @return
     */
    public static long getWeekStart(long millis) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(millis);

        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStart(cal.getTimeInMillis());
    }

    /**
     * 获取一周的结束时间.
     *
     * @param millis
     * @return
     */
    public static long getWeekEnd(long millis) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(getWeekStart(millis));
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return getDayEnd(cal.getTimeInMillis());
    }

    /**
     * 获取一个月的结束时间.
     *
     * @param millis
     * @return
     */
    public static long getMonthEnd(long millis) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(millis);
        int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH,day);
        return getDayEnd(cal.getTimeInMillis());
    }

    /**
     * 获取一个年的结束时间.
     *
     * @param millis
     * @return
     */
    public static long getYearEnd(long millis) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(millis);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,999);
        return cal.getTimeInMillis();
    }

    /**
     * 获取某个季度的结束时间.
     *
     * @param millis
     * @return
     */
    public static long getSeasonEnd(long millis) {
        final int[] SEASON = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 1);
        return getMonthEnd(cal.getTimeInMillis());
    }
}
