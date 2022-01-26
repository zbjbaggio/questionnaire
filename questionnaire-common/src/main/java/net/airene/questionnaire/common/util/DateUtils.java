package net.airene.questionnaire.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public final static String CHINA_LOCALE = "zh";

    public final static String CHINA_TIME_ZONE = "GMT+8";

    public final static String YEARFORMAT = "yyyy";
    public final static String VERIFYFORMAT = "yyyy-MM";
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATEFORMAT_ = "yyyy/MM/dd";
    public final static String SECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String MINUTE_FORMAT = "yyyy-MM-dd HH:mm:00";
    public final static String HOUR_FORMAT = "yyyy-MM-dd HH:00:00";
    public final static String MYSQL_TIMEFORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public final static String CRON_FORMAT = "ss mm HH dd MM ? yyyy";
    public final static String COMPACT = "yyMMddHHmmss";
    public final static String DATE_CODE = "yyMMdd";
    public final static String DATE_年月日 = "yyyy年M月dd日";
    public final static String DATEFORMAT_MMdd = "MMdd";
    public final static String DATE_月日时分 = "MM月dd日 HH:mm";

    private final static int IMPORTEXCELMONTH = 3;

    private final static String[] WEEK_DAYS_NAME = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    private final static String[] WEEK_DAYS_CODE = {"Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat"};

    /**
     * 30天
     */
    public final static int DAYS_30 = 30;

    public static Date format(String strDate) {
        return format(strDate, SECOND_FORMAT);
    }

    public static Date format(String strDate, String format) {
        if (StringUtils.isNotBlank(strDate)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return sdf.parse(strDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static long between(Date endDate, Date startDate , int calendarType) throws ParseException {
        String format = SECOND_FORMAT;
        long divisor = 1;
        if (calendarType == Calendar.DATE) {
            format = DATE_FORMAT;
            divisor = 86400000L;
        } else if (calendarType == Calendar.HOUR) {
            format = HOUR_FORMAT;
            divisor = 3600000L;
        } else if (calendarType == Calendar.SECOND) {
            divisor = 1000L;
        } else if (calendarType == Calendar.MINUTE) {
            format = MINUTE_FORMAT;
            divisor = 60000L;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        long startDateLong = startDate.getTime();
        long endDateLong = endDate.getTime();
        return (endDateLong - startDateLong) / divisor;
    }
}
