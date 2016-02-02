$(document).ready(function() {

})

/**
 * 
 * @Title: readCurrentVoltage
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
var volacc;
var curacc;
function readCurrentVoltage(id, type) {

	switch (type) {
	case 0:
		volacc = 10;
		curacc = 10;
		break;
	case 1:
		volacc = 100;
		curacc = 100;
		break;
	case 2:
		volacc = 100;
		curacc = 10;
		break;

	}

	readAllPhaseVoltage(id, type);
	readAllPhaseCurrent(id, type);

	t = setTimeout(function() {
		readCurrentVoltage(id, type);
	}, 3 * 1000);
}

/**
 * 
 * @Title: readAllPhaseVoltage
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function readAllPhaseVoltage(id, type) {

	$.ajax({
		type : "post",
		url : "read_voltage",
		async : false,
		data : {
			"switchId" : id,
			"type" : type,
		},
		success : function(data) {

			$("#a_phase_voltage").text(data[0] / volacc);
			$("#b_phase_voltage").text(data[1] / volacc);
			$("#c_phase_voltage").text(data[2] / volacc);

		}
	})
}

/**
 * 
 * @Title: readAllPhaseCurrent
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function readAllPhaseCurrent(id, type) {

	$.ajax({
		type : "post",
		url : "read_current",
		async : false,
		data : {
			"switchId" : id,
			"type" : type,
		},
		success : function(data) {

			$("#a_phase_current").text(data[0] / curacc);
			$("#b_phase_current").text(data[1] / curacc);
			$("#c_phase_current").text(data[2] / curacc);
		}

	})
}

/**
 * 
 * @Title: controlSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function controlSwitch(id, type, sign) {

	$.ajax({
		type : "post",
		url : "control_switch",
		async : false,
		data : {
			"switchId" : id,
			"sign" : sign,
			"type" : type,
		},
		success : function(data) {

			if (data == "success") {
				alert("操作成功！");
				$("#security_modal").modal('hide');
				TheBtnStatus();
			} else {
				alert("操作失败");
				$('#notice_msg').text("将在 " + '  ' + " 秒内执行！");
			}
		}

	})
}

/**
 * 
 * @Title: closeSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function closeSwitch(id, type) {

	controlSwitch(id, type, 1);

}

/**
 * 
 * @Title: openSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function openSwitch(id, type) {

	controlSwitch(id, type, 0);
}

function TheBtnStatus() {
	setTimeout(function () { // 回调函数
		$('#close_switch_btn').attr('disabled', 'true');
		$('#open_switch_btn').attr('disabled', 'true');
	}, 5*1000);
	$('#open_switch_btn').attr('disabled', 'false');
	$('#close_switch_btn').attr('disabled', 'false');
}
/**
 * 
 * @Title: cancelControlSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
// function cancelControlSwitch() {
//
// $.ajax({
// type : "post",
// url : "cancel_control_switch",
// async : false,
// data : {
// "switchId" : id,
// "sign" : $("#cancel_control_type").val(),
// }
//
// })
// }
// function data(switchId, sign) {
//
// this.switchId = switchId;
// this.sign = sign;
// return this;
// }
//
// /**
// *
// * @Title: read
// * @Description: TODO
// * @param
// * @param btn_id
// * @param
// * @param data
// * @param
// * @param result_location
// * @return void
// * @throws
// */
// function read(btn_id, data, result_location) {
//
// $("#" + btn_id).click(function() {
//
// $.ajax({
// type : "post",
// url : "read_voltage",
// async : false,
// data : data,
// success : function(data) {
// $("#" + result_location).val(data);
// }
//
// })
// })
// }
