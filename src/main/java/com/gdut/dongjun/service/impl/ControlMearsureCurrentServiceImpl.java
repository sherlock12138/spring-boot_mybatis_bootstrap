package com.gdut.dongjun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.ControlMearsureCurrentMapper;
import com.gdut.dongjun.domain.po.ControlMearsureCurrent;
import com.gdut.dongjun.service.ControlMearsureCurrentService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureCurrentServiceImpl.java
 * @description
 * @Date 2015年11月19日 下午3:30:35 
 * @version V1.0
 */
@Service
public class ControlMearsureCurrentServiceImpl extends 
	BaseServiceImpl<ControlMearsureCurrent>
		implements ControlMearsureCurrentService {

	@Autowired
	private ControlMearsureCurrentMapper currentMapper;

	@Override
	public List<ControlMearsureCurrent> getRecentlyCurrent() {
		return currentMapper.getRecentlyCurrent();
	}
	
}
