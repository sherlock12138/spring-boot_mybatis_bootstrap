/**
 * 
 */
package com.gdut.dongjun.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.HighVoltageVoltage;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;
import com.gdut.dongjun.service.HighVoltageVoltageService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.service.impl
 */
@Service
public class HighVoltageVoltageServiceImpl extends BaseServiceImpl<HighVoltageVoltage> implements
HighVoltageVoltageService {

	/* (non-Javadoc)
	 * @see com.gdut.dongjun.service.HighVoltageVoltageService#selectBySwitchId(java.lang.String)
	 */
	@Override
	public Map<String, Object> selectBySwitchId(String switchId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gdut.dongjun.service.HighVoltageVoltageService#selectByTime(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> selectByTime(String switchId, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gdut.dongjun.service.HighVoltageVoltageService#getRecentlyVoltage()
	 */
	@Override
	public List<HighVoltageVoltage> getRecentlyVoltage() {
		// TODO Auto-generated method stub
		return null;
	}



}
