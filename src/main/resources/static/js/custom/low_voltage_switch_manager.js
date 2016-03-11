$(document).ready(function() {


//	$.ajax({
//		type : "post",
//		url : "substation_list_by_company_id",
//		method: 'post',
//		//async : false,
//		data : {},
//		success : function(data) {
//
//			if(data!=null){
//
//				data = data.data;
//				default_id = data[0].id;
//				var options = "";
//				for (var i = 0; i < data.length; i++) {
//
//					options += "<option value='" + data[i].id + "'>" + data[i].name
//						+ "</option>";
//				}
//				Change_line(default_id);
//				$(".substations").append(options);
//				localStorage.setItem('defaultId', default_id);
//			}
//		}
//	})
//
//	$(".substations").change(function(){
//		Change_line(this.value);
//
//	});
//
////$(".lines").val('123')
//
//	function Change_line(lineId) {
//		$.ajax({
//			type : "post",
//			url : "line_list_by_substation_id",
//			async : false,
//			data : {
//				"substation_id":lineId
//			},
//			success : function(data) {
//
//				data = data.data;
//				var options = "";
//				for (var i = 0; i < data.length; i++) {
//
//					options += "<option value='" + data[i].id + "'>" + data[i].name
//						+ "</option>";
//				}
//				$(".lines").empty();
//				$(".lines").append(options);
//			}
//		})
//	}

	/**
	 * 初始化列表
	 */
	//alert('123');
	initial_table_low("switch_list");
	loadSubstationSet();
	$("#add_switch_btn").click(addSwitch);
	$(".edit_switch_btn").click(editSwitch);
	$(".del_switch_btn").click(delSwitch);
	$(".enter_map").click(enterMap);
	

	/**
	 * 编辑提交
	 */
	$("#edit_switch_confirm_btn").click(function() {

		$.ajax({
			type : "post",
			url : "edit_switch",
			async : false,
			data : {
				"id" : $("#editId").val(),
				"name" : $("#editName").val(),
				"lineId" : $("#editLineId").val(),
				"address" : $("#editAddress").val(),
				"longitude" : $("#editLongitude").val(),
				"latitude" : $("#editLatitude").val(),
				"simNumber" : $("#editSim").val(),
				"inlineIndex" : $("#editinlineIndex").val(),
				"deviceNumber":$("#editDeviceNumber").val(),
			},
			success : function(data) {

				if(data!=null){
					
					reloadDataTable(data);
				}
			}
		})
	});
	
	$("#add_switch_confirm_btn").click(function() {

		$.ajax({
			type : "post",
			url : "edit_switch",
			async : false,
			data : {
				"id" : $("#inputId").val(),
				"name" : $("#inputName").val(),
				"lineId" : $("#inputLineId").val(),
				"address" : $("#inputAddress").val(),
				"longitude" : $("#inputLongitude").val(),
				"latitude" : $("#inputLatitude").val(),
				"simNumber" : $("#inputSim").val(),
				"inlineIndex" : $("#inlineIndex").val(),
				"deviceNumber":$("#inputDeviceNumber").val(),
			},
			success : function(data) {

				if(data!=null){
					
					reloadDataTable(data);
				}
			}
		})
	});
	
	
	
	$(".lines").change(function(){
		reloadDataTable(this.value);
	});
	
});

/**
 * 
* @Title: reloadDataTable 
* @Description: TODO
* @param    
* @return void   
* @throws
 */
function reloadDataTable(lineId){
	
	$('#switch_list').DataTable( {
		"destroy": true,
		"ajax": {
			url: '/dongjun/switch_list_by_line_id?lineId=' + lineId
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
    } );
}


/**
 * 
 * @Title: addSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function addSwitch() {

	$("#inputId").val("");
	
	if($(".lines").val() == null){
		
		$("#inputLineId").val(
				$(".edit_switch_btn").parent("td").prevAll()[6].innerHTML);
	}else{
		$("#inputLineId").val($(".lines").val());
	}
	$("#inputAddress").val("");
	$("#inputLongitude").val("");
	$("#inputLatitude").val("");
	$("#inputDeviceNumber").val("");
	$("#inputName").val("");
	$("#inputSim").val("");
	$("#inlineIndex").val("");
}

/**
 * 
 * @Title: editSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function editSwitch() {

	var column = $(this).parent("td").prevAll();
	$("#editDeviceNumber").val(column[9].innerHTML);
	$("#editName").val(column[8].innerHTML);
	$("#editId").val(column[7].innerHTML);
	$("#editLineId").val(column[6].innerHTML);
	$("#editAddress").val(column[5].innerHTML);
	$("#editLongitude").val(column[4].innerHTML);
	$("#editLatitude").val(column[3].innerHTML);

	$("#editSim").val(column[2].innerHTML);
	$("#editinlineIndex").val(column[1].innerHTML);
}

/**
 * 
 * @Title: delSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function delSwitch() {

	var column = $(this).parent("td").prevAll();
	$("#del_confirm_btn").click(function() {

		$.ajax({
			type : "post",
			url : "del_switch",
			async : false,
			data : {
				"switchId" : column[8].innerHTML,
			},
			success : function(data) {

				if(data!=null){
					
					reloadDataTable(data);
				}
			}
		})
	});
}


/**
 * 
 * @Title: enterMap
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function enterMap() {

	var longitude = $(this).parent("td").prevAll()[2].innerHTML;
	var latitude = $(this).parent("td").prevAll()[1].innerHTML;
	localStorage.setItem('longitude', longitude);
	localStorage.setItem('latitude', latitude);
	location.href = "index";
}


