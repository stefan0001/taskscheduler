var interaction = {};

interaction.displayAllIssueEntities = function() {
	server.fetchAllIssueEntities( display.showData );
}

interaction.postNewIssueDraft = function(json) {
	server.postNewIssueDraft(json);
}

interaction.displayAllIssueDrafts = function() {
	server.fetchAllIssueDrafts();
}

