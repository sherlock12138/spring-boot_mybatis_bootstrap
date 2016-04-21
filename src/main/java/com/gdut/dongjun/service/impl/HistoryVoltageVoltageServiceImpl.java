package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.HistoryHighVoltageVoltageMapper;
import com.gdut.dongjun.domain.po.HistoryHighVoltageVoltage;
import com.gdut.dongjun.service.HistoryHighVoltageVoltageService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

/**   
 * @Title: UserServiceImpl.java 
 * @Package com.gdut.dongjun.service.impl.system 
 * @Description: TODO 
 * @author Sherlock-lee   
 * @date 2015年7月24日 下午2:33:08 
 * @version V1.0   
 */
@Service
public class HistoryVoltageVoltageServiceImpl extends 
	BaseServiceImpl<HistoryHighVoltageVoltage> implements HistoryHighVoltageVoltageService{
	/** 
	 * @ClassName: UserServiceImpl 
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08 
	 */
	@Autowired
	private HistoryHighVoltageVoltageMapper voltageMapper;

	@Override
	protected boolean isExist(HistoryHighVoltageVoltage record) {
		
		if (record != null
				&& voltageMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}
}
