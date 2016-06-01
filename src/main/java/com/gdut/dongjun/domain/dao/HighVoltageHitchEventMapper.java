/**
 * 
 */
package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.HighVoltageHitchEvent;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.domain.dao
 */
public interface HighVoltageHitchEventMapper extends
SinglePrimaryKeyBaseMapper<HighVoltageHitchEvent> {

	HighVoltageHitchEvent getRecentHitchEvent(String id);

	public List<HighVoltageHitchEvent> getAllHighEventByTime();

}
