package com.gdut.dongjun.service.device;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.dongjun.service.device_message_engine.ControlMessageEngine;
import com.gdut.dongjun.service.device_message_engine.DataMessageEngine;
import com.gdut.dongjun.service.device_message_engine.EventMessageEngine;
import com.sun.xml.bind.v2.TODO;

/**   
 * @author	Sherlock-lee
 * @date	2015年11月13日 上午1:44:43
 * @see 	TODO
 * @since   1.0
 */
@Service("LowVoltageDevice")
public class LowVoltageDevice extends Device{
	
	@Resource(name="LowVoltageSwitchMessageEngine")
	private ControlMessageEngine cme;
	@Resource(name="LowVoltageSwitchMessageEngine")
	private DataMessageEngine dme;
	@Resource(name="LowVoltageSwitchMessageEngine")
	private EventMessageEngine eme;
	
	public LowVoltageDevice() {
		super();
	}

	public LowVoltageDevice(ControlMessageEngine cme, DataMessageEngine dme,
			EventMessageEngine eme) {
		super();
		super.cme = cme;
		super.dme = dme;
		super.eme = eme;
	}

	public ControlMessageEngine getCme() {
		return cme;
	}

	@Resource(name="LowVoltageSwitchMessageEngine")	
	public void setCme(ControlMessageEngine cme) {
		super.cme = cme;
	}

	public DataMessageEngine getDme() {
		return dme;
	}

	@Resource(name="LowVoltageSwitchMessageEngine")
	public void setDme(DataMessageEngine dme) {
		super.dme = dme;
	}

	public EventMessageEngine getEme() {
		return eme;
	}

	@Resource(name="LowVoltageSwitchMessageEngine")
	public void setEme(EventMessageEngine eme) {
		super.eme = eme;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
