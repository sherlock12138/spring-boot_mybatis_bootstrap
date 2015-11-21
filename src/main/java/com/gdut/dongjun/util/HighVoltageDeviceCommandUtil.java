package com.gdut.dongjun.util;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.service.impl.enums.CurrentVariable;
import com.gdut.dongjun.service.impl.enums.HighCommandControlCode;

/**
 * 高压设备util类
 * 
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


	// 预置合闸
	public String closeSwitchPre(String address, String data) {
		address = correctAddress(address);
		String msg = HighCommandControlCode.PRE_CONTROL + " " + address + " " + HighCommandControlCode.COMMAND + " " + address + " " + data;
		this.setData(msg);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + msg + " " + this.check + " 16";
	}

	// 合闸
	public String closeSwitch(String address, String data) {
		address = correctAddress(address);
		String msg = HighCommandControlCode.CONTROL + " " + address + " " + HighCommandControlCode.COMMAND + " " + address + " " + data;
		this.setData(msg);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + msg + " " + this.check + " 16";
	}

	// 预置合闸
	public String openSwitchPre(String address, String data) {
		address = correctAddress(address);
		String msg = HighCommandControlCode.PRE_CONTROL + " " + address + " " + HighCommandControlCode.COMMAND + " " + address + " " + data;
		this.setData(msg);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + msg + " " + this.check + " 16";
	}

	// 合闸
	public String openSwitch(String address, String data) {
		address = correctAddress(address);
		String msg = HighCommandControlCode.CONTROL + " " + address + " " + HighCommandControlCode.COMMAND + " " + address + " " + data;
		this.setData(msg);
		return "68 " + this.dataLength + " " + this.dataLength + " 68 " + msg +" " + this.check + " 16";
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

	//地址补全
	public String correctAddress(String address) {
		while(address.length() < 4) {
			address = "0" + address;
		}
		if(address.length() < 5) {			
			address = address.substring(0, 2) + " " +address.substring(2, 4);
		}
		return address;
	}
	// 字符串反转
	public String reverseString(String data) {
		char[] data_reverse = data.toCharArray();
		data = "";
		char temp;
		for (int i = 0; i < data_reverse.length / 2; i++) {
			temp = data_reverse[i];
			data_reverse[i] = data_reverse[data_reverse.length / 2 + i];
			data_reverse[data_reverse.length / 2 + i] = temp;
		}
		for (int i = 0; i < data_reverse.length; i++) {
			data += data_reverse[i];
		}
		return data;
	}


	//读取电压电流的报文
	public String readVoltageAndCurrent(String address, String data) {
		address = correctAddress(address);
		String msg = HighCommandControlCode.CONTROL + " " + address + " " + data + " " + address + " 00 00 14";
		setData(msg);
		return  "68 " + this.dataLength + " " + this.dataLength + " 68 " + msg  + " "+ this.check + " 16";
	}
	
	//读AB的电压
	public String readABPhaseVoltage(String data) {
		// TODO Auto-generated method stub\
		
//		System.out.println("AB的电压"
//				+ Double.parseDouble(Integer.parseInt(reverseString(data.substring(30, 34)), 16) + "") / 100 + "V");
//		System.out.println("BC的电压"
//				+ Double.parseDouble(Integer.parseInt(reverseString(data.substring(38, 42)), 16) + "") / 100 + "V");
//		System.out.println("C的电压"
//				+ Double.parseDouble(Integer.parseInt(reverseString(baoWen.substring(38, 42)), 16) + "") / 100 + "V");
//		System.out.println("A的电流"
//				+ Double.parseDouble(Integer.parseInt(reverseString(data.substring(50, 54)), 16) + "") / 100 + "A");
//		System.out.println("B的电流"
//				+ Double.parseDouble(Integer.parseInt(reverseString(data.substring(54, 58)), 16) + "") / 100 + "A");
//		System.out.println("B的电流"
//				+ Double.parseDouble(Integer.parseInt(reverseString(data.substring(58, 62)), 16) + "") / 100 + "A");
		data = data.replace(" ", "");
		return Integer.parseInt(reverseString(data.substring(30, 34)), 16) / 100 + "";
	}
	
	//读BC电压
	public String readBCPhaseVoltage(String data) {
		data = data.replace(" ", "");
		return Integer.parseInt(reverseString(data.substring(38, 42)), 16) / 100 + "";
	}

	public String readCPhaseVoltage(String address) {
		return null;
	}

	//读A电流
	public String readAPhaseCurrent(String data) {
		data = data.replace(" ", "");
		return Integer.parseInt(reverseString(data.substring(50, 54)), 16) / 100 + "";
	}

	//读B电流
	public String readBPhaseCurrent(String data) {
		data = data.replace(" ", "");
		return Integer.parseInt(reverseString(data.substring(54, 58)), 16) / 100 + "";
	}

	//读C的电流
	public String readCPhaseCurrent(String data) {
		data = data.replace(" ", "");
		return Integer.parseInt(reverseString(data.substring(54, 58)), 16) / 100 + "";
	}

//	public static void main(String[] args) {
//		HighVoltageDeviceCommandUtil a = new HighVoltageDeviceCommandUtil();
//		System.out.println(a.closeSwitchPre("01 00", HighCommandControlCode.PRE_CLOSE_SWITCH.toString()));
//		System.out.println(a.closeSwitch("01 00", HighCommandControlCode.CLOSE_SWITCH.toString()));
//		System.out.println(a.openSwitch("01 00", HighCommandControlCode.OPEN_SWITCH.toString()));
//		System.out.println(a.openSwitchPre("01 00", HighCommandControlCode.PRE_OPEN_SWITCH.toString()));
//		System.out.println(a.readVoltageAndCurrent("01 00", HighCommandControlCode.READ_VOLTAGE_CURRENT.toString()));
//	}

}
