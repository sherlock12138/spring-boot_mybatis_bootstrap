package com.gdut.dongjun.service;

import java.util.List;

import com.gdut.dongjun.domain.po.LowVoltageHitchEvent;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @Title: UserService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface LowVoltageHitchEventService extends BaseService<LowVoltageHitchEvent> {

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
