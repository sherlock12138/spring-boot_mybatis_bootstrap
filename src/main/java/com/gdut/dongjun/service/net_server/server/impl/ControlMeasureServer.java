package com.gdut.dongjun.service.net_server.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.ControlMearsureSwitch;
import com.gdut.dongjun.service.ControlMearsureSwitchService;
import com.gdut.dongjun.service.impl.enums.ControlMearsureFunctionCode;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;
import com.gdut.dongjun.service.net_server.initializer.ServerInitializer;
import com.gdut.dongjun.service.net_server.server.NetServer;
import com.gdut.dongjun.util.ControlMearsureDeviceCommandUtil;

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
	@Autowired
	private ControlMearsureSwitchService lowVoltageSwitchService;

	@Resource(name = "ControlMeasureServerInitializer")
	public void setInitializer(ServerInitializer initializer) {

		super.initializer = initializer;
		super.hitchEventBreak = 35 * 60 * 1000;// 延迟了报警事件的读取
	}

	@Override
	protected void hitchEventSpy() {
		List<ControlMearsureSwitch> switchs = lowVoltageSwitchService
				.selectByParameters(null);

		if (switchs != null) {
			for (ControlMearsureSwitch s : switchs) {

				if (s.getId() != null && CtxStore.isReady(s.getId())) {

					SwitchGPRS gprs = CtxStore.get(s.getId());
					String msg = ControlMearsureDeviceCommandUtil
							.getTotalMessage(
									ControlMearsureFunctionCode.EVENT_REQUEST
											.toString(), s.getAddress());

					gprs.getCtx().writeAndFlush(msg);
				}
			}
		}
	}

	@Override
	protected void timedCVReadTask() {

		List<ControlMearsureSwitch> switchs = lowVoltageSwitchService
				.selectByParameters(null);

		if (switchs != null) {
			for (ControlMearsureSwitch s : switchs) {

				if (s.getId() != null && CtxStore.isReady(s.getId())) {

					SwitchGPRS gprs = CtxStore.get(s.getId());

					String msg = ControlMearsureDeviceCommandUtil
							.getTotalMessage(
									ControlMearsureFunctionCode.RECENTLY_DATA_REQUEST
											.toString(), s.getAddress());

					gprs.getCtx().writeAndFlush(msg);
				}
			}
		}

	}

}
