package com.gdut.dongjun.service.impl.enums;

public enum ControlMearsureHitchEvent {
	APHASE_VOLTAGE_OVER("0x01", "A相电压过压"), 
	BPHASE_VOLTAGE_OVER("0x02", "B相电压过压"),
	CPHASE_VOLTAGE_OVER("0x03", "C相电压过压"),
	APHASE_VOLTAGE_UNDER("0x04", "A相电压欠压"),
	BPHASE_VOLTAGE_UNDER("0x05", "B相电压欠压"),
	CPHASE_VOLTAGE_UNDER("0x06", "C相电压欠压"),
	APHASE_HARMONIC_OVERRUN("0x07", "A相电压谐波超限"),
	BPHASE_HARMONIC_OVERRUN("0x08", "B相电压谐波超限"),
	CPHASE_HARMONIC_OVERRUN("0x09", "C相电压谐波超限"),
	APHASE_LACK("0x0a", "A相缺相"),
	BPHASE_LACK("0x0b", "B相缺相"),
	CPHASE_LACK("0x0c", "C相缺相"),
	ZERO_CURRENT_OVERRUN("0x0c", "零序电流超限"),
	POWER_CUT("0x8e", "停电");
	
	private String code; //16进制标志
	private String statement;	//报警事件描述
	
	private ControlMearsureHitchEvent(String code, String statement) {
		this.code = code;
		this.statement = statement;
	}
	
	@Override
	public String toString() {
		return this.code;
	}
}
