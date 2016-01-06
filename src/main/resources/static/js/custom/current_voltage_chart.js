var currents;
var voltages;

$(document).ready(function() {

//	initail_current_chart();
//	initail_voltage_chart();
//	initail_power_chart();

	loadSubstationSet();
	initail_datetimepicker();

	$("#search_btn").click(search_chart);


	/*
		侧栏树
	*/
	// 初始化ZTree
	$.fn.zTree.init($("#treeDemo"), set_tree(0));// 0表示默认显示低压的数据

	// 添加搜索栏监听
	$("#searchNode").click(function() {

		zTreeSearch($("#search_node_key").val());
	});

	// 切换ZTree显示的开关种类
	$("#zTree_node_type_side").change(function() {

		$.fn.zTree.getZTreeObj("treeDemo").destroy();
		$.fn.zTree.init($("#treeDemo"), set_tree(this.value));
	});

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
		// callback : {
		// 	onAsyncSuccess : zTreeOnAsyncSuccess,// 添加动态加载成功回调函数
		// 	onClick : zTreeOnClick,// 添加节点点击事件回调函数
		// },
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



// 切换ZTree显示的开关种类
$("#zTree_node_type").click(
		function() {

			// $.fn.zTree.getZTreeObj("treeDemo").destroy();
			// $.fn.zTree.init($("#treeDemo"), set_tree(this.value));
			var url = "";
			switch (this.value) {
			case '0':
				url = "switch_list_by_line_id";
				break;
			case '1':
				url = "high_voltage_switch_list_by_line_id";
				break;
			case '2':
				url = "control_measure_switch_list_by_line_id";
				break;
			}

			$.ajax({
				type : "post",
				url : url,
				async : false,
				data : {
					"lineId" : $("#lines").val()
				},
				success : function(data) {

					data = data.data;
					var options = "";
					for (var i = 0; i < data.length; i++) {

						options += "<option value='" + data[i].id + "'>"
								+ data[i].name + "</option>";
					}
					$("#switchs").empty();
					$("#switchs").append(options);
				}
			})

		})

// 按照开关找记录
$("#switchs").click(search_chart);

// function updateChart(id, data) {
//
// $("#" + id).parent().css("width", data.A.length * 80 + "px");
// $("#" + id).css("width", data.A.length * 160);
// $("#" + id).css("height", 400);
// // $("#" + id).datasets[0] = data.A;
// // $("#" + id).datasets[1] = data.B;
// // $("#" + id).datasets[2] = data.C;
//
// var ctx = $("#" + id).get(0).getContext("2d");
//
// // ctx.canvas.datasets[0] = data.A;
// // ctx.canvas.datasets[1] = data.B;
// // ctx.canvas.datasets[2] = data.C;
//	
//	
// new Chart(ctx).Line(load(data), {
// responsive : true,
//
// });
//	
//	
//	
//	
// // $("#" + id).update();
// console.log(data.A.length)
// }

/**
 * 
 * @Title: search_chart
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function search_chart() {

	$.ajax({
		type : "post",
		url : "select_chart_by_switch_id",
		async : false,
		data : {
			"type" : $("#zTree_node_type").val(),
			"date" : $("#search_date").val(),
			"switchId" : $("#switchs").val()
		},
		success : function(data) {
			
			//不同的设备有不同 的精确度
			var vol_precision = 0;
			var cur_precision = 0;

			switch ($("#zTree_node_type").val()) {

			case '0':
				vol_precision = 10;
				cur_precision = 100;
			case '1':
				vol_precision = 100;
				cur_precision = 100;
			case '2':
				vol_precision = 100;
				cur_precision = 100;
			}

			creat("current_chart", data.current, cur_precision);
			creat("voltage_chart", data.voltage, vol_precision);
			creat("power_chart", calculate_power(data.current, data.voltage),
					cur_precision * vol_precision);
		}
	})
}

/**
 * 
 * @Title: initail_datetimepicker
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function initail_datetimepicker() {

	$('.form_date').datetimepicker({
		language : 'zh-CN',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0,
	});
}

/**
 * 
 * @Title: initail_power_chart
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function initail_power_chart() {
	creat("power_chart", calculate_power(currents, voltages));
}

/**
 * 
 * @Title: initail_voltage_chart
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function initail_voltage_chart() {

	$.ajax({
		type : "post",
		url : "voltage_chart",
		async : false,
		data : {
			"switchId" : "03"
		},
		success : function(data) {

			for (var i = 0; i < data.A.length; i++) {

				data.A[i].value = data.A[i].value / 100;
				data.B[i].value = data.B[i].value / 100;
				data.C[i].value = data.C[i].value / 100;
			}
			voltages = data;
			creat("voltage_chart", voltages);

		}

	})
}
/**
 * 
 * @Title: initail_current_chart
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function initail_current_chart() {
	/**
	 * 电流曲线
	 */
	$.ajax({
		type : "post",
		url : "current_chart",
		async : false,
		data : {
			"switchId" : "03"
		},
		success : function(data) {

			for (var i = 0; i < data.A.length; i++) {

				data.A[i].value = data.A[i].value / 100;
				data.B[i].value = data.B[i].value / 100;
				data.C[i].value = data.C[i].value / 100;
			}
			currents = data;
			creat("current_chart", currents);
		}
	})
}

/**
 * 
 * @Title: calculate_power
 * @Description: TODO
 * @param
 * @param currents
 * @param
 * @param voltages
 * @param
 * @returns
 * @return any
 * @throws
 */
function calculate_power(currents, voltages) {

	var len;
	if (voltages.A.length <= currents.A.length) {
		len = voltages.A.length;
	} else {
		len = currents.A.length;
	}

	for (var i = 0; i < len; i++) {

		if (voltages.A[i] != null && currents.A[i] != null) {
			voltages.A[i].value = voltages.A[i].value * currents.A[i].value;
		}

		if (voltages.B[i] != null && currents.B[i] != null) {
			voltages.B[i].value = voltages.B[i].value * currents.B[i].value;
		}

		if (voltages.C[i] != null && currents.C[i] != null) {
			voltages.C[i].value = voltages.C[i].value * currents.C[i].value;
		}
	}
	return voltages;
}

/**
 * 
 * @Title: creat
 * @Description: TODO
 * @param
 * @param id
 * @param
 * @param data
 * @return void
 * @throws
 */
function creat(id, data, precision) {

	$("#" + id).remove(); // this is my <canvas> element
	$("#parent_" + id).append('<canvas id="' + id + '" height="400"></canvas>');

	var height = parseInt($("#parent_" + id).css('height')) - 10;
	height = height - (height % 5);

	$("#" + id).parent().css("width", data.A.length * height / 5 + "px");
	$("#" + id).css("width", data.A.length * height / 5);
	$("#" + id).css("height", height);

	var ctx = $("#" + id).get(0).getContext("2d");
	new Chart(ctx).Line(load(data, precision), {
		responsive : true,
	});
}

/**
 * 
 * @Title: load
 * @Description: TODO
 * @param
 * @returns
 * @return any
 * @throws
 */
function load(data, precision) {

	var chart = lineChart();
	for (var i = 0; i < data.A.length; i++) {

		chart.labels[i] = getFormatDateByLong(data.A[i].time, "MM-dd hh:mm");

		if (data.A[i] != null && precision != 0) {
			chart.datasets[0].data[i] = data.A[i].value / precision;
		}
		if (data.B[i] != null && precision != 0) {

			chart.datasets[1].data[i] = data.B[i].value / precision;
		}

		if (data.C[i] != null && precision != 0) {
			chart.datasets[2].data[i] = data.C[i].value / precision;
		}

	}
	return chart;
}

/**
 * 
 * @Title: lineChart
 * @Description: TODO
 * @param
 * @returns {___anonymous3850_4667}
 * @return ___anonymous3850_4667
 * @throws
 */
function lineChart() {
	var lineChart = {
		labels : [],
		datasets : [ {
			scaleLabel : "My First dataset",
			fillColor : "rgba(220,220,220,0.2)",
			strokeColor : "#7EBBF9",
			pointColor : "#7EBBF9",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "#7EBBF9",
			data : []
		}, {
			scaleLabel : "My First dataset",
			fillColor : "rgba(220,220,220,0.2)",
			strokeColor : "#2975B5",
			pointColor : "#2975B5",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "#2975B5",
			data : []
		}, {
			scaleLabel : "My First dataset",
			fillColor : "rgba(220,220,220,0.2)",
			strokeColor : "#A572AA",
			pointColor : "#A572AA",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "#A572AA",
			data : []
		}, ],
	// scaleGridLineWidth : 600,
	// datasetStrokeWidth : 6,
	// scaleFontSize : 12,

	// scaleStepWidth : 20,

	}
	return lineChart;
}