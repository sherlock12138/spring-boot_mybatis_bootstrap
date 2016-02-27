package com.gdut.dongjun.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gdut.dongjun.domain.po.LocationSwitch;
import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.service.LocationSwitchService;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

/**
 *@Author link xiaoMian <972192420@qq.com>
 *@ClassName LocationSwitchController.java
 *@Time 2016年2月27日下午1:14:38
 *@Description TODO
 *@Version 1.0 Topview
 */
@Controller
@RequestMapping("/dongjun")
@SessionAttributes("currentUser")
public class LocationSwitchController {

	@Autowired
	public LocationSwitchService locateService;
	
	@RequestMapping("/edit_location")
	@ResponseBody
	public Object editLocation(HttpSession session, String switchId, int type) {
		
		LocationSwitch locationSwitch = getLocationSwitch(session);
		
		
		if(locationSwitch == null) {
			
			locationSwitch = new LocationSwitch();
			locationSwitch.setId(UUIDUtil.getUUID());
			locationSwitch.setUserId(((User) session.getAttribute("currentUser")).getId());
			locationSwitch.setSwitchId(switchId);
			locationSwitch.setType(type);
			locateService.insert(locationSwitch);
		} else {
			
			locationSwitch.setSwitchId(switchId);
			locationSwitch.setType(type);
			locateService.updateByPrimaryKeySelective(locationSwitch);
		}
		return MapUtil.warp("success", true);
	}
	
	@RequestMapping("delete_location")
	@ResponseBody
	public Object deleteLocation(HttpSession session) {
		
		LocationSwitch locationSwitch = getLocationSwitch(session);

		if(locationSwitch != null) {
			locateService.deleteByPrimaryKey(locationSwitch.getId());
		}
		
		return MapUtil.warp("success", true);
	}
	
	@RequestMapping("/get_location_switch")
	@ResponseBody
	public Object getSwitch(HttpSession session) {
		
		return getLocationSwitch(session);	
	}
	
	private LocationSwitch getLocationSwitch(HttpSession session) {
		
		User user = (User) session.getAttribute("currentUser");
		String id = null;
		if(user != null) {
			id = user.getId();
		}
		
		List<LocationSwitch> list = 
				locateService.selectByParameters(MyBatisMapUtil.warp("user_id", id));
		
		if(list != null && list.size() != 0) {

			return list.get(0);
		} else {
			
			return null;
		}
	}
}
