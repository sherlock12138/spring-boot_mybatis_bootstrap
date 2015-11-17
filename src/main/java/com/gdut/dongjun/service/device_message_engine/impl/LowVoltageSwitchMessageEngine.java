package com.gdut.dongjun.service.device_message_engine.impl;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.service.device_message_engine.ControlMessageEngine;
import com.gdut.dongjun.service.device_message_engine.DataMessageEngine;
import com.gdut.dongjun.service.device_message_engine.EventMessageEngine;
import com.gdut.dongjun.service.impl.DataZone;
import com.gdut.dongjun.service.impl.enums.ControlIdentificationCode;
import com.gdut.dongjun.util.LowVoltageDeviceCommandUtil;

/**
 * @author Sherlock-lee
 * @date 2015年11月11日 下午3:19:32
 * @see TODO
 * @since 1.0
 */
@Service("LowVoltageSwitchMessageEngine")
public class LowVoltageSwitchMessageEngine implements ControlMessageEngine,
		DataMessageEngine, EventMessageEngine {

	@Override
	public String generateCloseSwitchMessage(String address) {

		return LowVoltageDeviceCommandUtil.controlSwitch(address, new DataZone(
				ControlIdentificationCode.CLOSE_SWITCH.toString()));
	}

	@Override
	public String generateOpenSwitchMessage(String address) {

		return LowVoltageDeviceCommandUtil.controlSwitch(address, new DataZone(
				ControlIdentificationCode.OPEN_SWITCH.toString()));
	}

	@Override
	public String generateReadAPhaseCurrentMessage(String address) {

		return "001";
	}

	@Override
	public String generateReadBPhaseCurrentMessage(String address) {
		return null;
	}

	@Override
	public String generateReadCPhaseCurrentMessage(String address) {
		return null;
	}

	@Override
	public String generateReadAPhaseVoltageMessage(String address) {
		
		
		LowVoltageDeviceCommandUtil.readAllPhaseVoltage(address);
		return null;
	}

	@Override
	public String generateReadBPhaseVoltageMessage(String address) {
		return null;
	}

	@Override
	public String generateReadCPhaseVoltageMessage(String address) {
		return null;
	}

	@Override
	public String generateReadHitchEventMessage(String address) {
		return null;
	}
}
