package com.gdut.dongjun.service.impl;


/**
 * @Title: DataZone.java
 * @Package com.gdut.dongjun.service.impl
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月31日 上午12:20:52
 * @version V1.0
 */
public class DataZone {
	/**
	 * @ClassName: DataZone
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月31日 上午12:20:52
	 */
	private static final String DEFAULT_PASSWORD = "0000 0000";
	private static final String DEFAULT_OPERATOR_CODE = "0000 0000";

	// ***********************************************************
	// * Identifier *
	// ***********************************************************
	public static final String OPEN_SWITCH = "06 01 01 01";// 开关跳闸标示符
	public static final String CANCEL_OPEN_SWITCH = "06 01 01 02";
	public static final String CLOSE_SWITCH = "06 01 02 01";// 开关合闸标示符
	public static final String CANCEL_CLOSE_SWITCH = "06 01 02 02";
	public static final String TEST_OPEN_SWITCH = "06 01 03 01";// 模拟跳闸标示符
	public static final String CANCEL_TEST_OPEN_SWITCH = "06 01 03 02";

	// ***********************************************************
	// * Unit *
	// ***********************************************************
	public static final String MINITE = "02";
	public static final String HOUR = "03";

	private String identifier = "";
	private String password = DEFAULT_PASSWORD;
	private String operatorCode = DEFAULT_OPERATOR_CODE;
	private String data = "";

	public DataZone() {
		// TODO Auto-generated constructor stub
	}

	public DataZone(String identifier) {
		// TODO Auto-generated constructor stub
		this.identifier = identifier;
	}

	public DataZone(String identifier, String data) {
		this.identifier = identifier;
		this.data = data;
	}

	/**
	 * 
	 * @Title: creat
	 * @Description: 生成数据域 （这是一个数组）
	 * 
	 *               可能的情况是 （1）控制类命令组成： 标示码 密码 操作者代码 数据
	 * 
	 *               例如： 控制开关跳闸（数据为设置的时间）
	 * 
	 *               （2）读取类命令组成： 标示码
	 * 
	 *               例如： 读取电流
	 * @param @param identifier
	 * @param @param data
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String[] creatDataZoneArrays(int sign) {

		String[] data1 = new String[4];
		data1[0] = identifier;
		switch (sign) {
		case 1:
			data1[1] = password;
			data1[2] = operatorCode;
			System.out.println("inside creat" + data);
			if (data == null) {
				data1[3] = "";
			} else {
				if (data.length() % 2 == 1)
					data1[3] = "0" + data;
				else {
					data1[3] = data;
				}
			}
			break;

		default:
			break;
		}
		return data1;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
