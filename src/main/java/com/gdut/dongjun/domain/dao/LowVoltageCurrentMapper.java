package com.gdut.dongjun.domain.dao;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;

public interface LowVoltageCurrentMapper extends SinglePrimaryKeyBaseMapper<LowVoltageCurrent> {

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
	public List<Object> selectByTime(Map<String, Object> xx);

	/**
	 * 
	 * @Title: getRecentlyCurrent
	 * @Description: TODO
	 * @param @param switchId
	 * @return void
	 * @throws
	 */
	public List<LowVoltageCurrent> getRecentlyCurrent();

}