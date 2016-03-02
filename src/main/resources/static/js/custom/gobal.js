$('#log_out').click(function () {
	$.ajax({
		url: '/dongjun/logout',
	}).success(function () {
		alert('退出成功，再见！');
		location.href = 'login';
	})
});
