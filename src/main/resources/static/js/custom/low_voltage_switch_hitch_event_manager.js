$(document).ready(function() {

	/**
	 * 初始化列表
	 */

	$('#hitch_event_list').DataTable(
		{
			"destroy": true,// destroy之后才能重新加载
			"ajax": 'get_low_voltage_hitch_event_by_switch_id?switchId=07',
			"columns": [
				{
					"data": "hitchTime"
				},
				{
					"data": "hitchPhase"
				},
				{
					"data": "hitchReason"
				},
				{
					"data": "behitchAPhaseVoltage"
				},
				{
					"data": "behitchBPhaseVoltage"
				},
				{
					"data": "behitchCPhaseVoltage"
				},
				{
					"data": "behitchAPhaseCurrent"
				},
				{
					"data": "behitchBPhaseCurrent"
				},
				{
					"data": "behitchCPhaseCurrent"
				},
			]
		})

	//initial_table("hitch_event_list");
//	$(".del_event_btn").click(delSwitch);
	loadSubstationSet();
	/**
	 * 绑定线路的切换
	 */
	$(".lines").change(function() {

		loadSwitchListWithLineId("switch_list_by_line_id", this.value);
	})
	
	$("#switchs").change(function() {

		loadEventListWithSwitchId("get_low_voltage_hitch_event_by_switch_id.action?switchId=", this.value);
	})
	$('#searchType').change(function() {
		switch(this.value) {
			case '变电站': fuzzySearchHandler(0); break;
			case '线路': fuzzySearchHandler(1); break;
			case '设备': fuzzySearchHandler(3); break;
		}
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
}

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
