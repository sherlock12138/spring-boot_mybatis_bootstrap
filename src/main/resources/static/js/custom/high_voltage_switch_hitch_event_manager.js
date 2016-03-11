$(document)
	.ready(
				function() {

					/**
					 * 初始化列表
					 */
					$("#hitch_event_list").DataTable({  // 初始化表格
						"destroy": true,
						"ajax": {
							url: 'get_high_voltage_hitch_event_by_switch_id?switchId=07'
						},
						"columns" : [ {
							"data" : "hitchTime"
						}, {
							"data" : "hitchPhase"
						}, {
							"data" : "hitchReason"
						}],
					});

					//alert('dsa')
					loadSubstationSet();
					// $(".del_event_btn").click(delSwitch);

					$.ajax({
						type : "post",
						url : 'high_voltage_switch_list_by_line_id',
						//async : false,
						data : {
							"lineId" : '07'
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

					/**
					 * 绑定线路的切换
					 */
					$(".lines").change(
							function() {

								loadSwitchListWithLineId(
										"high_voltage_switch_list_by_line_id",
										$(".lines").val());
							})

					$("#switchs")
							.click(
									function() {

										loadEventListWithSwitchId(
												"get_high_voltage_hitch_event_by_switch_id.action?switchId=",
												$("#switchs").val());
									})
				});

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
					"data" : "hitchPreform"
				}, {
					"data" : "hitchReason"
				}],
				"createdRow" : function(row, data, index) {

					var hitchTime = $('td', row).eq(0).text();
					$('td', row).eq(0).text(
							getFormatDate(new Date(parseInt(hitchTime, 10))))

					var hitchReason = $('td', row).eq(2).text();
					var r = "";
					switch (parseInt(hitchReason)) {
					case 0:
						r += "分闸";
						break;
					case 1:
						r += "合闸";
						break;
					}
					$('td', row).eq(2).text(r);
				}

			});
}

// /**
// *
// * @Title: delSwitch
// * @Description: TODO
// * @param
// * @return void
// * @throws
// */
// function delSwitch() {
//
// var column = $(this).parent("td").prevAll();
// $("#del_confirm_btn").attr("href",
// "del_hitch_event?eventId=" + column[10].innerHTML);
// }
