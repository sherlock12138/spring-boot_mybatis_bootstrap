package com.gdut.dongjun.domain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.LowVoltageVoltageMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;

/**
 * 
 * @author Sherlock-lee
 * @date 2015年11月14日 下午4:57:08
 * @see TODO
 * @since 1.0
 */
@Repository
public class LowVoltageVoltageDAOImpl extends
		SinglePrimaryKeyBaseDAOImpl<LowVoltageVoltage> implements LowVoltageVoltageMapper {

	@Override
	public List<LowVoltageVoltage> selectBySwitchId(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectBySwitchId"), xx);
	}

	@Override
	public List<LowVoltageVoltage> selectByTime(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectByTime"), xx);
	}

	@Override
	public List<LowVoltageVoltage> getRecentlyVoltage() {
		// TODO Auto-generated method stub
		return template.selectList("getRecentlyVoltage");
	}

}
