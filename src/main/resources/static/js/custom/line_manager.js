$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("switch_list");
	$("#add_switch_btn").click(addSwitch);
	$(".edit_switch_btn").click(editSwitch);
	$(".del_switch_btn").click(delSwitch);
	loadSubstationSet();	
	
	
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
			for (var i = 0; i < data.length; i++) {

				options += "<option value='" + data[i].id + "'>" + data[i].name
						+ "</option>";
			}
			$(".substations").append(options);
			$("#inputLineId").append(options);
		}
	})
}

/**
 * 切换变电站时的监听
 */
$(".substations").click(function(){
	
	$('#switch_list').DataTable( {
		destroy: true,// destroy之后才能重新加载
        "ajax": "line_list_by_substation_id.action?substation_id="+this.value,
        "columns": [
            { "data": "name" },
            { 	"data": "id",
            	"visible": false},
            { 	"data": "substationId",
	            "visible": false},
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
    } );
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
	$("#del_confirm_btn").attr("href",
			"del_line?switchId=" + column[2].innerHTML);
}
