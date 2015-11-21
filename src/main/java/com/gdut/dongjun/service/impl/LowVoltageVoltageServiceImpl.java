package com.gdut.dongjun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.LowVoltageVoltageMapper;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;
import com.gdut.dongjun.service.LowVoltageVoltageService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @Title: VoltageServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
@Service
public class LowVoltageVoltageServiceImpl extends BaseServiceImpl<LowVoltageVoltage> implements
		LowVoltageVoltageService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private LowVoltageVoltageMapper voltageMapper;

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
	public List<LowVoltageVoltage> getRecentlyVoltage() {
		// TODO Auto-generated method stub
		return voltageMapper.getRecentlyVoltage();
	}

	@Override
	protected boolean isExist(LowVoltageVoltage record) {

		if (record != null
				&& voltageMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}

}
