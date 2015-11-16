package com.gdut.dongjun.service;

import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.service.base.BaseService;
import com.gdut.dongjun.service.impl.enums.LoginResult;

/**   
 * @Title: UserService.java 
 * @Package com.gdut.dongjun.service.system 
 * @Description: TODO 
 * @author Sherlock-lee   
 * @date 2015年7月24日 下午2:34:11 
 * @version V1.0   
 */
public interface UserService extends BaseService<User>{

	
	/**
	 * 
	* @Title: login 
	* @Description: TODO
	* @param @param user
	* @param @return   
	* @return boolean   
	* @throws
	 */
	public LoginResult login(String user, String password);
	
}
