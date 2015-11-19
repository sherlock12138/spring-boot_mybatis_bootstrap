package com.gdut.dongjun.service;

import java.util.List;

import com.gdut.dongjun.domain.po.ControlMearsureVoltage;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureVoltageService.java
 * @description	TODO
 * @Date 2015年11月19日 下午3:33:05 
 * @version V1.0
 */
public interface ControlMearsureVoltageService extends
	BaseService<ControlMearsureVoltage>{

	/**
	 * @description	读取实时电压
	 * @return	TODO
	 */
	public List<ControlMearsureVoltage> getRecentlyVoltage();
}
