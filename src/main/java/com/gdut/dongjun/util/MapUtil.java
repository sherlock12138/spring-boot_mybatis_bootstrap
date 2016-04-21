package com.gdut.dongjun.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 上午3:00:50
 * @see TODO
 * @since 1.0
 */
public class MapUtil {

	public static final Map<String, Object> SUCCESS = MapUtil.warp("success", true);
	public static final Map<String, Object> ERROR = MapUtil.warp("success", false);
	/**
	 * 
	 * @Title: wrap
	 * @Description: TODO
	 * @param @param key
	 * @param @param value
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	public static Map<String, Object> warp(String key, Object value) {

		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		return map;
	}

}
