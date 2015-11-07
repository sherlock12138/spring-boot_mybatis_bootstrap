package com.gdut.dongjun.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.Current;
import com.gdut.dongjun.domain.po.Voltage;
import com.gdut.dongjun.service.CurrentService;
import com.gdut.dongjun.service.HitchEventService;
import com.gdut.dongjun.service.SwitchService;
import com.gdut.dongjun.service.VoltageService;
import com.gdut.dongjun.service.impl.CtxStore;
import com.gdut.dongjun.service.impl.DataZone;
import com.gdut.dongjun.service.impl.SwitchGPRS;
import com.gdut.dongjun.service.impl.enums.ControlIdentificationCode;
import com.gdut.dongjun.util.CommandUtil;

@Controller
@RequestMapping("/dongjun")
public class CommandController {

	@Autowired
	private SwitchService switchService;
	@Autowired
	private CurrentService currentService;
	@Autowired
	private VoltageService voltageService;
	@Autowired
	private HitchEventService hitchEventService;
	private static final Logger logger = Logger.getLogger(CommandController.class);

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
			int sign, String orderTime, Model model,
			RedirectAttributes redirectAttributes) {

		SwitchGPRS gprs = CtxStore.get(switchId);
		String identifier = ControlIdentificationCode.valueOf(sign).toString();

		if (gprs != null && gprs.getAddress() != null) {

			String msg = CommandUtil.controlSwitch(gprs.getAddress(),
					new DataZone(identifier, orderTime));

			gprs.getCtx().writeAndFlush(msg);
		} else {
			return "error";
		}
		return "switch_detail";
	}

	/**
	 * 
	 * @Title: cancelControlSwitch
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param sign
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/cancel_control_switch")
	public String cancelControlSwitch(
			@RequestParam(required = true) String switchId, int sign,
			Model model, RedirectAttributes redirectAttributes) {

		SwitchGPRS gprs = CtxStore.get(switchId);
		String identifier = ControlIdentificationCode.valueOf(sign).toString();

		if (gprs != null && gprs.getAddress() != null) {

			String msg = CommandUtil.controlSwitch(gprs.getAddress(),
					new DataZone(identifier));

			gprs.getCtx().writeAndFlush(msg);
		} else {
			return "error";
		}

		return "switch_detail";
	}

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
	public Object readVoltage(@RequestParam(required = true) String switchId) {

		SwitchGPRS gprs = CtxStore.get(switchId);
		if (gprs != null && gprs.getAddress() != null) {

			String msg = CommandUtil.readAllPhaseVoltage(gprs.getAddress());
			gprs.getCtx().writeAndFlush(msg);// 执行命令
		} else {
			logger.error("the swtch you operate is offline!");
			return "";
		}

		//从数据库中查询结果
		List<Voltage> vliList = voltageService.getRecentlyVoltage();
		String[] deStrings = new String[3];

		if (vliList != null) {
			for (Voltage v : vliList) {
				String p = v.getPhase();
				switch (p) {
				case "A":
					deStrings[0] = v.getValue() + "";
					break;
				case "B":
					deStrings[1] = v.getValue() + "";
					break;
				case "C":
					deStrings[2] = v.getValue() + "";
					break;
				default:
					break;
				}
			}
			return deStrings;
		} else {
			return "";
		}
		
		
		
		
		
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
			@RequestParam(required = true) String switchId) {

		SwitchGPRS gprs = CtxStore.get(switchId);
		if (gprs != null && gprs.getAddress() != null) {

			String msg = CommandUtil.readAllPhaseCurrent(gprs.getAddress());
			gprs.getCtx().writeAndFlush(msg);// 执行命令
		} else {
			logger.error("the swtch you operate is offline!");
			return "";
		}

		//从数据库中查询结果
		List<Current> cliList = currentService.getRecentlyCurrent();
		String[] deStrings = new String[3];

		if (cliList != null) {
			for (Current current : cliList) {
				String p = current.getPhase();
				switch (p) {
				case "A":
					deStrings[0] = current.getValue() + "";
					break;
				case "B":
					deStrings[1] = current.getValue() + "";
					break;
				case "C":
					deStrings[2] = current.getValue() + "";
					break;
				default:
					break;
				}
			}
			return deStrings;
		} else {
			return "";
		}
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
