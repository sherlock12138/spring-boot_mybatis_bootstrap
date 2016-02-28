package com.gdut.dongjun.util;

import java.util.List;

import net.sf.json.JSONArray;

public class JsonUtil {

	public static String toJsonString(@SuppressWarnings("rawtypes") List list) {
		JSONArray jsonObject = JSONArray.fromObject(list);
		return jsonObject.toString();
	}
}
