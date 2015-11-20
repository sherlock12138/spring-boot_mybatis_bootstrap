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

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.ControlMearsureCurrent;
import com.gdut.dongjun.domain.po.ControlMearsureVoltage;
import com.gdut.dongjun.domain.po.LowVoltageHitchEvent;
import com.gdut.dongjun.service.ControlMearsureCurrentService;
import com.gdut.dongjun.service.ControlMearsureHitchEventService;
import com.gdut.dongjun.service.ControlMearsureSwitchService;
import com.gdut.dongjun.service.ControlMearsureVoltageService;
import com.gdut.dongjun.service.impl.enums.ControlMearsureFunctionCode;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;
import com.gdut.dongjun.util.ControlMearsureDeviceCommandUtil;
import com.gdut.dongjun.util.LowVoltageDeviceCommandUtil;
import com.gdut.dongjun.util.UUIDUtil;
import com.gdut.dongjun.web.UserController;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Service
@Sharable
public class ControlMeasureDataReceiver extends ChannelInboundHandlerAdapter {

	@Autowired
	private ControlMearsureCurrentService currentService;
	@Autowired
	private ControlMearsureVoltageService voltageService;
	@Autowired
	private ControlMearsureSwitchService switchService;
	@Autowired
	private ControlMearsureHitchEventService hitchEventService;
	@Autowired
	private LowVoltageDeviceCommandUtil commandUtil;
	
	@Autowired
	private UserController controller;
	
	private static final String READ_ADDRESS = "68AAAAAAAAAAAA681300DF16";
	private static final Logger logger = Logger.getLogger(ControlMeasureDataReceiver.class);

