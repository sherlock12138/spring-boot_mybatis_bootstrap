package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.LowVoltageSwitchService;

@Controller
@RequestMapping("/dongjun")
public class SwitchController {

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
	@RequestMapping("/switch_manager")
	public String getLineSwitchList(Model model) {

		model.addAttribute("switches", switchService.selectByParameters(null));
		return "switch_manager";
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
	@RequestMapping("/del_switch")
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		Line line = LineService.getLineBySwitchId(switchId);// 根据开关ID查到所属线路
		switchService.deleteByPrimaryKey(switchId);// 删除这个开关
		if (line != null)
			redirectAttributes.addAttribute("lineId", line.getId());// 再次查找线路下的开关

		// /为绝对路径，即为http://localhost:9080/switch_list?lineId=01
		// 没有/为相对路径 http://localhost:9080/dongjun/switch_list?lineId=01
		return "redirect:switch_manager";
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
		
		//@RequestParam(required = true) 
		//进不来
		System.out.println(switch1.toString());
		switchService.updateSwitch(switch1);
		redirectAttributes.addAttribute("lineId", switch1.getLineId());
		return "redirect:switch_manager";
	}

}
