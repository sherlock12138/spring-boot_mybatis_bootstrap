package com.gdut.dongjun.service.impl.enums;

public enum HighCommandControlCode {
	PRE_OPEN_SWITCH("0","600181","预置分闸"),OPEN_SWITCH("1","600101","分闸"),
	PRE_CLOSE_SWITCH("2","600182","预置合闸"),CLOSE_SWITCH("3","600102","合闸"),
	PRE_CONTROL("4","73","预置控制域"),CONTROL("5","53","控制域"),COMMAND("6","2E010601","双点命令"),
	READ_VOLTAGE_CURRENT("7","64010601","总站激活");
	private String sign;// 标示
	private String code;// 16进制代码
	private String statement;// 说明

	private HighCommandControlCode(String sign, String code, String statement) {
		this.sign = sign;
		this.code = code;
		this.statement = statement;
	}
	public static HighCommandControlCode valueOf(int sign) {

		switch (sign) {
		case 0:
			return PRE_OPEN_SWITCH;
		case 1:
			return OPEN_SWITCH;
		case 2:
			return PRE_CLOSE_SWITCH;
		case 3:
			return CLOSE_SWITCH;
		case 4:
			return PRE_CONTROL;
		case 5:
			return CONTROL;
		}
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code;
	}
	
//	public static void main(String[] args) {
//		System.out.println(HighCommandControlCode.CLOSE_SWITCH.toString());
//	}

}
