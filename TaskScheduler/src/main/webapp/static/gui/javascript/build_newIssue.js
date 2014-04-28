function createIssue() {
	var name = document.newIssueFormular.issueName.value;
	var des = document.newIssueFormular.issueDescription.value;
	var type = document.newIssueFormular.issueType.value.toUpperCase();
	var json = JSON.stringify({issueName: name, issueDescription: des, issueType: type});
	
	$('#newIssue').modal('hide');
	interaction.postNewIssueDraft(json);
}

function emptyNewIssueModal() {
	var body = document.getElementById("modalBodyNewIssue");
	
	for(var i = body.childNodes.length; i > 0; i--) {
		body.removeChild(body.lastChild);
	}
	
	var form = document.createElement("form");
	form.setAttribute("name", "newIssueFormular");
	
	var p1 = document.createElement("p");
	var p2 = document.createElement("p");
	var p3 = document.createElement("p");
	
	var input1 = createTextField("issueName", "", "Name");
	input1.setAttribute("class", "taskeingabe");
	var input2 = createTextarea("newIssueIssueDescription", "Beschreibung", "issueDescription", "taskeingabe", "4");
	var input3 = createSelect("1", "issueType");
	
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

