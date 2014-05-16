var server = {};

setupServer();

function setupServer(){
	pathArray = window.location.href.split( '/' );
	protocol = pathArray[0];
	host = pathArray[2];
	app = "TaskScheduler";
	server.url = protocol + '//' + host + '/' + app +"/";
};


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
	  success: function(data) {
		  return data;
	  }
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
	.complete(display.showResponse)
	.error(display.showCreateStatus(json, false));
}

server.createIssueEntityFor = function(id) {
	var json = JSON.stringify({issueStatus: "NEW", issueResolution: "FIXED"});
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issuedraft/"+id+"/issueentity",
		data: json,
		complete: function(data) {
			cleanContainerForGetIssueEntity();
			server.fetchAllIssueEntities(display.showData);
		}
	})
}

server.updateIssuedraft = function(id, json) {
	$.ajax({
		type: "PUT",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issuedraft/"+id,
		data: json
	});
}

server.updateIssueentity = function(id, json) {
	$.ajax({
		type: "PUT",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issueentity/"+id,
		data: json,
		complete: function() {
			interaction.displayAllIssueEntities();
		}
	});
}

server.deleteIssueEntity = function(id) {
	$.ajax({
		type: "DELETE",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issueentity/"+id,
		data: ""
	});
}

server.getIssueEntityById = function(id, buildEditIssue) {
	$.ajax({
		dataType: "json",
		url: this.url + "issueentity/"+id,
		data: "",
		success: buildEditIssue
	});
}

server.postNewTimeTask = function(json) {
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "timetask",
		data: json,
		complete: function(data) {
			createIssueForTimeTask(data.responseText);
		}
	})
}

server.postNewEventTask = function(eventId, json) {
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "event/"+eventId+"/eventtask",
		data: json,
		complete: function(data) {
			createIssueForEventTask(data.responseText);
		}
	})
}

server.putNewIssueDraftForTimeTask = function(taskId, json, existTask) {
	var newUrl = this.url;
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issuedraft",
		data: json,
		complete: function(data) {
			var idAt = data.responseText.search(/ID/);
			var slice = data.responseText.slice(idAt+4, idAt+6);
			var id = slice;
			if(slice.charAt(1) == ",") {
				id = slice.slice(0, 1);
			}
			var post = JSON.stringify({ID: id});
			$.ajax({
				type: "POST",
				dataType: "application/json",
				contentType: "application/json",
				url: newUrl + "timetask/"+taskId+"/issuedraft",
				data: post,
				complete: function(data) {
					if(existTask == true) {
						server.getIssuesOfTimeTask(taskId);
					}
				}
			})
		}
	})
}

server.putNewIssueDraftForEventTask = function(taskId, json, existTask) {
	var newUrl = this.url;
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "issuedraft",
		data: json,
		complete: function(data) {
			var idAt = data.responseText.search(/ID/);
			var slice = data.responseText.slice(idAt+4, idAt+6);
			var id = slice;
			if(slice.charAt(1) == ",") {
				id = slice.slice(0, 1);
			}
			var post = JSON.stringify({ID: id});
			$.ajax({
				type: "POST",
				dataType: "application/json",
				contentType: "application/json",
				url: newUrl + "eventtask/"+taskId+"/issuedraft",
				data: post,
				complete: function(data) {
					if(existTask == true) {
						server.getIssuesOfEventTask(taskId);
					}
				}
			})
		}
	})
}

server.getAllIssueDraft = function(existTask) {
	$.ajax({
		dataType: "json",
		url: this.url + "issuedraft",
		data: "",
		success: function(data) {
			buildSelectIssueModal(data, existTask);
		}
	});
}

server.getAllTimeTask = function() {
	$.ajax({
		dataType: "json",
		url: this.url + "timetask",
		data: "",
		success: function(data) {
			display.setData(data);
			selectTimeTaskView(data);
		}
	});
}

