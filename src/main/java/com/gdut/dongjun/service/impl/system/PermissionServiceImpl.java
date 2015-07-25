package com.gdut.dongjun.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.system.PermissionMapper;
import com.gdut.dongjun.service.system.PermissionService;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
public class PermissionServiceImpl extends BaseServiceImpl implements PermissionService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private PermissionMapper permissionMapper;
}
