package com.gdut.dongjun.util;

import java.lang.reflect.Field;

/**
 *@Author link xiaoMian <972192420@qq.com>
 *@ClassName GenericUtil.java
 *@Time 2016年3月6日下午4:32:54
 *@Description TODO
 *@Version 1.0 Topview
 */
public class GenericUtil {

	public static <T> Integer getPrivatyIntegerValue(T t, String column) {
		
		return Integer.valueOf(getPrivateObjectValue(t, column).toString());
	}
	
	public static <T> Object getPrivateObjectValue(T t, String column) {
		
		Field field = null;
		try {
			field = t.getClass().getDeclaredField(column);
			field.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		try {
			return field.get(t);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}
