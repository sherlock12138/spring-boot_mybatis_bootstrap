var currents;
var voltages;

$(document).ready(function() {

	initail_datetimepicker();

	//$("#search_btn").click(search_chart_by_switch_id);//右侧搜索按钮


});
function zTreeOnClick(event, treeId, treeNode) {
	<!-- 当点击Ztree默认先初始化电压曲线 -->
	var node = treeNode;
	show_chart(treeNode, 1, 'VoltageChart');
	$("#search_btn").click(function () {
		show_chart(node, 1, 'VoltageChart');
	});
	$('#showVchart').click(function () {
		show_chart(node, 1, 'VoltageChart');
		$("#search_btn").unbind().click(function () {
			show_chart(node, 1, 'VoltageChart');
		});
	});
	$('#showCchart').click(function () {
		show_chart(node, 0, 'current');
		$("#search_btn").unbind().click(function () {
			show_chart(node, 0, 'current');
		});
	});
	$("#showPchart").click(function () {
		show_chart(node, 2);
		$("#search_btn").unbind().click(function () {
			show_chart(node, 2);
		});
	});
	$('#showVExcal').click(function () {
		show_table(node, 1);
		$("#search_btn").unbind().click(function () {
			show_table(node, 1);
		});
	})
	//点击事件
	//search_chart_switch_id = treeNode.id;
	//search_chart_by_switch_id();
}

/** 用于tabpanel切换标签页时加载不同的图表
/** param： 树的点击节点
/** param： 图表类型，1电压，0电流，2功率
/** param： 对应实例化图表的ID
/**
*/
////dongjun/select_table_by_id?switchId=&type=&cov=&beginDate=&endDate=
function show_chart(treeNode, num, Chartname) {
	var option;
	var id = treeNode.id;
	var type = treeNode.type;
	var begin_time = $('#begin_search_date').val();
	var end_time = $('#end_search_date').val();
	//创建折线图
	var myChart = echarts.init(document.getElementById(Chartname));
	$.ajax({
		url: '/dongjun/select_chart_by_switch_id',
		method: 'POST',
		data : {
			switchId: id,
			type: type,
			beginDate: begin_time,
			endDate: end_time,
			cov: num
		}
	}).success(function (data) {
		option = data;
		myChart.setOption(option);
		myChart.showLoading();
		setTimeout(function () {
			myChart.hideLoading();
		}, 2000);
	})
}

function show_table (node, num) {
	var begin_time = $('#begin_search_date').val();
	var end_time = $('#end_search_date').val();
	$('#data_list').DataTable( {
		destroy: true,// destroy之后才能重新加载
		"ordering": false,
		"info":     false,
		"ajax" : {
			url: '/dongjun/select_table_by_id',
			method: 'post',
			data: {
				switchId: node.id,
				type: node.type,
				cov: num,
				beginDate: begin_time,
				endDate: end_time
			}
		},
		"columns" : [ {
			"data" : "time"
		}, {
			"data" : "aValue"
		}, {
			"data" : "bValue"
		}, {
			"data" : "cValue"
		}]
//		"columns": [
//			{ "data": "time" },
//			{ 	"data": "id"
//				},
//			{ 	"data": "companyId"
//				},
////			{ "data": null},// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
////			{ "data": null }// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
//		],
		// 为下面的列设置默认值
//		"columnDefs": [ {
//			"targets": -2,
//			"data": null,
//			"defaultContent": '<a href="#edit_switch_modal" role="button" class="edit_switch_btn btn" data-toggle="modal">修改 &raquo;</a>'
//		},
//			{
//				"targets": -1,
//				"data": null,
//				"defaultContent": '<a href="#del_switch_modal" class="del_switch_btn btn btn-danger" data-toggle="modal" data-backdrop="static">删除&raquo; </a>'
//			}],
//		"fnInitComplete": function(oSettings, json) {
//
//			$(".edit_switch_btn").click(editSwitch);
//			$(".del_switch_btn").click(delSwitch);
//		}
	} );

//	$('#data_list').DataTable({
//		"destroy" : true,// destroy之后才能重新加载
//		"ajax" : {
//			url: '/dongjun/select_table_by_id',
//			method: 'post',
//			data: {
//				switchId: node.id,
//				type: node.type,
//				cov: num,
//				beginDate: begin_time,
//				endDate: end_time
//			}
//		},
//		"columns" : [ {
//			"data" : "time"
//		}, {
//			"data" : "aValue"
//		}, {
//			"data" : "bValue"
//		}, {
//			"data" : "cValue"
//		}]
//	})
}

function search_chart_by_switch_id(){

	$.ajax({
		type : "post",
		url : "select_chart_by_switch_id",
		async : false,
		data : {
			"type" : $("#zTree_node_type").val(),
			"beginDate" : $("#begin_search_date").val(),
			"endDate" : $("#end_search_date").val(),
			"switchId" : search_chart_switch_id
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

