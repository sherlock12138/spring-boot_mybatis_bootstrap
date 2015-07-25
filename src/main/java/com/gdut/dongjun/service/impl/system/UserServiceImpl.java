package com.gdut.dongjun.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.system.UserMapper;
import com.gdut.dongjun.domain.po.system.User;
import com.gdut.dongjun.service.system.UserService;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private UserMapper userMapper;

	public void test() {

		User u = userMapper.selectByPrimaryKey("001");
		System.out.println(u.getName());

	}
}
