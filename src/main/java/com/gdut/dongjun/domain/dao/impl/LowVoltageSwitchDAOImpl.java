package com.gdut.dongjun.domain.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;

/**
 * 
 * @author	Sherlock-lee
 * @date	2015年11月14日 下午4:57:03
 * @see 	TODO
 * @since   1.0
 */
@Repository
public class LowVoltageSwitchDAOImpl extends SinglePrimaryKeyBaseDAOImpl<LowVoltageSwitch>
		implements LowVoltageSwitchMapper {

	@Override
	public List<LowVoltageSwitch> selectByLineId(String lineId) {
		// TODO Auto-generated method stub
		return template.selectList("selectByLineId", lineId);
	}




	
	
}
