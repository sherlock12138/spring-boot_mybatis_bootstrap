/**
 * 
 */
package com.gdut.dongjun.domain.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.HighVoltageCurrentMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.HighVoltageCurrent;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.domain.dao.impl
 */
@Repository
public class HighVoltageCurrentDAOImpl extends
SinglePrimaryKeyBaseDAOImpl<HighVoltageCurrent> implements HighVoltageCurrentMapper {

	@Override
	public List<HighVoltageCurrent> selectBySwitchId(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectBySwitchId"), xx);
	}

	@Override
	public List<Object> selectByTime(Map<String, Object> xx) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("selectByTime"), xx);
	}

	@Override
	public List<HighVoltageCurrent> getRecentlyCurrent(HighVoltageCurrent hc) {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("getRecentlyCurrent"), hc);

	}
}
