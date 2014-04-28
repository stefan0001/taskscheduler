/*
	At the Task overview, view the Time Tasks
*/
function selectTimeTaskView() {
	var div = document.getElementById("taskOverview");

	// If the Windows was changed before, clear it
	if(div.childNodes.length > 3) {
		for(var i = div.childNodes.length; i > 3; i--) {
			div.removeChild(div.lastChild);
		}
	}
	
	if(document.getElementById("radioTimeTasks").checked == true && div.childNodes.length == 3) {
		var weekdaysDe = ["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"];
		var weekdaysEngl = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
		var p = document.createElement("p");
		for(var i = 0; i < 7; i++) {
			var check = createCheckbox("checkDayTaskView"+i, "taskViewSelectDay(this);", "weekday", weekdaysEngl[i].toLowerCase());
			var label = createLabel("checkDayTaskView"+i, document.createTextNode(weekdaysDe[i]));
			p.appendChild(check);
			p.appendChild(label);
		}
		
		div.appendChild(p);
	}
}

/*
	Show a Day in the Time-Task View
*/
function taskViewSelectDay(check) {
	var weekdaysValue = {
		"monday": 1, 
		"tuesday": 2, 
		"wednesday": 3, 
		"thursday": 4, 
		"friday": 5, 
		"saturday": 6, 
		"sunday":7 };
		
	var weekdaysTrans = {
		"monday": "Montag", 
		"tuesday": "Dienstag", 
		"wednesday": "Mittwoch", 
		"thursday": "Donnerstag", 
		"friday": "Freitag", 
		"saturday": "Samstag", 
		"sunday": "Sonntag" };
		
	var divOverview = document.getElementById("taskOverview");
	if(check.checked == true) {
		var button = createButton("btn btn-default btn-lg btn-block", "", "", "width:90%; display: inline;", "", "modal", "#editTask");
		button.appendChild(document.createTextNode("Task"));

		var span = document.createElement("span");
		span.setAttribute("class", "glyphicon glyphicon-trash");
		
		var button2 = createButton("btn btn-lg deleteTaskButton", "", "", "width:8%", "", "", "");
		button2.appendChild(span);
		
		var p = document.createElement("p");
		p.setAttribute("id", weekdaysValue[check.getAttribute('value')]+"taskView"+check.getAttribute('value'));
		
		var heading = document.createElement("h3");
		heading.setAttribute("style", "margin-bottom:2px;");
		heading.appendChild(document.createTextNode(weekdaysTrans[check.getAttribute('value')]));
		
		var div = document.createElement("div");
		div.setAttribute("style", "width:100%; border-bottom:solid #adadad 1px; padding-bottom: 0px; margin-bottom:10px;");
		
		div.appendChild(heading);
		
		p.appendChild(div);
		p.appendChild(button);
		p.appendChild(button2);
		
		var length = divOverview.childNodes.length;
		for(var i = 1; i < length; i++) {
			if(divOverview.childNodes[i].nodeName != "#text") {
				if(divOverview.childNodes[i].getAttribute("id") != null) {
				
					if(divOverview.childNodes[i].getAttribute("id").slice(0, 1) >= weekdaysValue[check.getAttribute('value')]+1) {
						divOverview.insertBefore(p, divOverview.childNodes[i]);
						return;
					}
				}
			}
			if(i === length-1) {
				divOverview.appendChild(p);
			}		
		}
	}
	if(check.checked == false) {
		var length = divOverview.childNodes.length;
		for(var i = 1; i <= length; i++) {
			if(divOverview.childNodes[i].nodeName != "#text") {
				if(divOverview.childNodes[i].getAttribute("id") === weekdaysValue[check.getAttribute('value')]+"taskView"+check.getAttribute('value')) {
					divOverview.removeChild(divOverview.childNodes[i]);
				}
			}
		}
	}
}

/*
	Show the Event Tasks in the Task View
*/
function selectEventTaskView() {
	var div = document.getElementById("taskOverview");
	if(div.childNodes.length > 3) {
		for(var i = div.childNodes.length; i > 3; i--) {
			div.removeChild(div.lastChild);
		}
		
	}
	
	if(document.getElementById("radioEventTasks").checked == true && div.childNodes.length == 3) {
		var div1 = document.createElement("div");
		var table = document.createElement("table");
		var row1 = document.createElement("tr");
		var row2 = document.createElement("tr");
		var column1 = document.createElement("th");
		var column2 = document.createElement("th");
		var column3 = document.createElement("td");
		var column4 = document.createElement("td");
		var tbody = document.createElement("tbody");
		div1.setAttribute("class", "panel panel-default");
		table.setAttribute("class", "table");
		column1.setAttribute("width", "10%");
		column2.setAttribute("width", "90%");
		
		column1.appendChild(document.createTextNode("#"));
		column2.appendChild(document.createTextNode("Name"));
		column3.appendChild(document.createTextNode("1"));
		column4.appendChild(document.createTextNode("Neuer Mitarbeiter"));
		
		row1.appendChild(column1);
		row1.appendChild(column2);
		row2.appendChild(column3);
		row2.appendChild(column4);
		
		tbody.appendChild(row1);
		tbody.appendChild(row2);

		table.appendChild(tbody);
	
		div1.appendChild(table);
		
		var p = document.createElement("p");
		p.appendChild(div1);
		
		div.appendChild(p);
	}
}