	public ControlMeasureDataReceiver() {
		super();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		// Send greeting for a new connection.
		// System.out.println(InetAddress.getLocalHost().getHostName());

		SwitchGPRS gprs = new SwitchGPRS();// 添加ctx到Store中
		gprs.setCtx(ctx);
		CtxStore.add(gprs);

		ctx.channel().writeAndFlush(READ_ADDRESS);// 读取地址
		CtxStore.printCtxStore();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		String data = (String) msg;	// 查询后回来的报文
		System.out.println(data);
		data = data.replace(" ", "");
		String address = data.substring(10, 14);
		String controlCode = data.substring(16, 18);
		
		/*// 将接收到的客户端信息分类处理
		if (controlCode.equals("80")) {	// 读通信地址

			String address = data.substring(10, 12);
			address = commandUtil.decodeAddress(address);
			logger.info(address + " is online!");

			SwitchGPRS gprs = CtxStore.get(ctx);
			if (gprs != null) {

				String id = switchService.getSwitchId(address);
				gprs.setAddress(address);
				gprs.setId(id);
			} else {
				logger.info("can not get gprs,there is an error in setting ctx");
			}

		} else if (controlCode.equals("91") && data.length() < 51) {// 读数据(电流，电压)

			String address = data.substring(2, 14);
			address = commandUtil.decodeAddress(address);
			System.out.println(address);
			String id = CtxStore.getId(address);

			if (id != null && address != null) {
				saveCV(id, data);
			} else {
				logger.error("there is an error in saving CV!");
			}
		} else if (controlCode.equals("91") && data.length() == 82) {

			String address = data.substring(2, 14);
			address = commandUtil.decodeAddress(address);
			String id = CtxStore.getId(address);
			data = commandUtil.dataDecode(data);

			readHitchEvent(id, address, data);// 读取跳闸事件，处理
		} else {
			logger.info("undefine message received!");
		}*/
		
		if(controlCode.equals(ControlMearsureFunctionCode.
				RECENTLY_DATA_RESPONSE.toString())) {	//实时数据返回
			
			String id = CtxStore.getId(address);
			if(id != null || address != null) {
				saveCV(id, data);
			} else {
				logger.error("there is an error in saving CV!");
			}
		} else if(controlCode.equals(ControlMearsureFunctionCode.
				INTERGER_DATA_RESPONSE.toString())) {	//整点数据返回
			System.out.println("整点数据返回");
		} else if(controlCode.equals(ControlMearsureFunctionCode.
				COUNT_DATA_RESPONSE.toString())) {	//统计数据返回
			System.out.println("统计数据返回");
		} else {	//报警事件返回
			
			String eventId = data.substring(22, 24);
			String year = data.substring(24, 26);
			String month = data.substring(26, 28);
			String day = data.substring(28, 30);
			String hour = data.substring(32, 34);
			String minute = data.substring(34, 36);
		}
	};

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		
		CtxStore.remove(ctx);// 从Store中移除这个context
		CtxStore.printCtxStore();
	}

	/**
	 * 
	 * @Title: saveCV
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param data
	 * @return void
	 * @throws
	 */
	public void saveCV(String switchId, String data) {
		
		saveVoltage(switchId, ControlMearsureDeviceCommandUtil.
				cutString(4, data.substring(34, 46)));
		saveCurrent(switchId, ControlMearsureDeviceCommandUtil.
				cutString(4, data.substring(46, 58)));

		System.out.println("-------saved cv-----------");
	}

	/**
	 * @param switchId
	 * 
	 * @Title: saveCurrent
	 * @Description: TODO
	 * @param @param dStrings
	 * @return void
	 * @throws
	 */
	private void saveCurrent(String switchId, String[] dStrings) {
		
		logger.info("saving current..");
		Date date = new Date();
		ControlMearsureCurrent c1 = new ControlMearsureCurrent();
		c1.setId(UUIDUtil.getUUID());
		c1.setPhase("A");
		c1.setSwitchId(switchId);
		c1.setTime(date);
		c1.setValue(Integer.parseInt(dStrings[0], 16));
		
		ControlMearsureCurrent c2 = new ControlMearsureCurrent();
		c2.setId(UUIDUtil.getUUID());
		c2.setPhase("B");
		c2.setSwitchId(switchId);
		c2.setTime(date);
		c2.setValue(Integer.parseInt(dStrings[1], 16));

		ControlMearsureCurrent c3 = new ControlMearsureCurrent();
		c3.setId(UUIDUtil.getUUID());
		c3.setPhase("C");
		c3.setSwitchId(switchId);
		c3.setTime(date);
		c3.setValue(Integer.parseInt(dStrings[2], 16));
		
		currentService.insert(c1);
		currentService.insert(c2);
		currentService.insert(c3);
		logger.info("current has bean saved!");
		return;
	}

	/**
	 * @param switchId
	 * 
	 * @Title: saveVoltage
	 * @Description: TODO
	 * @param @param dStrings
	 * @return void
	 * @throws
	 */
	private void saveVoltage(String switchId, String[] dStrings) {

		logger.info("saving voltage...");
		Date date = new Date();
		ControlMearsureVoltage v1 = new ControlMearsureVoltage();
		v1.setId(UUIDUtil.getUUID());
		v1.setPhase("A");
		v1.setSwitchId(switchId);
		v1.setTime(date);
		v1.setValue(Integer.parseInt(dStrings[0]));

		ControlMearsureVoltage v2 = new ControlMearsureVoltage();
		v2.setId(UUIDUtil.getUUID());
		v2.setPhase("B");
		v2.setSwitchId(switchId);
		v2.setTime(date);
		v2.setValue(Integer.parseInt(dStrings[1]));

		ControlMearsureVoltage v3 = new ControlMearsureVoltage();
		v3.setId(UUIDUtil.getUUID());
		v3.setPhase("C");
		v3.setSwitchId(switchId);
		v3.setTime(date);
		v3.setValue(Integer.parseInt(dStrings[2]));
		
		voltageService.insert(v1);
		voltageService.insert(v2);
		voltageService.insert(v3);
		logger.info("voltage has bean saved!");
		return;
	}

	/**
	 * 
	 * @Title: readHitchEvent
	 * @Description: TODO
	 * @param @param id
	 * @param @param address
	 * @param @param data
	 * @return void
	 * @throws
	 */
	@SuppressWarnings("unused")
	private void readHitchEvent(String id, String address, String data) {

		/*if (address != null && id != null) {

			LowVoltageHitchEvent hitchEvent = LowVoltageDeviceCommandUtil.readHitchEvent(data);// 查询开关的结果
			hitchEvent.setId(UUIDUtil.getUUID());
			hitchEvent.setSwitchId(id);
			LowVoltageHitchEvent hitchEvent2 = hitchEventService.getRecentlyHitchEvent();

			hitchEvent2.getHitchTime().compareTo(hitchEvent.getHitchTime());

			if (hitchEvent2 != null) {
				if (hitchEvent != null) {
					if (hitchEvent2.getHitchTime().getTime() < hitchEvent// 当前的跳闸事件新增
							.getHitchTime().getTime()) {
						hitchEventService.insert(hitchEvent);// 存入数据库
						CtxStore.updateSwtichOpen(id);
					}

				}
			} else {
				hitchEventService.insert(hitchEvent);
				CtxStore.updateSwtichOpen(id);
			}

		}*/

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
	
	@Test
	public void testOne() {
		
	}

}
