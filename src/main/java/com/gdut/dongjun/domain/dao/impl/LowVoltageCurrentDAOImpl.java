package com.gdut.dongjun.domain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.LowVoltageCurrentMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;

/**
 * 
 * @author Sherlock-lee
 * @date 2015年11月14日 下午4:56:37
 * @see TODO
 * @since 1.0
 */
@Repository
public class LowVoltageCurrentDAOImpl extends
		SinglePrimaryKeyBaseDAOImpl<LowVoltageCurrent> implements LowVoltageCurrentMapper {

	@Override
	public List<LowVoltageCurrent> selectBySwitchId(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectBySwitchId"), xx);
	}

	@Override
	public List<Object> selectByTime(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectByTime"), xx);
	}

	@Override
	public List<LowVoltageCurrent> getRecentlyCurrent() {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("getRecentlyCurrent"));

	}

}