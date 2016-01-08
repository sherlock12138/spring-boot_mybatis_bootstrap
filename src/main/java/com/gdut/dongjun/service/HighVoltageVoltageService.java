package com.gdut.dongjun.service;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.po.HighVoltageVoltage;
import com.gdut.dongjun.service.base.BaseService;
/**
 * 
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.service
 */
public interface HighVoltageVoltageService extends BaseService<HighVoltageVoltage> {

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
	 * @param string 
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param date
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public Map<String, Object> selectByTime(String switchId, String date, String string);

	/**
	 * 
	 * @Title: getRecentlyVoltage
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Voltage>
	 * @throws
	 */
	public List<HighVoltageVoltage> getRecentlyVoltage();

}
