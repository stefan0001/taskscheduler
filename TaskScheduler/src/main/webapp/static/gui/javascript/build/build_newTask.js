/**
	Create a new Time Task 
**/
function createTimeTask(radio) {
	var taskForm = document.getElementById("TaskInput");
	for(var i = taskForm.childNodes.length; i > 4; i--) {
		taskForm.removeChild(taskForm.lastChild);
	}

	var input1 = createDateInput("taskeingabe", "TaskDate");
	var textfield = createTextField("TaskTime", "line-height: 34px; margin-left:3%;", "hh:mm", "", "")
	var p1 = document.createElement("p");
	p1.appendChild(input1);
	p1.appendChild(textfield);
	
	var input2 = createSelect("1", "taskIntervall");
	var option1 = createOption("Jede Stunde");
	var option2 = createOption("Jeden Tag");
	option2.setAttribute("checked", "true");
	var option3 = createOption("Jede Woche");
	var option4 = createOption("Zwei Wochen");

	input2.appendChild(option1);
	input2.appendChild(option2);
	input2.appendChild(option3);
	input2.appendChild(option4);
	input2.setAttribute("class", "taskeingabe");
	var p2 = document.createElement("p");
	p2.appendChild(input2);
		
	taskForm.appendChild(p1);
	taskForm.appendChild(p2);
}

/**
	Create a new Event Task 
**/
function createEventTask(radio) {
	var taskForm = document.getElementById("TaskInput");
	if(taskForm.childNodes.length > 4) {
		for(var i = taskForm.childNodes.length; i > 4; i--) {
			taskForm.removeChild(taskForm.lastChild);
		}
	}
	
	if(taskForm.childNodes.length == 4) {
		var input1 = createButton("btn btn-default", "newEvent", "newTaskNewEventButton", "neues Event", "margin-right:6%; width:21%;", "newTaskNewEvent();", "", "")
		var input2 = createButton("btn btn-default", "selectEvent", "newTaskSelectEventButton", "Event auswählen", "width:21%;", "selectEventInModal();", "modal", "#modalTwo")
		
		var p1 = document.createElement("p");
		p1.appendChild(input1);
		p1.appendChild(input2);
		
		taskForm.appendChild(p1);
	}
}

/**
	Create a new Issue when create a Task
**/
function createNewIssue(showIssue, exist) {
	var button1 = createButton("btn btn-default", "", "", "Abbrechen", "", "", "", "");
	button1.setAttribute("data-dismiss", "modal");
	var button2 = createButton("btn btn-primary", "", "", "Speichern", "", showIssue, "", "");
	if(exist == true) {
		buildModalThreeHeader("Neues Issue");
		buildModalThreeFooter(button1, button2);
		var body = document.getElementById("modalThreeBody");
	} else {
		buildModalTwoHeader("Neues Issue");
		buildModalTwoFooter(button1, button2);
		var body = document.getElementById("modalTwoBody");
	}
	for(var i = body.childNodes.length; i > 0; i--) {
		body.removeChild(body.lastChild);
	}
	var form = document.createElement("form");
	form.setAttribute("name", "newIssueForTaskFormular");
	var textfield = createTextField("issueName", "", "Name", "newIssueNameForTask", "");
	var input2 = createTextarea("IssueDescription", "Beschreibung", "issueDescription", "textarea", "4");
	var select = createSelect("1", "issueType");
	select.setAttribute("id", "newIssueTypForTask");
	select.setAttribute("class", "taskeingabe");
	var option1 = createOption("Bug");
	var option2 = createOption("Improvement");
	var option3 = createOption("Task");
	select.appendChild(option1);
	select.appendChild(option2);
	select.appendChild(option3);
	var p1 = document.createElement("p");
	var p2 = document.createElement("p");
	var p3 = document.createElement("p");
	p1.setAttribute("id", "issueNameParagraph");
	p2.setAttribute("id", "issueDescriptionParagraph");
	p3.setAttribute("id", "issueTypeParagraph");
	
	p1.appendChild(textfield);
	p2.appendChild(input2);
	p3.appendChild(select);
	
	form.appendChild(p1);
	form.appendChild(p2);
	form.appendChild(p3);
	
	body.appendChild(form);
}

