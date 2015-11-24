$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("hitch_event_list");
	loadSubstationSet();
//	$(".del_event_btn").click(delSwitch);
	
	/**
	 * 绑定线路的切换
	 */
	$("#lines").click(function() {

		loadSwitchListWithLineId("high_voltage_switch_list_by_line_id", $("#lines").val());
	})
	
	$("#switchs").click(function() {

		loadEventListWithSwitchId("get_high_voltage_hitch_event_by_switch_id.action?switchId=", $("#switchs").val());
	})
});


//function loadEventListWithSwitchId(_url, switchId) {
//
//	// alert(switchId)
//	$('#hitch_event_list').DataTable(
//			{
//				"destroy" : true,// destroy之后才能重新加载
//				"ajax" : _url + switchId,
//				"columns" : [ {
//					"data" : "hitchTime"
//				}, {
//					"data" : "hitchPhase"
//				}, {
//					"data" : "hitchReason"
//				}, {
//					"data" : "behitchAPhaseVoltage"
//				}, {
//					"data" : "behitchBPhaseVoltage"
//				}, {
//					"data" : "behitchCPhaseVoltage"
//				}, {
//					"data" : "behitchAPhaseCurrent"
//				}, {
//					"data" : "behitchBPhaseCurrent"
//				}, {
//					"data" : "behitchCPhaseCurrent"
//				}, ],
//				"createdRow" : function(row, data, index) {
//
//					var hitchTime = $('td', row).eq(0).text();
//					$('td', row).eq(0).text(
//							getFormatDate(new Date(parseInt(hitchTime, 10))))
//
//					var hitchReason = $('td', row).eq(2).text();
//					var r = "";
//					switch (parseInt(hitchReason)) {
//					case 1:
//						r += "剩余电流";
//						break;
//					case 2:
//						r += "缺零";
//						break;
//					case 3:
//						r += "过载";
//						break;
//					case 4:
//						r += "短路";
//						break;
//					case 5:
//						r += "缺相";
//						break;
//					case 6:
//						r += "欠压";
//						break;
//					case 7:
//						r += "过压";
//						break;
//					case 8:
//						r += "接地";
//						break;
//					case 9:
//						r += "停电";
//						break;
//					case 10:
//						r += "定时试验";
//						break;
//					case 11:
//						r += "远程";
//						break;
//					case 12:
//						r += "闭锁";
//						break;
//					case 13:
//						r += "手动";
//						break;
//					case 14:
//						r += "互感器故障";
//						break;
//					case 15:
//						r += "合闸失败";
//						break;
//					case 16:
//						r += "设置失败";
//						break;
//
//					}
//					$('td', row).eq(2).text(r);
//				}
//
//			});
//}

///**
// * 
// * @Title: delSwitch
// * @Description: TODO
// * @param
// * @return void
// * @throws
// */
//function delSwitch() {
//
//	var column = $(this).parent("td").prevAll();
//	$("#del_confirm_btn").attr("href",
//			"del_hitch_event?eventId=" + column[10].innerHTML);
//}
