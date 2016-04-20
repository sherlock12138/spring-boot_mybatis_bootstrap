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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.po.HighVoltageCurrent;
import com.gdut.dongjun.domain.po.HighVoltageHitchEvent;
import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.domain.po.HighVoltageVoltage;
import com.gdut.dongjun.service.HighVoltageCurrentService;
import com.gdut.dongjun.service.HighVoltageHitchEventService;
import com.gdut.dongjun.service.HighVoltageSwitchService;
import com.gdut.dongjun.service.HighVoltageVoltageService;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;
import com.gdut.dongjun.service.net_server.server.impl.HighVoltageServer;
import com.gdut.dongjun.service.net_server.status.HighVoltageStatus;
import com.gdut.dongjun.util.HighVoltageDeviceCommandUtil;
import com.gdut.dongjun.util.LowVoltageDeviceCommandUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.TimeUtil;
import com.gdut.dongjun.util.UUIDUtil;

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

	private static final Logger logger = Logger.getLogger(HighVoltageDataReceiver.class);

	public HighVoltageDataReceiver() {
		super();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		// Send greeting for a new connection.
		// System.out.println(InetAddress.getLocalHost().getHostName());

		SwitchGPRS gprs = new SwitchGPRS();// 添加ctx到Store中
		gprs.setCtx(ctx);
		if (CtxStore.get(ctx) == null) {
			CtxStore.add(gprs);
		}

		// ***********************************************
		// 设备刚连上我们的服务器还不知道它的地址的,先查一下它的地址
		// ***********************************************
		// ctx.channel().writeAndFlush(READ_ADDRESS);// 读取地址
		//CtxStore.printCtxStore();
		//
	}

	private static boolean checkCrc(String data) {
		
		String controlCode = data.substring(8, 10);
		String addressCoode = data.substring(10, 14);
		String CrcCode = data.substring(data.length() - 4, data.length() - 2);
		if(true) {
			return true;
		}
		return false;
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String data = (String) msg;// 查询后回来的报文
		data = data.replace(" ", "");
		logger.info("接收到的报文： " + data);
		// 截取控制码
		//if(!data.startsWith("EB90") && !checkCrc(data))
		String infoIdenCode = data.substring(14, 16);
		String hitchEventDesc = "控制回路";
		if (data.length() == 190) {

			hitchEventDesc = getHitchReason(data.substring(140, 160));
		}

		/**
		 * 将接收到的客户端信息分类处理
		 * 读通信地址并将地址反转
		 */
		if ((data.startsWith("EB90") || data.startsWith("eb90"))) {
			
			SwitchGPRS gprs = CtxStore.get(ctx);
			/**
			 * 当注册的高压开关的地址不为空，说明已经注册过了，不再进行相关操作
			 */
			if(gprs != null && gprs.getAddress() != null) {
				ctx.channel().writeAndFlush(data);
				return;
			}
			String address = data.substring(12, 16);
			gprs.setAddress(address);

			address = new HighVoltageDeviceCommandUtil().reverseString(address);

			if (gprs != null) {
				/**
				 * 根据反转后的地址查询得到highvoltageswitch的集合
				 */
				List<HighVoltageSwitch> list = switchService
						.selectByParameters(MyBatisMapUtil.warp("address", Integer.parseInt(address, 16)));
				HighVoltageSwitch s = null;
				if (list != null && list.size() != 0) {

					s = list.get(0);
					String id = s.getId();
					gprs.setId(id);
					
					/**
					 * 这个地方是开始对bug的一个测试，当开关从跳闸到合闸的时候，无法及时获取，只能
					 * 这样替换ctx才能进行状态更新
					 * 
					 * 	if (CtxStore.get(id) != null) {
					 *		CtxStore.remove(id);
					 *		CtxStore.add(gprs);
					 *	}
					 * 
					 */
					HighVoltageServer.totalCall(id);
					if(CtxStore.get(id) != null) {
						CtxStore.remove(id);
						CtxStore.add(gprs);
					}
				} else {
					logger.info("this device is not registered!!");
				}
			}
		} else if(infoIdenCode.equals("64")) {
			/**
			 * 总召激活确定
			 */
			logger.info("总召激活已经确定：" + data.substring(10, 14));
		} else if(infoIdenCode.equals("1f")) {
			/**
			 * 遥信变位确定
			 */
			String resu = new HighVoltageDeviceCommandUtil().confirmChange(data.substring(10, 14));
			logger.info("遥信变位---------" + resu);
			ctx.writeAndFlush(resu);
		} else if (infoIdenCode.equals("09")) {
			
			if(!data.substring(2,4).equals("47")) {
				/**
				 * 若data.length=40，测归一值
				 */
				logger.info("测归一值-------" + data);
				//680e0e68f4680009010301680008400000001a16
				//68131368f46600090203016600054000000006402700008116
				//68131368f46600090203016600054000000006402700008116
				for(int i = 22; i + 14 < data.length(); i += 10) {
					getMessageAddress(data.substring(i + 4, i + 8), data.substring(22, 26), 
							data.substring(i + 8, i + 14));
				}
				return;
			}
			logger.info("解析CV---------" + data);
			String address = data.substring(10, 14);
			String id = CtxStore.getIdbyAddress(address);
			if (id != null) {
				saveCV(id, data);
			} else {
				logger.error("there is an error in saving CV!");
			}
			/**
			 * 全遥测后终止总召
			 */
			String resu = new HighVoltageDeviceCommandUtil().finshTotalCall(data.substring(10, 14));
			/**
			 * 等待发回全遥测数据后执行终止
			 */
			logger.info("总召激活确定并收到全遥测，开始终止总召----------" + resu);
			ctx.writeAndFlush(resu);
		} else if (infoIdenCode.equals("01")) {

			String address = data.substring(10, 14);
			String id = CtxStore.getIdbyAddress(address);

			if (id != null && address != null) {

				HighVoltageStatus s = CtxStore.getStatusbyId(id);
				SwitchGPRS gprs = CtxStore.get(id);

				if (s == null) {

					s = new HighVoltageStatus();
					s.setId(id);
					CtxStore.addStatus(s);
				}

				s.setGuo_liu_yi_duan(data.substring(30, 32));
				s.setGuo_liu_er_duan(data.substring(32, 34));
				s.setGuo_liu_san_duan(data.substring(34, 36));

				s.setLing_xu_guo_liu_(data.substring(38, 40));

				if (data.substring(40, 42).equals("01") || data.substring(42, 44).equals("01")
						|| data.substring(44, 46).equals("01")) {
					s.setChong_he_zha("01");
				} else {
					s.setChong_he_zha("00");
				}

				s.setPt1_you_ya(data.substring(48, 50));
				s.setPt2_you_ya(data.substring(50, 52));

				s.setPt1_guo_ya(data.substring(52, 54));
				s.setPt2_guo_ya(data.substring(54, 56));

				String new_status = data.substring(66, 68);

				if ("01".equals(s.getStatus()) && "00".equals(new_status)) {

					gprs.setOpen(true);

					HighVoltageHitchEvent event = new HighVoltageHitchEvent();

					event.setHitchTime(TimeUtil.timeFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
					event.setHitchPhase("A");
					event.setHitchReason(hitchEventDesc == null ? "未知报警" : hitchEventDesc);
					event.setChangeType(0);
					event.setSolveWay("分闸");
					event.setId(UUIDUtil.getUUID());
					event.setSwitchId(id);
					// event.setSolvePeople();
					hitchEventService.insert(event);

					logger.info("-----------跳闸成功");
				} else if ("01".equals(new_status) && "00".equals(s.getStatus())) {

					gprs.setOpen(false);

					HighVoltageHitchEvent event = new HighVoltageHitchEvent();

					event.setHitchTime(TimeUtil.timeFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
					event.setHitchPhase("A");
					event.setHitchReason(hitchEventDesc == null ? "未知报警" : hitchEventDesc);
					event.setChangeType(1);
					event.setSolveWay("合闸");
					event.setId(UUIDUtil.getUUID());
					event.setSwitchId(id);
					hitchEventService.insert(event);
					logger.info("-----------合闸成功");
				}
				s.setStatus(new_status);

				s.setJiao_liu_shi_dian(data.substring(76, 78));

				s.setShou_dong_he_zha(data.substring(78, 80));
				s.setShou_dong_fen_zha(data.substring(80, 82));

				s.setYao_kong_he_zha(data.substring(84, 86));
				s.setYao_kong_fen_zha(data.substring(86, 88));
				s.setYao_kong_fu_gui(data.substring(88, 90));

				logger.info("状态变为-----------" + new_status);

			} else {
				logger.error("there is an error in catching hitch event!");
			}
		} else {
			logger.info("undefine message received!");
			logger.error("接收到的非法数据--------------------" + data);
		}

	}

	private void getMessageAddress(String code, String address, String value) {
		// TODO Auto-generated method stub
		if(code == null || code.length() == 0 || code.length() != 4) {
			return;
		}
		if(code.endsWith("40")) {
			/**
			 * 报文反转
			 */
			code = LowVoltageDeviceCommandUtil.reverseStringBy2(code);
		}
		if(CtxStore.getIdbyAddress(address) == null) {
			return;
		}
		if(code.equals("4008")) {
			HighVoltageVoltage hv = new HighVoltageVoltage();
			hv.setId(UUIDUtil.getUUID());
			hv.setTime(new Date());
			hv.setSwitchId(CtxStore.getIdbyAddress(address));
			hv.setValue(Integer.valueOf(HighVoltageDeviceCommandUtil.changToRight(value)));
			hv.setPhase("A");
			voltageService.insert(hv);
		} else {
			HighVoltageCurrent hc = new HighVoltageCurrent();
			hc.setId(UUIDUtil.getUUID());
			hc.setTime(new Date());
			hc.setSwitchId(CtxStore.getIdbyAddress(address));
			hc.setValue(Integer.valueOf(HighVoltageDeviceCommandUtil.changToRight(value)));
			switch(code) {
				case "4001": hc.setPhase("A");break;
				case "4002": hc.setPhase("B");break;
				case "4003": hc.setPhase("C");break;
				default:break;
			}
			if(hc.getPhase() != null) {
				currentService.insert(hc);
			}
		}
	}

	private String getHitchReason(String string) {

		for (int i = 0; i < string.length(); i = i + 2) {
			if (string.substring(i, i + 2).equals("01")) {
				return com.gdut.dongjun.service.impl.enums.HighVoltageHitchEvent.getStatement(i / 2 + 1).toString();
			}
		}
		return "未知报警";
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {

		SwitchGPRS gprs = CtxStore.get(ctx);
		if (gprs != null) {
			CtxStore.remove(ctx);// 从Store中移除这个context
			if(gprs.getId() != null) {
				HighVoltageSwitch hvSwitch = switchService.selectByPrimaryKey(gprs.getId());
				hvSwitch.setOnlineTime(TimeUtil.timeFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
				switchService.updateByPrimaryKey(hvSwitch);
			}
		}

		CtxStore.printCtxStore();
	}

	/**
	 * 
	 * @Title: saveCV @Description: TODO @param @param switchId @param @param
	 *         data @return void @throws
	 */
	public void saveCV(String switchId, String data) {
		data = data.replace(" ", "");
		String ABVoltage = new HighVoltageDeviceCommandUtil().readABPhaseVoltage(data);
		String BCVoltage = new HighVoltageDeviceCommandUtil().readBCPhaseVoltage(data);
		String ACurrent = new HighVoltageDeviceCommandUtil().readAPhaseCurrent(data);
		String BCurrent = new HighVoltageDeviceCommandUtil().readBPhaseCurrent(data);
		String CCurrent = new HighVoltageDeviceCommandUtil().readCPhaseCurrent(data);
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
	private void saveVoltage(String switchId, String[] dStrings) {

		logger.info("saving voltage...");
		Date date = new Date();
		HighVoltageVoltage v1 = new HighVoltageVoltage();
		v1.setId(UUIDUtil.getUUID());
		v1.setPhase("A");
		v1.setSwitchId(switchId);
		v1.setTime(date);
		v1.setValue(Integer.parseInt(dStrings[0]));

		HighVoltageVoltage v2 = new HighVoltageVoltage();
		v2.setId(UUIDUtil.getUUID());
		v2.setPhase("B");
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