/**
 * notice New Issues
 */
function saveNewIssueForTask() {
	var name = document.newIssueForTaskFormular.issueName.value;
	var des = document.newIssueForTaskFormular.issueDescription.value;
	var type = document.newIssueForTaskFormular.issueType.value;
	
	var form = document.getElementById("IssueInput");
	if(form.lastChild.getAttribute("id") == "selectIssuesForTaskTable" || form.lastChild.getAttribute("id") == null) {
		for(var i = form.childNodes.length; i > 2; i--) {
			form.removeChild(form.lastChild);
		}
		var div = document.createElement("div");
		div.setAttribute("class", "panel panel-default");
		div.setAttribute("id", "NewIssuesForTaskTable");
		var table = document.createElement("table");
		table.setAttribute("class", "table");
		var tbody = document.createElement("tbody");
		tbody.setAttribute("id", "newIssuesForTaskTableBody")
		var th = document.createElement("th");
		th.appendChild(document.createTextNode("Issues"));
		th.setAttribute("colspan", "3");
		var tr = document.createElement("tr");
		tr.appendChild(th);
		tbody.appendChild(tr);
		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		td1.appendChild(document.createTextNode(name));
		td2.appendChild(document.createTextNode(des));
		td3.appendChild(document.createTextNode(type));
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tbody.appendChild(tr);
		table.appendChild(tbody);
		div.appendChild(table);
		form.appendChild(div);
	} else {
		var body = document.getElementById("newIssuesForTaskTableBody");
		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		td1.appendChild(document.createTextNode(name));
		td2.appendChild(document.createTextNode(des));
		td3.appendChild(document.createTextNode(type));
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		body.appendChild(tr);
	}	
	$('#modalTwo').modal('hide');
}

/**
	Create a new Event when create a new Task
**/
function newTaskNewEvent() {
	var issueForm = document.getElementById("TaskInput");
	if(issueForm.childNodes.length > 5) {
		for(var i = issueForm.childNodes.length; i > 5; i--) {
			issueForm.removeChild(issueForm.lastChild);
		}
	}
	if(issueForm.childNodes.length == 5) {	
		var textfield = createTextField("newEventName", "", "Name", "", "");
		var p1 = document.createElement("p");
		p1.setAttribute("id", "newEventNameParagraph");
		p1.appendChild(textfield);
		issueForm.appendChild(p1);
	}
}

/**
 * remove Noticed Issues 
 */
function selectIssueInModal() {
	var issueForm = document.getElementById("IssueInput");
	if(document.getElementById("issueNameParagraph")) {
		for(var i = issueForm.childNodes.length; i > 2; i--) {
			issueForm.removeChild(issueForm.lastChild);
		}
	}
}

/**
 * build Modal to select Issues for new task
 */
