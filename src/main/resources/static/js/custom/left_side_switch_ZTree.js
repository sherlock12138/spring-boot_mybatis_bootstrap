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
