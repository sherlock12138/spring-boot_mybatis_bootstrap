package com.gdut.dongjun.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.LowVoltageCurrentMapper;
import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @Title: UserService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface LowVoltageVoltageService extends BaseService<LowVoltageVoltage> {

	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Voltage>
	 * @throws
	 */
	public Map<String, Object> selectBySwitchId(String switchId);

	/**
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param date
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public Map<String, Object> selectByTime(String switchId, String date);

	/**
	 * 
	 * @Title: getRecentlyVoltage
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Voltage>
	 * @throws
	 */
	public List<LowVoltageVoltage> getRecentlyVoltage();

}
