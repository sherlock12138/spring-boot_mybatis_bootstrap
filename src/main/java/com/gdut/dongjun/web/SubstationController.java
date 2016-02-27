package com.gdut.dongjun.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.Substation;
import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.service.CompanyService;
import com.gdut.dongjun.service.SubstationService;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

@Controller
@RequestMapping("/dongjun")
@SessionAttributes("currentUser")
public class SubstationController {

	@Autowired
	private SubstationService substationService;
	@Autowired
	private CompanyService companyService;
	private static final Logger logger = Logger
			.getLogger(SubstationController.class);

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
	@RequestMapping("/substation_manager")
	public String getLineSwitchList(Model model) {

		model.addAttribute("switches",
				substationService.selectByParameters(null));
		return "substation_manager";
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
	@RequestMapping("/substation_list_by_company_id")
	@ResponseBody
	public Object getLineSwitchListByLineId(HttpSession session, Model model) {

		User user = (User) session.getAttribute("currentUser");
		String companyId = null;
		if (user != null) {

			companyId = user.getCompanyId();
		}
		List<Substation> lines = substationService
				.selectByParameters(MyBatisMapUtil
						.warp("company_id", companyId));

		int size = lines.size();
		HashMap<String, Object> map = (HashMap<String, Object>) MapUtil.warp(
				"draw", 1);
		map.put("recordsTotal", size);
		map.put("data", lines);
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
	@RequestMapping("/del_substation")
	@ResponseBody
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		String lineId = substationService.selectByPrimaryKey(switchId)
				.getCompanyId();
		try {

			substationService.deleteByPrimaryKey(switchId);// 删除这个开关
		} catch (Exception e) {
			logger.error("删除开关失败！");
			return null;
		}
		return lineId;
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
	@RequestMapping("/edit_substation")
	@ResponseBody
	public String editSwitch(Substation switch1, Model model,
			RedirectAttributes redirectAttributes) {

		if (switch1.getId() == "") {
			switch1.setId(UUIDUtil.getUUID());
		}
		try {

			substationService.updateByPrimaryKey(switch1);
		} catch (Exception e) {

			logger.error("修改开关失败！");
			return null;
		}
		return switch1.getCompanyId();
	}

}
