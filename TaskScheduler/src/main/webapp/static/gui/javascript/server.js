var server = {};

server.url = "http://localhost:8083/TaskScheduler/";

server.fetchAllIssueEntities = function( showData ){
	$.ajax({
	  dataType: "json",
	  url: this.url + "issueentity",
	  data: "",
	  success: showData
	});
};


server.fetchAllIssueDrafts = function(  ){
	$.ajax({
	  dataType: "json",
	  url: this.url + "issuedraft",
	  data: "",
	});
};

server.postNewIssueDraft = function(json) {
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issuedraft",
		data: json
	})
	.complete(display.showCreateStatus(json, true))
	.error(display.showCreateStatus(json, false));
}


