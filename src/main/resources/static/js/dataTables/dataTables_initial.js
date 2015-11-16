
function initial_table(id) {

	$("#" + id).dataTable({
		dom : 'T<"clear">lfrtip',
		tableTools : {
			"sSwfPath" : "../../../resource/swf/copy_csv_xls_pdf.swf"
		},
		scrollCollapse : true,
		"scrollX" : true,// 启用水平滚动条
		// scrollY : 700,
		stateSave : true,
		"oLanguage" : {
			"sUrl" : "../../../resource/txt/dataTables_cn.txt"
		},
	});
}
