package com.gdut.dongjun.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.gdut.dongjun.domain.po.HitchEvent;
import com.gdut.dongjun.service.CommandDecoder;
import com.gdut.dongjun.service.impl.DataZone;
import com.gdut.dongjun.service.impl.enums.CommandControlCode;
import com.gdut.dongjun.service.impl.enums.CurrentVariable;
import com.gdut.dongjun.service.impl.enums.DataZoneStructure;
import com.gdut.dongjun.service.impl.enums.Phase;

@Component
public class CommandUtil implements CommandDecoder {

	private String address;
	private String control;
	private String dataLength;
	private String[] data;
	private String check;

	public CommandUtil() {
	}

	public CommandUtil(String address) {
		setAddress(address);
	}

	public void setAddress(String address) {
		this.address = reverseStringBy2(address.replace(" ", ""));
	}

	public void setControl(String control) {
		this.control = control.replace(" ", "");
	}

	public void setData(String[] data) {

		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				data[i] = "";
			}
		}
		this.data = new String[data.length];
		int dalen = 0;
		for (int i = 0; i < data.length; i++) {

			if (data[i] != null) {

				String tmp = data[i].replace(" ", "");
				String[] dali = new String[tmp.length() / 2];
				for (int j = 0; j < dali.length; j++) {

					String t = Integer.toHexString(Integer.parseInt(
							tmp.substring(2 * j, 2 * j + 2), 16) + 51);
					// t=FF时的bug
					if (t.length() == 3)
						t = t.substring(1, 3);
					dali[j] = t;
				}
				this.data[i] = ArraysToString(reverseArrays(dali));
				dalen += tmp.length();
			}
		}

		if (dalen != 0) {
			this.dataLength = Integer.toHexString(dalen / 2);
			if (dataLength.length() == 1)
				dataLength = "0" + dataLength;
			System.out.println(this.data[2]);
			this.check = CheckCodeUtil.generate("68" + address + "68" + control
					+ dataLength + ArraysToString(this.data));
		} else {
			this.dataLength = "00";
			this.check = CheckCodeUtil.generate("68" + address + "68" + control
					+ dataLength);
		}
	}

	/**
	 * 
	 * @Title: reverseStringBy2
	 * @Description: 将字符串每两个字节反转
	 * @param @param data
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String reverseStringBy2(String data) {

		String[] dali = new String[data.length() / 2];
		for (int j = 0; j < dali.length; j++) {

			dali[j] = data.substring(2 * j, 2 * j + 2);
		}
		return ArraysToString(reverseArrays(dali));
	}

	/**
	 * 
	 * @Title: reverseArrays
	 * @Description: 反转数组
	 * @param @param dali
	 * @param @return
	 * @return String[]
	 * @throws
	 */
	public static String[] reverseArrays(String[] dali) {

		for (int i = 0; i < dali.length / 2; i++) {
			String tmp = dali[dali.length - 1 - i];
			dali[dali.length - 1 - i] = dali[i];
			dali[i] = tmp;
		}
		return dali;
	}

	/**
	 * 
	 * @Title: ArraysToString
	 * @Description: 将数组转成字符串
	 * @param @param dali
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String ArraysToString(String[] dali) {

		if (dali != null) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < dali.length; i++) {
				sb.append(dali[i]);
			}
			return sb.toString();
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @Title: generate
	 * @Description: 生成命令
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generate() {

		return "68" + address + "68" + control + dataLength
				+ ArraysToString(this.data) + check + "16";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return generate();
	}

	/**
	 * 
	 * @Title: dataDecode
	 * @Description: 数据解析
	 * @param @param tmp
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String dataDecode(String tmp) {

		if (tmp != null) {
			tmp = filter(tmp);
		} else {
			return null;
		}
		String data = tmp.substring(28, tmp.length() - 4);// 切去头和尾只保留数据
		return decode(data);
	}

	/**
	 * 
	 * @Title: filter
	 * @Description: TODO
	 * @param @param tmp
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String filter(String tmp) {

		return tmp.replace("3f", "").replace("fe", "").replace(" ", "");
	}

	/**
	 * 
	 * @Title: decode
	 * @Description: TODO
	 * @param @param data
	 * @param @return
	 * @return String
	 * @throws
	 */
	@Override
	public String decode(String data) {

		if (data != null) {
			data = filter(data);
		} else {
			return null;
		}
		// 如果数据为奇数长度的字符串则报错
		if (data.length() % 2 != 0)
			return null;
		String[] dali = new String[data.length() / 2];

		for (int j = 0; j < dali.length; j++) {

			String t = Integer.toHexString(Integer.parseInt(
					data.substring(2 * j, 2 * j + 2), 16) - 51);
			if (t.length() == 1) {
				t = "0" + t;
			}
			dali[j] = t.substring(0, 2);
		}
		return ArraysToString(reverseArrays(dali));
	}

	@Override
	public String decodeAddress(String data) {

		return reverseStringBy2(data);
	}

	/**
	 * 
	 * @Title: divideResult
	 * @Description: TODO
	 * @param @param decodedString
	 * @param @param expected_length
	 * @param @return
	 * @return String[]
	 * @throws
	 */
	public static String[] divideResult(String decodedString,
			int expected_length) {

		if (decodedString != null && decodedString.length() > expected_length) {
			String[] dali2 = null;
			if (decodedString.length() % expected_length != 0) {
				dali2 = new String[decodedString.length() / expected_length + 1];
			} else {
				dali2 = new String[decodedString.length() / expected_length];
			}
			for (int i = 0; i < dali2.length; i++) {

				int tl = expected_length * i + expected_length;
				if (tl >= decodedString.length()) {
					dali2[i] = decodedString.substring(expected_length * i,
							decodedString.length());
				} else {
					dali2[i] = decodedString.substring(expected_length * i,
							expected_length * i + expected_length);
				}
			}
			return dali2;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @Title: readHitchEvent
	 * @Description: TODO
	 * @param @param decodedString
	 * @param @param expected_length
	 * @param @return
	 * @return String[]
	 * @throws
	 */
	public static HitchEvent readHitchEvent(String decodedString) {

		// System.out.println(decodedString.substring(0, 6));
		// System.out.println(decodedString.substring(6, 12));
		// System.out.println(decodedString.substring(12, 18));
		// System.out.println(decodedString.substring(18, 22));
		// System.out.println(decodedString.substring(22, 26));
		// System.out.println(decodedString.substring(26, 30));
		// System.out.println(decodedString.substring(30, 34));
		System.out.println(decodedString.substring(34, 46));
		// System.out.println(decodedString.substring(46, 48));
		// System.out.println(decodedString.substring(48, 50));

		HitchEvent hitchEvent = new HitchEvent();

		hitchEvent.setBehitchCPhaseCurrent(Integer.parseInt(decodedString
				.substring(0, 6)));
		hitchEvent.setBehitchBPhaseCurrent(Integer.parseInt(decodedString
				.substring(6, 12)));
		hitchEvent.setBehitchAPhaseCurrent(Integer.parseInt(decodedString
				.substring(12, 18)));

		hitchEvent.setBehitchCPhaseVoltage(Integer.parseInt(decodedString
				.substring(18, 22)));
		hitchEvent.setBehitchBPhaseVoltage(Integer.parseInt(decodedString
				.substring(22, 26)));
		hitchEvent.setBehitchAPhaseVoltage(Integer.parseInt(decodedString
				.substring(26, 30)));

		hitchEvent.setResidualCurrent(Integer.valueOf(decodedString.substring(
				30, 34)));

		DateFormat d = new SimpleDateFormat("yyMMddHHmmss");
		try {
			hitchEvent.setHitchTime(d.parse(decodedString.substring(34, 46)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(hitchEvent.getHitchTime());
		hitchEvent.setHitchPhase(Phase.define(decodedString.substring(46, 48))
				.value());

		String byteString = HexString_BytesUtil
				.hexStringToByteString(decodedString.substring(48, 50));

//		System.out.println(byteString.substring(0, 5));
		int i = com.gdut.dongjun.service.impl.enums.HitchEvent.define(
				byteString.substring(0, 5)).value();
		hitchEvent.setHitchReason(i);

		return hitchEvent;
	}

	/**
	 * 
	 * @Title: controlSwitch
	 * @Description: TODO
	 * @param @param address
	 * @param @param dataZone
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String controlSwitch(String address, DataZone dataZone) {
		// TODO Auto-generated method stub
		CommandUtil commandUtil = new CommandUtil();
		commandUtil.setAddress(address);
		commandUtil.setControl(CommandControlCode.CONTROL_DEVICE.toString());
		commandUtil
				.setData(dataZone
						.creatDataZoneArrays(DataZoneStructure.INDENTIFIER_PASSWORD_OPERATOR_CODE_DATA
								.value()));
		return commandUtil.generate();
	}

	/**
	 * 
	 * @Title: readAllPhaseVoltage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String readAllPhaseVoltage(String address) {
		// TODO Auto-generated method stub
		return readSwitch(address, CurrentVariable.ALL_PHASE_VOLTEGE.value());
	}

	/**
	 * 
	 * @Title: readAllPhaseCurrent
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String readAllPhaseCurrent(String address) {
		// TODO Auto-generated method stub
		return readSwitch(address, CurrentVariable.ALL_PHASE_CURRENT.value());
	}

	/**
	 * 
	 * @Title: readSwitch
	 * @Description: 调用普适的读取方法实现
	 * @param @param address
	 * @param @param identifier
	 * @param @return
	 * @return String
	 * @throws
	 */
	private static String readSwitch(String address, String identifier) {

		if (address != null) {
			String decodedString = read(address, new DataZone(identifier));
			return decodedString;

		} else {
			return null;
		}
	}

	/**
	 * 
	 * @Title: read
	 * @Description: TODO
	 * @param @param address
	 * @param @param dataZone
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String read(String address, DataZone dataZone) {

		CommandUtil commandUtil = new CommandUtil();
		commandUtil.setAddress(address);
		commandUtil.setControl(CommandControlCode.READ.toString());
		commandUtil.setData(dataZone
				.creatDataZoneArrays(DataZoneStructure.IDENTIFIER.value()));

		return commandUtil.generate();// 生成读命令
	}

	// public static void main(String[] args) {
	//
	// CommandUtil commandUtil = new CommandUtil("000000000001");
	// commandUtil.setControl("1c");
	// String[] data = { "06010101", "00000000", "00000000", "0002" };
	// commandUtil.setData(data);
	// // System.out.println(commandUtil.generate());
	// System.out.println(commandUtil.dataDecode("cb55"));
	// new CommUtil("COM4").excute(commandUtil.generate());
	// }

}