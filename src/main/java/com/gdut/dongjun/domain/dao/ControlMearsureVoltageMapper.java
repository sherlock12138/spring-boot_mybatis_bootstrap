package com.gdut.dongjun.domain.dao;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.ControlMearsureVoltage;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;

public interface ControlMearsureVoltageMapper extends
	SinglePrimaryKeyBaseMapper<ControlMearsureVoltage>{
	
	/**
	 * @description	读取实时电压
	 * @return	TODO
	 */
	public List<ControlMearsureVoltage> getRecentlyVoltage();
	
	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Voltage>
	 * @throws
	 */
	public List<LowVoltageVoltage> selectBySwitchId(Map<String, Object> xx);

	/**
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<LowVoltageVoltage> selectByTime(Map<String, Object> xx);
}
