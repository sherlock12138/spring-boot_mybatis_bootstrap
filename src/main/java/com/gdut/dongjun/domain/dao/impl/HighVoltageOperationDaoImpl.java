package com.gdut.dongjun.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.HighVoltageOperationMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.HighVoltageOperation;

@Repository
public class HighVoltageOperationDaoImpl extends SinglePrimaryKeyBaseDAOImpl<HighVoltageOperation>
	implements HighVoltageOperationMapper {

}
