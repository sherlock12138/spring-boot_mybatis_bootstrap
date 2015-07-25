package com.gdut.dongjun.domain.po.system;

/**   
 * @Title: Role.java 
 * @Package com.gdut.dongjun.domain.po.system 
 * @Description: TODO 
 * @author Sherlock-lee   
 * @date 2015年7月24日 下午1:57:53 
 * @version V1.0   
 */
public class Role {
	/** 
	 * @ClassName: Role 
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午1:57:53 
	 */
	private String id;
	private String role;
	private String description;
	private boolean isAvailable;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
