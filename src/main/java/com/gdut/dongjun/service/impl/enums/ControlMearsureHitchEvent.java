package com.gdut.dongjun.service.impl.enums;

public enum ControlMearsureHitchEvent {
	APHASE_VOLTAGE_OVER("01", "A相电压过压"), 
	BPHASE_VOLTAGE_OVER("02", "B相电压过压"),
	CPHASE_VOLTAGE_OVER("03", "C相电压过压"),
	APHASE_VOLTAGE_UNDER("04", "A相电压欠压"),
	BPHASE_VOLTAGE_UNDER("05", "B相电压欠压"),
	CPHASE_VOLTAGE_UNDER("06", "C相电压欠压"),
	APHASE_HARMONIC_OVERRUN("07", "A相电压谐波超限"),
	BPHASE_HARMONIC_OVERRUN("08", "B相电压谐波超限"),
	CPHASE_HARMONIC_OVERRUN("09", "C相电压谐波超限"),
	APHASE_LACK("0a", "A相缺相"),
	BPHASE_LACK("0b", "B相缺相"),
	CPHASE_LACK("0c", "C相缺相"),
	ZERO_CURRENT_OVERRUN("0c", "零序电流超限"),
	POWER_CUT("8e", "停电");
	
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
