package com.gdut.dongjun.domain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.ControlMearsureVoltageMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.ControlMearsureVoltage;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureVoltageDaoImpl.java
 * @description	TODO
 * @Date 2015年11月19日 下午3:29:49 
 * @version V1.0
 */
@Repository
public class ControlMearsureVoltageDaoImpl extends
	SinglePrimaryKeyBaseDAOImpl<ControlMearsureVoltage>
		implements ControlMearsureVoltageMapper {

	@Override
	public List<ControlMearsureVoltage> getRecentlyVoltage() {
		return template.selectList(getNamespace("getRecentlyVoltage"));
	}
		
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
}
