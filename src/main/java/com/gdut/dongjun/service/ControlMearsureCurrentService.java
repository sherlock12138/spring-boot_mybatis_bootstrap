package com.gdut.dongjun.service;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.po.ControlMearsureCurrent;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureCurrentService.java
 * @description	TODO
 * @Date 2015年11月19日 下午3:33:14 
 * @version V1.0
 */
public interface ControlMearsureCurrentService extends
	BaseService<ControlMearsureCurrent>{

	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Current>
	 * @throws
	 */
	public Map<String, Object> selectBySwitchId(String switchId);

	/**
	 * @param string 
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param d
	 * @return void
	 * @throws
	 */
	public Map<String, Object> selectByTime(String switchId, String date, String string);

	/**
	 * 
	 * @Title: getRecentlyHitchEvent
	 * @Description: 读取实时电流
	 * @param @param switchId
	 * @return void
	 * @throws
	 */
	public List<ControlMearsureCurrent> getRecentlyCurrent();
	
	
	
	
	
}
