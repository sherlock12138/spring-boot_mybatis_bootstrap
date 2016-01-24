$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("switch_list");
	$("#add_switch_btn").click(addSwitch);
	$(".edit_switch_btn").click(editSwitch);
	$(".del_switch_btn").click(delSwitch);

	
	/**
	 * 编辑提交
	 */
	$("#edit_switch_confirm_btn").click(function() {

		$.ajax({
			type : "post",
			url : "edit_substation",
			async : false,
			data : {
				"id" : $("#editId").val(),
				"name" : $("#editName").val(),
				"companyId" : $("#editLineId").val(),
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
			url : "edit_substation",
			async : false,
			data : {
				"id" : $("#inputId").val(),
				"name" : $("#inputName").val(),
				"companyId" : $("#inputLineId").val(),
			},
			success : function(data) {

				if(data!=null){
					
					reloadDataTable(data);
				}
			}
		})
	});
	
});


function reloadDataTable(id){
	
	$('#switch_list').DataTable( {
		destroy: true,// destroy之后才能重新加载
        "ajax": "substation_list_by_company_id.action",
        "columns": [
            { "data": "name" },
            { 	"data": "id",
            	"sClass": "dpass"},
            { 	"data": "companyId",
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
	$("#inputLineId").val(
			$(".edit_switch_btn").parent("td").prevAll()[0].innerHTML);
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
			url : "del_substation",
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
