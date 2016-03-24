/**
 * 
 */
package com.gdut.dongjun.domain.dao;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.HighVoltageCurrent;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.domain.dao
 */
public interface HighVoltageCurrentMapper extends
		SinglePrimaryKeyBaseMapper<HighVoltageCurrent> {


	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return List<Current>
	 * @throws
	 */
	public List<HighVoltageCurrent> selectBySwitchId(Map<String, Object> xx);

	/**
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<Object> selectByTime(Map<String, Object> xx);

	/**
	 * 
	 * @Title: getRecentlyCurrent
	 * @Description: TODO
	 * @param @param switchId
	 * @return void
	 * @throws
	 */
	public List<HighVoltageCurrent> getRecentlyCurrent();
}
