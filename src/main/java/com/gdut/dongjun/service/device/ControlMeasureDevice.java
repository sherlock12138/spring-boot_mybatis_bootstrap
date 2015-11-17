package com.gdut.dongjun.service.device;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.service.device_message_engine.ControlMessageEngine;
import com.gdut.dongjun.service.device_message_engine.DataMessageEngine;
import com.gdut.dongjun.service.device_message_engine.EventMessageEngine;

/**   
 * @author	Sherlock-lee
 * @date	2015年11月13日 上午1:44:43
 * @see 	TODO
 * @since   1.0
 */
@Service("ControlMeasureDevice")
public class ControlMeasureDevice extends Device{
	
	@Resource(name="ControlMeasureMessageEngine")
	private ControlMessageEngine cme;
	@Resource(name="ControlMeasureMessageEngine")
	private DataMessageEngine dme;
	@Resource(name="ControlMeasureMessageEngine")
	private EventMessageEngine eme;
	
	public ControlMeasureDevice() {
		super();
	}
	
	public ControlMeasureDevice(ControlMessageEngine cme, DataMessageEngine dme,
			EventMessageEngine eme) {
		super();
		super.cme = cme;
		super.dme = dme;
		super.eme = eme;
	}

	public ControlMessageEngine getCme() {
		return cme;
	}

	@Resource(name="ControlMeasureMessageEngine")
	public void setCme(ControlMessageEngine cme) {
		super.cme = cme;
	}

	public DataMessageEngine getDme() {
		return dme;
	}

	@Resource(name="ControlMeasureMessageEngine")
	public void setDme(DataMessageEngine dme) {
		super.dme = dme;
	}

	public EventMessageEngine getEme() {
		return eme;
	}

	@Resource(name="ControlMeasureMessageEngine")
	public void setEme(EventMessageEngine eme) {
		super.eme = eme;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