server.getAllEventTask = function(showTask) {
	$.ajax({
		dataType: "json",
		url: this.url + "eventtask",
		data: "",
		success: function(data) {
			selectEventTaskView(data);
		}
	});
}

server.fetchAllTimeTask = function() {
	$.ajax({
		dataType: "json",
		url: this.url + "timetask",
		data: "",
		success: function(data) {
			selectTimeTaskView(data);
		}
	});
}

server.getTimeTaskById = function(id) {
	$.ajax({
		dataType: "json",
		url: this.url + "timetask/"+id,
		data: "",
		success: function(data) {
			buildEditTask(data);
		}
	});
}

server.getEventTaskById = function(id) {
	$.ajax({
		dataType: "json",
		url: this.url + "eventtask/"+id,
		data: "",
		success: function(data) {
			buildEditTask(data);
		}
	});
}

server.updateTimeTask = function(id, json) {
	$.ajax({
		type: "PUT",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "timetask/"+id,
		data: json,
	})
}

server.updateEventTask = function(id, json) {
	$.ajax({
		type: "PUT",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "eventtask/"+id,
		data: json,
	})
}

server.createNewEvent = function(json) {
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "event",
		data: json,
		complete: function(data) {
			createTaskForEvent(data.responseText);
		}
	})
}

server.postExistentIssueDraftForEventTask = function(id, json, existTask) {
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "eventtask/"+id+"/issuedraft",
		data: json,
		complete: function(data) {
			server.getIssuesOfEventTask(id);
		}
	})
}

server.postExistentIssueDraftForTimeTask = function(id, json, existTask) {
	$.ajax({
		type: "POST",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "timetask/"+id+"/issuedraft",
		data: json,
		complete: function(data) {
			server.getIssuesOfTimeTask(id);
		}
	})
}

server.deleteEventTask = function(id) {
	$.ajax({
		type: "DELETE",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "eventtask/"+id,
		data: "",
		complete: function(data) {
			interaction.getAllEventTask();
		}
	})
}

server.deleteTimeTask = function(id, selectedDay) {
	$.ajax({
		type: "DELETE",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "timetask/"+id,
		data: "",
		complete: function(data) {
			server.getAllTimeTask();
			$('#showTasksByDate').modal('hide');
		}
	})
}

server.filterIssueEntitys = function(json, showData) {
	$.ajax({
		  dataType: "json",
		  url: this.url + "issueentity?filter="+json,
		  data: "",
		  success: showData
		});
}

server.filterIssueDrafts = function(json, existTask) {
	$.ajax({
		dataType: "json",
		url: this.url + "issuedraft?filter="+json,
		data: "",
		success: function(data) {
			buildSelectIssueModal(data, existTask)
		}
	});
}

server.getIssuesOfTimeTask = function(id) {
	$.ajax({
		dataType: "json",
		url: this.url + "timetask/"+id+"/issuedraft",
		data: "",
		success: function(data) {
			showIssuesOfTimeTask(data, id);
		}
	});
}

server.getIssuesOfEventTask = function(id) {
	$.ajax({
		dataType: "json",
		url: this.url + "eventtask/"+id+"/issuedraft",
		data: "",
		success: function(data) {
			showIssuesOfEventTask(data, id);
		}
	});
}

server.removeTimeTaskIssueConnection = function(issueId, taskId) {
	$.ajax({
		type: "DELETE",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "timetask/"+taskId+"/issuedraft/"+issueId,
		data: "",
		complete: function(data) {
			server.getIssuesOfTimeTask(taskId);
		}
	})
}

server.removeEventTaskIssueConnection = function(issueId, taskId) {
	$.ajax({
		type: "DELETE",
		dataType: "application/json",
		contentType: "application/json",
		url: this.url + "eventtask/"+taskId+"/issuedraft/"+issueId,
		data: "",
		complete: function(data) {
			server.getIssuesOfEventTask(taskId);
		}
	})
}