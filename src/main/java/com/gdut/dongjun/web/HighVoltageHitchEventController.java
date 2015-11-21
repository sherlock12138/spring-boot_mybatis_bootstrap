package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.service.LowVoltageHitchEventService;

@Controller
@RequestMapping("/dongjun")
public class HighVoltageHitchEventController {

	@Autowired
	private LowVoltageHitchEventService hitchEventService;

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
	@RequestMapping("/high_voltage_hitch_event_manager")
	public String getLineSwitchList(Model model) {

		model.addAttribute("hitch_events", hitchEventService.hitchEventList());
		return "high_voltage_hitch_event_manager";
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
	@RequestMapping("/del_high_voltage_hitch_event")
	public String delSwitch(@RequestParam(required = true) String eventId,
			Model model, RedirectAttributes redirectAttributes) {

		hitchEventService.deleteByPrimaryKey(eventId);// 删除这个事件

		// /为绝对路径，即为http://localhost:9080/switch_list?lineId=01
		// 没有/为相对路径 http://localhost:9080/dongjun/switch_list?lineId=01
		return "redirect:high_voltage_hitch_event_manager";
	}


	
}
