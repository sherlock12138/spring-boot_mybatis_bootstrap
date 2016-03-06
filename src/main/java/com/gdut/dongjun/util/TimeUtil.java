package com.gdut.dongjun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	private static final String standardPattern = "yyyy-MM-dd HH:mm";

	public static final String timeFormat(Date date) {
		
		return timeFormat(date, null);
	}
	
	public static String timeFormat(Date date, String pattern) {
		
		SimpleDateFormat format;
		if(pattern == null) {
			format = new SimpleDateFormat(standardPattern);
		} else {
			format = new SimpleDateFormat(pattern);
		}
		return format.format(date);
	}
	
	public static Date timeParse(String source) {
		
		return timeParse(source, null);
	}
	
	public static Date timeParse(String source, String pattern) {
		
		SimpleDateFormat format = null;
		if(pattern == null) {
			format = new SimpleDateFormat(standardPattern);
		} else {
			format = new SimpleDateFormat(pattern);
		}
		
		try {
			return format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
