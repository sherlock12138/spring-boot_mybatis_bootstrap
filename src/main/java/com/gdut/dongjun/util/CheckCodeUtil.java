package com.gdut.dongjun.util;


/**
 * @Title: CheckCodeUtil.java
 * @Package com.gdut.Netty_testing.dongjun.util
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月16日 下午2:47:29
 * @version V1.0
 */
public class CheckCodeUtil {

	/**
	 * 
	 * @Title: generate
	 * @Description: TODO
	 * @param @param source
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String generate(String source) {

		int sum = 0;
		source = source.replace(" ", "");
		for (int i = 0; i < source.length(); i = i + 2) {

			String tmp = source.substring(i, i + 2);// 将原串各个字节相加求和
			sum += Integer.parseInt(tmp, 16);// 16进制字符串转int
		}
		String checkCode = Integer.toHexString(sum % 256);
		if (checkCode.length() == 1)
			checkCode = "0" + checkCode;
		System.out.println("校验码： " + Integer.toHexString(sum % 256));
		return checkCode;
	}

	/**
	 * 
	 * @Title: check
	 * @Description: TODO
	 * @param @param hexString
	 * @param @param expect
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean check(String hexString, String expect) {

		if (generate(hexString).equalsIgnoreCase(expect))
			return true;
		else
			return false;
	}

//	@Test
//	public void test2() {
//
//		new CommUtil("COM4").excute("6801000000000668170104f316");
//
//		// 地址 010000000003
//		// 通讯地址 343333333336
//	}
//
//	// 68 01 00 00 00 00 03 68 11 04 02 02 02 00 EF 16
//	@Test
//	public void test() {
//		System.out.println(check("68010000000000681900",
//				"df"));
////		System.out.println(Integer.parseInt("5674", 16));
//
//	}
}
