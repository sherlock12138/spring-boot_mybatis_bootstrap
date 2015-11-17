package com.gdut.dongjun.service.impl.enums;

/**
 * @Title: EventVariable.java
 * @Package com.gdut.dongjun.service.impl.enums
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 下午12:34:48
 * @version V1.0
 */
public enum LoginResult {

	LOGIN_PASS("0", "登陆通过"), USER_NO_EXIST("1", "用户不存在"), WORNING_PASSWORD("2",
			"密码错误");

	private String sign;// 标示
	private String statement;// 说明

	private LoginResult(String sign, String statement) {
		this.sign = sign;
		this.statement = statement;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.statement;
	}

	public String value() {
		return sign;
	}

}