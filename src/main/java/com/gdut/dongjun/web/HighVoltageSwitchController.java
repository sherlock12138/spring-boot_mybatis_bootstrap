package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.LowVoltageSwitchService;

@Controller
@RequestMapping("/dongjun")
public class HighVoltageSwitchController {

	@Autowired
	private LowVoltageSwitchService switchService;
	@Autowired
	private LineService LineService;

	/**
	 * 
	 * @Title: getLineSwitchList
	 * @param @param lineId
	 * @param @param model
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/high_voltage_switch_manager")
	public String getLineSwitchList(Model model) {

		model.addAttribute("switches", switchService.selectByParameters(null));
		return "high_voltage_switch_manager";
	}

	/**
	 * 
	 * @Title: getAllHighVoltage_Switch
	 * @Description: TODO
	 * @param @param model
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/get_all_high_voltage_switch")
	@ResponseBody
	public Object getAllHighVoltage_Switch(Model model) {

		return switchService.selectByParameters(null);
	}

	/**
	 * 
	 * @Title: getLineSwitchList
	 * @Description: TODO
	 * @param @param lineId
	 * @param @param model
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/high_voltage_switch_list_by_line_id")
	public String getLineSwitchListByLineId(
			@RequestParam(required = true) String lineId, Model model) {

		model.addAttribute("switches", switchService.selectByLineId(lineId));
		return "switch_list";
	}

	/**
	 * 
	 * @Title: delSwitch
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/del_high_voltage_switch")
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		switchService.deleteByPrimaryKey(switchId);// 删除这个开关
		return "redirect:high_voltage_switch_manager";
	}

	/**
	 * 
	 * @Title: editSwitch
	 * @Description: TODO
	 * @param @param switch1
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/edit_high_voltage_switch")
	public String editSwitch(LowVoltageSwitch switch1, Model model,
			RedirectAttributes redirectAttributes) {

		switchService.updateSwitch(switch1);
		return "redirect:high_voltage_switch_manager";
	}

}
