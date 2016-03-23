$(document)
	.ready(
				function() {

					/**
					 * 初始化列表
					 */
					$("#hitch_event_list").DataTable({  // 初始化表格
						"destroy": true,
						"ajax": {
							url: 'get_high_voltage_hitch_event_by_switch_id?switchId=75ab61fafa814ce8a587eeb6a6693464'
						},
						"columns" : [ {
							"data" : "hitchTime"
						}, {
							"data" : "hitchReason"
						}, {
							"data" : "hitchPhase"
						}, {
							"data" : "changeType"
						}, {
							"data": "solvePeople"
						}, {
							"data": "solveTime"
						}, {
							"data": "solveWay"
						}]
					});
					loadSubstationSet();
					$.ajax({
						type : "post",
						url : 'high_voltage_switch_list_by_line_id',
						//async : false,
						data : {
							"lineId" : '07'
						},
						success : function(data) {
							switchList = [];
							data = data.data;
							var options = "";
							for (var i = 0; i < data.length; i++) {
								switchList.push(data[i]);
								options += "<option value='" + data[i].id + "'>" + data[i].name
									+ "</option>";
							}
							$("#switchs").empty();
							$("#switchs").append(options);
							console.log(switchList);
						}
					})

					/**
					 * 绑定线路的切换
					 */
					$(".lines").change(
							function() {

								loadSwitchListWithLineId(
										"high_voltage_switch_list_by_line_id",
										$(".lines").val());
							});

					$("#switchs").change(
									function() {
										loadEventListWithSwitchId(
												"get_high_voltage_hitch_event_by_switch_id.action?switchId=",
												$("#switchs").val());
									});
					$('#searchType').change(function() {
						switch(this.value) {
							case '变电站': fuzzySearchHandler(0); break;
							case '线路': fuzzySearchHandler(1); break;
							case '设备': fuzzySearchHandler(2); break;
						}
					})
				});

function loadEventListWithSwitchId(_url, switchId) {
	$('#hitch_event_list').DataTable(
			{
				"destroy" : true,// destroy之后才能重新加载
				"ajax" : _url + switchId,
				"columns" : [ {
					"data" : "hitchTime"
				}, {
					"data" : "hitchReason"
				}, {
					"data" : "hitchPhase"
				}, {
					"data" : "changeType"
				}, {
					"data": "solvePeople"
				}, {
					"data": "solveTime"
				}, {
					"data": "solveWay"
				}]
			});
}
