/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.gdut.dongjun.service.net_server.handler.msg_decoder;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.HighVoltageCurrent;
import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.domain.po.HighVoltageVoltage;
import com.gdut.dongjun.service.HighVoltageCurrentService;
import com.gdut.dongjun.service.HighVoltageHitchEventService;
import com.gdut.dongjun.service.HighVoltageSwitchService;
import com.gdut.dongjun.service.HighVoltageVoltageService;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;
import com.gdut.dongjun.util.HighVoltageDeviceCommandUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;
import com.gdut.dongjun.web.UserController;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Service
@Sharable
public class HighVoltageDataReceiver extends ChannelInboundHandlerAdapter {

	@Autowired
	private HighVoltageCurrentService currentService;
	@Autowired
	private HighVoltageVoltageService voltageService;
	@Autowired
	private HighVoltageSwitchService switchService;
	@Autowired
	private HighVoltageHitchEventService hitchEventService;
	@Autowired
	private HighVoltageDeviceCommandUtil commandUtil;
	@Autowired
	private UserController controller;
	private static final String READ_ADDRESS = "68AAAAAAAAAAAA681300DF16";
	private static final Logger logger = Logger
			.getLogger(HighVoltageDataReceiver.class);

	public HighVoltageDataReceiver() {
		super();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		// Send greeting for a new connection.
		// System.out.println(InetAddress.getLocalHost().getHostName());

		SwitchGPRS gprs = new SwitchGPRS();// 添加ctx到Store中
		gprs.setCtx(ctx);
		CtxStore.add(gprs);

		// ***********************************************
		// 设备刚连上我们的服务器还不知道它的地址的,先查一下它的地址
		// ***********************************************
		// ctx.channel().writeAndFlush(READ_ADDRESS);// 读取地址
		CtxStore.printCtxStore();
		//

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		String data = (String) msg;// 查询后回来的报文
		data = data.replace(" ", "");
		String controlCode = data.substring(14, 16);
		// EB 90 EB 90 EB 90 01 00 16
		// 将接收到的客户端信息分类处理
		logger.info("数据---------"+data);

		if (data.startsWith("EB90") || data.startsWith("eb90")) {
			// 读通信地址
			String address = new HighVoltageDeviceCommandUtil()
					.reverseString(data.substring(12, 16));

			SwitchGPRS gprs = CtxStore.get(ctx);
			if (gprs != null) {

				List<HighVoltageSwitch> list = switchService
						.selectByParameters(MyBatisMapUtil.warp("address",
								address));
				HighVoltageSwitch s = null;
				if (list != null && list.size() != 0) {

					s = list.get(0);
					String id = s.getId();
					gprs.setAddress(address);
					gprs.setId(id);
					logger.info(address + " is ready!");
					ctx.channel().writeAndFlush(data);// 需要原样返回
				}else {
					logger.info("this device is not registered!!");
				}
			} else {
				logger.info("can not get gprs,there is an error in setting ctx");
			}
			

		} else if (controlCode.equals("09")) {
			// 读数据(电流，电压)
			logger.info("解析CV---------"+data);
			String address = data.substring(10, 14);
			address = new HighVoltageDeviceCommandUtil().reverseString(address);
			System.out.println(address);
			String id = CtxStore.getId(address);

			if (id != null && address != null) {
				saveCV(id, data);
			} else {
				logger.error("there is an error in saving CV!");
			}
		} else {
			logger.info("undefine message received!");
			logger.error("接收到的非法数据--------------------"+data);
		}

	};

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {

		CtxStore.remove(ctx);// 从Store中移除这个context
		CtxStore.printCtxStore();
	}

