package com.gdut.dongjun.util;

public class CommandUtil {

	private String address;
	private String control;
	private String dataLength;
	private String[] data;
	private String check;

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

		this.data = new String[data.length];
		int dalen = 0;
		for (int i = 0; i < data.length; i++) {

			String tmp = data[i];
			String[] dali = new String[tmp.length() / 2];
			for (int j = 0; j < dali.length; j++) {

				String t = Integer.toHexString(Integer.parseInt(
						tmp.substring(2 * j, 2 * j + 2), 16) + 51);
				dali[j] = t;
			}
			this.data[i] = ArraysToString(reverseArrays(dali));
			dalen += tmp.length();
		}

		if (dalen != 0) {
			this.dataLength = Integer.toHexString(dalen / 2);
			if (dataLength.length() == 1)
				dataLength = "0" + dataLength;
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
	public String reverseStringBy2(String data) {

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
	public String[] reverseArrays(String[] dali) {

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
	public String ArraysToString(String[] dali) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < dali.length; i++) {
			sb.append(dali[i]);
		}
		return sb.toString();
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

		tmp = tmp.replace(" ", "");
		String[] dali = new String[tmp.length() / 2];
		for (int j = 0; j < dali.length; j++) {

			String t = Integer.toHexString(Integer.parseInt(
					tmp.substring(2 * j, 2 * j + 2), 16) - 51);
			dali[j] = t;
		}
		return ArraysToString(reverseArrays(dali));
	}

	private enum Control {

		REMAIN("00", "保留"), BROADCAST("08", "广播校时"), READ("11", "读数据"), READ_FALLOW(
				"12", "读后续数据"), READ_COMMUNICATE_ADDRESS("13", "读通信地址"), WRITE(
				"14", "写数据"), WRITE_FALLOW("15", "写后续数据"), CHANGE_COMMUNICATE_RATE(
				"17", "修改通信速率"), CHANGE_PASSWORD("18", "修改密码"), QUERY_DEVICE_WORNING(
				"19", "查询设备报警"), RESPOND_DEVICE_WORNING("1A", "响应设备报警"), CLEAR_EVENT(
				"1B", "事件清零"), CONTROL_DEVICE("1C", "控制设备");

		private String code;// 16进制代码
		private String statement;// 说明

		private Control(String code, String statement) {
			this.code = code;
			this.statement = statement;
		}

	}

//	private enum DataDefinition {
//
//		A_PHASE_VOLTAGE("02010100", "当前A相电压"), B_PHASE_VOLTAGE("02010200",
//				"当前B相电压"), C_PHASE_VOLTAGE("02010300", "当前C相电压"), ALL_PHASE_VOLTEGE(
//				"0201FF00", "当前A,B,C相电压"), A_PHASE_CURRENT("02020100", "当前A相电流"), B_PHASE_CURRENT(
//				"02020200", "当前B相电流"), C_PHASE_CURRENT("02020300", "当前C相电流"), ALL_PHASE_CURRENT(
//				"0202FF00", "当前A,B,C相电流");
//
//		private String code;
//		private String statement;
//		
//		
//	}

	/*public static void main(String[] args) {

		CommandUtil commandUtil = new CommandUtil("AAAAAAAAAAAA");
		commandUtil.setControl("13");
		String[] data = { "", "", "", "" };
		commandUtil.setData(data);
		System.out.println(commandUtil.generate());
		System.out.println(commandUtil.dataDecode("cb55"));
		new CommUtil("COM4").excute(commandUtil.generate());
	}*/

}