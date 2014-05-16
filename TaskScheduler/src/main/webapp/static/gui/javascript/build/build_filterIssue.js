/**
 * Filter the Issue View on start page
 **/
function filterIssues() {
	var name = document.getElementById("filterIssueName").value;
	var type = document.getElementById("filterIssueType").value;
	var embedded = JSON.stringify({embedded: {issueDraft: {issueName: name, issueType: type}}});
	if(type == "ALL") {
		embedded = JSON.stringify({embedded: {issueDraft: {issueName: name}}});
	} else if(name == "") {
		embedded = JSON.stringify({embedded: {issueDraft: {issueType: type}}});
	}
	if(type == "ALL" && name == "") {interaction.displayAllIssueEntities()}
	else {interaction.filterIssueEntitys(embedded)}
}

/**
 * Filter the Issue Drafts when create a new Task
 **/
function filterIssueDrafts(existTask) {
	var name = document.getElementById("filterIssueDraftForTask").value;
	var embedded = JSON.stringify({issueName: name});
	interaction.filterIssueDrafts(embedded, existTask);
}