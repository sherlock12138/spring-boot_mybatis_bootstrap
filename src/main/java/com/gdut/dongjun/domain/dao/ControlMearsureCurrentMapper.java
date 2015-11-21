package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.ControlMearsureCurrent;

public interface ControlMearsureCurrentMapper extends
	SinglePrimaryKeyBaseMapper<ControlMearsureCurrent>{
	
	/**
	 * @description	读取实时电流
	 * @return TODO
	 */
	public List<ControlMearsureCurrent> getRecentlyCurrent();
	
}
