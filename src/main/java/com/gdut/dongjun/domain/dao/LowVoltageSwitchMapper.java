package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;

public interface LowVoltageSwitchMapper extends SinglePrimaryKeyBaseMapper<LowVoltageSwitch> {

	/**
	 * 
	 * @Title: selectByLineId
	 * @Description: TODO
	 * @param @param lineId
	 * @param @return
	 * @return List<Switch>
	 * @throws
	 */
	public List<LowVoltageSwitch> selectByLineId(String lineId);


}