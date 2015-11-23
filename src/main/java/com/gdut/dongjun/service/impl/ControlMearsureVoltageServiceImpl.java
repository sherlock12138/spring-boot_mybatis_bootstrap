package com.gdut.dongjun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.ControlMearsureVoltageMapper;
import com.gdut.dongjun.domain.po.ControlMearsureVoltage;
import com.gdut.dongjun.service.ControlMearsureVoltageService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureVoltageServiceImpl.java
 * @description
 * @Date 2015年11月19日 下午3:31:56 
 * @version V1.0
 */
@Service
public class ControlMearsureVoltageServiceImpl extends
	BaseServiceImpl<ControlMearsureVoltage> implements
		ControlMearsureVoltageService {

	@Autowired
	private ControlMearsureVoltageMapper voltageMapper;
	
	@Override
	public List<ControlMearsureVoltage> getRecentlyVoltage() {
		return voltageMapper.getRecentlyVoltage();
	}

	@Override
	protected boolean isExist(ControlMearsureVoltage record) {

		if (record != null
				&& voltageMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}

}
