package com.gdut.dongjun.service.authc;

import com.gdut.dongjun.domain.po.authc.RoleModuleKey;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 上午10:58:49
 * @see TODO
 * @since 1.0
 */
public interface RoleModuleService extends BaseService<RoleModuleKey> {
	/**
	 * 
	 * @Title: arrangeModule
	 * @Description: TODO
	 * @param @param roleId
	 * @param @param modules
	 * @return void
	 * @throws
	 */
	public int arrangeModule(String roleId, String[] modules);

	/**
	 * 
	 * @Title: deleteByRoleId
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteByRoleId(String roleId);

}
