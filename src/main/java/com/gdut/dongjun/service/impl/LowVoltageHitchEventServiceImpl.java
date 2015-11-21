package com.gdut.dongjun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.LowVoltageHitchEventMapper;
import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.LowVoltageHitchEvent;
import com.gdut.dongjun.service.LowVoltageHitchEventService;
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
public class LowVoltageHitchEventServiceImpl extends BaseServiceImpl<LowVoltageHitchEvent>
		implements LowVoltageHitchEventService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private LowVoltageHitchEventMapper hitchEventMapper;
	@Autowired
	private LowVoltageSwitchMapper switchMapper;

	@Override
	public LowVoltageHitchEvent getRecentlyHitchEvent() {
		// TODO Auto-generated method stub
		return hitchEventMapper.getRecentlyHitchEvent();
	}

	@Override
	public List<com.gdut.dongjun.dto.HitchEvent> hitchEventList() {
		// TODO Auto-generated method stub
		List<com.gdut.dongjun.dto.HitchEvent> events = hitchEventMapper.hitchEventList();
		
		for (com.gdut.dongjun.dto.HitchEvent hitchEvent : events) {
			
			if(hitchEvent!= null && hitchEvent.getHitchTime()!= null){
				
				
				
					hitchEvent.setHitchTime(hitchEvent.getHitchTime().substring(0, 19));
			}
		}
		return events;
	}

	@Override
	protected boolean isExist(LowVoltageHitchEvent record) {

		if (record != null
				&& hitchEventMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}

}
