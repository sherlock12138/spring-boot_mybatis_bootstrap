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
					$(".lines")
							.click(
									function() {

										loadSwitchListWithLineId(
												"control_measure_switch_list_by_line_id",
												$(".lines").val());
									})

					$("#switchs")
							.click(
									function() {

										loadEvent(
												"get_control_measure_hitch_event_by_switch_id.action?switchId=",
												$("#switchs").val());
									})
				});


function loadEvent(_url, switchId) {

	// alert(switchId)
	$('#hitch_event_list').DataTable(
			{
				"destroy" : true,// destroy之后才能重新加载
				"ajax" : _url + switchId,
				"columns" : [ {
					"data" : "hitchTime"
				},  {
					"data" : "hitchReason"
				}],
				"createdRow" : function(row, data, index) {

					var hitchTime = $('td', row).eq(0).text();
					$('td', row).eq(0).text(
							getFormatDate(new Date(parseInt(hitchTime, 10))))

					var hitchReason = $('td', row).eq(1).text();
					var r = "";
					switch (parseInt(hitchReason)) {
					case 1:
						r += "A相电压过压";
						break;
					case 2:
						r += "B相电压过压";
						break;
					case 3:
						r += "C相电压过压";
						break;
					case 4:
						r += "A相电压欠压";
						break;
					case 5:
						r += "B相电压欠压";
						break;
					case 6:
						r += "C相电压欠压";
						break;
					case 7:
						r += "A相电压谐波超限";
						break;
					case 8:
						r += "B相电压谐波超限";
						break;
					case 9:
						r += "C相电压谐波超限";
						break;
					case 10:
						r += "A相缺相";
						break;
					case 11:
						r += "B相缺相";
						break;
					case 12:
						r += "C相缺相";
						break;
					case 13:
						r += "零序电流超限";
						break;
					case 14:
						r += "停电";
						break;
					}
					$('td', row).eq(1).text(r);
				}

			})
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
