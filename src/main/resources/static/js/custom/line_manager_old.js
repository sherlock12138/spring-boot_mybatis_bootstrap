$(document).ready(function() {

	// $.ajax({
	// type : "POST",
	// url : "/dongjun/line_list",
	// async : false,
	// data : {
	// "account" : $("#login>input[id='account']").val(),
	// "password" : $("#login>input[id='password']").val(),
	// },
	// success : function(data) {
	// },
	// error : function() {
	//
	// }
	//
	// })

	$("#search_line_btn").click(function() {
//		Spring.addDecoration(new Spring.AjaxEventDecoration({
//			formId : 'triggerform',
//			elementId : 'doUpdate',
//			event : 'onclick'
//		}));
		
		$("#test").lineHeight = 0;
		$.ajax({
			type : "post",
			url : "select_line",
			async : false,
			data : {
				"keyWord" : $("#keyWord").val(),
				"date" : new Date()
			}

		})
	})

	// // login鐧婚檰
	// $("#but1").click(function() {
	// $.ajax({
	// type : "GET",
	// url : "/school/user/login.action",
	// async : false,
	// data : {
	// "account" : $("#login>input[id='account']").val(),
	// "password" : $("#login>input[id='password']").val(),
	// },
	// success : function(data) {
	// },
	// error : function() {
	//
	// }
	//
	// })
	// })
});