package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.LowVoltageHitchEvent;

public interface LowVoltageHitchEventMapper extends
		SinglePrimaryKeyBaseMapper<LowVoltageHitchEvent> {

	/**
	 * 
	 * @Title: getRecentlyHitchEvent
	 * @Description: TODO
	 * @param @return
	 * @return HitchEvent
	 * @throws
	 */
	public LowVoltageHitchEvent getRecentlyHitchEvent();

	/**
	 * 
	 * @Title: hitchEventList
	 * @Description: TODO
	 * @param @return
	 * @return com.gdut.dongjun.dto.HitchEvent
	 * @throws
	 */
	public List<com.gdut.dongjun.dto.HitchEvent> hitchEventList();

}