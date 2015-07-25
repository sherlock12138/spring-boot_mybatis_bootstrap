package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdut.dongjun.domain.dao.LineMapper;
import com.gdut.dongjun.domain.dao.system.UserMapper;
import com.gdut.dongjun.service.LineService;

@Controller
@RequestMapping("/boot")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private LineService lineService;

	@RequestMapping("/f")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		System.out.println(userMapper.selectByPrimaryKey("001").getName());
		
		System.out.println(lineService.selectByPrimaryKey("01").getName());
		
		return "fluid";
	}

}
