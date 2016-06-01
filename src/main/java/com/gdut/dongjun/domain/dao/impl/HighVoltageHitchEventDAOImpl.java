/**
 * 
 */
package com.gdut.dongjun.domain.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.HighVoltageHitchEventMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.HighVoltageHitchEvent;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.domain.dao.impl
 */
@Repository
public class HighVoltageHitchEventDAOImpl extends SinglePrimaryKeyBaseDAOImpl<HighVoltageHitchEvent>
implements HighVoltageHitchEventMapper {


	@Override
	public HighVoltageHitchEvent getRecentHitchEvent(String id) {
		return template.selectOne(getNamespace("getRecentHitchEvent"), id);
	}

	@Override
	public List<HighVoltageHitchEvent> getAllHighEventByTime() {
		return template.selectList(getNamespace("getAllHighEventByTime"));
	}
}
