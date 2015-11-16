$(document).ready(function() {

	$.fn.zTree.init($("#treeDemo"), set_tree());

	$("#searchNode").click(function() {

		zTreeSearch($("#search_node_key").val());
	});

});

/**
 * 
 * @Title: set_tree
 * @Description: TODO
 * @param
 * @returns {___anonymous138_474}
 * @return ___anonymous138_474
 * @throws
 */
function set_tree() {

	var setting = {
		async : {
			enable : true,
			url : "switch_tree",
			autoParam : [ "id", "name=n", "level=lv" ],
			otherParam : {
				"companyId" : "001"
			},
			dataFilter : data_filter
		},
		callback : {
			onAsyncSuccess : zTreeOnAsyncSuccess,
			onClick : zTreeOnClick
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
 * @Title: filter
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
 * @Title: switch_filter
 * @Description: TODO
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
 * @Title: zTreeOnAsyncSuccess
 * @Description: ZTree成功渲染之后的回调函数
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
var map = new BMap.Map("baidu_map"); // 创建地图实例
var switch_icon = "../../ico/switch.jpg";
var nodes;

function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {

	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	nodes = treeObj.getNodesByFilter(switch_filter); // 查找节点集合

	var point;
	var longitude = localStorage.getItem('longitude');
	var latitude = localStorage.getItem('latitude');
	if (longitude != null && latitude != null) {
		point = new BMap.Point(longitude, latitude);
	} else {
		point = new BMap.Point(nodes[0].longitude, nodes[0].latitude); // 创建点坐标
	}

	map.centerAndZoom(point, 13); // 初始化地图，设置中心点坐标和地图级别
	map.enableScrollWheelZoom();// 启滑轮

	for (var i = 0; i < nodes.length; i++) {

		//*************************************************************
		// 描绘自定义点
		//*************************************************************
		switchs_draw(nodes[i]);
	}

	// 添加跳闸事件监听
	hitchEventSpy();

}

/**
 * 
 * @Title: zTreeOnClick
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

/**
 * 
 * @Title: zTreeSearch
 * @Description: TODO
 * @param
 * @param value
 * @return void
 * @throws
 */
function zTreeSearch(value) {

	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var nodeList = zTree.getNodes();

	if (nodeList.children != null) {

		zTreeSearch(nodeList.children);
	}

	alert(nodeList.length)
	updateNodes(nodeList, false);// 重置状态

	nodeList = zTree.getNodesByParamFuzzy("name", value);
	updateNodes(nodeList, true);
}

/**
 * 
 * @Title: updateNodes
 * @Description: TODO
 * @param
 * @param nodes
 * @param
 * @param highlight
 * @return void
 * @throws
 */
function updateNodes(nodes, highlight) {

	var zTree = $.fn.zTree.getZTreeObj("treeDemo");

	for (var i = 0, l = nodes.length; i < l; i++) {

		nodes[i].highlight = highlight;
		zTree.updateNode(nodes[i]);
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
		color : "#A60000",
		"font-weight" : "bold"
	} : {
		color : "#36A6F0",
		"font-weight" : "normal"
	};
}

/**
 * 
 * @Title: switchs_draw
 * @Description: TODO
 * @param
 * @param map
 * @param
 * @param node
 * @return void
 * @throws
 */
function switchs_draw(node) {

	// var marker = new BMap.Marker(new BMap.Point(116.404, 39.915)); //创建点
	// map.addOverlay(marker); // 增加点

	// 创建标注
	var pt = new BMap.Point(node.longitude, node.latitude);
	var myIcon = new BMap.Icon(switch_icon, new BMap.Size(20, 20));
	var marker2 = new BMap.Marker(pt, {
		icon : myIcon
	}); // 创建标注
	map.addOverlay(marker2); // 将标注添加到地图中

	// 添加文字提示
	var label = new BMap.Label(node.name, {
		offset : new BMap.Size(20, -18)
	});
	marker2.setLabel(label);

	// 添加点击事件
	marker2.addEventListener("click", click_switch);

	// **************************************************************************
	// 添加自定义控件
	// **************************************************************************
	// 定义一个控件类,即function
	function ZoomControl() {
		// 默认停靠位置和偏移量
		this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
		this.defaultOffset = new BMap.Size(10, 10);
	}

	// 通过JavaScript的prototype属性继承于BMap.Control
	ZoomControl.prototype = new BMap.Control();

	// 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
	// 在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
	ZoomControl.prototype.initialize = function(map) {
		// 创建一个DOM元素
		var div = document.createElement("div");
		// 添加文字说明
		div.appendChild(document.createTextNode("添加连线"));
		// div.appendChild(document.createTextNode("编辑连线"));
		// div.appendChild(document.createTextNode("保存连线"));
		// 设置样式
		div.style.cursor = "pointer";
		div.style.border = "1px solid gray";
		div.style.backgroundColor = "white";
		// 绑定事件
		div.onclick = function(e) {

			var polyline = new BMap.Polyline([ new BMap.Point(116.500, 39.910),
					new BMap.Point(116.405, 39.900) ], {
				strokeColor : "blue",
				strokeWeight : 4,
				strokeOpacity : 0.5
			}); // 创建折线

			map.addOverlay(polyline);// 增加折线
			polyline.enableEditing();// 开启可编辑
		}
		// 添加DOM元素到地图中
		map.getContainer().appendChild(div);
		// 将DOM元素返回
		return div;
	}
	// 创建控件
	var myZoomCtrl = new ZoomControl();
	// 添加到地图当中
	map.addControl(myZoomCtrl);

}

/**
 * 
 * @Title: click_switch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function click_switch() {

	var content = "<h4>开关控制</h4>"
			+ "<div class='container offset2'>"
			+ "<div class='row'>"
			+ "<div class='span2'>"
			+ "<ul class='inline'>"
			+ "<li>A相电压:</li>"
			+ "<li id='a_phase_voltage' class='value_block'></li>"
			+ "</ul>"
			+ "<ul class='inline'>"
			+ "<li>B相电压:</li>"
			+ "<li id='b_phase_voltage' class='value_block'></li>"
			+ "</ul>"
			+ "<ul class='inline'>"
			+ "<li>C相电压:</li>"
			+ "<li id='c_phase_voltage' class='value_block'></li>"
			+ "</ul>"
			+ "</div>"
			+ "<div class='span2'>"
			+ "<ul class='inline'>"
			+ "<li>A相电流:</li>"
			+ "<li id='a_phase_current' class='value_block'></li>"
			+ "</ul>"
			+ "<ul class='inline'>"
			+ "<li>B相电流:</li>"
			+ "<li id='b_phase_current' class='value_block'></li>"
			+ "</ul>"
			+ "<ul class='inline'>"
			+ "<li>C相电流:</li>"
			+ "<li id='c_phase_current' class='value_block'></li>"
			+ "</ul>"
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='span4 text-center'>"
			+ "<select id='control_type' class='span5'>"
			+ "<option value='0'>预约跳闸</option>"
			+ "<option value='2'>预约合闸</option>"
			+ "<option value='4'>测试预约跳闸</option>"
			+ "</select> <input type='text' id='control_switch' class='span2'"
			+ "placeholder='0-99' /> <select id='control_switch_unit'"
			+ "class='span3'>"
			+ "<option value='02'>分钟</option>"
			+ "<option value='03'>小时</option>"
			+ "</select> <a id='control_switch_btn' class='btn btn-primary' onclick='controlSwitch()'>确定</a>"
			+ "</div>"
			+ "</div>"
			+ "<div class='row'>"
			+ "<div class='span4 text-center'>"
			+ "<select id='cancel_control_type'>"
			+ "<option value='1'>取消预约跳闸</option>"
			+ "<option value='3'>取消预约合闸</option>"
			+ "<option value='5'>取消测试预约跳闸</option>"
			+ "</select> <a id='cancel_control_switch_btn' class='btn btn-primary' onclick='cancelControlSwitch()'>确定</a>"
			+ "</div>" + "</div>" + "</div>";

	var opts = {
		width : 450, // 信息窗口宽度
		height : 210, // 信息窗口高度
	}
	// var currentInfoWindow = new InfoWindow(getMarkInfoView(marker), latLng,
	// -47);

	var infoWindow = new BMap.InfoWindow(content, opts); // 创建信息窗口对象
	this.openInfoWindow(infoWindow);
	// 窗口打开读取实时数据,switch_detail.js 中定义
	readCurrentVoltage();

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
var worning_switch = "../../ico/worning_switch.jpg";
function hitchEventSpy() {

	$.ajax({
		type : "post",
		url : "read_hitch_event",
		async : false,
		data : {},
		success : function(data) {

			for (var i = 0; i < data.length; i++) {

				for (var j = 0; j < nodes.length; j++) {
					if (nodes[j].id == data[i].id) {
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
