package com.gdut.dongjun.domain.po.system;

/**   
 * @Title: Permission.java 
 * @Package com.gdut.dongjun.domain.po.system 
 * @Description: TODO 
 * @author Sherlock-lee   
 * @date 2015年7月24日 下午1:59:40 
 * @version V1.0   
 */
public class Permission {
	/** 
	 * @ClassName: Permission 
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午1:59:40 
	 */
	private String id;
	private String permission;
	private String description;
	private boolean isAvailable;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
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
