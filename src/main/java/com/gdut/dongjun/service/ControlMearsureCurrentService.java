package com.gdut.dongjun.service;

import java.util.List;

import com.gdut.dongjun.domain.po.ControlMearsureCurrent;
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
	 * @description	读取实时电流
	 * @return TODO
	 */
	public List<ControlMearsureCurrent> getRecentlyCurrent();
}
