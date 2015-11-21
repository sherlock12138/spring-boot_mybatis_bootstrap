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
			$(".edit_switch_btn").parent("td").prevAll()[7].innerHTML);

	$("#inputAddress").val("");
	$("#inputLongitude").val("");
	$("#inputLatitude").val("");
	$("#inputDeviceNumber").val("");
	$("#inputName").val("");
	$("#inputSim").val("");
	$("#inputProtocal").text("");
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
	$("#editId").val(column[8].innerHTML);
	$("#editLineId").val(column[7].innerHTML);
	$("#editAddress").val(column[6].innerHTML);
	$("#editLongitude").val(column[5].innerHTML);
	$("#editLatitude").val(column[4].innerHTML);

	$("#editSim").val(column[3].innerHTML);
	$("#editProtocal").val(column[2].innerHTML);
	// $("#editIsOnline").val("false");
	// $("#inputDeviceNumber").attr("placeholder",
	// column[4].innerHTML);
	// $("#inputName").attr("placeholder", column[3].innerHTML);
	// $("#inputSim").attr("placeholder", column[2].innerHTML);
	// $("#inputProtocal").attr("placeholder", column[1].innerHTML);
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
			"del_switch?switchId=" + column[9].innerHTML);
}

