function start() {
	interaction.displayAllIssueEntities();
	interaction.displayAllIssueDrafts();
}

/*
	Statistic, how many Issues are in a Container
*/
function countIssueContainer() {
	var countTodo = (document.getElementById("accordion1").childNodes.length)-3;
	var countWik = (document.getElementById("accordion2").childNodes.length)-3;
	var countDone = (document.getElementById("accordion3").childNodes.length)-3;

	document.getElementById("todoBadge").appendChild(document.createTextNode(countTodo));
	document.getElementById("wikBadge").appendChild(document.createTextNode(countWik));
	document.getElementById("doneBadge").appendChild(document.createTextNode(countDone));
}

function showIssueFromDatabase(id, status, resolution, tid, name, description, type) {
	if(status == "NEW") {
		var accordion = "accordion1";
	} else if(status == "IN_PROGRESS") {
		var accordion = "accordion2";
	} else if(status == "DONE") {
		var accordion = "accordion3"
	}
	
	var div1 = document.createElement("div");
	var div2 = document.createElement("div");
	var div3 = document.createElement("div");
	var div4 = document.createElement("div");
	var heading = document.createElement("h6");
	var link = document.createElement("a");
	var button = document.createElement("button");
	
	div1.setAttribute("class", "panel panel-default");
	div2.setAttribute("class", "panel-heading");
	div3.setAttribute("id", id);
	div3.setAttribute("class", "panel-collapse collapse");
	div4.setAttribute("class", "panel-body");
	
	heading.setAttribute("class", "panel-title");
	
	link.setAttribute("data-toggle", "collapse");
	link.setAttribute("data-parent", "#"+accordion);
	link.setAttribute("href", "#"+id);
	
	button.setAttribute("class", "editIssue");
	button.setAttribute("data-toggle", "modal");
	button.setAttribute("data-target", "#editIssue");

	var form = document.createElement("form");
	form.setAttribute("method", "get");
	form.setAttribute("action", "");
	form.setAttribute("style", "display:inline;");
	form.setAttribute("onsubmit", "send(this.id); return false;");
	
	var hidden = document.createElement("input");
	hidden.setAttribute("type", "hidden");
	hidden.setAttribute("name", "id");
	hidden.setAttribute("value", id);
	
	form.appendChild(hidden);
	form.appendChild(button);
	div4.appendChild(form);
	div4.appendChild(document.createTextNode(description+' '));
	
	
	div3.appendChild(div4);
	
	link.appendChild(document.createTextNode(name));
	heading.appendChild(link);
	
	div2.appendChild(heading);
	
	div1.appendChild(div2);
	div1.appendChild(div3);
	
	var acc = document.getElementById(accordion);
	acc.appendChild(div1);
}

/*
	Create the View of an Issue
*/
function showIssue(name, description, href, accordion, issueId, status, resolution, templateId, typ) {
	var div1 = document.createElement("div");
	var div2 = document.createElement("div");
	var div3 = document.createElement("div");
	var div4 = document.createElement("div");
	var heading = document.createElement("h6");
	var link = document.createElement("a");
	var button = document.createElement("button");
	
	div1.setAttribute("class", "panel panel-default");
	div2.setAttribute("class", "panel-heading");
	div3.setAttribute("id", href);
	div3.setAttribute("class", "panel-collapse collapse");
	div4.setAttribute("class", "panel-body");
	
	heading.setAttribute("class", "panel-title");
	
	link.setAttribute("data-toggle", "collapse");
	link.setAttribute("data-parent", "#"+accordion);
	link.setAttribute("href", "#"+href);
	
	button.setAttribute("class", "editIssue");
	button.setAttribute("data-toggle", "modal");
	button.setAttribute("data-target", "#editIssue");

	var form = document.createElement("form");
	form.setAttribute("method", "get");
	form.setAttribute("action", "");
	form.setAttribute("style", "display:inline;");
	form.setAttribute("onsubmit", "send(this.id); return false;");
	
	var hidden = document.createElement("input");
	hidden.setAttribute("type", "hidden");
	hidden.setAttribute("name", "id");
	hidden.setAttribute("value", href);
	
	form.appendChild(hidden);
	form.appendChild(button);
	div4.appendChild(form);
	div4.appendChild(document.createTextNode(description+' '));
	
	
	div3.appendChild(div4);
	
	link.appendChild(document.createTextNode(name));
	heading.appendChild(link);
	
	div2.appendChild(heading);
	
	div1.appendChild(div2);
	div1.appendChild(div3);
	
	var acc = document.getElementById(accordion);
	acc.appendChild(div1);
}

