/**
 * 
 */
dwr.engine.setActiveReverseAjax(true);
//设置在页面关闭时，通知服务端销毁会话
dwr.engine.setNotifyServerOnPageUnload(true);

var alarmList = [];
function showHitchEvent(data) {
	
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	for (var i = data.length - 1; i >= 0; --i) {
		
		if(data[i].id != null) {
			var nodeList = zTree.getNodesByParamFuzzy("id", data[i].id);
			
			if(nodeList.length != 0) {
				if(data[i].status == "00") {
					switchs_draw(nodeList[0], open_switch, click_high_voltage_switch);	//开闸描绘
					if(data[i].open == true) {
						
						alarmList.push(nodeList[0].id);	//status与open同时符合才报警
						//alert("警告，已经跳闸！");
						update(nodeList, 2);  // 树节点变红
						worning_switchs_draw(nodeList[0]); //声音的 图标的
						
						if(isPush(nodeList[0].id)) {
							alarmList.push(nodeList[0].id);
						}
					}
				} else {
					
					switchs_draw(nodeList[0], close_switch, click_high_voltage_switch);
					deleteAlarmSwitch(nodeList);
				}
			}
		}
	}
}

function isPush(id) {
	for(var i = alarmList.length - 1; i >= 0; --i) {
		if(alarmList[i] == id) {
			return false;
		}
	}
	return true;
}

function deleteAlarmSwitch(node) {
	
	for(var i = 0, length = alarmList.length; i < length; ++i) {
		if(node[0].id == alarmList[i]) {
			if(i == 0 || i == length - 1) {
				alarmList[i] = [];
			} else {
				for(var j = i; j < length - 1; j++) {
					alarmList[j] = alarmList[j + 1];
				}
				alarmList[j] = [];
			}
			
			alert("设备已响应：现为合闸状态");
			update(node, 0);
			$('audio').remove();
		}
	}
}


