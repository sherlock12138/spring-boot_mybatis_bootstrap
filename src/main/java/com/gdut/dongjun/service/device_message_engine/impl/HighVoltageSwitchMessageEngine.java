package com.gdut.dongjun.service.device_message_engine.impl;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.service.device_message_engine.ControlMessageEngine;
import com.gdut.dongjun.service.device_message_engine.DataMessageEngine;
import com.gdut.dongjun.service.device_message_engine.EventMessageEngine;
import com.gdut.dongjun.service.impl.enums.HighCommandControlCode;
import com.gdut.dongjun.service.net_server.handler.msg_decoder.HighVoltageDataReceiver;
import com.gdut.dongjun.util.HighVoltageDeviceCommandUtil;

/**
 * @author Sherlock-lee
 * @date 2015年11月11日 下午3:19:32
 * @see TODO
 * @since 1.0
 */
@Service("HighVoltageSwitchMessageEngine")
public class HighVoltageSwitchMessageEngine implements ControlMessageEngine, DataMessageEngine, EventMessageEngine {

	@Override
	public String generateCloseSwitchMessage(String address) {
		return new HighVoltageDeviceCommandUtil().closeSwitchPre(address,
				HighCommandControlCode.PRE_CLOSE_SWITCH.toString())
				+ new HighVoltageDeviceCommandUtil().closeSwitch(address,
						HighCommandControlCode.CLOSE_SWITCH.toString());
	}

	@Override
	public String generateOpenSwitchMessage(String address) {

		return new HighVoltageDeviceCommandUtil().openSwitchPre(address,
				HighCommandControlCode.PRE_OPEN_SWITCH.toString())
				+ new HighVoltageDeviceCommandUtil().openSwitch(address, HighCommandControlCode.OPEN_SWITCH.toString());
	}

	@Override
	public String generateReadAPhaseCurrentMessage(String address) {
		return new HighVoltageDeviceCommandUtil().readVoltageAndCurrent(address, HighCommandControlCode.READ_VOLTAGE_CURRENT.toString());
	}

	@Override
	public String generateReadBPhaseCurrentMessage(String address) {
		return new HighVoltageDeviceCommandUtil().readVoltageAndCurrent(address, HighCommandControlCode.READ_VOLTAGE_CURRENT.toString());
	}

	@Override
	public String generateReadCPhaseCurrentMessage(String address) {
		return new HighVoltageDeviceCommandUtil().readVoltageAndCurrent(address, HighCommandControlCode.READ_VOLTAGE_CURRENT.toString());
	}

	@Override
	public String generateReadAPhaseVoltageMessage(String address) {
		return new HighVoltageDeviceCommandUtil().readVoltageAndCurrent(address, HighCommandControlCode.READ_VOLTAGE_CURRENT.toString());
	}

	@Override
	public String generateReadBPhaseVoltageMessage(String address) {
		return new HighVoltageDeviceCommandUtil().readVoltageAndCurrent(address, HighCommandControlCode.READ_VOLTAGE_CURRENT.toString());
	}

	@Override
	public String generateReadCPhaseVoltageMessage(String address) {
		return new HighVoltageDeviceCommandUtil().readVoltageAndCurrent(address, HighCommandControlCode.READ_VOLTAGE_CURRENT.toString());
	}

	@Override
	public String generateReadHitchEventMessage(String address) {
		return null;
	}
}
