package com.gdut.dongjun.service.authc;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.po.authc.Permission;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 下午12:21:55
 * @see TODO
 * @since 1.0
 */
public interface PermissionService extends BaseService<Permission> {

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
//	public List<Permission> selectUserModulePermission(Map<String, Object> map);

	public List<Permission> selectUserModulePermission(String userId, String moduleId,
			String classId);

}
