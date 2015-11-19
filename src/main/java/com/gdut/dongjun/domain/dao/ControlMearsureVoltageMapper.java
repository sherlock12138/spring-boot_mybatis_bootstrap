package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.ControlMearsureVoltage;

public interface ControlMearsureVoltageMapper extends
	SinglePrimaryKeyBaseMapper<ControlMearsureVoltage>{
	
	/**
	 * @description	读取实时电压
	 * @return	TODO
	 */
	public List<ControlMearsureVoltage> getRecentlyVoltage();
}