function buildSelectIssueModal(data, existTask) {
	console.log(existTask);
	var button1 = createButton("btn btn-default", "", "", "Abbrechen", "", "", "", "");
	button1.setAttribute("data-dismiss", "modal");
	if(existTask == true) {
		var button2 = createButton("btn btn-primary", "", "", "Speichern", "", "saveSelectedIssuesForExistingTimeTask();", "", "");
	} else {
		var button2 = createButton("btn btn-primary", "", "", "Speichern", "", "saveSelectedIssues();", "", "");
	}
	if(existTask == true) {
		var body = document.getElementById("modalThreeBody");
		buildModalThreeHeader("Issue ausw\u00e4hlen");
		buildModalThreeFooter(button1, button2);
	} else {
		var body = document.getElementById("modalTwoBody");
		buildModalTwoHeader("Issue ausw\u00e4hlen");
		buildModalTwoFooter(button1, button2);
	}
	for(var i = body.childNodes.length; i > 0; i--) {
		body.removeChild(body.lastChild);
	}
	var div = document.createElement("div");
	div.setAttribute("style", "margin-bottom:20px;");
	var filterInput = createTextField("filterIssueDraftForTask", "margin-right:10px;", "Issue Name", "filterIssueDraftForTask", "");
	var submitButton = createButton("btn btn-default", "filterIssueDraftForTask", "", "Suchen", "", "filterIssueDrafts("+existTask+");", "", "");
	div.appendChild(filterInput);
	div.appendChild(submitButton);
	body.appendChild(div);
	var div = document.createElement("div");
	div.setAttribute("class", "panel panel-default");
	var table = document.createElement("table");
	table.setAttribute("class", "table");
	var tbody = document.createElement("tbody");
	var row = document.createElement("tr");
	var th1 = document.createElement("th");
	var th2 = document.createElement("th");
	var th3 = document.createElement("th");
	var th4 = document.createElement("th");
	var th5 = document.createElement("th");
	th1.setAttribute("width", "6%");
	th2.setAttribute("width", "26%");
	th3.setAttribute("width", "58%");
	th4.setAttribute("width", "10%");
	th1.appendChild(document.createTextNode("#"));
	th2.appendChild(document.createTextNode("Name"));
	th3.appendChild(document.createTextNode("Beschreibung"));
	th5.appendChild(document.createTextNode("Typ"));
	th4.appendChild(document.createTextNode("ausw\u00e4hlen"));
	row.appendChild(th1);
	row.appendChild(th2);
	row.appendChild(th3);
	row.appendChild(th5);
	row.appendChild(th4);
	tbody.appendChild(row);
	for(var i = 0; i < data.content.length; i++) {
		var row = document.createElement("tr");
		var td1 = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		var td4 = document.createElement("td");
		var td5 = document.createElement("td");
		td1.appendChild(document.createTextNode(data.content[i].ID));
		td2.appendChild(document.createTextNode(data.content[i].issueName));
		td3.appendChild(document.createTextNode(data.content[i].issueDescription));
		td5.appendChild(document.createTextNode(data.content[i].issueType));
		td4.appendChild(createCheckbox(data.content[i].id+"selectIssuesForTask", "", "selectIssuesForTask", data.content[i].issueName));
		row.appendChild(td1);
		row.appendChild(td2);
		row.appendChild(td3);
		row.appendChild(td5);
		row.appendChild(td4);
		tbody.appendChild(row);
	}
	table.appendChild(tbody);
	div.appendChild(table);
	body.appendChild(div);
}

/**
 * remove event input
 */
function selectEventInModal() {
	if(document.getElementById("newEventNameParagraph")) {
		var taskForm = document.getElementById("TaskInput");
		taskForm.removeChild(document.getElementById("newEventNameParagraph"));
	}
}

/**
 * build the Modal to create a new task
 */
function emptyNewTaskModal() {
	var body = document.getElementById("modalOneBody");
	buildModalOneHeader("Neuer Task");
	var button1 = createButton("btn btn-default", "", "", "Abbrechen", "", "", "", "");
	button1.setAttribute("data-dismiss", "modal");
	var button2 = createButton("btn btn-primary", "", "", "Speichern", "", "createNewTask();", "", "");
	buildModalOneFooter(button1, button2)
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
	
	var input1 = createTextField("TaskName", "", "Name", "newTaskName", "");
	p1.appendChild(input1);
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
	
	var button3 = createButton("btn btn-default", "newIssue", "selectNewIssue", "Neues Issue", "margin-right:6%; width:21%;", "createNewIssue('saveNewIssueForTask()');", "modal", "#modalTwo");
	var button4 =createButton("btn btn-default", "selectIssue", "selectSelectIssue", "Issue ausw\u00e4hlen", "width:21%;", "interaction.getAllIssueDraft();", "modal", "#modalTwo");
	
	p4.appendChild(button3);
	p4.appendChild(button4);
	
	form2.appendChild(h2);
	form2.appendChild(p4);
	
	body.appendChild(form1);
	body.appendChild(form2);
}

