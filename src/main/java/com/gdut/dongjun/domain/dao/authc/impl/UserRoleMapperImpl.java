package com.gdut.dongjun.domain.dao.authc.impl;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.authc.UserRoleMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.authc.UserRoleKey;

/**
 * 
 * @author Sherlock-lee
 * @date 2015年9月29日 下午8:12:23
 * @see TODO
 * @since 1.0
 */
@Repository
public class UserRoleMapperImpl extends SinglePrimaryKeyBaseDAOImpl<UserRoleKey> implements
		UserRoleMapper {

	@Override
	public int deleteByUserId(String userId) {

		return template.delete(getNamespace("deleteByUserId"), userId);
	}

	@Override
	public int deleteByPrimaryKey(UserRoleKey key) {

		return template.delete(getNamespace("deleteByPrimaryKey"), key);
	}

	@Override
	public int deleteByRoleId(String roleId) {
		
		return template.delete(getNamespace("deleteByRoleId"), roleId);
	}

}
