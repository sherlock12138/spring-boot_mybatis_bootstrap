package com.gdut.dongjun.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdut.dongjun.service.CurrentService;
import com.gdut.dongjun.service.VoltageService;

@Controller
@RequestMapping("/dongjun")
public class ChartController {

	@Autowired
	private CurrentService currentService;
	@Autowired
	private VoltageService voltageService;

	/**
	 * 
	 * @Title: currentChart
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/current_chart")
	@ResponseBody
	public Object currentChart(@RequestParam(required = true) String switchId) {

		return currentService.selectBySwitchId(switchId);

	}

	/**
	 * 
	 * @Title: voltageChart
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/voltage_chart")
	@ResponseBody
	public Object voltageChart(@RequestParam(required = true) String switchId) {

		return voltageService.selectBySwitchId(switchId);

	}

	/**
	 * 
	 * @Title: selectChartByDate
	 * @Description: TODO
	 * @param @param search_date
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/select_chart_by_date")
	@ResponseBody
	public Object selectChartByDate(
			@RequestParam(required = true) String switchId, String date) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("current", currentService.selectByTime(switchId, date + "%"));
		map.put("voltage", voltageService.selectByTime(switchId, date + "%"));
		return map;
	}

}
