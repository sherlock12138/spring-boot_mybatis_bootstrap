package com.gdut.dongjun.service.impl;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.port.ProtocolPort;
import com.gdut.dongjun.service.ProtocolPortService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;

@Service
public class ProtocolPortServiceImpl extends BaseServiceImpl<ProtocolPort>
	implements ProtocolPortService {

	@Override
	protected boolean isExist(ProtocolPort record) {
		// TODO Auto-generated method stub
		return true;
	}

}
