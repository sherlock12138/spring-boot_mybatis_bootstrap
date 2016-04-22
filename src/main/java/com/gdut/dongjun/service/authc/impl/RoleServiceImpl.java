package com.gdut.dongjun.service.authc.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.authc.RoleMapper;
import com.gdut.dongjun.domain.po.authc.Role;
import com.gdut.dongjun.service.authc.RoleService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.sun.xml.bind.v2.TODO;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 上午2:34:39
 * @see TODO
 * @since 1.0
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectByUserId(String userId) {

		return roleMapper.selectByUserId(userId);
	}

//	@Resource
//	public void setBaseDao(RoleMapper roleMapper) {
//
//		super.setBaseDao(roleMapper);
//	}

	@Override
	public List<Map<String, Object>> selectAllUserRole(String schoolId) {

//		List<Teacher> teachers = teacherService.getTeacher(MapUtil.warp(
//				"schoolId", schoolId));

		List<Map<String, Object>> maps = new LinkedList<>();
//		for (Teacher t : teachers) {
//
//			if(t!= null){
//				
//				Map<String, Object> map = MapUtil.warp("id", t.getId());
//				map.put("name", t.getName());
//				map.put("roles", roleMapper.selectByUserId(t.getId()));
//				maps.add(map);
//			}
//		}
		return maps;
	}

	@Override
	public List<Object> selectUnarrangeRoleByUserId(Map<String, Object> map) {
		
		return roleMapper.selectUnarrangeRoleByUserId(map);
	}

	@Override
	protected boolean isExist(Role record) {
		return true;
	}

}
