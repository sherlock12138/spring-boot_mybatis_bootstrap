/**
 * 
 */
dwr.engine.setActiveReverseAjax(true);
//设置在页面关闭时，通知服务端销毁会话
dwr.engine.setNotifyServerOnPageUnload(true);

var oldList = [];
var newList = [];
var alarmList = [];
var distinctList = [];

function showHitchEvent(data) {
	console.log(data);
	var data = eval(data);
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	for (var i = data.length - 1; i >= 0; --i) {
		if(isDistinct(data[i].id, distinctList)) {	//防止重复数据
			distinctList.push(data[i].id);	
			console.log(data[i].id);
			if(data[i].id != null) {
				var nodeList = zTree.getNodesByParamFuzzy("id", data[i].id);
				
				if(nodeList.length != 0) {
					if(data[i].status == "00") {
						
						switchs_draw(nodeList[0], open_switch, click_high_voltage_switch);	//开闸描绘
						if(data[i].open == true) {
							if(isDistinct(nodeList[0].id, alarmList)) {
								alarmList.push(nodeList[0].id);	//status与open同时符合才报警
								//alert("警告，已经跳闸！");
								update(nodeList, 2);  // 树节点变红
								worning_switchs_draw(nodeList[0]); //声音的 图标的
							}
						}
					} else {
						deleteAlarmSwitch(nodeList);
						newList.push(data[i].id);
					}
				}
			}
		}
	}

	for(var i = newList.length - 1; i >= 0; --i) {
		for(var j = oldList.length - 1; j >= 0; --j) {
			if(newList[i] == oldList[j]) {
				oldList[j] = "";
				break;
			}
		}
		if(j < 0 && zTree.getNodesByParamFuzzy("id", newList[i]).length != 0) {
			switchs_draw(zTree.getNodesByParamFuzzy("id", newList[i])[0], close_switch, click_high_voltage_switch);
		}
	}

	for(var i = oldList.length - 1; i >= 0; --i) {
		if(oldList[i] != "") {
			switchs_draw(zTree.getNodesByParamFuzzy("id", oldList[i])[0], outLine_switch, click_high_voltage_switch);
		}
	}

	oldList = newList;
	//清空数据
	newList = [];
	distinctList = [];
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

		  map.removeOverlay(new BMap.Marker(new BMap.Point(node[0].longitude, node[0].latitude), {
			   icon : new BMap.Icon(worning_switch, new BMap.Size(80, 80))}));
		}
	}
}

function isDistinct(id, list) {
	for(var i = list.length - 1; i >= 0; --i) {
		if(distinctList[i] == id) {
			return false;
		}
	}
	return true;
}
/*var alarmList = [];
function showHitchEvent(data) {
	console.log('data:' + data);
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
}*/


