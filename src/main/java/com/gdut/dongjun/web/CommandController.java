package com.gdut.dongjun.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.ControlMearsureCurrent;
import com.gdut.dongjun.domain.po.ControlMearsureVoltage;
import com.gdut.dongjun.domain.po.HighVoltageCurrent;
import com.gdut.dongjun.domain.po.HighVoltageVoltage;
import com.gdut.dongjun.domain.po.LowVoltageCurrent;
import com.gdut.dongjun.domain.po.LowVoltageVoltage;
import com.gdut.dongjun.service.ControlMearsureCurrentService;
import com.gdut.dongjun.service.ControlMearsureVoltageService;
import com.gdut.dongjun.service.HighVoltageCurrentService;
import com.gdut.dongjun.service.HighVoltageVoltageService;
import com.gdut.dongjun.service.LowVoltageCurrentService;
import com.gdut.dongjun.service.LowVoltageVoltageService;
import com.gdut.dongjun.service.device.Device;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;

@Controller
@RequestMapping("/dongjun")
public class CommandController {

	@Autowired
	private LowVoltageCurrentService currentService;
	@Autowired
	private LowVoltageVoltageService voltageService;
	@Autowired
	private HighVoltageCurrentService currentService2;
	@Autowired
	private HighVoltageVoltageService voltageService2;
	@Autowired
	private ControlMearsureCurrentService currentService3;
	@Autowired
	private ControlMearsureVoltageService voltageService3;

	@Resource(name = "LowVoltageDevice")
	private Device lowVoltageDevice;

	@Resource(name = "HighVoltageDevice")
	private Device highVoltageDevice;

	@Resource(name = "ControlMeasureDevice")
	private Device controlMeasureDevice;

	private static final Logger logger = Logger
			.getLogger(CommandController.class);

	/**
	 * 
	 * @Title: controlSwitch
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param sign
	 * @param @param orderTime
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/control_switch")
	public String controlSwitch(@RequestParam(required = true) String switchId,
			int sign, int type, Model model,
			RedirectAttributes redirectAttributes) {

		SwitchGPRS gprs = CtxStore.get(switchId);
		String address = null;
		String msg = null;

		if (gprs != null && gprs.getAddress() != null) {

			address = gprs.getAddress();
		} else {
			// return "error";
		}

		switch (sign) {
		case 0:// 开
			switch (type) {
			case 0:// 低压开关
				msg = lowVoltageDevice.generateOpenSwitchMessage(address);
				break;
			case 1:// 高压开关
				msg = highVoltageDevice.generateOpenSwitchMessage(address);
				break;
			case 2:// 管控开关
				msg = controlMeasureDevice.generateOpenSwitchMessage(address);
				break;
			default:
				break;
			}
			break;
		case 1:// 合
			switch (type) {
			case 0:// 低压开关
				msg = lowVoltageDevice.generateCloseSwitchMessage(address);
				break;
			case 1:// 高压开关
				msg = highVoltageDevice.generateCloseSwitchMessage(address);
				break;
			case 2:// 管控开关
				msg = controlMeasureDevice.generateCloseSwitchMessage(address);
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		// 发送报文
		if (msg != null && gprs != null && gprs.getCtx() != null) {

			gprs.getCtx().writeAndFlush(msg);
		} else {
			return "error";
		}
		return "switch_detail";
	}

	// /**
	// *
	// * @Title: cancelControlSwitch
	// * @Description: TODO
	// * @param @param switchId
	// * @param @param sign
	// * @param @param model
	// * @param @param redirectAttributes
	// * @param @return
	// * @return String
	// * @throws
	// */
	// @RequestMapping("/cancel_control_switch")
	// public String cancelControlSwitch(
	// @RequestParam(required = true) String switchId, int sign,
	// Model model, RedirectAttributes redirectAttributes) {
	//
	// SwitchGPRS gprs = CtxStore.get(switchId);
	// String identifier = ControlIdentificationCode.valueOf(sign).toString();
	//
	// if (gprs != null && gprs.getAddress() != null) {
	//
	// String msg = LowVoltageDeviceCommandUtil.controlSwitch(gprs.getAddress(),
	// new DataZone(identifier));
	//
	// gprs.getCtx().writeAndFlush(msg);
	// } else {
	// return "error";
	// }
	//
	// return "switch_detail";
	// }

