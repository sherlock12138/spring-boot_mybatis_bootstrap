package com.gdut.dongjun.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.ControlMearsureSwitch;
import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.service.ControlMearsureSwitchService;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

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
	 * @throws high_voltage_
	 */
	@RequestMapping("/control_measure_switch_manager")
	public String getLineSwitchList(String lineId, Model model) {

		if (lineId != null) {

			model.addAttribute("switches", switchService
					.selectByParameters(MyBatisMapUtil.warp("line_id", lineId)));
		} else {
			model.addAttribute("switches",
					switchService.selectByParameters(null));
		}
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
	@ResponseBody
	public Object getLineSwitchListByLineId(
			@RequestParam(required = true) String lineId, Model model) {

		System.out.println(lineId);
		List<ControlMearsureSwitch> switchs = switchService
				.selectByParameters(MyBatisMapUtil.warp("line_id", lineId));
		HashMap<String, Object> map = (HashMap<String, Object>) MapUtil.warp(
				"draw", 1);
		int size = switchs.size();
		map.put("recordsTotal", size);
		map.put("data", switchs);
		map.put("recordsFiltered", size);
		return map;
	}

	/**
	 * 
	 * @Title: selectCMByLineIdInAsc
	 * @Description: TODO
	 * @param @param lineId
	 * @param @param model
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/selectCMByLineIdInAsc")
	@ResponseBody
	public Object selectCMByLineIdInAsc(
			@RequestParam(required = true) String lineId, Model model) {

		List<ControlMearsureSwitch> switchs = switchService
				.selectByParameters(MyBatisMapUtil.warp("line_id", lineId));

		return switchs;
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

		String lineId = switchService.selectByPrimaryKey(switchId).getLineId();
		switchService.deleteByPrimaryKey(switchId);// 删除这个开关
		redirectAttributes.addAttribute("lineId", lineId);
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
		if (switch1.getId() == "") {
			switch1.setId(UUIDUtil.getUUID());
		}
		switchService.updateByPrimaryKey(switch1);
		redirectAttributes.addAttribute("lineId", switch1.getLineId());
		return "redirect:control_measure_switch_manager";
	}

}
