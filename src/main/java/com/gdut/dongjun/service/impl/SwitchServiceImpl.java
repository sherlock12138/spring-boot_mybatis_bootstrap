package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.SwitchMapper;
import com.gdut.dongjun.service.SwitchService;
import com.gdut.dongjun.service.impl.system.BaseServiceImpl;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
public class SwitchServiceImpl extends BaseServiceImpl implements SwitchService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private SwitchMapper switchMapper;
	
	
	
}
