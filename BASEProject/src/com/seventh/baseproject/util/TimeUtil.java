package com.seventh.baseproject.util;

import java.util.TimeZone;

import hirondelle.date4j.DateTime;

/**
 * 时间工具类
 * @author gr
 *
 */
public class TimeUtil {
	/**
	 * yyyyMMdd
	 */
	public static final String DATEFORMAT_1_1 = "YYYYMMDD";
	/**
	 * yyyyMMdd HH:mm
	 */
	public static final String DATEFROMAT_1_2 = "YYYYMMDD hh:mm";
	/**
	 * yyyyMMdd HH:mm:ss
	 */
	public static final String DATEFROMAT_1_3 = "YYYYMMDD hh:mm:ss";
	
	/**
	 * yyyy-MM-dd
	 */
	public static final String DATEFORMAT_2_1 = "YYYY-MM-DD";
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String DATEFROMAT_2_2 = "YYYY-MM-DD hh:mm";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATEFROMAT_2_3 = "YYYY-MM-DD hh:mm:ss";
	
	/**
	 * yyyy_MM_dd
	 */
	public static final String DATEFORMAT_3_1 = "YYYY_MM_DD";
	/**
	 * yyyy_MM_dd HH:mm
	 */
	public static final String DATEFROMAT_3_2 = "YYYY_MM_DD hh:mm";
	/**
	 * yyyy_MM_dd HH:mm:ss
	 */
	public static final String DATEFROMAT_3_3 = "YYYY_MM_DD hh:mm:ss";
	
	
	
	/**
	 * 获取当前时间(mS)
	 * @return
	 */
	public static long getNowTimemS(){
		return 0;
	}
	
	/**
	 * 获取当前时间(S)
	 * @return
	 */
	public static long getNowTimeS(){
		return 0;
	}
	
	/**
	 * 获取当前时间(DateTime)
	 * @return<br/>
	 * 0000-00-00 00:00:00.000000000
	 */
	public static DateTime getNowDateTime(){
		return DateTime.now(TimeZone.getDefault());
	}
}
