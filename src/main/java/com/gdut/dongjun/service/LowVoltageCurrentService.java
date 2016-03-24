package com.gdut.dongjun.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.LowVoltageCurrentMapper;
import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @Title: UserService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface LowVoltageCurrentService extends
		BaseService<LowVoltageCurrent> {

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
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param date
	 * @param @param string
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	public List<Object> selectByTime(String switchId, String date,
			String string);

	/**
	 * 
	 * @Title: getRecentlyHitchEvent
	 * @Description: TODO
	 * @param @param switchId
	 * @return void
	 * @throws
	 */
	public List<LowVoltageCurrent> getRecentlyCurrent();

}