/**
 * Notice selected Event for new task
 */
function saveSelectedEvent() {
	var events = document.getElementsByName("selectEventForTask");
	for(var i = 0; i < events.length; i++) {
		if(events[i].checked == true) {
			var selected = events[i];
			break;
		}
	}
	var value = selected.value;
	$('#modalTwo').modal('hide');
	var form = document.getElementById("TaskInput");
	form.appendChild(document.createTextNode(value));
}

/**
 * Notice Selected Issues for new Task
 */
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
	$('#modalTwo').modal('hide');
	var form = document.getElementById("IssueInput");
	
	for(var i = form.childNodes.length; i > 2; i--) {
		form.removeChild(form.lastChild);
	}
	
	var div = document.createElement("div");
	div.setAttribute("id", "selectIssuesForTaskTable");
	div.setAttribute("class", "panel panel-default");
	var table = document.createElement("table");
	table.setAttribute("class", "table");
	var tbody = document.createElement("tbody");
	tbody.setAttribute("id", "selectedIssuesForTaskTableBody");
	var th = document.createElement("th");
	th.setAttribute("colspan", "4");
	th.appendChild(document.createTextNode("Issues"))
	var tr = document.createElement("tr");
	tr.appendChild(th);
	tbody.appendChild(tr);
	for(var i = 0; i < selected.length; i++) {
		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		var td4 = document.createElement("td");
		var id = selected[i].parentNode.previousSibling.previousSibling.previousSibling.previousSibling.firstChild.nodeValue;
		var des = selected[i].parentNode.previousSibling.previousSibling.firstChild.nodeValue;
		var typ = selected[i].parentNode.previousSibling.firstChild.nodeValue;
		td1.appendChild(document.createTextNode(id));		
		td2.appendChild(document.createTextNode(selected[i].value));
		td3.appendChild(document.createTextNode(des));
		td4.appendChild(document.createTextNode(typ));
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tbody.appendChild(tr);
	}
	table.appendChild(tbody);
	div.appendChild(table);
	form.appendChild(div);
}

/**
 * Write a New task in Database
 */
function createNewTask() {
	if(document.TaskInput.tasktype[1].checked == true) {
		var type = "Eventask";
	} else if(document.TaskInput.tasktype[0].checked == true) {
		var type = "Timetask";
	}
	if(type == "Timetask") {
		var name = document.TaskInput.TaskName.value;
		var date = document.TaskInput.TaskDate.value;
		if(date.charAt(2) == ".") {
			var splitDate = date.split(".");
			var day = splitDate[0];
			var month = splitDate[1];
			var year = splitDate[2];
		} else {
			var splitDate = date.split("-");
			var day = splitDate[2];
			var month = splitDate[1];
			var year = splitDate[0];
		}
		var time = document.TaskInput.TaskTime.value;
		var splitTime = time.split(":");
		var hour = splitTime[0];
		var min = splitTime[1];
		var firstDate = new Date(year, month-1, day, hour, min, 0);
		var firstDateInMilliSeconds = firstDate.getTime();
		var intervall = document.TaskInput.taskIntervall.value;
		if(intervall == "Jede Stunde") {
			var stdIntervall = 3600;
		} else if(intervall == "Jeden Tag") {
			var stdIntervall = 86400;
		} else if(intervall == "Jede Woche") {
			var stdIntervall = 604800;
		} else if(intervall == "Zwei Wochen") {
			var stdIntervall = 1209600;
		}
		var json = JSON.stringify({name: name, firstFireTime: firstDateInMilliSeconds, intervall: stdIntervall, activated: "true"});
		interaction.createNewTimeTask(json);
	} else if(type == "Eventask") {
		var eventname = document.TaskInput.newEventName.value;
		var json = JSON.stringify({name: eventname});
		interaction.createNewEvent(json);
	}	
	$('#modalOne').modal('hide');
}

