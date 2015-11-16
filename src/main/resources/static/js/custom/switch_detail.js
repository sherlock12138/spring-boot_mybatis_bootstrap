$(document).ready(function() {

	// read(a_phase_voltage_btn, new data('03', 0), a_phase_voltage);
	// read(b_phase_voltage_btn, new data('03', 1), b_phase_voltage);
	// read(c_phase_voltage_btn, new data('03', 2), c_phase_voltage);
	//
	// read(a_phase_current_btn, new data('03', 4), a_phase_current);
	// read(b_phase_current_btn, new data('03', 5), b_phase_current);
	// read(c_phase_current_btn, new data('03', 6), c_phase_current);

	// ************************************************************

//	$("#if_switch_open_btn").click(function() {
//
//		$.ajax({
//			type : "post",
//			url : "read_hitch_event",
//			async : false,
//			data : {
//				"switchId" : "03",
//				"sign" : 0,
//			},
//			success : function(data) {
//				$("#a_phase_current").innerHTML(data[0]);
//				$("#b_phase_current").innerHTML(data[1]);
//				$("#c_phase_current").innerHTML(data[2]);
//			}
//
//		})
//	})
	
})

/**
 * 
 * @Title: readCurrentVoltage
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function readCurrentVoltage() {

	readAllPhaseVoltage();
	readAllPhaseCurrent();
	t = setTimeout("readCurrentVoltage()", 4 * 1000);
}

/**
 * 
 * @Title: readAllPhaseVoltage
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function readAllPhaseVoltage() {

	$.ajax({
		type : "post",
		url : "read_voltage",
		async : false,
		data : {
			"switchId" : "03",
			"sign" : 3,
		},
		success : function(data) {

			$("#a_phase_voltage").text(data[0]);
			$("#b_phase_voltage").text(data[1]);
			$("#c_phase_voltage").text(data[2]);
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
function readAllPhaseCurrent() {

	$.ajax({
		type : "post",
		url : "read_current",
		async : false,
		data : {
			"switchId" : "03",
			"sign" : 7,
		},
		success : function(data) {
			$("#a_phase_current").text(data[0]);
			$("#b_phase_current").text(data[1]);
			$("#c_phase_current").text(data[2]);
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
function controlSwitch(type) {

	$.ajax({
		type : "post",
		url : "control_switch",
		async : false,
		data : {
			"switchId" : "03",
			"sign" : $("#control_type").val(),
			"type" : type,
		}

	})
}

function closeSwitch(){
	
	controlSwitch()
	
}









/**
 * 
 * @Title: cancelControlSwitch
 * @Description: TODO
 * @param
 * @return void
 * @throws
 */
function cancelControlSwitch() {

	$.ajax({
		type : "post",
		url : "cancel_control_switch",
		async : false,
		data : {
			"switchId" : "03",
			"sign" : $("#cancel_control_type").val(),
		}

	})
}

function data(switchId, sign) {

	this.switchId = switchId;
	this.sign = sign;
	return this;
}

/**
 * 
 * @Title: read
 * @Description: TODO
 * @param
 * @param btn_id
 * @param
 * @param data
 * @param
 * @param result_location
 * @return void
 * @throws
 */
function read(btn_id, data, result_location) {

	$("#" + btn_id).click(function() {

		$.ajax({
			type : "post",
			url : "read_voltage",
			async : false,
			data : data,
			success : function(data) {
				$("#" + result_location).val(data);
			}

		})
	})
}
