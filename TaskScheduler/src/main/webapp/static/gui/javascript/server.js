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
	var jqXHR = $.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issuedraft",
		data: json
	})
	.complete(display.showResponse)
	.error(display.showCreateStatus(json, false));
}

server.createIssueEntityFor = function(id) {
	var json = JSON.stringify({issueStatus: "NEW", issueResolution: "DONE"});
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issuedraft/"+id+"/issueentity",
		data: json
	})
}


