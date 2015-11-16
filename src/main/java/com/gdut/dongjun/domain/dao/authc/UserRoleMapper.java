package com.gdut.dongjun.domain.dao.authc;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.authc.UserRoleKey;

public interface UserRoleMapper extends SinglePrimaryKeyBaseMapper<UserRoleKey> {

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
	 * @Title: deleteByRoleId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteByRoleId(String roleId);
}