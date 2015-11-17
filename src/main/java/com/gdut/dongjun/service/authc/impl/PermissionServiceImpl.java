package com.gdut.dongjun.service.authc.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.authc.PermissionMapper;
import com.gdut.dongjun.domain.dao.authc.RoleMapper;
import com.gdut.dongjun.domain.po.authc.Permission;
import com.gdut.dongjun.service.authc.PermissionService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MapUtil;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 下午12:23:12
 * @see TODO
 * @since 1.0
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission>
		implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	@Autowired
	private RoleMapper roleMapper;

//	@Resource
//	public void setBaseDao(PermissionMapper permissionMapper) {
//		super.setBaseDao(permissionMapper);
//	}

	@Override
	public List<Permission> selectByRoleModuleId(Map<String, Object> warp) {

		return permissionMapper.selectByRoleModuleId(warp);
	}

	@Override
	public List<Permission> selectUnarrangePermissionByRoleModuleId(
			Map<String, Object> map) {

		return permissionMapper.selectUnarrangePermissionByRoleModuleId(map);
	}

	@Override
	public List<Permission> selectUserModulePermission(String userId,
			String moduleId, String classId) {

		if (classId != null) {

			Map<String, Object> map = MapUtil.warp("user_id", userId);// 尝试根据class_id查询，看是不是班主任
			map.put("module_id", moduleId);
			map.put("class_id", classId);
			List<Permission> permissions = permissionMapper
					.selectUserModulePermission(map);
			
			if (permissions.size() != 0) {

				return permissions;
			} else {// 放弃关联class_id 的查询

				map.remove("class_id");
				return permissionMapper
						.selectUserModulePermissionWithoutClassId(map);
			}
		} else {

			Map<String, Object> map = MapUtil.warp("user_id", userId);
			map.put("module_id", moduleId);
			return permissionMapper.selectUserModulePermission(map);
		}
	}
}
