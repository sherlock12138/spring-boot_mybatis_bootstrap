package com.gdut.dongjun.service.authc;

/**
 * 
 * @Title: RoleType.java
 * @Package com.topview.school.service.authority
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月20日 上午7:17:55
 * @version V1.0
 */
public enum RoleType {

	SUPER_MANAGER("000", "超级管理员"), SCHOOL_MANAGER("001", "学校管理员"), SUBJECT_MANAGER(
			"002", "学科负责人"), CURRICULA_MANAGER("003", "课程负责人"), MONITOR("004",
			"级长"), MASTER_TEACHER("005", "班主任"), TEACHER("006", "任课老师");

	private String id;// 标示
	private String statement;// 说明

	private RoleType(String id, String statement) {
		this.id = id;
		this.statement = statement;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	/**
	 * 
	 * @Title: value
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String value() {

		return id;
	}

}
