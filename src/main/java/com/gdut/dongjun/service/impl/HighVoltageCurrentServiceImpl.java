/**
 * 
 */
package com.gdut.dongjun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.HighVoltageCurrent;
import com.gdut.dongjun.service.HighVoltageCurrentService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.service.impl
 */
@Service
public class HighVoltageCurrentServiceImpl extends BaseServiceImpl<HighVoltageCurrent> implements
HighVoltageCurrentService {

	/* (non-Javadoc)
	 * @see com.gdut.dongjun.service.HighVoltageCurrentService#selectBySwitchId(java.lang.String)
	 */
	@Override
	public Map<String, Object> selectBySwitchId(String switchId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gdut.dongjun.service.HighVoltageCurrentService#selectByTime(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> selectByTime(String switchId, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gdut.dongjun.service.HighVoltageCurrentService#getRecentlyCurrent()
	 */
	@Override
	public List<HighVoltageCurrent> getRecentlyCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

}
