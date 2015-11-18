package com.gdut.dongjun.domain.dao;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.system.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.Voltage;

public interface VoltageMapper extends SinglePrimaryKeyBaseMapper<Voltage> {

	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Voltage>
	 * @throws
	 */
	public List<Voltage> selectBySwitchId(Map<String, Object> xx);

	/**
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<Voltage> selectByTime(Map<String, Object> xx);

	/**
	 * 
	 * @Title: getRecentlyVoltage
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Voltage>
	 * @throws
	 */
	public List<Voltage> getRecentlyVoltage();

}