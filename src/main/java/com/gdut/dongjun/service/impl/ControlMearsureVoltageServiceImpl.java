package com.gdut.dongjun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.ControlMearsureVoltageMapper;
import com.gdut.dongjun.domain.po.ControlMearsureVoltage;
import com.gdut.dongjun.service.ControlMearsureVoltageService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureVoltageServiceImpl.java
 * @description
 * @Date 2015年11月19日 下午3:31:56 
 * @version V1.0
 */
@Service
public class ControlMearsureVoltageServiceImpl extends
	BaseServiceImpl<ControlMearsureVoltage> implements
		ControlMearsureVoltageService {

	@Autowired
	private ControlMearsureVoltageMapper voltageMapper;
	
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
	public Map<String, Object> selectByTime(String switchId, String beginDate,
			String endDate) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> xx = new HashMap<String, Object>();
		xx.put("switchId", switchId);
		xx.put("phase", "A");
		xx.put("beginDate", beginDate);
		xx.put("endDate", endDate);
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
	public List<ControlMearsureVoltage> getRecentlyVoltage() {
		return voltageMapper.getRecentlyVoltage();
	}

	@Override
	protected boolean isExist(ControlMearsureVoltage record) {

		if (record != null
				&& voltageMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}

}
