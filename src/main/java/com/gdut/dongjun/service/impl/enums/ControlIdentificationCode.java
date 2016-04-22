package com.gdut.dongjun.service.impl.enums;

/**
 * @Title: ControlIdentificationCode.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 上午11:24:38
 * @version V1.0
 */
public enum ControlIdentificationCode {

	OPEN_SWITCH("0", "06 01 01 01", "预约跳闸"), CANCEL_OPEN_SWITCH("1",
			"06 01 01 02", "取消预约跳闸"), CLOSE_SWITCH("2", "06 01 02 01", "预约合闸"), CANCEL_CLOSE_SWITCH(
			"3", "06 01 02 02", "取消预约合闸"), TEST_OPEN_SWITCH("4", "06 01 03 01",
			"测试预约跳闸"), CANCEL_TEST_OPEN_SWITCH("5", "06 01 03 02", "取消测试预约跳闸");

	@SuppressWarnings("unused")
	private String sign;// 标示
	private String code;// 16进制代码
	@SuppressWarnings("unused")
	private String statement;// 说明

	private ControlIdentificationCode(String sign, String code, String statement) {
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
	 * @return ControlIdentificationCode
	 * @throws
	 */
	public static ControlIdentificationCode valueOf(int sign) {

		switch (sign) {
		case 0:
			return OPEN_SWITCH;
		case 1:
			return CANCEL_OPEN_SWITCH;
		case 2:
			return CLOSE_SWITCH;
		case 3:
			return CANCEL_CLOSE_SWITCH;
		case 4:
			return TEST_OPEN_SWITCH;
		case 5:
			return CANCEL_TEST_OPEN_SWITCH;

		}
		return null;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code;
	}

}
