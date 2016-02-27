package com.gdut.dongjun.util;


/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureUtil.java
 * @description	管控协议工具类
 * @Date 2015年11月18日 下午8:24:39 
 * @version V1.0
 */
public class ControlMearsureDeviceCommandUtil {

	private static final String BEGIN_BIT = "68"; //	起始位，间隔位
	private static final String SPACE_BIT = "00"; //空格位
	private static final String END_BIT = "16"; //结束符
	private static final String DEFAULT_DATA = "00080000000000000000";	//默认帧数据
	
	/**
	 * @description	生成管控报文
	 * @param functionCode	功能码
	 * @param address	发送到从站的地址	
	 * @param data	数据位
	 * @return	TODO
	 */
	public static String getTotalMessage(String functionCode, String address, String data) {
		address = disposeSpace(address);
		data = disposeSpace(data);
		StringBuffer messageWithoutCRC = new StringBuffer().append(BEGIN_BIT).append(SPACE_BIT).append(SPACE_BIT).
				append(SPACE_BIT).append(SPACE_BIT).append(address).append(BEGIN_BIT).
				append(functionCode).append(data);
		return messageWithoutCRC.append(getCRCCode(messageWithoutCRC.toString())).
				append(END_BIT).toString();
	}

	/**
	 * @description	生成管控报文
	 * @param functionCode	功能码
	 * @param address	发送到从站的地址
	 * @return	TODO
	 */
	public static String getTotalMessage(String functionCode, String address) {
		return getTotalMessage(functionCode, address, DEFAULT_DATA);
	}

	/**
	 * @description 消除字符串中的空格
	 * @param address	需要进行处理的字符串
	 * @return	TODO
	 */
	private static String disposeSpace(String message) {
		return message.replace(" ", "");
	}

	/**
	 * @description	获取CRC验证位
	 * @param messageWithoutCRC	CRC验证码之前的报文
	 * @return	TODO
	 */
	private static String getCRCCode(String messageWithoutCRC) {
		long result = 0x00;
		String[] addStr = cutString(2, messageWithoutCRC);
		for(String str : addStr) {
			result += Long.parseLong(str, 16);
		}
		return Long.toHexString(result).substring(Long.toHexString(result).length() - 2, 
				Long.toHexString(result).length()).toUpperCase();
	}

	/**
	 * @description	将字符串进行切割
	 * @param digit	每段字符串的长度
	 * @param preString	需要处理的字符串
	 * @return
	 */
	public static String[] cutString(int digit, String preString) {
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
}
