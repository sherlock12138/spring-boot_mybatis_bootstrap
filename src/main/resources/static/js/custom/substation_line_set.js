var default_id ;
var substationList = [];
var lineList = [];
var switchList = [];
function loadSubstationSet() {

	$.ajax({
		type : "post",
		url : "substation_list_by_company_id",
		method: 'post',
		//async : false,
		data : {},
		success : function(data) {

			if(data!=null){

				data = data.data;
				default_id = data[0].id;
				var options = "";
				substationList = [];
				for (var i = 0; i < data.length; i++) {
					substationList.push(data[i]);
					options += "<option value='" + data[i].id + "'>" + data[i].name
							+ "</option>";
				}
				Change_line(default_id);
				$(".substations").append(options);
				$(".substations").unbind().change(function(){  // 不知道为什么在低压事件的页面只能在这里添加监听函数
					Change_line(this.value);
					$('#searchType').val('变电站');
				});
				localStorage.setItem('defaultId', default_id);
			}
		}
	})

}

/**
 * 切换变电站时的监听
 */
$(".substations").unbind().change(function(){
	Change_line(this.value);
	$('#searchType').val('变电站');
});

//$(".lines").val('123')

function Change_line(lineId) {
	$.ajax({
		type : "post",
		url : "line_list_by_substation_id",
		async : false,
		data : {
			"substation_id":lineId
		},
		success : function(data) {

			data = data.data;
			var options = "";
			lineList = [];
			for (var i = 0; i < data.length; i++) {
				lineList.push(data[i]);
				options += "<option value='" + data[i].id + "'>" + data[i].name
					+ "</option>";
			}
			$(".lines").empty().append(options);

			$.ajax({
				type : "post",
				url : 'high_voltage_switch_list_by_line_id',
				async : false,
				data : {
					"lineId" : $(".lines").val()
				},
				success : function(data) {
					console.log($(".lines").val());
					data = data.data;
					var options = "";
					switchList = [];
					for (var i = 0; i < data.length; i++) {
						switchList.push(data[i]);
						options += "<option value='" + data[i].id + "'>" + data[i].name
							+ "</option>";
					}
					$("#switchs").empty();
					$("#switchs").append(options);
				}
			})

		}
	})
	var op = "";
	for(var i = 0; i < substationList.length; i++) {
		op += "<option value='" + substationList[i].id + "'>" + substationList[i].name
			+ "</option>";
	}
	$("#searchlist").empty().append(op);
}

function fuzzySearchHandler(type) {
	var options = "";
	if(type == 1) {
		for(var i = 0; i < lineList.length; i++) {
			options += "<option value='" + lineList[i].id + "'>" + lineList[i].name
				+ "</option>";
		}
		$("#searchlist").empty().append(options);
	} else if(type == 0) {
		for(var i = 0; i < substationList.length; i++) {
			options += "<option value='" + substationList[i].id + "'>" + substationList[i].name
				+ "</option>";
		}
		$("#searchlist").empty().append(options);
	} else if(type == 2) {
		console.log(switchList);
		for(var i = 0; i < switchList.length; i++) {
			options += "<option value='" + switchList[i].name + "'>"
				+ "</option>";
		}
		$("#searchlist").empty().append(options);
	}
}

function checkoutSearch() {
	var type = $('#searchType').val();
	console.log(type);
	var searchContent = $('#Search').val();
	console.log(searchContent);
	switch (type) {
		case '变电站': substationSearch(searchContent); break;
		case '线路': lineSearch(searchContent); break;
		case '设备': switchSearch(searchContent); break;
	}
}

function substationSearch(content) {
	$('.substations').val(content);
	Change_line(content);
	$('#Search').val('');
	loadEventListWithSwitchId("get_high_voltage_hitch_event_by_switch_id.action?switchId=", switchList[0].id);
}

function lineSearch(content) {
	$(".lines").val(content);
	$('#Search').val('');
	loadSwitchListWithLineId("high_voltage_switch_list_by_line_id", content);
	loadEventListWithSwitchId("get_high_voltage_hitch_event_by_switch_id.action?switchId=", switchList[0].id);
}

function switchSearch(content) {
	$('#searchType').val('变电站');
	for(var i = 0; i < switchList.length; i++) {
		if(switchList[i].name == content) {
			content = switchList[i].id;
			break;
		}
	}
	$("#switchs").val(content);
	$('#Search').val('');
	loadEventListWithSwitchId("get_high_voltage_hitch_event_by_switch_id.action?switchId=", content);
}