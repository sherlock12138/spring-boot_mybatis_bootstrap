package com.gdut.dongjun.service.impl.enums;


/**
 * @Title: EventVariable.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 下午12:34:48
 * @version V1.0
 */
public enum Phase {

	A_PHASE("A", "01", "A相"), B_PHASE("B", "02", "B相"), C_PHASE("C", "03", "C相");

	private String sign;// 标示
	private String code;// 16进制代码
	private String statement;// 说明

	private Phase(String sign, String code, String statement) {
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
	public static Phase define(String sign) {

		switch (sign) {
		case "01":
			return A_PHASE;
		case "02":
			return B_PHASE;
		case "03":
			return C_PHASE;
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
		return sign;
	}
}