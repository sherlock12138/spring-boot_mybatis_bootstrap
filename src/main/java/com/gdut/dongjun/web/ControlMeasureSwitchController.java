package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.ControlMearsureSwitch;
import com.gdut.dongjun.service.ControlMearsureSwitchService;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.util.MyBatisMapUtil;

@Controller
@RequestMapping("/dongjun")
public class ControlMeasureSwitchController {

	@Autowired
	private ControlMearsureSwitchService switchService;
	@Autowired
	private LineService LineService;

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
	@RequestMapping("/control_measure_switch_manager")
	public String getLineSwitchList(Model model) {

		model.addAttribute("switches", switchService.selectByParameters(null));
		return "control_measure_switch_manager";
	}

	/**
	 * 
	 * @Title: getAllLowVoltage_Switch
	 * @Description: TODO
	 * @param @param model
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/get_all_control_measure_switch")
	@ResponseBody
	public Object getAllLowVoltage_Switch(Model model) {

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
	@RequestMapping("/control_measure_switch_list_by_line_id")
	public String getLineSwitchListByLineId(
			@RequestParam(required = true) String lineId, Model model) {

		model.addAttribute("switches", switchService
				.selectByParameters(MyBatisMapUtil.warp("line_id", lineId)));
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
	@RequestMapping("/del_control_measure_switch")
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		switchService.deleteByPrimaryKey(switchId);// 删除这个开关

		// /为绝对路径，即为http://localhost:9080/switch_list?lineId=01
		// 没有/为相对路径 http://localhost:9080/dongjun/switch_list?lineId=01
		return "redirect:control_measure_switch_manager";
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
	@RequestMapping("/edit_control_measure_switch")
	public String editSwitch(ControlMearsureSwitch switch1, Model model,
			RedirectAttributes redirectAttributes) {

		// @RequestParam(required = true)
		// 进不来
		switchService.updateByPrimaryKey(switch1);
		return "redirect:control_measure_switch_manager";
	}

}
