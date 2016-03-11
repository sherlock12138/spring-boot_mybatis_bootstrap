
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
			{  "data": "id",
				"sClass": "dpass"
			},
			{  "data": "lineId",
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
		],
		"columnDefs": [
			{
				"targets": -4,
				"data": null,
				"defaultContent": '<button class="btn btn enter_map">进入地图 &raquo;</button>'
			},
			{
				"targets": -3,
				"data": null,
				"defaultContent": '<a href="#edit_switch_modal" role="button" class="edit_switch_btn btn" data-toggle="modal">修改 &raquo;</a>'
			},
			{
				"targets": -2,
				"data": null,
				"defaultContent": '<a href="#del_switch_modal" class="del_switch_btn btn btn-danger" data-toggle="modal" data-backdrop="static">删除&raquo; </a>'
			},
			{
				"targets": -1,
				"data": null,
				"defaultContent": '<a href="#location_switch_modal" role="button" class="location_switch_btn btn btn-primary" data-toggle="modal">设为定位中心</a>'
			}
		]
	});

}

function initial_table_low(id) {
	$("#" + id).DataTable({
		"destroy": true,
		"ajax": {
			url: '/dongjun/switch_list_by_line_id?lineId=07'
		},
		"columns": [
			{ "data": "deviceNumber" },
			{ "data": "name" },
			{ "data": "showName"},
			{  "data": "id",
				"sClass": "dpass"
			},
			{  "data": "lineId",
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
		],
		"columnDefs": [
			{
				"targets": -4,
				"data": null,
				"defaultContent": '<button class="btn btn enter_map">进入地图 &raquo;</button>'
			},
			{
				"targets": -3,
				"data": null,
				"defaultContent": '<a href="#edit_switch_modal" role="button" class="edit_switch_btn btn" data-toggle="modal">修改 &raquo;</a>'
			},
			{
				"targets": -2,
				"data": null,
				"defaultContent": '<a href="#del_switch_modal" class="del_switch_btn btn btn-danger" data-toggle="modal" data-backdrop="static">删除&raquo; </a>'
			},
			{
				"targets": -1,
				"data": null,
				"defaultContent": '<a href="#location_switch_modal" role="button" class="location_switch_btn btn btn-primary" data-toggle="modal">设为定位中心</a>'
			}
		]
	});
}

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

