package com.gdut.dongjun.service.device;

import com.gdut.dongjun.domain.po.enums.Protocol;
import com.gdut.dongjun.service.device_message_engine.ControlMessageEngine;
import com.gdut.dongjun.service.device_message_engine.DataMessageEngine;
import com.gdut.dongjun.service.device_message_engine.EventMessageEngine;

/**
 * @author Sherlock-lee
 * @date 2015年11月10日 下午8:24:16
 * @see TODO
 * @since 1.0
 */
public abstract class Device {

	private String id;
	private String name;
	private String address;
	private String deviceNumber;
	private Enum<Protocol> protocal;

	protected ControlMessageEngine cme;
	protected DataMessageEngine dme;
	protected EventMessageEngine eme;

	public Device() {
		super();
	}

	public Device(ControlMessageEngine cme, DataMessageEngine dme,
			EventMessageEngine eme) {
		super();
		this.cme = cme;
		this.dme = dme;
		this.eme = eme;
	}

	/***
	 * 
	 * @Title: generateCloseSwitchMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	// @Pointcut
	public String generateCloseSwitchMessage(String address) {

		if (cme != null) {

			return cme.generateCloseSwitchMessage(address);
		} else {
			return "";
		}

	}

	

	/**
	 * @param address
	 * 
	 * @Title: generateOpenSwitchMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateOpenSwitchMessage(String address) {

		if (cme != null) {

			return cme.generateOpenSwitchMessage(address);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: generateReadAPhaseCurrentMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadAPhaseCurrentMessage(String address) {

		if (cme != null) {

			return dme.generateReadAPhaseCurrentMessage(address);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: generateReadBPhaseCurrentMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadBPhaseCurrentMessage() {

		if (cme != null) {

			return dme.generateReadBPhaseCurrentMessage(address);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: generateReadCPhaseCurrentMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadCPhaseCurrentMessage() {

		if (cme != null) {

			return dme.generateReadCPhaseCurrentMessage(address);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: generateReadAPhaseVoltageMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadAPhaseVoltageMessage(String address) {

		if (cme != null) {

			return dme.generateReadAPhaseVoltageMessage(address);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: generateReadBPhaseVoltageMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadBPhaseVoltageMessage(String address) {

		if (cme != null) {

			return dme.generateReadBPhaseVoltageMessage(address);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: generateReadCPhaseVoltageMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadCPhaseVoltageMessage(String address) {

		if (cme != null) {

			return dme.generateReadCPhaseVoltageMessage(address);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: generateReadHitchEventMessage
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadHitchEventMessage(String address) {

		if (cme != null) {

			return eme.generateReadHitchEventMessage(address);
		} else {
			return "";
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public Enum<Protocol> getProtocal() {
		return protocal;
	}

	public void setProtocal(Enum<Protocol> protocal) {
		this.protocal = protocal;
	}

}
