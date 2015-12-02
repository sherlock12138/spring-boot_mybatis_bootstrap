package com.gdut.dongjun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.UserMapper;
import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.service.UserService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.service.impl.enums.LoginResult;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private UserMapper userMapper;
	private static final Logger logger = Logger
			.getLogger(UserServiceImpl.class);

	@Override
	public LoginResult login(String user, String password) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", user);

		List<User> ulist = userMapper.selectByParameters(MyBatisMapUtil
				.warp(map));

		if (ulist != null && ulist.size() != 0) {

			for (User user2 : ulist) {
				if (user2.getPassword() != null) {
					if (user2.getPassword().equals(password)) {
						return LoginResult.LOGIN_PASS;
					} else {
						return LoginResult.WORNING_PASSWORD;
					}
				} else {
					logger.error("password no is null!");
				}
			}
		}
		return LoginResult.USER_NO_EXIST;

	}

	@Override
	protected boolean isExist(User record) {

		if (record != null
				&& userMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}
}
