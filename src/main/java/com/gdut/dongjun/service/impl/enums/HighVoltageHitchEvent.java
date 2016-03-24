package com.gdut.dongjun.service.impl.enums;

public enum HighVoltageHitchEvent {

	KONGZHIHUILU(1, "控制回路"), ZIDONGHUIHUAN(2, "自动合环"), QINGWASIGAOJING(3, "轻瓦斯告警"),
	ZHONGWASIGAOJING(4, "重瓦斯告警"), GAOWENGAOJING(5, "高温告警"), CHAOWENTIAOZHA(6, "超温跳闸"),
	DIANCHIHUOHUA(7, "电池活化操作"), UNDEFINE(100, "未知报警");
	
	@SuppressWarnings("unused")
	private int code;// hitch_reason 报警原因
	
	private String statement;// 说明
	
	private HighVoltageHitchEvent(int code, String statement) {
		this.code = code;
		this.statement = statement;
	}
	
	public static HighVoltageHitchEvent getStatement(int code) {
		switch(code) {
		case 1 : return KONGZHIHUILU;
		case 2 : return ZIDONGHUIHUAN;
		case 3 : return QINGWASIGAOJING;
		case 4 : return ZHONGWASIGAOJING;
		case 5 : return GAOWENGAOJING;
		case 6 : return CHAOWENTIAOZHA;
		case 7 : return DIANCHIHUOHUA;
		default : return UNDEFINE;
		}
	}
	
	public String toString() {
		return this.statement;
	}
}
