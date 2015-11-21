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
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.domain.po.Substation;
import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.service.CompanyService;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.service.SubstationService;
import com.gdut.dongjun.util.MyBatisMapUtil;

@Controller
@RequestMapping("/dongjun")
@SessionAttributes("currentUser")
public class SubstationController {

	@Autowired
	private SubstationService substationService;
	@Autowired
	private CompanyService companyService;

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
	public String getLineSwitchListByLineId(HttpSession session, Model model) {

		User user = (User) session.getAttribute("currentUser");
		String companyId = null;
		if (user != null) {

			companyId = user.getCompanyId();
		}
		model.addAttribute("switches", substationService
				.selectByParameters(MyBatisMapUtil
						.warp("company_id", companyId)));
		return "substation_list";
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
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		substationService.deleteByPrimaryKey(switchId);
		redirectAttributes.addAttribute("lineId",
				substationService.selectByParameters(null));

		return "redirect:substation_manager";
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
	public String editSwitch(Substation switch1, Model model,
			RedirectAttributes redirectAttributes) {

		// @RequestParam(required = true)
		// 进不来
		System.out.println(switch1.toString());
		substationService.updateByPrimaryKey(switch1);
		redirectAttributes.addAttribute("lineId",
				substationService.selectByParameters(null));
		return "redirect:substation_manager";
	}

}
