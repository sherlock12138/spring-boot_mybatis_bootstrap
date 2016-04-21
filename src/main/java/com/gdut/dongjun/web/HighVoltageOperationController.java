package com.gdut.dongjun.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdut.dongjun.domain.po.HighVoltageOperation;
import com.gdut.dongjun.domain.po.SwitchOperation;
import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.service.HighVoltageOperationService;
import com.gdut.dongjun.service.SwitchOperationService;
import com.gdut.dongjun.service.UserService;
import com.gdut.dongjun.util.ListUtil;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

@RestController
@RequestMapping("/dongjun")
public class HighVoltageOperationController {

	@Autowired
	public HighVoltageOperationService operationService;
	
	@Autowired
	private SwitchOperationService switchOperationService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/operation_switch_user")
	public Object getOperationBySwitchAndUser(@RequestParam(required=false) 
		String switchId, HttpSession session) {
		
		User user = (User) session.getAttribute("currentUser");
		
		if(user != null) {
			Map<String, Object> map = new HashMap<>(2);
			map.put("user_id", user.getId());
			map.put("switch_id", switchId);
			return operationService.selectByParameters(MyBatisMapUtil.warp("user_id", 
					user.getId()));
		}
		return null;
	}
	
	public Object getUserBySwitch(@RequestParam(required=false) String switchId) {
		
		return null;
	}
	
	@RequestMapping("/add_operation")
	public Object addOneOperationToOneUser(@RequestParam(required=false) String switchId, 
			String type, String userId) {
		
		operationService.insert(new HighVoltageOperation(
				UUIDUtil.getUUID(), userId, switchId, type));
		return MapUtil.SUCCESS;
	}
	
	@RequestMapping("/add_all_operation")
	public Object addAllOperationToOneUser(@RequestParam(required=false) String switchId, 
			String userId) {
		
		List<SwitchOperation> list = switchOperationService.selectByParameters(null);
		Map<String, Object> map = HighVoltageOperation.getMap(userId, switchId);
		if(list != null && list.size() != 0) {
			for(int i = list.size(); i >= 0; --i) {
				map.put("operation_id", String.valueOf(i));
				if(ListUtil.isEmpty(operationService.selectByParameters(
						MyBatisMapUtil.warp(map)))) {
					HighVoltageOperation operation = new HighVoltageOperation(map);
					operation.setId(UUIDUtil.getUUID());
					operationService.insert(operation);
				}
			}
		}
		return MapUtil.SUCCESS;
	}
	
	/*@RequestMapping("/add_all_user_opera")
	public Object addOneOperationToAllUser(@RequestParam(required=false) String switchId,
		String type) {
		
		List<User> list = userService.selectByParameters(null);
		if(!ListUtil.isEmpty(list)) {
			Map<String, Object> map = HighVoltageOperation.getAnoMap(switchId, type);
			for(User user : list) {
				HighVoltageOperation operation = new HighVoltageOperation(map);
				operation.setId(UUIDUtil.getUUID());
				operation.setUserId(user.getId());
				operationService.insert(operation);
			}
		}
		return MapUtil.SUCCESS;
	}*/

	@RequestMapping("/delete_one_operation")
	public Object deleteOneOperationToOneUser(@RequestParam(required=false) String switchId,
		String type, String userId) {
		
		Map<String, Object> operation = new HashMap<>();
		operation.put("switch_id", switchId);
		operation.put("user_id", userId);
		operation.put("operation_id", type);
		List<HighVoltageOperation> hto = operationService.
				selectByParameters(MyBatisMapUtil.warp(operation));
		if(hto != null && hto.size() != 0) {
			operationService.deleteByPrimaryKey(hto.get(0).getId());
		}
		return MapUtil.SUCCESS;
	}
	
	@RequestMapping("/delete_all_operation")
	public Object deleteAllOperationToOneUser(@RequestParam(required=false) String switchId,
		String userId) {
		
		Map<String, Object> operation = new HashMap<>();
		operation.put("switch_id", switchId);
		operation.put("user_id", userId);
		List<HighVoltageOperation> htos = operationService.
				selectByParameters(MyBatisMapUtil.warp(operation));
		if(htos != null && htos.size() != 0) {
			for(HighVoltageOperation hto : htos) {
				operationService.deleteByPrimaryKey(hto.getId());
			}
		}
		return MapUtil.SUCCESS;
	}

	
}