/*
	Send the Issue that should edited to the editIssue modal
*/
function send(box) {
	var modal = document.getElementById("modalBodyEditIssue");
	for(var i = modal.childNodes.length; i > 0; i--) {
		modal.removeChild(modal.lastChild);
	}
	var data = display.getData();
	for( var i = 0; i < data.length; i++ ) {
		if(data[i].content.id == box.value) {
			buildEditIssue(i);
		}
	}
}

function buildEditIssue(value) {
	var modal = document.getElementById("modalBodyEditIssue");
	var objects = display.getData();
	var data = objects[value];
	
	var table = document.createElement("table");
	var row1 = document.createElement("tr");
	var row2 = document.createElement("tr");
	var col1 = document.createElement("td");
	var col2 = document.createElement("td");
	var col3 = document.createElement("td");
	var col4 = document.createElement("td");
	var div = document.createElement("div");
	div.setAttribute("class", "panel panel-default");
	div.setAttribute("id", "modalEditIssueTable");
	var buttonTasks = createButton("btn btn-default", value+"issueUsedByTasks", "Tasks", "", "openTasksOfIssue(this.getAttribute('name'))", "", "");
	buttonTasks.setAttribute("id", "buttonShowTasksOfIssue")
	table.setAttribute("class", "table");
	col1.setAttribute("width", "20%");
	
	col2.setAttribute("id", "modalEditIssueColumn2");
	col4.setAttribute("id", "modalEditIssueColumn4");
	
	var button = createButton("editIssue", "editModalIssue", "", "", "editModalIssue("+value+");", "", "");
	button.setAttribute("id", "editModalIssue");
	
	col1.appendChild(document.createTextNode("Name:"));
	col2.appendChild(document.createTextNode(data.embedded[0].content.issueName));
	col3.appendChild(document.createTextNode("Beschreibung:"));
	col4.appendChild(document.createTextNode(data.embedded[0].content.issueDescription));

	row1.appendChild(col1);
	row1.appendChild(col2);
	row2.appendChild(col3);
	row2.appendChild(col4);
	
	var tbody = document.createElement('tbody');
	tbody.appendChild(row1);
	tbody.appendChild(row2);
	
	table.appendChild(tbody);
	div.appendChild(table);
	modal.appendChild(button);
	modal.appendChild(div);
	modal.appendChild(buttonTasks);
	
}

function openTasksOfIssue(issue) {
	var id = issue.slice(0, 1);
	$('#editIssue').modal('hide');
	$('#tasksOfAnIssue').modal('show');
	var modal = document.getElementById('tasksOfAnIssue');
	var body = document.getElementById('modalBodyTasksOfAnIssue');
	for(var i = body.childNodes.length; i > 0; i--) {
		body.removeChild(body.lastChild);
	}
	var table = document.createElement('table');
	table.setAttribute("class", "table");
	var tbody = document.createElement('tbody');
	var row1 = document.createElement('tr');
	var row2 = document.createElement('tr');
	var th1 = document.createElement('th');
	var th2 = document.createElement('th');
	var th3 = document.createElement('th');
	th1.appendChild(document.createTextNode("#"));
	th2.appendChild(document.createTextNode("Name"));
	th3.appendChild(document.createTextNode("bearbeiten"));
	row1.appendChild(th1);
	row1.appendChild(th2);
	row1.appendChild(th3);
	tbody.appendChild(row1);
	
	// show single Task
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");
	td1.appendChild(document.createTextNode("1"));
	td2.appendChild(document.createTextNode("Test"));
	
	var button = createButton("editIssue", "editTask", "", "", "buildEditTask()", "", "");
	td3.appendChild(button);
	
	row2.appendChild(td1);
	row2.appendChild(td2);
	row2.appendChild(td3);
	tbody.appendChild(row2);
	table.appendChild(tbody);
	var div = document.createElement("div");
	div.setAttribute("class", "panel panel-default");
	div.appendChild(table);
	body.appendChild(div);
}

