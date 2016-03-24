$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("switch_list");
	loadSubstationSet();
	//reloadDataTable(localStorage.getItem('defaultId'))
	$("#add_switch_btn").click(addSwitch);
	$(".edit_switch_btn").click(editSwitch);
	$(".del_switch_btn").click(delSwitch);
	$(".enter_map").click(enterMap);
	$(".location_switch_btn").click(locateSwitch);

	/**
	 * 编辑提交
	 */
	$("#edit_switch_confirm_btn").click(function() {

		$.ajax({
			type : "post",
			url : "edit_high_voltage_switch",
			async : false,
			data : {
				"id" : $("#editId").val(),
				"name" : $("#editName").val(),
				"showName" : $("#editShowName").val(),
				"lineId" : $("#editLineId").val(),
				"address" : $("#editAddress").val(),
				"longitude" : $("#editLongitude").val(),
				"latitude" : $("#editLatitude").val(),
				"simNumber" : $("#editSim").val(),
				"inlineIndex" : $("#editinlineIndex").val(),
				"deviceNumber":$("#editDeviceNumber").val()
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
			url : "edit_high_voltage_switch",
			async : false,
			data : {
				"id" : $("#inputId").val(),
				"name" : $("#inputName").val(),
				"showName" : $("#inputShowName").val(),
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
		"destroy": true,// destroy之后才能重新加载
		"ajax": "high_voltage_switch_list_by_line_id.action?lineId="+lineId,
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
        ],
        
        // 为下面的列设置默认值
        "columnDefs": [ {
            "targets": -4,
            "data": null,
            "defaultContent": '<button class="btn btn enter_map">进入地图 &raquo;</button>'
        },{
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
        ],
        "fnInitComplete": function(oSettings, json) {
	        //alert('123')
        	$(".edit_switch_btn").click(editSwitch);
        	$(".del_switch_btn").click(delSwitch);
        	$(".enter_map").click(enterMap);
        	$(".location_switch_btn").click(locateSwitch);
          }
    } );

	$.ajax({
			url: '/dongjun/online_order',
			method: 'POST',
			data: {
				'lineId': lineId
			}
		}).success(function(data) {

		})

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
				$(".edit_switch_btn").parent("td").prevAll()[7].innerHTML);
	}else{
		$("#inputLineId").val($(".lines").val());
	}
	$("#inputAddress").val("");
	$("#inputLongitude").val("");
	$("#inputLatitude").val("");
	$("#inputDeviceNumber").val("");
	$("#inputName").val("");
	$("#inputShowName").val("");
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
	$("#editDeviceNumber").val(column[10].innerHTML);
	$("#editName").val(column[9].innerHTML);
	$("#editShowName").val(column[8].innerHTML);
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
			url : "del_high_voltage_switch",
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

function locateSwitch() {
	
	var column = $(this).parent("td").prevAll();
	$.ajax({
		type : "get",
		url : "edit_location",
		async : false,
		data : {
			"switchId" : column[9].innerHTML,
			"type" : 1
		},
		success : function(data) {

			if(data != null){
				
				alert("设置成功");
			}
		}
	})
}
