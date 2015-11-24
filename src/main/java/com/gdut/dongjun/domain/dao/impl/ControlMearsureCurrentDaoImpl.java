package com.gdut.dongjun.domain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.ControlMearsureCurrentMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.ControlMearsureCurrent;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;

/**
 * @author Xiaomian_Link <972192420@qq.com>
 * @className ControlMearsureCurrentDaoImpl.java
 * @description	TODO
 * @Date 2015年11月19日 下午3:29:41 
 * @version V1.0
 */
@Repository
public class ControlMearsureCurrentDaoImpl 
	extends SinglePrimaryKeyBaseDAOImpl<ControlMearsureCurrent> 
		implements ControlMearsureCurrentMapper {

	@Override
	public List<ControlMearsureCurrent> getRecentlyCurrent() {
		return template.selectList(getNamespace("getRecentlyCurrent"));
	}

	@Override
	public List<LowVoltageCurrent> selectBySwitchId(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectBySwitchId"), xx);
	}

	@Override
	public List<LowVoltageCurrent> selectByTime(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectByTime"), xx);
	}


}