	/**
	 * 
	 * @Title: saveCV @Description: TODO @param @param switchId @param @param
	 *         data @return void @throws
	 */
	public void saveCV(String switchId, String data) {
		data = data.replace(" ", "");
		String ABVoltage = new HighVoltageDeviceCommandUtil()
				.readABPhaseVoltage(data);
		String BCVoltage = new HighVoltageDeviceCommandUtil()
				.readBCPhaseVoltage(data);
		String ACurrent = new HighVoltageDeviceCommandUtil()
				.readAPhaseCurrent(data);
		String BCurrent = new HighVoltageDeviceCommandUtil()
				.readBPhaseCurrent(data);
		String CCurrent = new HighVoltageDeviceCommandUtil()
				.readCPhaseCurrent(data);
		String[] dStrings_voltage = { ABVoltage, BCVoltage };

		saveVoltage(switchId, dStrings_voltage);
		String[] dStrings_current = { ACurrent, BCurrent, CCurrent };
		saveCurrent(switchId, dStrings_current);

		System.out.println("-------saved cv-----------");
	}

	/**
	 * @param switchId
	 * 
	 * @Title: saveCurrent @Description: TODO @param @param dStrings @return
	 *         void @throws
	 */
	private void saveCurrent(String switchId, String[] dStrings) {

		logger.info("saving current..");
		Date date = new Date();
		HighVoltageCurrent c1 = new HighVoltageCurrent();
		c1.setId(UUIDUtil.getUUID());
		c1.setPhase("A");
		c1.setSwitchId(switchId);
		c1.setTime(date);
		c1.setValue(Integer.parseInt(dStrings[0]));

		HighVoltageCurrent c2 = new HighVoltageCurrent();
		c2.setId(UUIDUtil.getUUID());
		c2.setPhase("B");
		c2.setSwitchId(switchId);
		c2.setTime(date);
		c2.setValue(Integer.parseInt(dStrings[1]));

		HighVoltageCurrent c3 = new HighVoltageCurrent();
		c3.setId(UUIDUtil.getUUID());
		c3.setPhase("C");
		c3.setSwitchId(switchId);
		c3.setTime(date);
		c3.setValue(Integer.parseInt(dStrings[2]));

		currentService.insert(c1);
		currentService.insert(c2);
		currentService.insert(c3);
		logger.info("current has bean saved!");
	}

	/**
	 * @param switchId
	 * 
	 * @Title: saveVoltage @Description: TODO @param @param dStrings @return
	 *         void @throws
	 */
	@Test
	private void saveVoltage(String switchId, String[] dStrings) {

		logger.info("saving voltage...");
		Date date = new Date();
		HighVoltageVoltage v1 = new HighVoltageVoltage();
		v1.setId(UUIDUtil.getUUID());
		v1.setPhase("AB");
		v1.setSwitchId(switchId);
		v1.setTime(date);
		v1.setValue(Integer.parseInt(dStrings[0]));

		HighVoltageVoltage v2 = new HighVoltageVoltage();
		v2.setId(UUIDUtil.getUUID());
		v2.setPhase("BC");
		v2.setSwitchId(switchId);
		v2.setTime(date);
		v2.setValue(Integer.parseInt(dStrings[1]));

		voltageService.insert(v1);
		voltageService.insert(v2);
		logger.info("voltage has bean saved!");
		return;
	}

	/**
	 * 
	 * @Title: readHitchEvent @Description: TODO @param @param id @param @param
	 *         address @param @param data @return void @throws
	 */
	@SuppressWarnings("unused")
	private void readHitchEvent(String id, String address, String data) {
		//
		// if (address != null && id != null) {
		//
		// LowVoltageHitchEvent hitchEvent =
		// LowVoltageDeviceCommandUtil.readHitchEvent(data);// 查询开关的结果
		// hitchEvent.setId(UUIDUtil.getUUID());
		// hitchEvent.setSwitchId(id);
		// LowVoltageHitchEvent hitchEvent2 =
		// hitchEventService.getRecentlyHitchEvent();
		//
		// hitchEvent2.getHitchTime().compareTo(hitchEvent.getHitchTime());
		//
		// if (hitchEvent2 != null) {
		// if (hitchEvent != null) {
		// if (hitchEvent2.getHitchTime().getTime() < hitchEvent// 当前的跳闸事件新增
		// .getHitchTime().getTime()) {
		// hitchEventService.insert(hitchEvent);// 存入数据库
		// CtxStore.updateSwtichOpen(id);
		// }
		//
		// }
		// } else {
		// hitchEventService.insert(hitchEvent);
		// CtxStore.updateSwtichOpen(id);
		// }
		//
		// }

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}
