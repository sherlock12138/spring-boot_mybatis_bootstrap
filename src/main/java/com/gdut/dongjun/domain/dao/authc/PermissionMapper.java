package com.gdut.dongjun.domain.dao.authc;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.authc.Permission;

public interface PermissionMapper extends
		SinglePrimaryKeyBaseMapper<Permission> {

	/**
	 * 
	 * @Title: selectByRoleModuleId
	 * @Description: TODO
	 * @param @param warp
	 * @param @return
	 * @return List<Permission>
	 * @throws
	 */
	public List<Permission> selectByRoleModuleId(Map<String, Object> warp);

	/**
	 * 
	 * @Title: selectUnarrangePermissionByRoleModuleId
	 * @Description: TODO
	 * @param @param map
	 * @param @return
	 * @return List<Permission>
	 * @throws
	 */
	public List<Permission> selectUnarrangePermissionByRoleModuleId(
			Map<String, Object> map);

	/**
	 * 
	 * @Title: selectUserModulePermission
	 * @Description: TODO
	 * @param @param map
	 * @param @return
	 * @return List<Permission>
	 * @throws
	 */
	public List<Permission> selectUserModulePermission(Map<String, Object> map);

	/**
	 * 
	 * @Title: selectUserModulePermissionWithoutClassId
	 * @Description: TODO
	 * @param @param map
	 * @param @return
	 * @return List<Permission>
	 * @throws
	 */
	public List<Permission> selectUserModulePermissionWithoutClassId(
			Map<String, Object> map);

}