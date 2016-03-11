
function initial_table(id) {

	$("#" + id).DataTable({
		"destroy": true,
		"ajax": {
			url: '/dongjun/high_voltage_switch_list_by_line_id?lineId=07'
		},
		"columns": [
			{ "data": "deviceNumber" },
			{ "data": "name" },
			{ "data": "showName"},
			{ 	"data": "id",
				"sClass": "dpass"
			},
			{ 	"data": "lineId",
				"sClass": "dpass"
			},
			{ "data": "address" },
			{ "data": "longitude" },
			{ "data": "latitude" },
			{ "data": "simNumber" },
			{ "data": "inlineIndex" },
			{ "data": "onlineTime"},
			{ "data": null},
			{ "data": null},// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
			{ "data": null},// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
			{ "data": null}
		]
	});



//	$("#" + id).DataTable({
//		dom : 'T<"clear">lfrtip',
//		tableTools : {
//			"sSwfPath" : "../../../resource/swf/copy_csv_xls_pdf.swf"
//		},
//		scrollCollapse : true,
//		"scrollX" : true,// 启用水平滚动条
//		// scrollY : 700,
//		stateSave : true,
//		"oLanguage" : {
//			"sUrl" : "../../../resource/txt/dataTables_cn.txt"
//		},
//		"fnInitComplete": function(oSettings, json) {
//			//alert('321')
//		}
//	});
	//$('#switch_list tr:eq(1)').addClass('online');

}