function editModalIssue(value) {
	var col1 = document.getElementById("modalEditIssueColumn2");
	var col2 = document.getElementById("modalEditIssueColumn4");
	
	var text1 = col1.innerHTML;
	var text2 = col2.innerHTML;
	
	var input1 = createTextField("editIssueModalName", "taskeingabe", "");
	input1.setAttribute("value", text1);
	input1.setAttribute("id", "editIssueModalName");
	var input2 = createTextField("editIssueModalDes", "taskeingabe", "");
	input2.setAttribute("value", text2);
	input2.setAttribute("id", "editIssueModalDes");
	
	col1.removeChild(col1.lastChild);
	col2.removeChild(col2.lastChild);
	col1.appendChild(input1);
	col2.appendChild(input2);
	
	var button = document.getElementById('buttonShowTasksOfIssue');
	var button1 = document.getElementById('editModalIssue');
	var body = document.getElementById("modalBodyEditIssue");
	body.removeChild(button);
	body.removeChild(button1);
	
	var newButton = createButton("btn btn-primary", "saveIssueChanges", "OK", "", "saveIssueChanges("+value+")", "", "");
	newButton.setAttribute("id", "saveIssueChanges");
	var modalFooter = document.getElementById('editIssueModalFooter');
	modalFooter.replaceChild(newButton, document.getElementById('saveEditedIssue'));
}

function saveIssueChanges(value) {
	var name = document.getElementById('editIssueModalName').value;
	var des = document.getElementById('editIssueModalDes').value;
	
	document.getElementById('modalEditIssueColumn2').replaceChild(document.createTextNode(name), document.getElementById('editIssueModalName'));
	document.getElementById('modalEditIssueColumn4').replaceChild(document.createTextNode(des), document.getElementById('editIssueModalDes'));

	var newButton = createButton("btn btn-primary", "saveEditedIssue", "Speichern", "", "$('#editIssue').modal('hide');", "", "");
	newButton.setAttribute("id", "saveEditedIssue");
	document.getElementById('editIssueModalFooter').replaceChild(newButton, document.getElementById("saveIssueChanges"));
	
	var buttonTasks = createButton("btn btn-default", value+"issueUsedByTasks", "Tasks", "", "openTasksOfIssue(this.getAttribute('name'))", "", "");
	buttonTasks.setAttribute("id", "buttonShowTasksOfIssue");
	document.getElementById("modalBodyEditIssue").appendChild(buttonTasks);
	var editButton = createButton("editIssue", "editModalIssue", "", "", "editModalIssue("+value+");", "", "");
	editButton.setAttribute("id", "editModalIssue");
	document.getElementById("modalBodyEditIssue").insertBefore(editButton, document.getElementById('modalEditIssueTable'));
}

/*
	Cerate an Issue Object
*/
function Issue(name, description, href, accordion, issueId, status, resolution, templateId, type) {
	this.name = name;
	this.description = description;
	this.href = href;
	this.accordion = accordion;
	showIssue(name, description, href, accordion);
}

