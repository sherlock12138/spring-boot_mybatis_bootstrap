package com.gdut.dongjun.service;

import java.util.List;

import com.gdut.dongjun.domain.po.HitchEvent;
import com.gdut.dongjun.service.system.BaseService;

/**
 * @Title: UserService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface HitchEventService extends BaseService<HitchEvent> {

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
