package com.gdut.dongjun.domain.po.system;

/**   
 * @Title: User.java 
 * @Package com.gdut.dongjun.domain.po 
 * @Description: TODO 
 * @author Sherlock-lee   
 * @date 2015年7月24日 下午1:56:05 
 * @version V1.0   
 */
public class User {
	/** 
	 * @ClassName: User 
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午1:56:05 
	 */
	private String id;
	private String name;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
