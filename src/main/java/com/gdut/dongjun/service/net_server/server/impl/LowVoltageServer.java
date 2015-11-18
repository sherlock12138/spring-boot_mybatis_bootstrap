package com.gdut.dongjun.service.net_server.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.service.impl.DataZone;
import com.gdut.dongjun.service.impl.enums.EventVariable;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;
import com.gdut.dongjun.service.net_server.initializer.ServerInitializer;
import com.gdut.dongjun.service.net_server.server.NetServer;
import com.gdut.dongjun.util.LowVoltageDeviceCommandUtil;

/**
 * @author Sherlock-lee
 * @date 2015年11月17日 下午12:01:03
 * @see TODO
 * @since 1.0
 */
@Service("LowVoltageServer")
public class LowVoltageServer extends NetServer {

	@Resource(name = "LowVoltageServerInitializer")
	private ServerInitializer initializer;
	@Autowired
	private LowVoltageSwitchService lowVoltageSwitchService;

	@Resource(name = "LowVoltageServerInitializer")
	public void setInitializer(ServerInitializer initializer) {

		super.initializer = initializer;
	}

	/**
	 * 
	 * @Title: hitchEventSpy
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	@Override
	protected void hitchEventSpy() {

		List<LowVoltageSwitch> switchs = lowVoltageSwitchService
				.selectByParameters(null);

		if (switchs != null) {
			for (LowVoltageSwitch s : switchs) {

				if (s.getId() != null) {

					SwitchGPRS gprs = CtxStore.get(s.getId());
					String msg = LowVoltageDeviceCommandUtil.read(gprs
							.getAddress(), new DataZone(
							EventVariable.HITCH_EVENT.toString()));

					gprs.getCtx().writeAndFlush(msg);
				}
			}
		}

	}

	/**
	 * 
	 * @Title: timedCVRead
	 * @Description: 定时读取电流电压
	 * @param
	 * @return void
	 * @throws
	 */
	@Override
	protected void timedCVReadTask() {

		String msg = null;
		List<LowVoltageSwitch> switchs = lowVoltageSwitchService
				.selectByParameters(null);

		if (switchs != null) {
			for (LowVoltageSwitch s : switchs) {

				if (s.getId() != null) {

					SwitchGPRS gprs = CtxStore.get(s.getId());
					msg = LowVoltageDeviceCommandUtil.readAllPhaseVoltage(gprs
							.getAddress());

					gprs.getCtx().writeAndFlush(msg);// 读取电压
				}
			}

			for (LowVoltageSwitch s : switchs) {

				if (s.getId() != null) {

					SwitchGPRS gprs = CtxStore.get(s.getId());
					msg = LowVoltageDeviceCommandUtil.readAllPhaseCurrent(gprs
							.getAddress());

					gprs.getCtx().writeAndFlush(msg);// 读取电流
				}
			}
		}
	}
}
