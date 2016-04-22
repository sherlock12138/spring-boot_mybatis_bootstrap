package com.gdut.dongjun.service.net_server.server.impl;

import java.util.List;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.service.HighVoltageSwitchService;
import com.gdut.dongjun.service.impl.enums.HighCommandControlCode;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;
import com.gdut.dongjun.service.net_server.initializer.ServerInitializer;
import com.gdut.dongjun.service.net_server.server.NetServer;
import com.gdut.dongjun.util.HighVoltageDeviceCommandUtil;


/**
 * @author Sherlock-lee
 * @date 2015年11月17日 下午12:01:03
 * @see TODO
 * @since 1.0
 */
@Service("HighVoltageServer")
public class HighVoltageServer extends NetServer {

	@Resource(name = "HighVoltageServerInitializer")
	private ServerInitializer initializer;
	@Autowired
	private HighVoltageSwitchService lowVoltageSwitchService;
	private static final Logger logger = Logger
			.getLogger(HighVoltageServer.class);

	@Resource(name = "HighVoltageServerInitializer")
	public void setInitializer(ServerInitializer initializer) {

		super.initializer = initializer;
		super.hitchEventBreak = 30 * 60 * 1000;
		// super.cvReadBreak = 30 * 1000;//设置较短的读取间隔
	}

	@Override
	protected void hitchEventSpy() {

		List<HighVoltageSwitch> switchs = lowVoltageSwitchService
				.selectByParameters(null);

		if (switchs != null) {
			for (HighVoltageSwitch s : switchs) {
				if (s.getId() != null && CtxStore.isReady(s.getId())) {
					totalCall(s);
				}
			}
		}

	}
	
	/**
	 * 这个方法可以用于当有新的高压开关在线时，进行一次总召.
	 * @return 返回发送总召命令的报文
	 */
	public static String totalCall(HighVoltageSwitch s) {
		
		return totalCall(s.getId());
	}
	
	public static String totalCall(String id) {
		
		SwitchGPRS gprs = CtxStore.get(id);
		String msg = new HighVoltageDeviceCommandUtil()
				.readVoltageAndCurrent(gprs.getAddress(),
						HighCommandControlCode.READ_VOLTAGE_CURRENT
								.toString());
		logger.info("总召激活地址：" + gprs.getAddress() + "---" + msg);
		gprs.getCtx().writeAndFlush(msg);// 读取电压
		return msg;
	}

	@Override
	protected void timedCVReadTask() {
		
	}	
	
}
