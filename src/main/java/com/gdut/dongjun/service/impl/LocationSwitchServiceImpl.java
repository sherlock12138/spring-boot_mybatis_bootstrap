package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.LocationSwitchMapper;
import com.gdut.dongjun.domain.po.LocationSwitch;
import com.gdut.dongjun.service.LocationSwitchService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

@Service
public class LocationSwitchServiceImpl extends BaseServiceImpl<LocationSwitch>
	implements LocationSwitchService {

	@Autowired
	private LocationSwitchMapper switchMapper;

	@Override
	protected boolean isExist(LocationSwitch record) {

		if (record != null
				&& switchMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			
			return false;
		}
	}

}
