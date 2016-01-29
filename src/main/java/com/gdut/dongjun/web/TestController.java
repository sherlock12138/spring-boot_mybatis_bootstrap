package com.gdut.dongjun.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdut.dongjun.domain.po.HighVoltageHitchEvent;
import com.gdut.dongjun.service.HighVoltageHitchEventService;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.UUIDUtil;

@Controller
@RequestMapping("/dongjun")
public class TestController {

	@Autowired
	private HighVoltageHitchEventService hitchEvent;
	
	@RequestMapping("/testA")
	@ResponseBody
	public Object testA() {
		HighVoltageHitchEvent hitch = new HighVoltageHitchEvent();
		hitch.setId(UUIDUtil.getUUID());
		hitch.setHitchTime(new Date());
		hitch.setHitchPhase("A");
		hitch.setHitchReason(0);
		hitch.setSwitchId("03");
		hitchEvent.insert(hitch);
		return MapUtil.warp("success", "true");
	}
}
