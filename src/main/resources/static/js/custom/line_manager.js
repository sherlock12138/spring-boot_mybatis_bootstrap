$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("switch_list");
	$("#add_switch_btn").click(addSwitch);
	$(".edit_switch_btn").click(editSwitch);
	$(".del_switch_btn").click(delSwitch);
	loadSubstationSet();	
	
	/**
	 * 编辑提交
	 */
	$("#edit_switch_confirm_btn").click(function() {

		$.ajax({
			type : "post",
			url : "edit_line",
			async : false,
			data : {
				"id" : $("#editId").val(),
				"name" : $("#editName").val(),
				"substationId" : $("#editLineId").val(),
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
			url : "edit_line",
			async : false,
			data : {
				"id" : $("#inputId").val(),
				"name" : $("#inputName").val(),
				"substationId" : $("#inputLineId").val(),
			},
			success : function(data) {

				if(data!=null){
					
					reloadDataTable(data);
				}
			}
		})
	});
	
	/**
	 * 切换变电站时的监听
	 */
	$(".substations").click(function(){
		
		reloadDataTable(this.value);
	});
});

/**
 * 
 * @Title: loadSubstationSet
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function loadSubstationSet() {

	$.ajax({
		type : "post",
		url : "substation_list_by_company_id",
		async : false,
		data : {},
		success : function(data) {

			var options = "";
			for (var i = 0; i < data.data.length; i++) {

				options += "<option value='" + data.data[i].id + "'>" + data.data[i].name
						+ "</option>";
			}
			$(".substations").append(options);
			$("#inputLineId").append(options);
		}
	})
}


/**
 * 
* @Title: reloadDataTable 
* @Description: TODO
* @param @param id   
* @return void   
* @throws
 */
function reloadDataTable(id){
	
	$('#switch_list').DataTable( {
		destroy: true,// destroy之后才能重新加载
        "ajax": "line_list_by_substation_id.action?substation_id="+id,
        "columns": [
            { "data": "name" },
            { 	"data": "id",
            	"sClass": "dpass"},
            { 	"data": "substationId",
                	"sClass": "dpass"},
            { "data": null},// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
            { "data": null }// 设置默认值 null，表示列不会获得数据源对象的信息,否则默认值会被覆盖掉
        ],
        // 为下面的列设置默认值
        "columnDefs": [ {
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
          }
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
	$("#inputLineId").val("");
	$("#inputName").val("");
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
	$("#editName").val(column[2].innerHTML);
	$("#editId").val(column[1].innerHTML);
	$("#editLineId").val(column[0].innerHTML);
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
			url : "del_line",
			async : false,
			data : {
				"switchId" : column[2].innerHTML,
			},
			success : function(data) {

				if(data!=null){
					
					reloadDataTable(data);
				}
			}
		})
	});
}






