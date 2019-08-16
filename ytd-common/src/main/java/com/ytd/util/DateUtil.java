package com.ytd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期转换工具
 */
public class DateUtil {

	public static final String DATE_PATTON_YYYY_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_FORMAT_YYYY_MM_dd_HH_mm_ss = "yyyy年MM月dd日 HH:mm:ss";
	
	public static final String DATE_PATTON_YYYY_MM_dd = "yyyy-MM-dd";

	public static final String DATE_FORMAT_YYYY_MM_dd = "yyyy年MM月dd日";
	
	public static final String DATE_PATTON_YYYYMMdd = "yyyyMMdd";

	public static final String DATE_PATTON_HHmmss = "HHmmss";
	
	/**
	 * string转date  yyyy-MM-dd HH:mm:ss
	 * @param dateValue : 时间字符串
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 * @return Date
	 */
	public static Date parseDateTime(String dateValue) {	// TODO	string转date  yyyy-MM-dd HH:mm:ss
		Date resultDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_YYYY_MM_dd_HH_mm_ss);
			resultDate = sdf.parse(dateValue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}
	
	/**
	 * string转date  yyyy-MM-dd HH:mm:ss
	 * @param date : 日期
	 * @param time : 时间
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 */
	public static Date parseDateTime(String date,String time) {	// TODO	string转date  yyyy-MM-dd HH:mm:ss
		Date resultDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_YYYY_MM_dd_HH_mm_ss);
			String y = date.substring(0,4);		
			String M = date.substring(4,6);		
			String d = date.substring(6,8);		
			String H = time.substring(0,2);		
			String m = time.substring(2,4);		
			String s = time.substring(4,6);		
			String operationTime = y + "-" + M + "-" + d + " " + H + ":" + m + ":" + s;
			resultDate = sdf.parse(operationTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}
	
	/**
	 * date转string  yyyy-MM-dd HH:mm:ss
	 * @param dateValue : 时间戳
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 * @return string
	 */
	public static String formatDateTime(Date dateValue) {	// TODO	date转string  yyyy-MM-dd HH:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_YYYY_MM_dd_HH_mm_ss);
		return sdf.format(dateValue);
	}

	/**
	 * date转string  yyyyMMdd
	 * @param dateValue : 时间戳
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 * @return string
	 */
	public static String format_YYYYMMdd(Date dateValue) {	// TODO	date转string  yyyyMMdd
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_YYYYMMdd);
		return sdf.format(dateValue);
	}
	
	/**
	 * string转date  yyyyMMdd
	 * @param dateValue : 时间戳
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 */
	public static Date pase_YYYYMMdd(String dateValue) {	// TODO string转date  yyyyMMdd
		Date parse = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_YYYYMMdd);
		try {
			parse = sdf.parse(dateValue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}
	
	/**
	 * date转string  yyyy-MM-dd
	 * @param dateValue : 时间戳
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 * @return string
	 */
	public static String format_YYYY_MM_dd(Date dateValue) {	// TODO	date转string  yyyy-MM-dd
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_YYYY_MM_dd);
		return sdf.format(dateValue);
	}
	
	/**
	 * date转date  yyyy-MM-dd
	 * @param dateValue : 时间戳
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 * @return Date
	 */
	public static Date pase_YYYY_MM_dd(Date dateValue) {	// TODO	date转date  yyyy-MM-dd
		Date parse = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_YYYY_MM_dd);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateValue);
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DATE);
		String ymd = y + "-" + m + "-" + d;
		try {
			parse = sdf.parse(ymd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}
	
	/**
	 * 获取年月日	yyyyMMdd
	 * @author wfl  
	 * @date 2018年8月27日 上午11:18:43
	 */
	public static String getDate() {	// TODO	获取年月日	yyyyMMdd
		SimpleDateFormat sf = new SimpleDateFormat(DATE_PATTON_YYYYMMdd);
		return sf.format(new Date());
	}

	/**
	 * 获取时分秒   HHmmss
	 * @author wfl  
	 * @date 2018年8月27日 上午11:18:10
	 */
	public static String getTime() {	// TODO 获取时分秒   HHmmss
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTON_HHmmss);
		return sdf.format(new Date());
	}
	
	/**
	 * date转string  yyyy年MM月dd日 HH:mm:ss
	 * @param date : 时间戳
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 * @return string
	 */
	public static String getFormat_YYYY_MM_dd_HH_mm_ss(Date date) {	// TODO date转string  yyyy年MM月dd日 HH:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_dd_HH_mm_ss);
		return sdf.format(date);
	}

	/**
	 * date转string  yyyy年MM月dd日
	 * @param date : 时间戳
	 * @author wfl  
	 * @date 2018年8月24日 下午1:32:29
	 * @return string
	 */
	public static String getFormat_YYYY_MM_dd(Date date) {	// TODO date转string  yyyy年MM月dd日
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_dd);
		return sdf.format(date);
	}
    
	/**
	 * 取得指定日期N天后的日期
	 * @description	1.date ：原日期	2.days ： 天数
	 * @author wfl  
	 * @date 2018年8月27日 上午11:15:26
	 */
	public static Date addDays(Date date, Integer days) {	// TODO 取得指定日期N天后的日期
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}
	
	/**
	 * 取得指定日期N月后的日期
	 * @description	1.date ：原日期	2.months ： 月数
	 * @author wfl  
	 * @date 2018年8月27日 上午11:15:26
	 */
	public static Date addMonths(Date date, Integer months) {	// TODO 取得指定日期N月后的日期
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * 加年份
	 * @description 1.date ：时间  2.count ：需要增加的数量
	 * @author wfl
	 * @date 2018年1月12日 下午2:27:23
	 */
	public static Date addYear(Date date, int count) {	// TODO 加年份
		String fmt_day = null;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		int year = cal1.get(Calendar.YEAR);
		int fmt_year = year + count;
		int month = cal1.get(Calendar.MONTH) + 1;
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		if (month == 2 && day == 29) {
			fmt_day = "28";
		} else {
			fmt_day = day + "";
		}
		int fmt_H = cal1.get(Calendar.HOUR_OF_DAY);
		int fmt_m = cal1.get(Calendar.MINUTE);
		int fmt_s = cal1.get(Calendar.SECOND);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fmt_date = fmt_year +"-"+ month +"-"+ fmt_day +" "+ fmt_H +":"+ fmt_m +":"+ fmt_s;
		try {
			date = sdf.parse(fmt_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 判断两个时间之间相差的 天、小时、分钟、秒
	 * @description date1 - date2
	 * @author wfl
	 * @date 2018年1月12日 下午2:27:23
	 * @return day ：共计天数，HH ： 共计小时数，mm ： 共计分钟数 ss ： 共计秒数
	 */
	public static Map<String, Integer> getDateDistance(Date date1, Date date2) {	// TODO 判断两个时间之间相差的 天、小时、分钟、秒
		Map<String, Integer> map = new HashMap<String, Integer>();
		int day = (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));// 共计天数
		map.put("day", day);
		int ss = (int) ((date1.getTime() - date2.getTime()) / (1000)); // 共计秒数
		map.put("ss", ss);
		int mm = (int) ss / 60; // 共计分钟数
		map.put("mm", mm);
		int HH = (int) ss / 3600; // 共计小时数
		map.put("HH", HH);
		return map;
	}
}