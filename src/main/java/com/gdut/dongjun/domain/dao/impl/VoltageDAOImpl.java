package com.gdut.dongjun.domain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.VoltageMapper;
import com.gdut.dongjun.domain.dao.impl.system.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.Voltage;

/**
 * @author Sherlock-lee
 * @version 创建时间：2015年3月20日 上午8:56:12
 * @Tel 15622358381
 * @state 站内消息DaoImpl
 */
@Repository
public class VoltageDAOImpl extends SinglePrimaryKeyBaseDAOImpl<Voltage>
		implements VoltageMapper {

	@Override
	public List<Voltage> selectBySwitchId(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectBySwitchId"), xx);
	}

	@Override
	public List<Voltage> selectByTime(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectByTime"), xx);
	}

	@Override
	public List<Voltage> getRecentlyVoltage() {
		// TODO Auto-generated method stub
		return template.selectList("getRecentlyVoltage");
	}

}
