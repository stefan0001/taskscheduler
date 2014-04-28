/*
	Create a new Time Task 
*/
function createTimeTask(radio) {
	var taskForm = document.getElementById("TaskInput");
	// If Windows was changed befor, remove the changes
	if(taskForm.childNodes.length > 4) {
		for(var i = taskForm.childNodes.length; i > 4; i--) {
			taskForm.removeChild(taskForm.lastChild);
		}
	}
	
	if(taskForm.childNodes.length == 4) {
		// Input for the Fire Date
		var input1 = createDateInput("taskeingabe", "TaskDate");
		// Input for the Fire Time
		var textfield = createTextField("TaskTime", "line-height: 34px; margin-left:3%;", "hh:mm");
		// If the Task should Repeat
		var checkbox = createCheckbox("taskRepeat", "repeatTimeTask(this);", "taskRepeat", "");
		var text = document.createTextNode("Wiederholen: ");
		var label = createLabel("taskRepeat", text);
		
		var p1 = document.createElement("p");
		p1.appendChild(input1);
		p1.appendChild(textfield);
		
		var p2 = document.createElement("p");
		p2.appendChild(label);
		p2.appendChild(checkbox);
		
		taskForm.appendChild(p1);
		taskForm.appendChild(p2);
	}
}

/*
	Create a new Event Task 
*/
function createEventTask(radio) {
	var taskForm = document.getElementById("TaskInput");
	// If Windows was changed befor, remove the changes
	if(taskForm.childNodes.length > 4) {
		for(var i = taskForm.childNodes.length; i > 4; i--) {
			taskForm.removeChild(taskForm.lastChild);
		}
	}
	
	if(taskForm.childNodes.length == 4) {
		// Button for a new Event
		var input1 = createButton("btn btn-default", "newEvent", "neues Event", "margin-right:6%; width:21%;", "newTaskNewEvent();", "", "");
		// Button to select a event
		var input2 = createButton("btn btn-default", "selectEvent", "Event auswählen", "width:21%;", "selectEventInModal();", "modal", "#newTaskSelectEvent");
		
		var p1 = document.createElement("p");
		p1.appendChild(input1);
		p1.appendChild(input2);
		
		taskForm.appendChild(p1);
	}
}

/*
	If a Time Task should repeat
*/
function repeatTimeTask(checkbox) {
	var taskForm = document.getElementById("TaskInput");
	if(checkbox.checked ==  true) {
		if(taskForm.childNodes.length == 6) {
			var input1 = createDateInput("taskeingabe", "taskEndDate")
			var input2 = createSelect("1", "taskIntervall");
			var option1 = createOption("Jeden Tag");
			var option2 = createOption("Jede Woche");
			var option3 = createOption("Jeden Monat");
			var option4 = createOption("Jedes Jahr");

			input2.appendChild(option1);
			input2.appendChild(option2);
			input2.appendChild(option3);
			input2.appendChild(option4);
			
			var p1 = document.createElement("p");
			var p2 = document.createElement("p");
			
			p1.appendChild(input1);
			p2.appendChild(input2);
			
			taskForm.appendChild(p1);
			taskForm.appendChild(p2);
		}
	} 
	if(checkbox.checked ==  false) {
		taskForm.removeChild(taskForm.lastChild);
		taskForm.removeChild(taskForm.lastChild);
	}
}

/*
	Create a new Issue when create a Task
*/
function createNewIssue() {
	var issueForm = document.getElementById("IssueInput");
	if(issueForm.childNodes.length > 2) {
		for(var i = issueForm.childNodes.length; i > 2; i--) {
			issueForm.removeChild(issueForm.lastChild);
		}
	}
	var textfield = createTextField("issueName", "", "Name");
	var input2 = createTextarea("IssueDescription", "Beschreibung", "issueDescription", "taskeingabe", "4");
	var p1 = document.createElement("p");
	var p2 = document.createElement("p");
	p1.setAttribute("id", "issueNameParagraph");
	p2.setAttribute("id", "issueDescriptionParagraph");
	
	p1.appendChild(textfield);
	p2.appendChild(input2);
		
	issueForm.appendChild(p1);
	issueForm.appendChild(p2);
}

/*
	Create a new Event when create a new Task
*/
function newTaskNewEvent() {
	var issueForm = document.getElementById("TaskInput");
	if(issueForm.childNodes.length > 5) {
		for(var i = issueForm.childNodes.length; i > 5; i--) {
			issueForm.removeChild(issueForm.lastChild);
		}
	}
	if(issueForm.childNodes.length == 5) {	
		var textfield = createTextField("newEventName", "", "Name");
		var p1 = document.createElement("p");
		p1.setAttribute("id", "newEventNameParagraph");
		p1.appendChild(textfield);
		issueForm.appendChild(p1);
	}
}

function selectIssueInModal() {
	var issueForm = document.getElementById("IssueInput");
	if(document.getElementById("issueNameParagraph")) {
		for(var i = issueForm.childNodes.length; i > 2; i--) {
			issueForm.removeChild(issueForm.lastChild);
		}
	}
}

