package com.gdut.dongjun.service.impl.enums;

/**
 * @Title: CurrentVariable.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 下午12:34:48
 * @version V1.0
 */
public enum CurrentVariable {

	A_PHASE_VOLTAGE("0", "02010100", "当前A相电压"), B_PHASE_VOLTAGE("1",
			"02010200", "当前B相电压"), C_PHASE_VOLTAGE("2", "02010300", "当前C相电压"), ALL_PHASE_VOLTEGE(
			"3", "0201FF00", "当前A,B,C相电压"), A_PHASE_CURRENT("4", "02020100",
			"当前A相电流"), B_PHASE_CURRENT("5", "02020200", "当前B相电流"), C_PHASE_CURRENT(
			"6", "02020300", "当前C相电流"), ALL_PHASE_CURRENT("7", "0202FF00",
			"当前A,B,C相电流");

	private String sign;// 标示
	private String code;// 16进制代码
	private String statement;// 说明

	private CurrentVariable(String sign, String code, String statement) {
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
	 * @return CurrentVariable
	 * @throws
	 */
	public static CurrentVariable valueOf(int sign) {

		switch (sign) {
		case 0:
			return A_PHASE_VOLTAGE;
		case 1:
			return B_PHASE_VOLTAGE;
		case 2:
			return C_PHASE_VOLTAGE;
		case 3:
			return ALL_PHASE_VOLTEGE;
		case 4:
			return A_PHASE_CURRENT;
		case 5:
			return B_PHASE_CURRENT;
		case 6:
			return C_PHASE_CURRENT;
		case 7:
			return ALL_PHASE_CURRENT;

		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code;
	}
	
	public String value() {
		// TODO Auto-generated method stub
		return code;
	}


}