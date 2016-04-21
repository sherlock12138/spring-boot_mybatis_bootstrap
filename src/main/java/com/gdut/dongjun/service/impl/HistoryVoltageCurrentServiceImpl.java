package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.HistoryHighVoltageCurrentMapper;
import com.gdut.dongjun.domain.po.HistoryHighVoltageCurrent;
import com.gdut.dongjun.service.HistoryHighVoltageCurrentService;
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
public class HistoryVoltageCurrentServiceImpl extends 
	BaseServiceImpl<HistoryHighVoltageCurrent> implements HistoryHighVoltageCurrentService {
	/** 
	 * @ClassName: UserServiceImpl 
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08 
	 */
	@Autowired
	private HistoryHighVoltageCurrentMapper currentMapper;

	@Override
	protected boolean isExist(HistoryHighVoltageCurrent record) {
		
		if (record != null
				&& currentMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}
}
