$(document)
		.ready(
				function() {

					/**
					 * 初始化列表
					 */
					initial_table("hitch_event_list");
					loadSubstationSet();
					// $(".del_event_btn").click(delSwitch);

					/**
					 * 绑定线路的切换
					 */
					$(".lines").click(
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
