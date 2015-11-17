package com.gdut.dongjun.service.impl.enums;

/**
 * @Title: HitchEvent.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 下午12:34:48
 * @version V1.0
 */
public enum HitchEvent {

	NORMAL_RUNNING("0", "00000", "正常运行"), REMAIN_CURRENT("1", "00010", "剩余电流"), LACK_ZERO(
			"2", "00100", "缺零"), OVER_LOAD("3", "00101", "过载"), SHORT("4",
			"00110", "短路"), LACK_PHASE("5", "00111", "缺相"), UNDER_VOLTAGE("6",
			"01000", "欠压"), OVER_VOLTAGE("7", "01001", "过压"), LANDING("8",
			"01010", "接地"), POWER_CUT("9", "01011", "停电"), TIMING_TEST("10",
			"01100", "定时试验"), REMOTE("11", "01101", "远程"), INTER_LOCK("12",
			"01111", "闭锁"), MANUAL("13", "10010", "手动"), TRANSFORMER_HITCH(
			"14", "10000", "互感器故障"), CLOSE_SWITCH_FAILURE("15", "10001", "合闸失败"), SETTING_CHANGE(
			"16", "10011", "设置失败");

	private String sign;// 标示
	private String code;// 16进制代码
	private String statement;// 说明

	private HitchEvent(String sign, String code, String statement) {
		this.sign = sign;
		this.code = code;
		this.statement = statement;
	}

	/**
	 * 
	 * @Title: valueOf
	 * @Description: TODO
	 * @param @param sign
	 * @param @return
	 * @return EventVariable
	 * @throws
	 */
	public static HitchEvent define(String code) {

		switch (code) {
		case "00000":
			return NORMAL_RUNNING;
		case "00010":
			return REMAIN_CURRENT;
		case "00100":
			return LACK_ZERO;
		case "00101":
			return OVER_LOAD;
		case "00110":
			return SHORT;
		case "00111":
			return LACK_PHASE;
		case "01000":
			return UNDER_VOLTAGE;
		case "01001":
			return OVER_VOLTAGE;
		case "01010":
			return LANDING;
		case "01011":
			return POWER_CUT;
		case "01100":
			return TIMING_TEST;
		case "01101":
			return REMOTE;
		case "01111":
			return INTER_LOCK;
		case "10010":
			return MANUAL;
		case "10000":
			return TRANSFORMER_HITCH;
		case "10001":
			return CLOSE_SWITCH_FAILURE;
		case "10011":
			return SETTING_CHANGE;

		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code;
	}

	public int value() {
		// TODO Auto-generated method stub
		return Integer.parseInt(sign);
	}

}