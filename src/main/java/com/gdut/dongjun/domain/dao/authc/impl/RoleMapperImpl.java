package com.gdut.dongjun.domain.dao.authc.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.authc.RoleMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.authc.Role;

/**
 * 
 * @author	Sherlock-lee
 * @date	2015年9月29日 下午8:12:19
 * @see 	TODO
 * @since   1.0
 */
@Repository
public class RoleMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Role> implements
		RoleMapper {

	@Override
	public List<Role> selectByUserId(String userId) {
		
		return template.selectList(getNamespace("selectByUserId"), userId);
	}

	@Override
	public List<Object> selectUnarrangeRoleByUserId(Map<String, Object> map) {
		
		return template.selectList(getNamespace("selectUnarrangeRoleByUserId"), map);
	}



}
