function buildEditTask() {
	$('#tasksOfAnIssue').modal('hide');
	$('#editTask').modal('show');
	
	$('#taskTab a').click(function (e) {
		e.preventDefault()
		$(this).tab('show')
	})
	$('#fireTimeTab a').click(function (e) {
		e.preventDefault()
		$(this).tab('show')
	})

}