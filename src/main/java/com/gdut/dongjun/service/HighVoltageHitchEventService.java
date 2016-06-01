package com.gdut.dongjun.service;

import java.util.List;

import com.gdut.dongjun.domain.po.HighVoltageHitchEvent;
import com.gdut.dongjun.service.base.BaseService;
/**
 * 
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.service
 */
public interface HighVoltageHitchEventService extends BaseService<HighVoltageHitchEvent> {

	public HighVoltageHitchEvent getRecentHitchEvent(String id);

	public List<HighVoltageHitchEvent> getAllHighEventByTime();
	
}
