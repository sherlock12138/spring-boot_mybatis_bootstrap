package com.gdut.dongjun.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.SubstationService;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

@Controller
@RequestMapping("/dongjun")
@SessionAttributes("currentUser")
public class LineController {

	@Autowired
	private LineService lineService;
	@Autowired
	private SubstationService substationService;

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
	@RequestMapping("/line_manager")
	public String getLineSwitchList(Model model) {

		model.addAttribute("switches", lineService.selectByParameters(null));
		return "line_manager";
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
	@RequestMapping("/line_list_by_substation_id")
	public String getLineSwitchListByLineId(String substation_id,
			HttpSession session, Model model) {

		model.addAttribute("switches", lineService
				.selectByParameters(MyBatisMapUtil.warp("substation_id",
						substation_id)));
		return "line_list";
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
	@RequestMapping("/del_line")
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		lineService.deleteByPrimaryKey(switchId);
		redirectAttributes.addAttribute("lineId",
				lineService.selectByParameters(null));

		return "redirect:line_manager";
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
	@RequestMapping("/edit_line")
	public String editSwitch(Line switch1, Model model,
			RedirectAttributes redirectAttributes) {

		// @RequestParam(required = true)
		// 进不来
		System.out.println(switch1.toString());
		switch1.setId(UUIDUtil.getUUID());
		lineService.updateByPrimaryKey(switch1);
		redirectAttributes.addAttribute("lineId",
				lineService.selectByParameters(null));
		return "redirect:line_manager";
	}

}
