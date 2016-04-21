package com.gdut.dongjun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdut.dongjun.service.SwitchOperationService;

@RestController
@RequestMapping("/dongjun")
public class SwitchOperationController {
	
	@Autowired
	private SwitchOperationService operationService;
	
	@RequestMapping("/get_all_operation")
	public Object getAllOperation() {
		
		return operationService.selectByParameters(null);
	}
}