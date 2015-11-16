package com.gdut.dongjun.domain.dao.authc;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.authc.Role;

public interface RoleMapper extends SinglePrimaryKeyBaseMapper<Role> {

	/**
	 * 
	 * @Title: selectByUserId
	 * @Description: TODO
	 * @param @param userId
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<Role> selectByUserId(String userId);

	/**
	 * 
	 * @Title: selectUnarrangeRoleByUserId
	 * @Description: TODO
	 * @param @param map
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<Object> selectUnarrangeRoleByUserId(Map<String, Object> map);

}