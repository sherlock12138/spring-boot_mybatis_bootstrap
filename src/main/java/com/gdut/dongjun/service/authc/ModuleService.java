package com.gdut.dongjun.service.authc;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.po.authc.Module;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 上午3:40:49
 * @see TODO
 * @since 1.0
 */
public interface ModuleService extends BaseService<Module> {

	/**
	 * 
	 * @Title: selectByRoleId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<ExtTreeNode> selectModuleTreeByRoleId(String roleId);

	/**
	 * 
	 * @Title: selectUnarrangeRoleByUserId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<Object> selectUnarrangeRoleByUserId(String roleId);

	/**
	 * @param schoolId 
	 * 
	 * @Title: selectAllRoleModule
	 * @Description: TODO
	 * @param @return
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	public List<Map<String, Object>> selectAllRoleModule(String schoolId);

	/**
	 * 
	 * @Title: selectAllUserModule
	 * @Description: TODO
	 * @param @param userId
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<ExtTreeNode> selectUserModule(String userId);

	/**
	 * 
	 * @Title: selectModuleListByRoleId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return List<Module>
	 * @throws
	 */
	public List<Module> selectModuleListByRoleId(String roleId);

	/**
	 * 
	 * @Title: selectFatherModuleListByRoleId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return List<Module>
	 * @throws
	 */
	public List<Module> selectFatherModuleListByRoleId(String roleId);

	/**
	 * 
	 * @Title: selectSonModuleListByRoleAndFatherModuleId
	 * @Description: TODO
	 * @param @param warp
	 * @param @return
	 * @return List<Module>
	 * @throws
	 */
	public List<Module> selectSonModuleListByRoleAndFatherModuleId(
			Map<String, Object> warp);

}
