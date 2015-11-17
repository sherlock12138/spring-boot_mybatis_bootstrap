package com.gdut.dongjun.service.impl.enums;

/**
 * @Title: CommandControlCode.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 上午12:12:43
 * @version V1.0
 */
public enum CommandControlCode {

	REMAIN("00", "保留"), BROADCAST("08", "广播校时"), READ("11", "读数据"), READ_FALLOW(
			"12", "读后续数据"), READ_COMMUNICATE_ADDRESS("13", "读通信地址"), WRITE(
			"14", "写数据"), WRITE_FALLOW("15", "写后续数据"), CHANGE_COMMUNICATE_RATE(
			"17", "修改通信速率"), CHANGE_PASSWORD("18", "修改密码"), QUERY_DEVICE_WORNING(
			"19", "查询设备报警"), RESPOND_DEVICE_WORNING("1A", "响应设备报警"), CLEAR_EVENT(
			"1B", "事件清零"), CONTROL_DEVICE("1C", "控制设备");

	private String code;// 16进制代码
	private String statement;// 说明

	private CommandControlCode(String code, String statement) {
		this.code = code;
		this.statement = statement;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code;
	}
}