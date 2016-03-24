package com.gdut.dongjun.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *@Author link xiaoMian <972192420@qq.com>
 *@ClassName EncoderUtil.java
 *@Time 2016年3月3日下午8:55:37
 *@Description TODO
 *@Version 1.0 Topview
 */
public class EncoderUtil {

	public static String getUrlEncode(String text) {
		
		try {
			return URLEncoder.encode(text, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
