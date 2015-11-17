package com.gdut.dongjun.service.impl.enums;

/**
 * @Title: DataZoneStructure.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 下午2:04:04
 * @version V1.0
 */
public enum DataZoneStructure {

	IDENTIFIER(0), INDENTIFIER_PASSWORD_OPERATOR_CODE_DATA(1);
	private int sign;// 标示

	private DataZoneStructure(int sign) {
		this.sign = sign;
	}

	public int value() {
		// TODO Auto-generated method stub
		return sign;
	}

	
}
