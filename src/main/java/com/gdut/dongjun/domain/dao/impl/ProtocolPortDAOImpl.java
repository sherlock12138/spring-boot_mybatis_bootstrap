package com.gdut.dongjun.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.ProtocolPortMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.port.ProtocolPort;

@Repository
public class ProtocolPortDAOImpl extends SinglePrimaryKeyBaseDAOImpl<ProtocolPort>
	implements ProtocolPortMapper {

}
