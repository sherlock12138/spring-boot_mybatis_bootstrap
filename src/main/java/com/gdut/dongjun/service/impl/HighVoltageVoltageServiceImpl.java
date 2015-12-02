/**
 * 
 */
package com.gdut.dongjun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.HighVoltageVoltageMapper;
import com.gdut.dongjun.domain.po.HighVoltageVoltage;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;
import com.gdut.dongjun.service.HighVoltageCurrentService;
import com.gdut.dongjun.service.HighVoltageVoltageService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MyBatisMapUtil;

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

	@Autowired
	private HighVoltageVoltageMapper voltageMapper;
	@Override
	public Map<String, Object> selectBySwitchId(String switchId) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("switch_id", switchId);
		map.put("phase", "A");
		result.put("A", voltageMapper.selectBySwitchId(MyBatisMapUtil.warp(map)));
		map.remove("phase");
		map.put("phase", "B");
		result.put("B", voltageMapper.selectBySwitchId(MyBatisMapUtil.warp(map)));
		map.remove("phase");
		map.put("phase", "C");
		result.put("C", voltageMapper.selectBySwitchId(MyBatisMapUtil.warp(map)));
		return result;
	}

	@Override
	public Map<String, Object> selectByTime(String switchId, String date) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> xx = new HashMap<String, Object>();
		xx.put("switchId", switchId);
		xx.put("phase", "A");
		xx.put("time", date);
		result.put("A", voltageMapper.selectByTime(xx));
		xx.remove("phase");
		xx.put("phase", "B");
		result.put("B", voltageMapper.selectByTime(xx));
		xx.remove("phase");
		xx.put("phase", "C");
		result.put("C", voltageMapper.selectByTime(xx));
		return result;
	}

	@Override
	public List<HighVoltageVoltage> getRecentlyVoltage() {
		// TODO Auto-generated method stub
		return voltageMapper.getRecentlyVoltage();
	}

	@Override
	protected boolean isExist(HighVoltageVoltage record) {

		if (record != null
				&& voltageMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}



}
