$(document).ready(function() {

	// 初始化ZTree
	$.fn.zTree.init($("#treeDemo"), set_tree(0));// 0表示默认显示低压的数据

	// 添加搜索栏监听
	$("#searchNode").click(function() {

		zTreeSearch($("#search_node_key").val());
	});

	// 切换ZTree显示的开关种类
	$("#zTree_node_type").change(function() {

		$.fn.zTree.getZTreeObj("treeDemo").destroy();
		$.fn.zTree.init($("#treeDemo"), set_tree(this.value));
	})

	// // 添加跳闸事件监听
	// hitchEventSpy();

});

/**
 * 
 * @Title: 设置ZTree属性
 * @Description: TODO
 * @param
 * @returns {___anonymous258_608}
 * @return ___anonymous258_608
 * @throws
 */
function set_tree(zTreeNodeType) {

	var setting = {
		async : {
			enable : true,
			url : "switch_tree",// 数据源
			autoParam : [ "id", "name=n", "level=lv" ],
			otherParam : {
				"type" : zTreeNodeType,// 0低压 1高压 2管测
			},
			dataFilter : data_filter,// 添加节点名称过滤器
		},
		callback : {
			onAsyncSuccess : zTreeOnAsyncSuccess,// 添加动态加载成功回调函数
			onClick : zTreeOnClick,// 添加节点点击事件回调函数
		},
		view : {
			showLine : false,
			fontCss : getFontCss
		}
	};
	return setting;
}

/**
 * 
 * @Title: 节点名称过滤
 * @Description: TODO
 * @param
 * @param treeId
 * @param
 * @param parentNode
 * @param
 * @param childNodes
 * @param
 * @returns
 * @return any
 * @throws
 */
