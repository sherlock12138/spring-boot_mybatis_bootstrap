$(document).ready(function() {

	/**
	 * 初始化列表
	 */
	initial_table("hitch_event_list");
	$(".del_event_btn").click(delSwitch);
	dateTimeFromat();
});

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
			"del_hitch_event?eventId=" + column[10].innerHTML);
}
