package com.gdut.dongjun.util;

import org.junit.Test;

/**
 * @Title: HexString_BytesUtil.java
 * @Package com.gdut.Netty_testing.dongjun.util
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月12日 下午4:10:57
 * @version V1.0
 */
public class HexString_BytesUtil {
	/**
	 * 
	 * @Title: bytesToHexString
	 * @Description: TODO
	 * @param @param src
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 
	 * @Title: hexStringToBytes
	 * @Description: TODO
	 * @param @param hexString
	 * @param @return
	 * @return byte[]
	 * @throws
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	
	/**
	 * 
	 * @Title: hexStringToByteStringsf
	 * @Description: TODO
	 * @param @param hexString
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String hexStringToByteString(String hexString) {

		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		char[] hexChars = hexString.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hexChars.length; i++) {
			sb.append(Integer.toBinaryString(charToByte(hexChars[i])));
		}
		return sb.toString();
	}
	
	@Test
	public void t(){
		
		hexStringToByteString("0f");
	}
	

	/**
	 * 
	 * @Title: charToByte
	 * @Description: TODO
	 * @param @param c
	 * @param @return
	 * @return byte
	 * @throws
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
}
