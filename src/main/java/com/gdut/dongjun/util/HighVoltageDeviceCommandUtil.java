package com.gdut.dongjun.util;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.service.impl.enums.CurrentVariable;
import com.gdut.dongjun.service.impl.enums.HighCommandControlCode;

/**
 * 高压设备util类
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月18日
 * @description
 * @package com.gdut.dongjun.util
 */
@Component
public class HighVoltageDeviceCommandUtil {
	
	private String address;// 地址
	private String control;// 控制域
	private String dataLength;// 报文长度
	private String[] data;// 应用服务数据单元ASDU
	private String check;// 帧校验和CS

//	public String baoWen = "68 47 47 68 D4 01 00 09 94 14 01 01 00 01 40 5F 5C 00 00"
//			+ " 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
//			+ "00 00 00 00 E8 03 00 8B 13 00 45 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 52 16";
	public String baoWen = "68 47 47 68 D4 01 00 09 94 14 01 01 00 01 40 F9 5B 00 00 "
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
			+ "00 00 E8 03 00 88 13 00 45 00 00 00 00 00 00 00 00 "
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 E8 16";
	// 预置合闸
	public String closeSwitchPre(String address, String data) {
		this.setData(HighCommandControlCode.PRE_CONTROL + " " + data);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + HighCommandControlCode.PRE_CONTROL + " "
				+ data + " " + this.check + " 16";
	}

	// 合闸
	public String closeSwitch(String address, String data) {
		this.setData(HighCommandControlCode.CONTROL + " " + data);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + HighCommandControlCode.CONTROL + " " + data
				+ " " + this.check + " 16";
	}

	// 预置合闸
	public String openSwitchPre(String address, String data) {
		this.setData(HighCommandControlCode.PRE_CONTROL + " " + data);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + HighCommandControlCode.PRE_CONTROL + " "
				+ data + " " + this.check + " 16";
	}

	// 合闸
	public String openSwitch(String address, String data) {
		this.setData(HighCommandControlCode.CONTROL + " " + data);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + HighCommandControlCode.CONTROL + " " + data
				+ " " + this.check + " 16";
	}

	public void setData(String data) {
		this.data = data.split(" ");
		int sum = 0, length = 0;
		for (String s : this.data) {
			sum += Integer.parseInt(s, 16);
			length++;
		}
		sum %= 256;
		this.dataLength = Integer.toHexString(length);
		this.check = Integer.toHexString(sum);
		polish();
	}

	// 补齐16进制高位的0
	public void polish() {
		if (this.dataLength.matches(".")) {
			this.dataLength = "0" + this.dataLength;
		}
		if (this.check.matches(".")) {
			this.check = "0" + this.check;
		}
	}
	//字符串反转
	public String reverseString(String data) {
		char[] data_reverse = data.toCharArray();
		data = "";
		char temp;
		for(int i = 0;i < data_reverse.length/2;i++) {
			temp = data_reverse[i];
			data_reverse[i] = data_reverse[data_reverse.length/2 + i];
			data_reverse[data_reverse.length/2 + i] = temp;
		}
		for(int i = 0;i < data_reverse.length;i++) {
			data += data_reverse[i];
		}
		return data;
	}
	
	@Test
	public void readAPhaseVoltage() {
		// TODO Auto-generated method stub\
		baoWen = baoWen.replace(" ", "");
		System.out.println("A的电压" + Double.parseDouble(Integer.parseInt(reverseString(baoWen.substring(30, 34)), 16) + "")/100 + "V");
		System.out.println("B的电压" + Double.parseDouble(Integer.parseInt(reverseString(baoWen.substring(34, 38)), 16) + "")/100 + "V");
		System.out.println("C的电压" + Double.parseDouble(Integer.parseInt(reverseString(baoWen.substring(38, 42)), 16) + "")/100 + "V");
		System.out.println("A的电流" + Double.parseDouble(Integer.parseInt(reverseString(baoWen.substring(42, 46)), 16) + "")/100 + "A");
		System.out.println("B的电流" + Double.parseDouble(Integer.parseInt(reverseString(baoWen.substring(46, 50)), 16) + "")/100 + "A");
		System.out.println("B的电流" + Double.parseDouble(Integer.parseInt(reverseString(baoWen.substring(50, 54)), 16) + "")/100 + "A");
		//return null;
		//System.out.println(baoWen.substring(34, 38));
	}
	
	public String readBPhaseVoltage(String address) {
		return null;
	}
	
	public String readCPhaseVoltage(String address) {
		return null;
	}
	
	public String readAPhaseCurrent(String address) {
		return null;
	}
	
	public String readBPhaseCurrent(String address) {
		return null;
	}
	
	public String readCPhaseCurrent(String address) {
		return null;
	}
	/*
	 * public static void main(String[] args) { HighVoltageDeviceCommandUtil a =
	 * new HighVoltageDeviceCommandUtil();
	 * //System.out.println(a.closeSwitchPre("01 00"
	 * ,HighCommandControlCode.PRE_CLOSE_SWITCH.toString()));
	 * //System.out.println(a.closeSwitch("01 00",
	 * HighCommandControlCode.CLOSE_SWITCH.toString()));
	 * //System.out.println(a.openSwitch("01 00",
	 * HighCommandControlCode.OPEN_SWITCH.toString()));
	 * System.out.println(a.openSwitchPre("01 00",
	 * HighCommandControlCode.PRE_OPEN_SWITCH.toString())); }
	 */

}
