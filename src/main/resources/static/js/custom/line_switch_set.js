function loadSwitchListWithLineId(_url, lineId) {

	$.ajax({
		type : "post",
		url : _url,
		async : false,
		data : {

			"lineId" : lineId
		},
		success : function(data) {

			data = data.data;
			var options = "";
			for (var i = 0; i < data.length; i++) {

				options += "<option value='" + data[i].id + "'>" + data[i].name
						+ "</option>";
			}
			$("#switchs").empty();
			$("#switchs").append(options);
		}
	})

}

function loadEventListWithSwitchId(_url, switchId) {

	// alert(switchId)
	$('#hitch_event_list').DataTable(
			{
				"destroy" : true,// destroy之后才能重新加载
				"ajax" : _url + switchId,
				"columns" : [ {
					"data" : "hitchTime"
				}, {
					"data" : "hitchPhase"
				}, {
					"data" : "hitchReason"
				}, {
					"data" : "behitchAPhaseVoltage"
				}, {
					"data" : "behitchBPhaseVoltage"
				}, {
					"data" : "behitchCPhaseVoltage"
				}, {
					"data" : "behitchAPhaseCurrent"
				}, {
					"data" : "behitchBPhaseCurrent"
				}, {
					"data" : "behitchCPhaseCurrent"
				}, ],
				"createdRow" : function(row, data, index) {

					var hitchTime = $('td', row).eq(0).text();
					$('td', row).eq(0).text(
							getFormatDate(new Date(parseInt(hitchTime, 10))))

					var hitchReason = $('td', row).eq(2).text();
					var r = "";
					switch (parseInt(hitchReason)) {
					case 1:
						r += "剩余电流";
						break;
					case 2:
						r += "缺零";
						break;
					case 3:
						r += "过载";
						break;
					case 4:
						r += "短路";
						break;
					case 5:
						r += "缺相";
						break;
					case 6:
						r += "欠压";
						break;
					case 7:
						r += "过压";
						break;
					case 8:
						r += "接地";
						break;
					case 9:
						r += "停电";
						break;
					case 10:
						r += "定时试验";
						break;
					case 11:
						r += "远程";
						break;
					case 12:
						r += "闭锁";
						break;
					case 13:
						r += "手动";
						break;
					case 14:
						r += "互感器故障";
						break;
					case 15:
						r += "合闸失败";
						break;
					case 16:
						r += "设置失败";
						break;

					}
					$('td', row).eq(2).text(r);
				}

			});

	// $.ajax({
	// type : "post",
	// url : _url,
	// async : false,
	// data : {
	//
	// "switchId" : lineId
	// },
	// success : function(data) {
	//
	// data = data.data;
	// var options = "";
	// for (var i = 0; i < data.length; i++) {
	//
	// options += "<option value='" + data[i].id + "'>" + data[i].name
	// + "</option>";
	// }
	// $("#switchs").empty();
	// $("#switchs").append(options);
	// }
	// })

}
