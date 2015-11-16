package com.gdut.dongjun.domain.dao.authc;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.authc.RoleModuleKey;

public interface RoleModuleMapper extends
		SinglePrimaryKeyBaseMapper<RoleModuleKey> {

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