function changeShowStatus(checkboxClicked) {
	var id = checkboxClicked.id;
	var spalte = "";
	if(id === "showStatusTodo") {
		spalte = document.getElementById("columnTodo");
	} else if(id === "showStatusInProgress") {
		spalte = document.getElementById("columnInProgress");
	} else if(id === "showStatusDone") {
		spalte = document.getElementById("columnDone");
	}
	
	var zeile = document.getElementById("issueTableRow");
	
	if(checkboxClicked.checked === true) {
		var boolTodoCol = false;
		var boolProgressCol = false;
		var boolDoneCol = false;
		var count = 0;
		var width = "80%";
		
		if (document.getElementById('columnTodo')) {
			boolTodoCol = true;
			count++;
		}
		if (document.getElementById('columnInProgress')) {
			boolProgressCol = true;
			count++;
		}
		if (document.getElementById('columnDone')) {
			boolDoneCol = true;
			count++;
		}
		
		if(count == 1) {
			width = "90%";
		} else if (count == 2) {
			width = "80%";
		} else {
			width = "100%";
		}
		
		if(id === "showStatusTodo") {
			if(boolProgressCol == true) {
				zeile.insertBefore(data.getColumn1(), document.getElementById('columnInProgress'));
				if(count == 1) {
					document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour right");
					document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour right");
					document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader right");
				}
			} else if(boolDoneCol == true) {
				zeile.insertBefore(data.getColumn1(), document.getElementById('columnDone'));
			}
		} else if(id === "showStatusInProgress") {
			if(boolDoneCol == true) {
				zeile.insertBefore(data.getColumn2(), document.getElementById('columnDone'));
				if(boolTodoCol == false) {
					document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour left");
					document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour left");
					document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader left");
				} else {
					document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour");
					document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour");
					document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader");
				}
			} else if(boolTodoCol == true) {
				if(boolDoneCol == false) {
					zeile.appendChild(data.getColumn2());
					document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour right");
					document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour right");
					document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader right");
				} else {
					document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour");
					document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour");
					document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader");
				}
			}
		} else if(id === "showStatusDone") {
			zeile.appendChild(data.getColumn3());
			if(count === 1 && boolProgressCol === true) {
				document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour left");
				document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour left");
				document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader left");
			}
		}
		
		if(count === 2) {
			document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour");
			document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour");
			document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader");
		}
		
		for(var i = 0; i < document.getElementsByName("adjustSize").length; i++) {
			document.getElementsByName("adjustSize")[i].setAttribute("style", "width:"+width);
		}
		

	} else {
		if(zeile.childNodes.length > 5) {
			if(id === "showStatusTodo") {
				data.setColumn1(spalte);
			} else if(id === "showStatusInProgress") {
				data.setColumn2(spalte);
			} else if(id === "showStatusDone") {
				data.setColumn3(spalte);
			}
			zeile.removeChild(spalte);
			
			var boolTodoCol = false;
			var boolProgressCol = false;
			var boolDoneCol = false;
			var count = 0;
			var width = "80%";
			if (document.getElementById('columnTodo')) {
				boolTodoCol = true;
				count++;
			}
			if (document.getElementById('columnInProgress')) {
				boolProgressCol = true;
				count++;
			}
			if (document.getElementById('columnDone')) {
				boolDoneCol = true;
				count++;
			}
			if(count == 1) {
				width = "100%";
			} else if (count == 2) {
				width = "90%";
			}
			for(var i = 0; i < document.getElementsByName("adjustSize").length; i++) {
				document.getElementsByName("adjustSize")[i].setAttribute("style", "width:"+width);
			}
			if(boolProgressCol == true) {
				if(boolTodoCol == true) {
					document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour right");
					document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour right");
					document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader right");
				} else if(boolDoneCol == true) {
					document.getElementById("adjustSizeInProgress1").setAttribute("class", "issueContainerHeaderBackground issueContainerColour left");
					document.getElementById("adjustSizeInProgress2").setAttribute("class", "issueContainer issueContainerColour left");
					document.getElementById("adjustSizeInProgress3").setAttribute("class", "issueContainerHeader left");
				}
			}
			
		} else {
			checkboxClicked.checked = true;
		}
	}
}