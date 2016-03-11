var default_id ;
function loadSubstationSet() {

	$.ajax({
		type : "post",
		url : "substation_list_by_company_id",
		async : false,
		data : {},
		success : function(data) {

			if(data!=null){

				data = data.data;
				default_id = data[0].id;
				var options = "";
				for (var i = 0; i < data.length; i++) {

					options += "<option value='" + data[i].id + "'>" + data[i].name
							+ "</option>";
				}
				Change_line(default_id);
				$(".substations").append(options);
				localStorage.setItem('defaultId', default_id);
			}
		}
	})

}

/**
 * 切换变电站时的监听
 */
$(".substations").change(function(){
	Change_line(this.value);

});

//$(".lines").val('123')

function Change_line(lineId) {
	$.ajax({
		type : "post",
		url : "line_list_by_substation_id",
		async : false,
		data : {
			"substation_id":lineId
		},
		success : function(data) {

			data = data.data;
			var options = "";
			for (var i = 0; i < data.length; i++) {

				options += "<option value='" + data[i].id + "'>" + data[i].name
					+ "</option>";
			}
			$(".lines").empty();
			$(".lines").append(options);
		}
	})
}




