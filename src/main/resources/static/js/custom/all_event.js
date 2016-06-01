$('#all_event').DataTable({
	'destroy': true,
	'ajax': {
		url: 'get_all_high_event_by_time'
	},
	'columns' : [ {
		'data' : "hitchTime"
	}, {
		'data' : "hitchReason"
	}, {
		'data' : "hitchPhase"
	}, {
		'data' : "changeType"
	}, {
		'data': "solvePeople"
	}, {
		'data': "solveTime"
	}, {
		'data': "solveWay"
	}]
})