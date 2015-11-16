package com.gdut.dongjun.domain.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.LowVoltageHitchEventMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.LowVoltageHitchEvent;

/**
 * 
 * @author	Sherlock-lee
 * @date	2015年11月14日 下午4:56:54
 * @see 	TODO
 * @since   1.0
 */
@Repository
public class LowVoltageHitchEventDAOImpl extends SinglePrimaryKeyBaseDAOImpl<LowVoltageHitchEvent>
		implements LowVoltageHitchEventMapper {

	@Override
	public LowVoltageHitchEvent getRecentlyHitchEvent() {
		// TODO Auto-generated method stub
		return template.selectOne(getNamespace("getRecentlyHitchEvent"));
	}

	@Override
	public List<com.gdut.dongjun.dto.HitchEvent> hitchEventList() {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("hitchEventList"));
	}

}