function selectEventInModal() {
	if(document.getElementById("newEventNameParagraph")) {
		var taskForm = document.getElementById("TaskInput");
		taskForm.removeChild(document.getElementById("newEventNameParagraph"));
	}
}

function emptyNewTaskModal() {
	var body = document.getElementById("modalBodyNewTask");
	for(var i = body.childNodes.length; i > 0; i--) {
		body.removeChild(body.lastChild);
	}
	
	var form1 = document.createElement("form");
	var form2 = document.createElement("form");
	
	var h1 = document.createElement("h3");
	var h2 = document.createElement("h3");
	
	var p1 = document.createElement("p");
	var p2 = document.createElement("p");
	var p3 = document.createElement("p");
	var p4 = document.createElement("p");
	
	
	form1.setAttribute("action", "index.html");
	form1.setAttribute("method", "post");
	form1.setAttribute("name", "TaskInput");
	form1.setAttribute("id", "TaskInput");
	
	h1.setAttribute("style", "margin-top: 10px;");
	h1.appendChild(document.createTextNode("Task"));
	
	var input1 = createTextField("taskName", "", "Name");
	input1.setAttribute("class", "taskeingabe");
	p1.appendChild(input1);
	var textarea1 = createTextarea("taskDescriptionInput", "Beschreibung", "taskDescription", "taskeingabe", "4");
	p2.appendChild(textarea1);
	var button1 = createRadioButton("tasktype", "Timetask", "radioNewTimeTask", "createTimeTask(this);");
	var button2 = createRadioButton("tasktype", "Eventask", "radioNewEventTask", "createEventTask(this);");
	var label1 = createLabel("radioNewTimeTask", document.createTextNode("Zeitbasiert"));
	var label2 = createLabel("radioNewEventTask", document.createTextNode("Eventbasiert"));
	p3.appendChild(button1);
	p3.appendChild(label1);
	p3.appendChild(button2);
	p3.appendChild(label2);
	form1.appendChild(h1);
	form1.appendChild(p1);
	form1.appendChild(p2);
	form1.appendChild(p3);
	
	form2.setAttribute("action", "index.html");
	form2.setAttribute("method", "post");
	form2.setAttribute("id", "IssueInput");
	form2.setAttribute("name", "IssueInput");
	
	h2.appendChild(document.createTextNode("Issue"));
	h2.setAttribute("style", "margin-top: 10px;");
	
	var button3 = createButton("btn btn-default", "newIssue", "Neues Issue", "margin-right:6%; width:21%;", "createNewIssue();", "", "");
	button3.setAttribute("id", "selectNewIssue");
	var button4 =createButton("btn btn-default", "selectIssue", "Issue ausw\u00e4hlen", "width:21%;", "selectIssueInModal();", "modal", "#selectIssueForTask");
	button4.setAttribute("id", "selectSelectIssue");
	
	p4.appendChild(button3);
	p4.appendChild(button4);
	
	form2.appendChild(h2);
	form2.appendChild(p4);
	
	body.appendChild(form1);
	body.appendChild(form2);
}

function saveSelectedEvent() {
	var events = document.getElementsByName("selectEventForTask");
	for(var i = 0; i < events.length; i++) {
		if(events[i].checked == true) {
			var selected = events[i];
			break;
		}
	}
	var value = selected.value;
	$('#newTaskSelectEvent').modal('hide');
	var form = document.getElementById("TaskInput");
	form.appendChild(document.createTextNode(value));
}

function saveSelectedIssues() {
	var issues = document.getElementsByName("selectIssuesForTask");
	var a = 0;
	var selected = new Array();
	for(var i = 0; i < issues.length; i++) {
		if(issues[i].checked == true) {
			selected[a] = issues[i];
			a++;
		}
	}
	$('#selectIssueForTask').modal('hide');
	var form = document.getElementById("IssueInput");
	for(var i = 0; i < selected.length; i++) {
		form.appendChild(document.createTextNode(selected[i].value));
	}
}

function createNewTask() {
	var name = document.TaskInput.taskName.value;
	var des = document.TaskInput.taskDescription.value;
	var type = document.TaskInput.tasktype.value;
	if(type == "Timetask") {
		var day = document.TaskInput.TaskDate.value;
		var time = document.TaskInput.TaskTime.value;
		var repeat = document.TaskInput.taskRepeat.checked;
		if(repeat === true) {
			var endDate = document.TaskInput.taskEndDate.value;
			var intervall = document.TaskInput.taskIntervall.value;
		}
	} else if(type == "Eventtask") {
		var eventname = document.TaskInput.newEventName.value;
	}
	var issueName = document.IssueInput.issueName.value;
	var issueDes = document.IssueInput.issueDescription.value;
	
	var newTask = {
		"issueName": name,
		"issueDescription": des,
		"issueType": type,
	};
	
	console.log(newTask);
	$.ajax({
		dataType: "json",
		type: "POST",
		url: "http://localhost:8083/TaskScheduler/task",
		data: newTask,
	});
	
	//$('#newTaskModal').modal('hide');
}
