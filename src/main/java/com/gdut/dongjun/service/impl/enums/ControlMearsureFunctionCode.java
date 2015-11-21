package com.gdut.dongjun.service.impl.enums;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureFunctionCode.java
 * @description	管控协议功能码枚举类
 * @Date 2015年11月19日 上午11:21:58 
 * @version V1.0
 */
public enum ControlMearsureFunctionCode {
	
	COUNT_DATA_REQUEST("03", "统计数据召测"), COUNT_DATA_RESPONSE("83", "统计数据应答"),
	RECENTLY_DATA_REQUEST("00", "实时数据召测"),RECENTLY_DATA_RESPONSE("80", "实时数据应答"),
	INTEGER_DATA_REQUEST("01", "整点数据召测"), INTERGER_DATA_RESPONSE("81", "整点数据应答"),
	EVENT_REQUEST("04", "事件数据召测"), EVENT_RESPONSE("84", "事件数据应答"),
	BOARDCAST("ff", "广播报时");
	
	private String code;
	private String statement;
	
	private ControlMearsureFunctionCode(String code, String statement) {
		this.code = code;
		this.statement = statement;
	}
	
	@Override
	public String toString() {
		return this.code;
	}
}
