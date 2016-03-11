package com.gdut.dongjun.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.service.ZTreeNodeService;
import com.gdut.dongjun.service.net_server.CtxStore;
import com.gdut.dongjun.service.net_server.SwitchGPRS;
import com.gdut.dongjun.util.EncoderUtil;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.VoiceFixUtil;

@Controller
@RequestMapping("/dongjun")
@SessionAttributes("currentUser")
public class IndexController {

	@Autowired
	private ZTreeNodeService zTreeNodeService;
	@Autowired
	private org.apache.shiro.mgt.SecurityManager manager;

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
	public Object switchTree(@RequestParam(required = true) String type,
			Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {

		User user = (User) session.getAttribute("currentUser");
		if (user != null && user.getCompanyId() != null) {

			return zTreeNodeService.getSwitchTree(user.getCompanyId(),type);
		} else {

			return "";
		}
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

	@RequestMapping("get_voice_of_event")
	@ResponseBody
	public String getVoiceOfEvent(@RequestParam(required=false) String name) {
		
		String httpUrl = "http://apis.baidu.com/apistore/baidutts/tts";
		String httpArg = "text=" + EncoderUtil.getUrlEncode
				("开关" + name + "已经报警，请及时处理") +"&ctp=1&per=0";
		//String httpArg = "text=%E8%AF%AD%E9%9F%B3%E5%90%88%E6%88%90%E6%8A%80%E6%9C%AF&ctp=1&per=0";
		return VoiceFixUtil.request(httpUrl, httpArg);
	}
	
	@RequestMapping("/ignore_hitch_event") 
	@ResponseBody
	public Object ignoreHitchEvent(@RequestParam(required = true)String switchId) {
		
		SwitchGPRS gprs = CtxStore.get(switchId);
		gprs.setOpen(false);
		return MapUtil.warp("success", true);
	}
}
