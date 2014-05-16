/**
 * Gets the selected Issue from Database 
 **/
function getToEditIssue(value) {
	console.log(value);
	interaction.getIssueEntityById(value);
}

/**
 * Build the Modal to Edit an Issue
 **/
function buildEditIssue(data) {	
	console.log(data);
	// Build the Header and Footer
	var button1 = createButton("btn btn-default", "", "", "Abbrechen", "", "", "", "")
	button1.setAttribute("data-dismiss", "modal");
	var button2 = createButton("btn btn-primary", "", "saveEditedIssue", "Speichern", "", "saveEditedIssue("+data.ID+", "+data.embedded.issueDraft.ID+");", "", "")
	buildModalOneFooter(button1, button2);
	buildModalOneHeader("Issue bearbeiten");
	// Build the Modal Body
	var modal = document.getElementById("modalOneBody");	
	for(var i = modal.childNodes.length; i > 0; i--) {
		modal.removeChild(modal.lastChild);
	}
	var table = createTable(4, 2);
	var div = document.createElement("div");
	div.setAttribute("class", "panel panel-default");
	div.setAttribute("id", "modalEditIssueTable");
	
	table.firstChild.childNodes[0].childNodes[0].setAttribute("width", "20%");
	table.firstChild.childNodes[0].childNodes[1].setAttribute("id", "modalEditIssueColumn2");
	table.firstChild.childNodes[1].childNodes[1].setAttribute("id", "modalEditIssueColumn4");
	table.firstChild.childNodes[2].childNodes[1].setAttribute("id", "modalEditIssueColumn6");
	table.firstChild.childNodes[3].childNodes[1].setAttribute("id", "modalEditIssueColumn8");
	
	var button = createButton("editIssue", "editModalIssue", "editModalIssue", "", "", "editModalIssue("+data.ID+", "+data.embedded.issueDraft.ID+");", "", "");
	var pb = document.createElement("p");
	pb.setAttribute("style", "height:22px;")
	pb.appendChild(button);
	
	table.firstChild.childNodes[0].childNodes[0].appendChild(document.createTextNode("Name:"));
	table.firstChild.childNodes[0].childNodes[1].appendChild(document.createTextNode(data.embedded.issueDraft.issueName));
	table.firstChild.childNodes[1].childNodes[0].appendChild(document.createTextNode("Beschreibung:"));
	table.firstChild.childNodes[1].childNodes[1].appendChild(document.createTextNode(data.embedded.issueDraft.issueDescription));
	table.firstChild.childNodes[2].childNodes[0].appendChild(document.createTextNode("Status:"));
	var status = "";
	if(data.issueStatus == "NEW") status = "New";
	else if(data.issueStatus == "IN_PROGRESS") status = "In Progress";
	else if(data.issueStatus == "CLOSED") status = "Closed";
	table.firstChild.childNodes[2].childNodes[1].appendChild(document.createTextNode(status));
	table.firstChild.childNodes[3].childNodes[0].appendChild(document.createTextNode("Typ:"));
	table.firstChild.childNodes[3].childNodes[1].appendChild(document.createTextNode(data.embedded.issueDraft.issueType));
	div.appendChild(table);
	modal.appendChild(pb);
	modal.appendChild(div);	
}

/**
 * Build the Modal when the "edit Issue" Button was clicked
 **/
function editModalIssue(entityId, draftId) {
	var col1 = document.getElementById("modalEditIssueColumn2");
	var col2 = document.getElementById("modalEditIssueColumn4");
	var col3 = document.getElementById("modalEditIssueColumn6");
	var col4 = document.getElementById("modalEditIssueColumn8");
	
	var text1 = col1.firstChild.nodeValue;
	var text2 = col2.firstChild.nodeValue;
	var text3 = col3.firstChild.nodeValue;
	var text4 = col4.firstChild.nodeValue;
	
	var input1 = createTextField("editIssueModalName", "taskeingabe", "", "editIssueModalName", text1);
	var input2 = createTextField("editIssueModalDes", "taskeingabe", "", "editIssueModalDes", text2);
	
	col1.replaceChild(input1, col1.lastChild);
	col2.replaceChild(input2, col2.lastChild);
	
	var button1 = document.getElementById('editModalIssue');
	var body = document.getElementById("modalOneBody");
	body.removeChild(button1.parentNode);
	
	var radio1 = createRadioButton("editIssueRadioStatus", "new", "editIssueRadioStatusNew", "");
	var radio2 = createRadioButton("editIssueRadioStatus", "inProgress", "editIssueRadioStatusInProgress", "");
	var radio3 = createRadioButton("editIssueRadioStatus", "Closed", "editIssueRadioStatusClosed", "");
	
	var label1 = createLabel("editIssueRadioStatusNew", document.createTextNode("New"));
	var label2 = createLabel("editIssueRadioStatusInProgress", document.createTextNode("In Progress"));
	var label3 = createLabel("editIssueRadioStatusClosed", document.createTextNode("Closed"));
	
	if(text3 == "New") {
		radio1.setAttribute("checked", "true");
	} else if(text3 == "In Progress") {
		radio2.setAttribute("checked", "true");
	} else if(text3 == "Closed") {
		radio3.setAttribute("checked", "true");
	}
	
	var col6 = document.getElementById("modalEditIssueColumn6");
	col6.removeChild(col6.firstChild);
	col6.appendChild(radio1);
	col6.appendChild(label1);
	col6.appendChild(radio2);
	col6.appendChild(label2);
	col6.appendChild(radio3);
	col6.appendChild(label3);

	var radio1 = createRadioButton("editIssueRadioType", "bug", "editIssueRadioTypeBug", "");
	var radio2 = createRadioButton("editIssueRadioType", "inprovement", "editIssueRadioTypeImprovement", "");
	var radio3 = createRadioButton("editIssueRadioType", "task", "editIssueRadioTypeTask", "");
	
	var label1 = createLabel("editIssueRadioTypeBug", document.createTextNode("Bug"));
	var label2 = createLabel("editIssueRadioTypeImprovement", document.createTextNode("Improvement"));
	var label3 = createLabel("editIssueRadioTypeTask", document.createTextNode("Task"));
	
	if(text4 == "BUG") {
		radio1.setAttribute("checked", "true");
	} else if(text4 == "IMPROVEMENT") {
		radio2.setAttribute("checked", "true");
	} else if(text4 == "TASK") {
		radio3.setAttribute("checked", "true");
	}
	
	var col8 = document.getElementById("modalEditIssueColumn8");
	col8.removeChild(col8.firstChild);
	col8.appendChild(radio1);
	col8.appendChild(label1);
	col8.appendChild(radio2);
	col8.appendChild(label2);
	col8.appendChild(radio3);
	col8.appendChild(label3);
	
	var newButton = createButton("btn btn-primary", "saveIssueChanges", "saveIssueChanges", "OK", "", "saveIssueChanges("+entityId+", "+draftId+")", "", "");
	buildModalOneFooter(newButton);
}

