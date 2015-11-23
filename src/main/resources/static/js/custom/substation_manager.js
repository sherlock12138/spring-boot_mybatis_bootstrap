$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("switch_list");
	$("#add_switch_btn").click(addSwitch);
	$(".edit_switch_btn").click(editSwitch);
	$(".del_switch_btn").click(delSwitch);

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
	$("#del_confirm_btn").attr("href",
			"del_substation?switchId=" + column[2].innerHTML);
}
