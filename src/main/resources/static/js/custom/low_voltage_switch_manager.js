$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("switch_list");
	loadSubstationSet();	
	$("#add_switch_btn").click(addSwitch);
	$(".edit_switch_btn").click(editSwitch);
	$(".del_switch_btn").click(delSwitch);
	$(".enter_map").click(enterMap);
	

	/**
	 * 编辑开关提交时,处理select属性值
	 */
	$("#edit_switch_confirm_btn").click(function() {

		if ($("#editProtocal").val() == "07") {
			$("#editProtocal").val("1");
		} else if ($("#editProtocal").val() == "101") {
			$("#editProtocal").val("0");
		}
	});
	
	
	$("#lines").click(function(){
		$('#switch_list').DataTable( {
			"destroy": true,// destroy之后才能重新加载
			"ajax": "switch_list_by_line_id.action?lineId="+this.value,
	        "columns": [
	            { "data": "deviceNumber" },        
	            { "data": "name" },
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
		        { "data": null},
	            { "data": null},// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
	            { "data": null }// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
	        ],
	        
	        // 为下面的列设置默认值
	        "columnDefs": [ {
	            "targets": -3,
	            "data": null,
	            "defaultContent": '<button class="btn btn enter_map">进入地图 &raquo;</button>'
	        },{
	            "targets": -2,
	            "data": null,
	            "defaultContent": '<a href="#edit_switch_modal" role="button" class="edit_switch_btn btn" data-toggle="modal">修改 &raquo;</a>'
	        },
	        {
	            "targets": -1,
	            "data": null,
	            "defaultContent": '<a href="#del_switch_modal" class="del_switch_btn btn btn-danger" data-toggle="modal" data-backdrop="static">删除&raquo; </a>'
	        }],
	        "fnInitComplete": function(oSettings, json) { 

	        	$(".edit_switch_btn").click(editSwitch);
	        	$(".del_switch_btn").click(delSwitch);
	        	$(".enter_map").click(enterMap);
	          }
	    } );
	});
	
});


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
	
	if($("#lines").val() == null){
		
		$("#inputLineId").val(
				$(".edit_switch_btn").parent("td").prevAll()[5].innerHTML);
	}else{
		$("#inputLineId").val($("#lines").val());
	}
	$("#inputAddress").val("");
	$("#inputLongitude").val("");
	$("#inputLatitude").val("");
	$("#inputDeviceNumber").val("");
	$("#inputName").val("");
	$("#inputSim").val("");
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
	$("#editDeviceNumber").val(column[8].innerHTML);
	$("#editName").val(column[7].innerHTML);
	$("#editId").val(column[6].innerHTML);
	$("#editLineId").val(column[5].innerHTML);
	$("#editAddress").val(column[4].innerHTML);
	$("#editLongitude").val(column[3].innerHTML);
	$("#editLatitude").val(column[2].innerHTML);

	$("#editSim").val(column[1].innerHTML);
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
	$("#del_confirm_btn").attr("href",
			"del_switch?switchId=" + column[7].innerHTML);
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
