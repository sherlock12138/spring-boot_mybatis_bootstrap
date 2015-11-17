package com.gdut.dongjun.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: MyBatisMapUtil.java
 * @Package com.gdut.dongjun.util
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月8日 下午2:50:42
 * @version V1.0
 */
public class MyBatisMapUtil {

	/**
	 * 
	 * @Title: warp
	 * @Description: TODO
	 * @param @param map
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	public static Map<String, Object> warp(Map<String, Object> map) {

		return doWarp(map);
	}

	/**
	 * 
	 * @Title: warp
	 * @Description: TODO
	 * @param @param key
	 * @param @param value
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	public static Map<String, Object> warp(String key, Object value) {

		return doWarp(MapUtil.warp(key, value));
	}

	/**
	 * 
	 * @Title: doWarp
	 * @Description: TODO
	 * @param @param map
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	private static Map<String, Object> doWarp(Map<String, Object> map) {

		Map<String, Object> xx = new HashMap<String, Object>();
		xx.put("map", map);
		return xx;
	}

}
