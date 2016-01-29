/**
 * 
 */
dwr.engine.setActiveReverseAjax( true);
//设置在页面关闭时，通知服务端销毁会话
dwr.engine.setNotifyServerOnPageUnload( true);
function hvStatusShow(data) {
	
	console.log(data);
	if (data == null || data == "") {

		$("#status").text("离线");
	} else {

		$("#guo_liu_yi_duan").addClass(
				green_or_red(data.guo_liu_yi_duan));
		$("#guo_liu_er_duan").addClass(
				green_or_red(data.guo_liu_er_duan));
		$("#guo_liu_san_duan").addClass(
				green_or_red(data.guo_liu_san_duan));

		$("#pt1_you_ya").addClass(green_or_red(data.pt1_you_ya));
		$("#pt2_you_ya").addClass(green_or_red(data.pt2_you_ya));
		$("#pt1_guo_ya").addClass(green_or_red(data.pt1_guo_ya));
		$("#pt2_guo_ya").addClass(green_or_red(data.pt2_guo_ya));

		$("#shou_dong_he_zha").addClass(
				green_or_red(data.shou_dong_he_zha));
		$("#shou_dong_fen_zha").addClass(
				green_or_red(data.shou_dong_fen_zha));

		$("#yao_kong_fu_gui").addClass(
				green_or_red(data.yao_kong_fu_gui));
		$("#yao_kong_fen_zha").addClass(
				green_or_red(data.yao_kong_fen_zha));
		$("#yao_kong_he_zha").addClass(
				green_or_red(data.yao_kong_he_zha));

		$("#jiao_liu_shi_dian").addClass(
				green_or_red(data.jiao_liu_shi_dian));
		$("#chong_he_zha").addClass(green_or_red(data.chong_he_zha));
		$("#ling_xu_guo_liu_").addClass(
				green_or_red(data.ling_xu_guo_liu_));

		if (data.status == "00") {

			$("#status").text("分");
		} else if (data.status == "01") {

			$("#status").text("合");
		}

	}
}

function showHitchEvent(data) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	for (var i = 0; i < data.length; i++) {

		if (data[i].open == true) {
			alert("警告，已经跳闸！");
			nodeList = zTree.getNodesByParamFuzzy("id", data[i].id);

			update(nodeList, 2);  // 树节点变红
			worning_switchs_draw(nodeList[0]); //声音的 图标的
		}
	}
}