	/**
	 * 
	 * @Title: readVoltage
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param sign
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/read_voltage")
	@ResponseBody
	public Object readVoltage(@RequestParam(required = true) String switchId,
			String type) {

		Integer[] deStrings = new Integer[3];
		switch (type) {
		case "0":// 低压开关
			// 从数据库中查询结果
			List<LowVoltageVoltage> cliList = voltageService
					.getRecentlyVoltage();

			if (cliList != null) {
				for (LowVoltageVoltage current : cliList) {
					String p = current.getPhase();
					switch (p) {
					case "A":
						deStrings[0] = current.getValue();
						break;
					case "B":
						deStrings[1] = current.getValue();
						break;
					case "C":
						deStrings[2] = current.getValue();
						break;
					default:
						break;
					}
				}
			}
			break;
		case "1":// 高压开关
			// 从数据库中查询结果
			List<HighVoltageVoltage> cliList2 = voltageService2
					.getRecentlyVoltage();

			if (cliList2 != null) {
				for (HighVoltageVoltage current : cliList2) {
					String p = current.getPhase();
					switch (p) {
					case "A":
						deStrings[0] = current.getValue();
						break;
					case "B":
						deStrings[1] = current.getValue();
						break;
					case "C":
						deStrings[2] = current.getValue();
						break;
					default:
						break;
					}
				}
			}
			break;
		case "2":// 管控开关
			// 从数据库中查询结果
			List<ControlMearsureVoltage> cliList3 = voltageService3
					.getRecentlyVoltage();

			if (cliList3 != null) {
				for (ControlMearsureVoltage current : cliList3) {
					String p = current.getPhase();
					switch (p) {
					case "A":
						deStrings[0] = current.getValue();
						break;
					case "B":
						deStrings[1] = current.getValue();
						break;
					case "C":
						deStrings[2] = current.getValue();
						break;
					default:
						break;
					}
				}

			}
			break;
		default:
			break;
		}
		return deStrings;
	}

	/**
	 * 
	 * @Title: readCurrentVariable
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param sign
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/read_current")
	@ResponseBody
	public Object readCurrentVariable(
			@RequestParam(required = true) String switchId, String type) {

		Integer[] deStrings = new Integer[3];
		switch (type) {
		case "0":// 低压开关
			// 从数据库中查询结果
			List<LowVoltageCurrent> cliList = currentService
					.getRecentlyCurrent();

			if (cliList != null) {
				for (LowVoltageCurrent current : cliList) {
					String p = current.getPhase();
					switch (p) {
					case "A":
						deStrings[0] = current.getValue();
						break;
					case "B":
						deStrings[1] = current.getValue();
						break;
					case "C":
						deStrings[2] = current.getValue();
						break;
					default:
						break;
					}
				}
			}
			break;
		case "1":// 高压开关
			// 从数据库中查询结果
			List<HighVoltageCurrent> cliList2 = currentService2
					.getRecentlyCurrent();

			if (cliList2 != null) {
				for (HighVoltageCurrent current : cliList2) {
					String p = current.getPhase();
					switch (p) {
					case "A":
						deStrings[0] = current.getValue();
						break;
					case "B":
						deStrings[1] = current.getValue();
						break;
					case "C":
						deStrings[2] = current.getValue();
						break;
					default:
						break;
					}
				}
			}
			break;
		case "2":// 管控开关
			// 从数据库中查询结果
			List<ControlMearsureCurrent> cliList3 = currentService3
					.getRecentlyCurrent();

			if (cliList3 != null) {
				for (ControlMearsureCurrent current : cliList3) {
					String p = current.getPhase();
					switch (p) {
					case "A":
						deStrings[0] = current.getValue();
						break;
					case "B":
						deStrings[1] = current.getValue();
						break;
					case "C":
						deStrings[2] = current.getValue();
						break;
					default:
						break;
					}
				}

			}
			break;
		default:
			break;
		}
		return deStrings;
	}

	/**
	 * 
	 * @Title: readHitchEvent
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param sign
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/read_hitch_event")
	@ResponseBody
	public Object readHitchEvent() {

		return CtxStore.getInstance();
	}

}
