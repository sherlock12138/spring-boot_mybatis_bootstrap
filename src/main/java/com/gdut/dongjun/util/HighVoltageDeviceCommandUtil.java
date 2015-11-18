package com.gdut.dongjun.util;

import org.springframework.stereotype.Component;
/**
 * 
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月18日
 * @description
 * @package com.gdut.dongjun.util
 */
@Component
public class HighVoltageDeviceCommandUtil {
	
	private String address;//地址
	private String control;//控制域
	private String dataLength;//报文长度
	private String[] data;//应用服务数据单元ASDU
	private String check;//帧校验和CS
	

	
	
	
	//预置分闸
	public String closeSwitchPre(String address) {
		
		return "68" + this.dataLength + this.dataLength + this.data + this.check + "16";
	}
	
	
	//分闸
	public String closeSwitch(String address) {
		return null;
	}


	public void setData(String data) {
		this.data = data.split(" ");
		int sum = 0,length = 0;
		for(String s : this.data) {
			sum += Integer.parseInt(s,16);
			length++;
		}
		this.dataLength = Integer.toHexString(length);
		this.check = Integer.toHexString(sum);
	}

	
	
	
	
	public static void main(String[] args) {
		HighVoltageDeviceCommandUtil a = new HighVoltageDeviceCommandUtil();
		a.setData("73 01 00 2E 01 06 01 01 00 60 01 81");
		System.out.println(a.closeSwitchPre(""));
	}
	
}
