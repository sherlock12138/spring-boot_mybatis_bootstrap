package com.gdut.dongjun.service.net_server.server.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.service.net_server.initializer.ServerInitializer;
import com.gdut.dongjun.service.net_server.server.NetServer;

/**
 * @author Sherlock-lee
 * @date 2015年11月17日 下午12:01:03
 * @see TODO
 * @since 1.0
 */
@Service("ControlMeasureServer")
public class ControlMeasureServer extends NetServer {

	@Resource(name = "ControlMeasureServerInitializer")
	private ServerInitializer initializer;

	@Resource(name = "ControlMeasureServerInitializer")
	public void setInitializer(ServerInitializer initializer) {

		super.initializer = initializer;
	}

	@Override
	protected void hitchEventSpy() {
		
		
	}

	@Override
	protected void timedCVReadTask() {
		
		
	}

}
