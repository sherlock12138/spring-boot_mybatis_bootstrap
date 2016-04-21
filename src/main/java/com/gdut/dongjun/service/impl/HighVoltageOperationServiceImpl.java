package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.HighVoltageOperationMapper;
import com.gdut.dongjun.domain.po.HighVoltageOperation;
import com.gdut.dongjun.service.HighVoltageOperationService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

@Service
public class HighVoltageOperationServiceImpl extends 
	BaseServiceImpl<HighVoltageOperation> implements
	HighVoltageOperationService {

	@Autowired
	private HighVoltageOperationMapper operationMapper;
	
	@Override
	protected boolean isExist(HighVoltageOperation record) {

		if (record != null
				&& operationMapper.selectByPrimaryKey(record.getId()) != null) {
			return true;
		} else {
			return false;
		}
	}
	
}