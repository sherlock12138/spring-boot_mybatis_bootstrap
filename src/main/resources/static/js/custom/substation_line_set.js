
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
			$("#substations").append(options);
		}
	})
}

/**
 * 切换变电站时的监听
 */
$("#substations").click(function(){
	
	$.ajax({
		type : "post",
		url : "line_list_by_substation_id",
		async : false,
		data : {
			
			"substation_id":this.value
		},
		success : function(data) {

			data = data.data;
			var options = "";
			for (var i = 0; i < data.length; i++) {

				options += "<option value='" + data[i].id + "'>" + data[i].name
						+ "</option>";
			}
			$("#lines").empty();
			$("#lines").append( options);
		}
	})
	
	
});



