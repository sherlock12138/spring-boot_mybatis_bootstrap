package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.service.ZTreeNodeService;

@Controller
@RequestMapping("/dongjun")
public class IndexController {

	@Autowired
	private ZTreeNodeService zTreeNodeService;

	/**
	 * 
	 * @Title: forwardIndex
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/index")
	public String forwardIndex() {
		return "index";
	}

	/**
	 * 
	* @Title: manager 
	* @Description: TODO
	* @param @return   
	* @return String   
	* @throws
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "manager";
	}

	/**
	 * 
	 * @Title: currentVoltageChart
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/current_voltage_chart")
	public String currentVoltageChart() {
		return "current_voltage_chart";
	}

	
	/**
	 * 
	 * @Title: switchTree
	 * @Description: TODO
	 * @param @param companyId
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/switch_tree")
	@ResponseBody
	public Object switchTree(@RequestParam(required = true) String companyId,
			Model model, RedirectAttributes redirectAttributes) {

		System.out.println(zTreeNodeService.getSwitchTree(companyId));

		return zTreeNodeService.getSwitchTree(companyId);

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
	@RequestMapping("/switch_detail")
	public String enterMap(@RequestParam(required = true) String switchId,
			Model model) {

		model.addAttribute("switchId", switchId);
		return "switch_detail";
	}

}
