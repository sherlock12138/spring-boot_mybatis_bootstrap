var currents;
var voltages;

$(document).ready(function() {

	initail_current_chart();
	initail_voltage_chart();
	initail_power_chart();

	initail_datetimepicker();

	$("#search_btn").click(search_chart);
})

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
		url : "select_chart_by_date",
		async : false,
		data : {
			"date" : $("#search_date").val(),
			"switchId" : "03"
		},
		success : function(data) {
			creat("current_chart", data.current);
			creat("voltage_chart", data.voltage);

			creat("power_chart", calculate_power(data.current, data.voltage));
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
		forceParse : 0
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

				data.A[i].value = data.A[i].value /10;
				data.B[i].value = data.B[i].value /10;
				data.C[i].value = data.C[i].value /10;
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

				data.A[i].value = data.A[i].value /100;
				data.B[i].value = data.B[i].value /100;
				data.C[i].value = data.C[i].value /100;
			}
			currents = data;
			creat("current_chart", currents);
			// currents = data;
			// var chart1 = lineChart();
			// for (var i = 0; i < data.A.length; i++) {
			//
			// chart1.labels[i] = getFormatDateByLong(
			// data.A[i].time, "MM-dd hh:mm");
			// chart1.datasets[0].data[i] = data.A[i].value;
			// chart1.datasets[1].data[i] = data.B[i].value;
			// chart1.datasets[2].data[i] = data.C[i].value;
			//
			// }
			// var ctx = $("#current_chart").get(0).getContext(
			// "2d");
			// current_chart = new Chart(ctx).Line(chart1, {
			// responsive : true
			// });
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

		voltages.A[i].value = voltages.A[i].value * currents.A[i].value;
		voltages.B[i].value = voltages.B[i].value * currents.B[i].value;
		voltages.C[i].value = voltages.C[i].value * currents.C[i].value;
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
function creat(id, data) {

	var ctx = $("#" + id).get(0).getContext("2d");
	new Chart(ctx).Line(load(data), {
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
function load(data) {

	var chart = lineChart();
	for (var i = 0; i < data.A.length; i++) {

		chart.labels[i] = getFormatDateByLong(data.A[i].time, "MM-dd hh:mm");
		chart.datasets[0].data[i] = data.A[i].value;
		chart.datasets[1].data[i] = data.B[i].value;
		chart.datasets[2].data[i] = data.C[i].value;
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
		}, ]

	}
	return lineChart;
}