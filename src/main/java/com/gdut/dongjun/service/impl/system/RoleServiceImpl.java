package com.gdut.dongjun.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.system.RoleMapper;
import com.gdut.dongjun.service.system.RoleService;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private RoleMapper roleMapper;
}
