package com.gdut.dongjun.service.authc;

import com.gdut.dongjun.domain.po.authc.UserRoleKey;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @Title: RoleService.java
 * @Package com.topview.school.service.authority
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月20日 上午7:19:00
 * @version V1.0
 */
public interface UserRoleService extends BaseService<UserRoleKey> {

	/**
	 * 
	 * @Title: isAuthc
	 * @Description: TODO
	 * @param @param tId
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean hasRole(String tId, String rId);

	/**
	 * 
	 * @Title: deleteByPrimaryKey
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteByPrimaryKey(UserRoleKey key);

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int insert(UserRoleKey record);

	/**
	 * 
	 * @Title: insertSelective
	 * @Description: TODO
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int insertSelective(UserRoleKey record);

	/**
	 * 
	 * @Title: arrangeRole
	 * @Description: TODO
	 * @param @param userId
	 * @param @param roles
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int arrangeRole(String userId, String[] roles);

	/**
	 * 
	 * @Title: deleteByRoleId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteByRoleId(String roleId);

	/**
	 * 
	 * @Title: deleteByUserId
	 * @Description: TODO
	 * @param @param userId
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteByUserId(String userId);

}
