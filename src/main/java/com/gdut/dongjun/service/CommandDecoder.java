package com.gdut.dongjun.service;

/**
 * @Title: CommandDecoder.java
 * @Package com.gdut.dongjun.service
 * @Description: 将16进制的字符串逆置，并转为十进制 多用于标示符，数据域的解码
 * 
 *               notice ： 地址域只需要进行逆置即可
 * @author Sherlock-lee
 * @date 2015年8月8日 下午6:15:54
 * @version V1.0
 */
public interface CommandDecoder {

	/**
	 * 
	 * @Title: decode
	 * @Description: TODO
	 * @param @param data
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String decode(String data);

	/**
	 * 
	 * @Title: decodeAddress
	 * @Description: 解析地址
	 * @param @param data
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String decodeAddress(String data);
}
