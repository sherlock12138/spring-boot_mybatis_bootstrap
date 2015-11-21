package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdut.dongjun.service.ControlMearsureVoltageService;

@Controller
@RequestMapping("/dongjun")
public class TestController {

	@Autowired
	public ControlMearsureVoltageService voltageService;
	
	@RequestMapping("/test1")
	@ResponseBody
	public Object readCurrentVariable() {
		/**
		 * 实现报警事件的报文
		 */
		
		
		return null;
	}
}
