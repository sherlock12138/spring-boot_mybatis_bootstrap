$('#log_out').click(function () {
	$.ajax({
		url: '/dongjun/logout',
	}).success(function () {
		alert('退出成功，再见！');
		location.href = 'login';
	})
});
var webPage = $('#module').data("web");
switch (webPage) {
	case 1: $('[href="index"]').removeClass('btn-primary').addClass('btn-success'); break;
	case 2: $('#manage').removeClass('btn-primary').addClass('btn-success'); break;
	case 3: $('[href="current_voltage_chart"]').removeClass('btn-primary').addClass('btn-success'); break;
	case 4: $('#event').removeClass('btn-primary').addClass('btn-success'); break;
}