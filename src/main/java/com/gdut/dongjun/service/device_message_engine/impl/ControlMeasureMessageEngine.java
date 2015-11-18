package com.gdut.dongjun.service.device_message_engine.impl;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.service.device_message_engine.ControlMessageEngine;
import com.gdut.dongjun.service.device_message_engine.DataMessageEngine;
import com.gdut.dongjun.service.device_message_engine.EventMessageEngine;

/**
 * @author Sherlock-lee
 * @date 2015年11月11日 下午3:19:32
 * @see TODO
 * @since 1.0
 */
@Service("ControlMeasureMessageEngine")
public class ControlMeasureMessageEngine implements ControlMessageEngine,
		DataMessageEngine, EventMessageEngine {

	@Override
	public String generateCloseSwitchMessage(String address) {
		
		return null;
	}

	@Override
	public String generateOpenSwitchMessage(String address) {
		
		return null;
	}

	@Override
	public String generateReadAPhaseCurrentMessage(String address) {
		return null;
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