/**
 * Create a Task for a Event
 * @param data the Event
 */
function createTaskForEvent(data) {
	var idAt = data.search(/ID/);
	var id = data.slice(idAt+4, idAt+6);
	var idFinal = id;
	if(id.charAt(1) == ",") {
		idFinal = id.slice(0, 1);
	}
	var name = document.TaskInput.TaskName.value;
	var json = JSON.stringify({name: name});
	interaction.createNewEventTask(idFinal, json);
}

/**
 * Create Issues for a Time Task
 * @param data the Time Task
 */
function createIssueForTimeTask(data) {
	var idAt = data.search(/ID/);
	var slice = data.slice(idAt+4, idAt+6);
	var id = slice;
	if(slice.charAt(1) == ",") {
		id = slice.slice(0, 1);
	}
	var form = document.getElementById("IssueInput");
	var tbody = document.getElementById("newIssuesForTaskTableBody");
	if(document.getElementById("newIssuesForTaskTableBody")) {
		var tbody = document.getElementById("newIssuesForTaskTableBody");
		if(form.lastChild.getAttribute("id") == "NewIssuesForTaskTable") {
			for(var i = 1; i < tbody.childNodes.length; i++) {
				var name = tbody.childNodes[i].childNodes[0].firstChild.nodeValue;
				var des = tbody.childNodes[i].childNodes[1].firstChild.nodeValue;
				var type = tbody.childNodes[i].childNodes[2].firstChild.nodeValue;
				var json = JSON.stringify({issueName: name, issueDescription: des, issueType: type.toUpperCase()});
				interaction.postNewIssueDraftForTimeTask(id, json);
			}
		}
	} else if(document.getElementById("selectedIssuesForTaskTableBody")) {
		var tbody = document.getElementById("selectedIssuesForTaskTableBody");
		if(form.lastChild.getAttribute("id") == "selectIssuesForTaskTable") {
			for(var i = 1; i < tbody.childNodes.length; i++) {
				var issueId = tbody.childNodes[i].childNodes[0].firstChild.nodeValue;
				var json = JSON.stringify({ID: issueId});
				interaction.postExistentIssueDraftForTimeTask(id, json);
			}
		}
	}
}

/**
 * Create issues for Event Task
 * @param data the Event Task
 */
function createIssueForEventTask(data) {
	console.log(data);
	var idAt = data.search(/ID/);
	var slice = data.slice(idAt+4, idAt+6);
	var id = slice;
	if(slice.charAt(1) == ",") {
		id = slice.slice(0, 1);
	}
	var form = document.getElementById("IssueInput");
	if(document.getElementById("newIssuesForTaskTableBody")) {
		var tbody = document.getElementById("newIssuesForTaskTableBody");
		if(form.lastChild.getAttribute("id") == "NewIssuesForTaskTable") {
			for(var i = 1; i < tbody.childNodes.length; i++) {
				var name = tbody.childNodes[i].childNodes[0].firstChild.nodeValue;
				var des = tbody.childNodes[i].childNodes[1].firstChild.nodeValue;
				var type = tbody.childNodes[i].childNodes[2].firstChild.nodeValue;
				var json = JSON.stringify({issueName: name, issueDescription: des, issueType: type.toUpperCase()});
				interaction.postNewIssueDraftForEventTask(id, json);
			}
		}
	} else if(document.getElementById("selectedIssuesForTaskTableBody")) {
		var tbody = document.getElementById("selectedIssuesForTaskTableBody");
		if(form.lastChild.getAttribute("id") == "selectIssuesForTaskTable") {
			for(var i = 1; i < tbody.childNodes.length; i++) {
				var issueId = tbody.childNodes[i].childNodes[0].firstChild.nodeValue;
				var json = JSON.stringify({ID: issueId});
				interaction.postExistentIssueDraftForEventTask(id, json);
			}
		}
	}
}
