/**
 * Write the Issue in the Database
 **/
function createIssue() {
	var name = document.newIssueFormular.issueName.value;
	var des = document.newIssueFormular.issueDescription.value;
	var type = document.newIssueFormular.issueType.value.toUpperCase();
	var json = JSON.stringify({issueName: name, issueDescription: des, issueType: type});
	
	$('#modalOne').modal('hide');
	interaction.postNewIssueDraft(json);
}

/**
 * Build the Modal to Create an Issue
 **/
function emptyNewIssueModal() {
	var button1 = createButton("btn btn-default", "", "", "Abbrechen", "", "", "", "");
	button1.setAttribute("data-dismiss", "modal");
	var button2 = createButton("btn btn-primary", "", "", "Speichern", "", "createIssue();", "", "");
	buildModalOneFooter(button1, button2);
	buildModalOneHeader("Neues Issue");
	var body = document.getElementById("modalOneBody");
	
	for(var i = body.childNodes.length; i > 0; i--) {
		body.removeChild(body.lastChild);
	}
	
	var form = document.createElement("form");
	form.setAttribute("name", "newIssueFormular");
	
	var p1 = document.createElement("p");
	var p2 = document.createElement("p");
	var p3 = document.createElement("p");
	
	var input1 = createTextField("issueName", "", "Name", "newIssueName", "");
	var input2 = createTextarea("newIssueIssueDescription", "Beschreibung", "issueDescription", "textarea", "4");
	var input3 = createSelect("1", "issueType");
	input3.setAttribute("class", "taskeingabe");
	input3.setAttribute("id", "newIssueTyp");
	
	var option1 = createOption("Bug");
	var option2 = createOption("Improvement");
	var option3 = createOption("Task");
	
	input3.appendChild(option1);
	input3.appendChild(option2);
	input3.appendChild(option3);
	
	p1.appendChild(input1);
	p2.appendChild(input2);
	p3.appendChild(input3);
	
	form.appendChild(p1);
	form.appendChild(p2);
	form.appendChild(p3);
	
	body.appendChild(form);
}