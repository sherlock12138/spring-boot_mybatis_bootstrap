package com.gdut.dongjun.service.authc;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.po.authc.Role;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 上午2:33:42
 * @see TODO
 * @since 1.0
 */
public interface RoleService extends BaseService<Role> {

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
	 * @param schoolId
	 * 
	 * @Title: selectAllUserRole
	 * @Description: TODO
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<Map<String, Object>> selectAllUserRole(String schoolId);

	/**
	 * 
	 * @Title: selectUnarrangeRoleByUserId
	 * @Description: TODO
	 * @param @param userId
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<Object> selectUnarrangeRoleByUserId(Map<String, Object> map);

}
