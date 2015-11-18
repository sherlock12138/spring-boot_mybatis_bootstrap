package com.gdut.dongjun.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.HitchEventMapper;
import com.gdut.dongjun.domain.dao.SwitchMapper;
import com.gdut.dongjun.domain.po.HitchEvent;
import com.gdut.dongjun.domain.po.Switch;
import com.gdut.dongjun.service.HitchEventService;
import com.gdut.dongjun.service.impl.system.BaseServiceImpl;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
@Service
public class HitchEventServiceImpl extends BaseServiceImpl<HitchEvent>
		implements HitchEventService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private HitchEventMapper hitchEventMapper;
	@Autowired
	private SwitchMapper switchMapper;

	@Override
	public HitchEvent getRecentlyHitchEvent() {
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

}
