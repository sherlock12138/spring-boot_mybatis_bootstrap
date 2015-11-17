package com.gdut.dongjun.domain.dao.authc;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.authc.RoleModulePermissionKey;

public interface RoleModulePermissionMapper extends
		SinglePrimaryKeyBaseMapper<RoleModulePermissionKey> {

	/**
	 * 
	 * @Title: deleteByRoleModuleId
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteByRoleModuleId(String id);

}