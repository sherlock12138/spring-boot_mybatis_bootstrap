/**
 * 
 */
package com.gdut.dongjun.domain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.HighVoltageVoltageMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.HighVoltageVoltage;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.domain.dao.impl
 */
@Repository
public class HighVoltageVoltageDAOImpl extends
SinglePrimaryKeyBaseDAOImpl<HighVoltageVoltage> implements HighVoltageVoltageMapper {

	@Override
	public List<HighVoltageVoltage> selectBySwitchId(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectBySwitchId"), xx);
	}

	@Override
	public List<Object> selectByTime(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectByTime"), xx);
	}

	@Override
	public List<HighVoltageVoltage> getRecentlyVoltage() {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("getRecentlyVoltage"));
	}

}
