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
function readCurrentVoltage(id, type) {

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

			anum = Math.floor(Math.random() * 10);
			if (data[0] == 0) {

				$("#a_phase_voltage").text(data[0] / 10);
			} else {
				$("#a_phase_voltage").text(
						(data[0] + Math.floor(Math.random() * 10)) / 10);
			}

			if (data[1] == 0) {

				$("#b_phase_voltage").text(data[1] / 10);
			} else {
				$("#b_phase_voltage").text(
						(data[1] + Math.floor(Math.random() * 10)) / 10);
			}

			if (data[2] == 0) {

				$("#c_phase_voltage").text(data[2] / 10);
			} else {
				$("#c_phase_voltage").text(
						(data[2] + Math.floor(Math.random() * 10)) / 10);
			}
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

			anum = Math.floor(Math.random() * 10);

			/*
			 * if (data[0] == 0) {
			 * 
			 * $("#a_phase_current").text(data[0] / 10); } else {
			 * $("#a_phase_current").text((data[0] + Math.floor(Math.random() *
			 * 10)) / 10); }
			 * 
			 * if (data[1] == 0) {
			 * 
			 * $("#b_phase_current").text(data[1] / 10); } else {
			 * $("#b_phase_current").text((data[1] + Math.floor(Math.random() *
			 * 10)) / 10); }
			 * 
			 * if (data[2] == 0) {
			 * 
			 * $("#c_phase_current").text(data[2] / 10); } else {
			 * $("#c_phase_current").text((data[2] + Math.floor(Math.random() *
			 * 10)) / 10); }
			 */

			$("#a_phase_current").text(data[0] / 10);
			$("#b_phase_current").text(data[1] / 10);
			$("#c_phase_current").text(data[2] / 10);
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
				alert("操作成功！")
			} else {
				alert("操作失败")
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
