package com.gdut.dongjun.service.authc.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.dongjun.domain.dao.authc.UserRoleMapper;
import com.gdut.dongjun.domain.po.authc.UserRoleKey;
import com.gdut.dongjun.service.authc.UserRoleService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @Title: RoleServiceImpl.java
 * @Package com.topview.school.service.authority.impl
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月20日 上午7:19:34
 * @version V1.0
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleKey> implements
		UserRoleService {
	/**
	 * @ClassName: RoleServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年8月20日 上午7:19:34
	 */
	@Resource
	private UserRoleMapper userRoleMapper;

	@Override
	public int deleteByPrimaryKey(UserRoleKey key) {

		return userRoleMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(UserRoleKey record) {

		return userRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(UserRoleKey record) {

		return userRoleMapper.insertSelective(record);
	}

	@Override
	public boolean hasRole(String tId, String rId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", tId);
		map.put("role_id", rId);
		List<UserRoleKey> list = userRoleMapper
				.selectByParameters(MyBatisMapUtil.warp(map));

		if (list != null && list.size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public int arrangeRole(String userId, String[] roles) {

		userRoleMapper.deleteByUserId(userId);// 删除原有的分配
		if(roles!=null){
			
			for (String r : roles) {

				UserRoleKey key = new UserRoleKey(userId, r);
				if (userRoleMapper.insertSelective(key) == 0) {

					throw new RuntimeException();// 抛错才会回滚
				}
			}
		}
		return 1;
	}

//	@Resource
//	public void setRoleMapper(UserRoleMapper roleMapper) {
//
//		super.setBaseDao(roleMapper);
//	}

	@Override
	public int deleteByRoleId(String roleId) {
		
		return userRoleMapper.deleteByRoleId(roleId);
	}

	@Override
	public int deleteByUserId(String userId) {
		
		return userRoleMapper.deleteByUserId(userId);
	}

}
