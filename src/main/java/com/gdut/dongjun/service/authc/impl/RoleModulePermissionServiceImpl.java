package com.gdut.dongjun.service.authc.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.dongjun.domain.dao.authc.RoleModulePermissionMapper;
import com.gdut.dongjun.domain.po.authc.RoleModuleKey;
import com.gdut.dongjun.domain.po.authc.RoleModulePermissionKey;
import com.gdut.dongjun.service.authc.RoleModulePermissionService;
import com.gdut.dongjun.service.authc.RoleModuleService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 下午12:27:41
 * @see TODO
 * @since 1.0
 */
@Service
public class RoleModulePermissionServiceImpl extends
		BaseServiceImpl<RoleModulePermissionKey> implements
		RoleModulePermissionService {

	@Autowired
	private RoleModuleService roleModuleService;

	@Resource
	private RoleModulePermissionMapper roleModulePermissionMapper;

//	@Resource
//	public void setBaseDao(RoleModulePermissionMapper roleModulePermissionMapper) {
//		super.setBaseDao(roleModulePermissionMapper);
//	}

	@Override
	@Transactional
	public int arrangePermission(String roleId, String moduleId,
			String[] permissions) {

		Map<String, Object> map = MapUtil.warp("role_id", roleId);
		map.put("module_id", moduleId);
		List<RoleModuleKey> rms = roleModuleService
				.selectByParameters(MyBatisMapUtil.warp(map));

		String id = null;
		if (rms != null && rms.size() == 1) {

			id = rms.get(0).getId();// 找出角色-模块关系的Id
		}
		roleModulePermissionMapper.deleteByRoleModuleId(id);// 删除原有的权限分配

		if (permissions != null) {

			for (String p : permissions) {

				RoleModulePermissionKey key = new RoleModulePermissionKey(id, p);
				int sign = roleModulePermissionMapper.insert(key);
				if (sign == 0) {

					throw new RuntimeException();
				}
			}
		}

		return 1;
	}

	@Override
	public int deleteByRoleModuleId(String id) {
		
		return roleModulePermissionMapper.deleteByRoleModuleId(id);
	}
}
