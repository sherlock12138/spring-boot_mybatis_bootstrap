package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.ControlMearsureSwitchMapper;
import com.gdut.dongjun.domain.po.ControlMearsureSwitch;
import com.gdut.dongjun.service.ControlMearsureSwitchService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

@Service
public class ControlMearsureSwitchServiceImpl extends 
	BaseServiceImpl<ControlMearsureSwitch> implements
		ControlMearsureSwitchService {

	@Autowired
	private ControlMearsureSwitchMapper switchMapper;

	@Override
	protected boolean isExist(ControlMearsureSwitch record) {

		if (record != null
				&& switchMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}
}
