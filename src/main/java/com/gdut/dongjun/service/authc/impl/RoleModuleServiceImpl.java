package com.gdut.dongjun.service.authc.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.dongjun.domain.dao.authc.RoleModuleMapper;
import com.gdut.dongjun.domain.dao.authc.RoleModulePermissionMapper;
import com.gdut.dongjun.domain.po.authc.RoleModuleKey;
import com.gdut.dongjun.service.authc.RoleModuleService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 上午11:35:10
 * @see TODO
 * @since 1.0
 */
@Service
public class RoleModuleServiceImpl extends BaseServiceImpl<RoleModuleKey>
		implements RoleModuleService {

	@Resource
	private RoleModuleMapper roleModuleMapper;
	@Autowired
	private RoleModulePermissionMapper roleModulePermissionMapper;

	@Override
	@Transactional
	public int arrangeModule(String roleId, String[] modules) {

		List<RoleModuleKey> rms = roleModuleMapper
				.selectByParameters(MyBatisMapUtil.warp("role_id", roleId));

		for (RoleModuleKey rm : rms) {

			roleModulePermissionMapper.deleteByRoleModuleId(rm.getId());// 将依赖该角色-模块关系下的权限分配删除
		}
		roleModuleMapper.deleteByRoleId(roleId);// 删除原有的分配
		
		if(modules!= null){
			for (String m : modules) {//重新分配模块

				RoleModuleKey key = new RoleModuleKey(roleId, m);
				if (roleModuleMapper.insertSelective(key) == 0) {

					throw new RuntimeException();// 抛错才会回滚
				}
			}
		}
		return 1;// 没出错就返回1
	}

//	@Resource
//	public void setBaseDao(RoleModuleMapper roleModuleMapper) {
//		super.setBaseDao(roleModuleMapper);
//	}

	@Override
	public int deleteByRoleId(String roleId) {
		
		return roleModuleMapper.deleteByRoleId(roleId);
	}

	@Override
	protected boolean isExist(RoleModuleKey record) {
		return true;
	}

}
