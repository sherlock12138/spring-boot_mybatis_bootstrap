package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.system.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.HitchEvent;

public interface HitchEventMapper extends
		SinglePrimaryKeyBaseMapper<HitchEvent> {

	/**
	 * 
	 * @Title: getRecentlyHitchEvent
	 * @Description: TODO
	 * @param @return
	 * @return HitchEvent
	 * @throws
	 */
	public HitchEvent getRecentlyHitchEvent();

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