/**
 * update the Modal with the new Inputs
**/
function saveIssueChanges(entityId, draftId) {
	var td1 = document.getElementById("modalEditIssueColumn2");
	var td2 = document.getElementById("modalEditIssueColumn4");
	var td3 = document.getElementById("modalEditIssueColumn6");
	var td4 = document.getElementById("modalEditIssueColumn8");
	if(document.getElementById("editIssueRadioStatusNew").checked == true) {
		var newStatus = "New";
	} else if(document.getElementById("editIssueRadioStatusInProgress").checked == true) {
		var newStatus = "In Progress";
	} else if(document.getElementById("editIssueRadioStatusClosed").checked == true) {
		var newStatus = "Closed";
	}
	for(var i = td3.childNodes.length; i > 0; i--) {
		td3.removeChild(td3.lastChild);
	}
	td3.appendChild(document.createTextNode(newStatus));
	
	if(document.getElementById("editIssueRadioTypeBug").checked == true) {
		var newType = "BUG";
	} else if(document.getElementById("editIssueRadioTypeImprovement").checked == true) {
		var newType = "IMPROVEMENT";
	} else if(document.getElementById("editIssueRadioTypeTask").checked == true) {
		var newType = "TASK";
	}
	
	for(var i = td4.childNodes.length; i > 0; i--) {
		td4.removeChild(td4.lastChild);
	}
	td4.appendChild(document.createTextNode(newType));
	
	var name = document.getElementById('editIssueModalName').value;
	var des = document.getElementById('editIssueModalDes').value;
	document.getElementById('modalEditIssueColumn2').replaceChild(document.createTextNode(name), document.getElementById('editIssueModalName'));
	document.getElementById('modalEditIssueColumn4').replaceChild(document.createTextNode(des), document.getElementById('editIssueModalDes'));
	
	var newButton = createButton("btn btn-primary", "saveEditedIssue", "saveEditedIssue", "Speichern", "",  "saveEditedIssue("+entityId+", "+draftId+");", "", "");
	buildModalOneFooter(newButton);

	var editButton = createButton("editIssue", "editModalIssue", "", "", "editModalIssue("+entityId+", "+draftId+");", "", "");
	editButton.setAttribute("id", "editModalIssue");
	var pb = document.createElement("p");
	pb.setAttribute("style", "height:22px;");
	pb.appendChild(editButton);
	document.getElementById("modalOneBody").insertBefore(pb, document.getElementById('modalEditIssueTable'));
}

/**
 * Write the new Issue in Database
 **/
function saveEditedIssue(entityId, draftId) {
	var name = document.getElementById("modalEditIssueColumn2").firstChild.nodeValue;
	var des = document.getElementById("modalEditIssueColumn4").firstChild.nodeValue;
	var status = document.getElementById("modalEditIssueColumn6").firstChild.nodeValue;
	var type = document.getElementById("modalEditIssueColumn8").firstChild.nodeValue;
	
	var upperStatus = status.toUpperCase();
	var endStatus = upperStatus.replace(/\s/, "_");
	var json1 = JSON.stringify({issueName: name, issueDescription: des, issueType: type});
	var json2 = JSON.stringify({issueStatus: endStatus, issueResolution: "FIXED"});

	interaction.updateIssuedraft(draftId, json1);
	interaction.updateIssueentity(entityId, json2);
	$('#modalOne').modal('hide');
}