function data_filter(treeId, parentNode, childNodes) {
	if (!childNodes)
		return null;
	for (var i = 0, l = childNodes.length; i < l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}

/**
 * 
 * @Title: 选择过滤器
 * @Description: 第二层的子节点
 * @param
 * @param node
 * @param
 * @returns {Boolean}
 * @return Boolean
 * @throws
 */
function switch_filter(node) {
	return (node.level == 2);
}

/**
 * 
 * @Title: 搜索ZTree节点
 * @Description: TODO
 * @param
 * @param value
 * @return void
 * @throws
 */
var last_value;// 存储上一个搜索的关键字
function zTreeSearch(value) {

	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var nodeList;
	if (last_value != null) {

		nodeList = zTree.getNodesByParamFuzzy("name", last_value);
		update(nodeList, false);// 重置状态
	}
	last_value = value;

	nodeList = zTree.getNodesByParamFuzzy("name", value);
	update(nodeList, true);
}

/**
 * 
 * @Title: 搜索节点，高亮显示节点
 * @Description: TODO
 * @param
 * @param nodes
 * @param
 * @param highlight
 * @return void
 * @throws
 */
function update(nodes, highlight) {

	var zTree = $.fn.zTree.getZTreeObj("treeDemo");

	for (var i = 0, l = nodes.length; i < l; i++) {

		nodes[i].highlight = highlight;
		zTree.updateNode(nodes[i]);// 调用库函数，高亮显示
	}
}

/**
 * 
 * @Title: getFontCss
 * @Description: TODO
 * @param
 * @param treeId
 * @param
 * @param treeNode
 * @param
 * @returns
 * @return any
 * @throws
 */
function getFontCss(treeId, treeNode) {

	return (!!treeNode.highlight) ? {
		color : "#5C297F",
		"font-weight" : "bold"
	} : {
		color : "#999999",
		"font-weight" : "bold"
	};
}

/**
 * 
 * @Title: zTree节点重定位
 * @Description: TODO
 * @param
 * @param event
 * @param
 * @param treeId
 * @param
 * @param treeNode
 * @return void
 * @throws
 */
function zTreeOnClick(event, treeId, treeNode) {

	map.panTo(new BMap.Point(treeNode.longitude, treeNode.latitude));
};

var map = new BMap.Map("baidu_map"); // 创建地图实例
var nodes;// 所有的节点
/**
 * 
 * @Title: zTreeOnAsyncSuccess
 * @Description: ZTree成功渲染之后的回调函数，描绘定点
 * @param
 * @param event
 * @param
 * @param treeId
 * @param
 * @param treeNode
 * @param
 * @param msg
 * @return void
 * @throws
 */
function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {

	// var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	// nodes = treeObj.getNodesByFilter(switch_filter); // 用选择过滤器查找节点集合
	var low_voltage_nodes = getAllLowVoltageSwitch();

	var point;
	var longitude = localStorage.getItem('longitude');
	var latitude = localStorage.getItem('latitude');

	if (longitude != null && latitude != null) {
		// 从localStorage中取值定位
		point = new BMap.Point(longitude, latitude);
	} else {
		// 否则用原始数据第一个定位
		point = new BMap.Point(low_voltage_nodes[0].longitude,
				low_voltage_nodes[0].latitude); // 创建点坐标
	}

	map.centerAndZoom(point, 13); // 初始化地图，设置中心点坐标和地图级别
	map.enableScrollWheelZoom();// 启滑轮缩放

	// *************************************************************
	// 遍历描绘定点
	// *************************************************************

	var low_voltage_switch_icon = "../../ico/low_voltage_switch.jpg";// 低压开关的图标
	var high_voltage_switch_icon = "../../ico/high_voltage_switch.jpg";// 低压开关的图标
	var control_measure_switch_icon = "../../ico/control_measure_switch.jpg";// 低压开关的图标

	forDrawPoint(low_voltage_nodes, low_voltage_switch_icon,// 描绘低压开关
	click_low_voltage_switch);

	forDrawPoint(getAllHighVoltageSwitch(), high_voltage_switch_icon,// 描绘高压开关
	click_low_voltage_switch);

	forDrawPoint(getAllControlMeasureSwitch(), control_measure_switch_icon,// 描绘管测开关
	click_low_voltage_switch);

}

/**
 * 
 * @Title: getAllLowVoltageSwitch
 * @Description: TODO
 * @param
 * @returns
 * @return any
 * @throws
 */
function getAllLowVoltageSwitch() {

	var nodes;
	$.ajax({
		type : "post",
		url : "get_all_low_voltage_switch",
		async : false,
		data : {},
		success : function(data) {

			nodes = data;// 设置开关类型
			for (var i = 0; i < nodes.length; i++) {
				nodes[i].type = 0;
			}
		}
	})
	return nodes;
}

/**
 * 
 * @Title: getAllHighVoltageSwitch
 * @Description: TODO
 * @param
 * @returns
 * @return any
 * @throws
 */
function getAllHighVoltageSwitch() {

	var nodes;
	$.ajax({
		type : "post",
		url : "get_all_high_voltage_switch",
		async : false,
		data : {},
		success : function(data) {

			nodes = data;
			for (var i = 0; i < nodes.length; i++) {
				nodes[i].type = 1;
			}
		}
	})
	return nodes;
}

/**
 * 
 * @Title: getAllControlMeasureSwitch
 * @Description: TODO
 * @param
 * @returns
 * @return any
 * @throws
 */
function getAllControlMeasureSwitch() {

	var nodes;
	$.ajax({
		type : "post",
		url : "get_all_control_measure_switch",
		async : false,
		data : {},
		success : function(data) {

			nodes = data;
			for (var i = 0; i < nodes.length; i++) {
				nodes[i].type = 2;
			}
		}
	})
	return nodes;
}

/**
 * 
 * @Title: 遍历描绘定点
 * @Description: TODO
 * @param
 * @param nodes
 * @param
 * @param switch_icon
 * @param
 * @param click_function
 * @return void
 * @throws
 */
function forDrawPoint(nodes, switch_icon, click_function) {

	for (var i = 0; i < nodes.length; i++) {

		switchs_draw(nodes[i], switch_icon, click_function);
	}
}

/**
 * 
 * @Title: 描绘定点
 * @Description: TODO
 * @param
 * @param map
 * @param
 * @param node
 * @return void
 * @throws
 */
function switchs_draw(node, switch_icon, click_switch) {

	// var marker = new BMap.Marker(new BMap.Point(116.404, 39.915)); //创建点
	// map.addOverlay(marker); // 增加点

	// 创建标注
	var pt = new BMap.Point(node.longitude, node.latitude);
	var myIcon = new BMap.Icon(switch_icon, new BMap.Size(20, 20));
	var marker2 = new BMap.Marker(pt, {
		icon : myIcon
	}); // 创建标注
	// ****************************************************************
	marker2.id = node.id;// 设置id
	marker2.type = node.type;
	// mraker2.isWorning = false;//设置报警标志
	// ****************************************************************
	map.addOverlay(marker2); // 将标注添加到地图中

	// 添加文字提示
	var label = new BMap.Label(node.name, {
		offset : new BMap.Size(20, -18)
	});
	marker2.setLabel(label);

	// **************************************************************************
	// 添加图标点击事件,弹出窗口
	marker2.addEventListener("click", click_switch);
	// **************************************************************************

}

/**
 * 
 * @Title: click_low_voltage_switch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
var old_icon = "";
function click_low_voltage_switch() {

	// zTree.reAsyncChildNodes(null, "refresh");

	// var p = this.getPosition();
	// alert(this.id)
	var content = "<h4>开关控制</h4>" + "<div class='container offset2'>"
			+ "<div class='row'>" + "<div class='span2'>"
			+ "<ul class='inline'>" + "<li>A相电压:</li>"
			+ "<li id='a_phase_voltage' class='value_block'></li>" + "</ul>"
			+ "<ul class='inline'>" + "<li>B相电压:</li>"
			+ "<li id='b_phase_voltage' class='value_block'></li>" + "</ul>"
			+ "<ul class='inline'>" + "<li>C相电压:</li>"
			+ "<li id='c_phase_voltage' class='value_block'></li>" + "</ul>"
			+ "</div>" + "<div class='span2'>" + "<ul class='inline'>"
			+ "<li>A相电流:</li>"
			+ "<li id='a_phase_current' class='value_block'></li>" + "</ul>"
			+ "<ul class='inline'>" + "<li>B相电流:</li>"
			+ "<li id='b_phase_current' class='value_block'></li>" + "</ul>"
			+ "<ul class='inline'>" + "<li>C相电流:</li>"
			+ "<li id='c_phase_current' class='value_block'></li>" + "</ul>"
			+ "</div>" + "</div>" + "<br/><div class='span4'>"
			+ "<a id='close_switch_btn'" + "class='btn btn-primary'>合闸</a> <a"
			+ "id='open_switch_btn' class='btn btn-primary'" + ">分闸</a>"
			+ "</div>";

	// + "<div class='row'>"
	// + "<div class='span4 text-center'>"
	// + "<select id='cancel_control_type'>"
	// + "<option value='1'>取消预约跳闸</option>"
	// + "<option value='3'>取消预约合闸</option>"
	// + "<option value='5'>取消测试预约跳闸</option>"
	// + "</select> <a id='cancel_control_switch_btn' class='btn btn-primary'
	// onclick='cancelControlSwitch()'>确定</a>"
	// + "</div>" + "</div>" + "</div>";

	var opts = {
		width : 415, // 信息窗口宽度
		height : 180, // 信息窗口高度
	}
	// var currentInfoWindow = new InfoWindow(getMarkInfoView(marker), latLng,
	// -47);

	var infoWindow = new BMap.InfoWindow(content, opts); // 创建信息窗口对象
	this.openInfoWindow(infoWindow);

	// 窗口打开读取实时数据,switch_detail.js 中定义
	// ********************************************************************
	if (old_icon != "") {

		this.setIcon(old_icon);// 打开窗口就代表去处理了报警
	}
	// 还没有提报警处理的需求 ==！
	// ********************************************************************

	// 绑定控制监听
	$("#open_switch_btn").click(function() {

		openSwitch(this.id, this.type);
	})

	$("#close_switch_btn").click(function() {

		closeSwitch(this.id, this.type);
	})

	// ********************************************************************
	readCurrentVoltage(this.id, this.type);// 读取实时数据。。
	// ********************************************************************

	// 添加窗口关闭监听，停止读取实时数据
	infoWindow.addEventListener("close", function() {
		clearTimeout(t);
	});

}



/**
 * 
 * @Title: hitchEventSpy
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
var worning_switch = "../../ico/worning_switch.jpg";// 报警状态的图标
function hitchEventSpy() {

	$.ajax({
		type : "post",
		url : "read_hitch_event",
		async : false,
		data : {},
		success : function(data) {

			for (var i = 0; i < data.length; i++) {
				for (var j = 0; j < nodes.length; j++) {

					if (data[i].id == nodes[j].id) {
						worning_switchs_draw(nodes[j]);
					}
				}
			}
		}

	})
	h = setTimeout("hitchEventSpy()", 5 * 60 * 1000);
}

/**
 * 
 * @Title: worning_switchs_draw
 * @Description: TODO
 * @param
 * @param node
 * @return void
 * @throws
 */
function worning_switchs_draw(node) {

	// var marker = new BMap.Marker(new BMap.Point(116.404,
	// 39.915)); //创建点
	// map.addOverlay(marker); // 增加点
	old_icon = myIcon;// 保存原来的icon
	// 创建标注
	var pt = new BMap.Point(node.longitude, node.latitude);
	var myIcon = new BMap.Icon(worning_switch, new BMap.Size(20, 20));
	var marker2 = new BMap.Marker(pt, {
		icon : myIcon
	}); // 创建标注
	map.addOverlay(marker2); // 将标注添加到地图中,覆盖原有的图标

	// 不用添加文字提示
	// 需要重复添加点击事件
	marker2.addEventListener("click", click_switch);

	$("body")
			.append(
					"<audio src='../../audio/wornning.wav' autoplay='true' loop='true'></audio>");

}

// //**************************************************************************
// //添加自定义控件
// //**************************************************************************
// //定义一个控件类,即function
// function ZoomControl() {
// // 默认停靠位置和偏移量
// this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
// this.defaultOffset = new BMap.Size(10, 10);
// }
//
// //通过JavaScript的prototype属性继承于BMap.Control
// ZoomControl.prototype = new BMap.Control();
//
// //自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
// //在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
// ZoomControl.prototype.initialize = function(map) {
// // 创建一个DOM元素
// var div = document.createElement("div");
// // 添加文字说明
// div.appendChild(document.createTextNode("添加连线"));
// // div.appendChild(document.createTextNode("编辑连线"));
// // div.appendChild(document.createTextNode("保存连线"));
// // 设置样式
// div.style.cursor = "pointer";
// div.style.border = "1px solid gray";
// div.style.backgroundColor = "white";
// // 绑定事件
// div.onclick = function(e) {
//
// var polyline = new BMap.Polyline([ new BMap.Point(116.500, 39.910),
// new BMap.Point(116.405, 39.900) ], {
// strokeColor : "blue",
// strokeWeight : 4,
// strokeOpacity : 0.5
// }); // 创建折线
//
// map.addOverlay(polyline);// 增加折线
// polyline.enableEditing();// 开启可编辑
// }
// // 添加DOM元素到地图中
// map.getContainer().appendChild(div);
// // 将DOM元素返回
// return div;
// }
// //创建控件
// var myZoomCtrl = new ZoomControl();
// //添加到地图当中
// map.addControl(myZoomCtrl);

