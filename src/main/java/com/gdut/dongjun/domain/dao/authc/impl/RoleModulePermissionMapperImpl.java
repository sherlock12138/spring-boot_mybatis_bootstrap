package com.gdut.dongjun.domain.dao.authc.impl;
import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.authc.RoleModulePermissionMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.authc.RoleModulePermissionKey;
/**
 * 
 * @author Sherlock-lee
 * @date 2015年9月29日 下午8:12:23
 * @see TODO
 * @since 1.0
 */
@Repository
public class RoleModulePermissionMapperImpl extends
		SinglePrimaryKeyBaseDAOImpl<RoleModulePermissionKey> implements
		RoleModulePermissionMapper {

	@Override
	public int deleteByRoleModuleId(String roleModuleId) {
		
		return template.delete(getNamespace("deleteByRoleModuleId"), roleModuleId);
	}

}
