package com.gdut.dongjun.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.LocationSwitchMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.LocationSwitch;

@Repository
public class LocationSwitchDaoImpl extends SinglePrimaryKeyBaseDAOImpl<LocationSwitch>
	implements LocationSwitchMapper {

}
