package com.gdut.dongjun.domain.dao.authc.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.authc.ModuleMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.authc.Module;

/**
 * 
 * @author Sherlock-lee
 * @date 2015年9月29日 下午8:12:14
 * @see TODO
 * @since 1.0
 */
@Repository
public class ModuleMapperImpl extends SinglePrimaryKeyBaseDAOImpl<Module>
		implements ModuleMapper {

	@Override
	public List<Module> selectByRoleId(String roleId) {

		return template.selectList(getNamespace("selectByRoleId"), roleId);
	}

	@Override
	public List<Object> selectUnarrangeModuleByRoleId(String roleId) {

		return template.selectList(
				getNamespace("selectUnarrangeModuleByRoleId"), roleId);
	}

	@Override
	public List<Module> selectUserModule(String userId) {

		return template.selectList(getNamespace("selectUserModule"), userId);
	}

	@Override
	public List<Module> selectFatherModuleListByRoleId(String roleId) {

		return template.selectList(
				getNamespace("selectFatherModuleListByRoleId"), roleId);
	}

	@Override
	public List<Module> selectSonModuleListByRoleAndFatherModuleId(
			Map<String, Object> warp) {

		return template.selectList(
				getNamespace("selectSonModuleListByRoleAndFatherModuleId"),
				warp);
	}

}
