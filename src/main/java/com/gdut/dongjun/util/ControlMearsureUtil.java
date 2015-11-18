package com.gdut.dongjun.util;

import org.junit.Test;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureUtil.java
 * @description	
 * @Date 2015年11月18日 下午8:24:39 
 * @version V1.0
 */
public class ControlMearsureUtil {

	public static final String BEGIN_BIT = "68"; //	起始位，间隔位
	public static final String SPACE_BIT = "00"; //空格位
	public static final String END_BIT = "16"; //结束符
	
	private String functionBit; //功能位
	private String dataBit;	//数据位
	private String messageWithoutCRC;

	
	public static String getCRCCode(String messageWithoutCRC) {
		long result = 0x00;
		String[] addStr = messageWithoutCRC.split(" ");
		for(String str : addStr) {
			result += Long.parseLong(str, 16);
		}
		return Long.toHexString(result).substring(Long.toHexString(result).length() - 2, 
				Long.toHexString(result).length()).toUpperCase();
	}

	public static String[] CutString(int digit, String preString) {
		if(preString.length() % digit != 0 || digit < 0 
				|| preString.length() == 0) {
			throw new NumberFormatException("CutString"
					+ "(int digit, String preString)"
					+ "发生不整除切割错误");
		}
		
		int length = preString.length();
		String[] result = new String[length / digit];
		
		for(int i = 0, j = 0; j < length; j += digit, i++) {
			result[i] = preString.substring(j, j + digit);
		}
		return result;
	}

	@Test
	public void testOne() {
		System.out.println(ControlMearsureUtil.getCRCCode("68 02 68 08 68 02 68 08"));
		System.out.println(Long.parseLong("da", 16));
	}
	
}
