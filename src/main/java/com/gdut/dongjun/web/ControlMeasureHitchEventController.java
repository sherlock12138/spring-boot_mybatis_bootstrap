package com.gdut.dongjun.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdut.dongjun.domain.po.ControlMearsureHitchEvent;
import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.service.ControlMearsureHitchEventService;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;

@Controller
@RequestMapping("/dongjun")
public class ControlMeasureHitchEventController {

	@Autowired
	private ControlMearsureHitchEventService hitchEventService;

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
	@RequestMapping("/control_measure_hitch_event_manager")
	public String getLineSwitchList(String switchId, Model model) {

		List<ControlMearsureHitchEvent> events = null;
		if (switchId != null) {

			events = hitchEventService.selectByParameters(MyBatisMapUtil.warp(
					"switch_id", switchId));
		} else {
			events = hitchEventService.selectByParameters(null);
		}
		model.addAttribute("hitch_events", events);
		return "control_measure_hitch_event_manager";
	}

	/**
	 * 
	 * @Title: getEventList
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param model
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/get_control_measure_hitch_event_by_switch_id")
	@ResponseBody
	public Object getEventList(String switchId, Model model) {

		List<ControlMearsureHitchEvent> events = null;
		if (switchId != null) {

			events = hitchEventService.selectByParameters(MyBatisMapUtil.warp(
					"switch_id", switchId));
		} else {
			events = hitchEventService.selectByParameters(null);
		}
		HashMap<String, Object> map = (HashMap<String, Object>) MapUtil.warp(
				"draw", 1);
		int size = events.size();
		map.put("recordsTotal", size);
		map.put("data", events);
		map.put("recordsFiltered", size);
		return map;
	}
	

	// /**
	// *
	// * @Title: delSwitch
	// * @Description: TODO
	// * @param @param switchId
	// * @param @param model
	// * @param @param redirectAttributes
	// * @param @return
	// * @return String
	// * @throws
	// */
	// @RequestMapping("/del_low_voltage_hitch_event")
	// public String delSwitch(@RequestParam(required = true) String eventId,
	// Model model, RedirectAttributes redirectAttributes) {
	//
	// hitchEventService.deleteByPrimaryKey(eventId);// 删除这个事件
	//
	// // /为绝对路径，即为http://localhost:9080/switch_list?lineId=01
	// // 没有/为相对路径 http://localhost:9080/dongjun/switch_list?lineId=01
	// return "redirect:low_voltage_hitch_event_manager";
	// }

}
