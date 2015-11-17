package com.gdut.dongjun.domain.dao.authc;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.authc.Module;

public interface ModuleMapper extends SinglePrimaryKeyBaseMapper<Module> {

	/**
	 * 
	 * @Title: selectByRoleId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return List<Module>
	 * @throws
	 */
	public List<Module> selectByRoleId(String roleId);

	/**
	 * 
	 * @Title: selectUnarrangeModuleByRoleId
	 * @Description: TODO
	 * @param @param roleId
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<Object> selectUnarrangeModuleByRoleId(String roleId);

	/**
	 * 
	 * @Title: selectUserModule
	 * @Description: TODO
	 * @param @param userId
	 * @param @return
	 * @return List<Object>
	 * @throws
	 */
	public List<Module> selectUserModule(String userId);

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