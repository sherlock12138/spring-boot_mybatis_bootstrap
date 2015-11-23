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

import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

@Controller
@RequestMapping("/dongjun")
public class LowVoltageSwitchController {

	@Autowired
	private LowVoltageSwitchService switchService;
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
	@RequestMapping("/low_voltage_switch_manager")
	public String getLineSwitchList(Model model) {

		model.addAttribute("switches", switchService.selectByParameters(null));
		return "low_voltage_switch_manager";
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
	@RequestMapping("/get_all_low_voltage_switch")
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
	@RequestMapping("/switch_list_by_line_id")
	@ResponseBody
	public Object getLineSwitchListByLineId(
			@RequestParam(required = true) String lineId, Model model) {

		System.out.println(lineId);
		List<LowVoltageSwitch> switchs = switchService
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
	 * @Title: delSwitch
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/del_switch")
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		switchService.deleteByPrimaryKey(switchId);// 删除这个开关
		return "redirect:low_voltage_switch_manager";
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
	@RequestMapping("/edit_switch")
	public String editSwitch(LowVoltageSwitch switch1, Model model,
			RedirectAttributes redirectAttributes) {

		// @RequestParam(required = true)
		// 进不来
		if (switch1.getId() == "") {
			switch1.setId(UUIDUtil.getUUID());
		}
		switchService.updateByPrimaryKey(switch1);
		return "redirect:low_voltage_switch_manager";
	}

}
