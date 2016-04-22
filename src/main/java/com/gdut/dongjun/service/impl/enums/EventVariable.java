package com.gdut.dongjun.service.impl.enums;


/**
 * @Title: EventVariable.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 下午12:34:48
 * @version V1.0
 */
public enum EventVariable {

	HITCH_EVENT("0", "038E0001", "保护器跳闸事件");

	private String sign;// 标示
	private String code;// 16进制代码
	@SuppressWarnings("unused")
	private String statement;// 说明

	private EventVariable(String sign, String code, String statement) {
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
	public static EventVariable valueOf(int sign) {

		switch (sign) {
		case 0:
			return HITCH_EVENT;
			// case 1:
			// return B_PHASE_VOLTAGE;
			// case 2:
			// return C_PHASE_VOLTAGE;
			// case 3:
			// return ALL_PHASE_VOLTEGE;
			// case 4:
			// return A_PHASE_CURRENT;
			// case 5:
			// return B_PHASE_CURRENT;
			// case 6:
			// return C_PHASE_CURRENT;
			// case 7:
			// return ALL_PHASE_CURRENT;

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