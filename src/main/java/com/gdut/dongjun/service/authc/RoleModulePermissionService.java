package com.gdut.dongjun.service.authc;

import com.gdut.dongjun.domain.po.authc.RoleModulePermissionKey;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 下午12:27:05
 * @see TODO
 * @since 1.0
 */
public interface RoleModulePermissionService extends
		BaseService<RoleModulePermissionKey> {

	/**
	 * 
	 * @Title: arrangePermission
	 * @Description: TODO
	 * @param @param roleId
	 * @param @param moduleId
	 * @param @param permissions
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int arrangePermission(String roleId, String moduleId,
			String[] permissions);

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
