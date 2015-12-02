/**
 * 
 */
package com.gdut.dongjun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.ControlMearsureCurrentMapper;
import com.gdut.dongjun.domain.dao.HighVoltageHitchEventMapper;
import com.gdut.dongjun.domain.po.HighVoltageHitchEvent;
import com.gdut.dongjun.domain.po.LowVoltageHitchEvent;
import com.gdut.dongjun.dto.HitchEvent;
import com.gdut.dongjun.service.HighVoltageHitchEventService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.service.impl
 */
@Service
public class HighVoltageHitchEventServiceImpl extends BaseServiceImpl<HighVoltageHitchEvent>
implements HighVoltageHitchEventService {
	
	@Autowired
	private HighVoltageHitchEventMapper currentMapper;

	@Override
	protected boolean isExist(HighVoltageHitchEvent record) {

		if (record != null
				&& currentMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}

}
