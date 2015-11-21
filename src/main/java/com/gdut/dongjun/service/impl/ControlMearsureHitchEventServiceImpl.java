package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.ControlMearsureHitchEventMapper;
import com.gdut.dongjun.domain.po.ControlMearsureHitchEvent;
import com.gdut.dongjun.service.ControlMearsureHitchEventService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

@Service
public class ControlMearsureHitchEventServiceImpl extends
	BaseServiceImpl<ControlMearsureHitchEvent>
 		implements ControlMearsureHitchEventService {
	
	@Autowired
	private ControlMearsureHitchEventMapper hitchEventMapper;
}
