package com.gdut.dongjun.domain.dao;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.ControlMearsureCurrent;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;

public interface ControlMearsureCurrentMapper extends
	SinglePrimaryKeyBaseMapper<ControlMearsureCurrent>{
	
	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return List<Current>
	 * @throws
	 */
	public List<LowVoltageCurrent> selectBySwitchId(Map<String, Object> xx);

	/**
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<LowVoltageCurrent> selectByTime(Map<String, Object> xx);

	/**
	 * 
	 * @Title: getRecentlyCurrent
	 * @Description: 读取实时电流
	 * @param @param switchId
	 * @return void
	 * @throws
	 */
	public List<ControlMearsureCurrent> getRecentlyCurrent();
}
