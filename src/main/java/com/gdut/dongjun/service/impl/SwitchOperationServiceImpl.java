package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.SwitchOperationMapper;
import com.gdut.dongjun.domain.po.SwitchOperation;
import com.gdut.dongjun.service.SwitchOperationService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

@Service
public class SwitchOperationServiceImpl extends 
	BaseServiceImpl<SwitchOperation> implements
	SwitchOperationService {

	@Autowired
	private SwitchOperationMapper operationMapper;

	@Override
	protected boolean isExist(SwitchOperation record) {

		if (record != null
				&& operationMapper.selectByPrimaryKey(record.getId()) != null) {
			return true;
		} else {
			return false;
		}
	}
	
}