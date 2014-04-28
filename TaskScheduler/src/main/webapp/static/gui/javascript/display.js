var display = {};

display.data = null;

display.displayAllIssueEntities = function( data ){
	display.data = data;
	for( var i = 0; i < data.length; i++ ) {
		showIssueFromDatabase(data[i].content.id, data[i].content.issueStatus, data[i].content.issueResolution, data[i].embedded[0].content.id, data[i].embedded[0].content.issueName, data[i].embedded[0].content.issueDescription, data[i].embedded[0].content.issueType);
	}
	countIssueContainer();
}

display.getData = function(data) {
	return display.data;
}

display.showData = function(data) {
	display.data = data;
	display.displayAllIssueEntities(data);
}

display.showCreateStatus = function(json, status) {
	var text = "Das Issue wurde ";
	if(status === false) {
		$('#statusmessage').text(text+'erstellt').animate({'margin-bottom':30},200);
	} else {
		$('#statusmessage').text(text+'nicht erstellt').animate({'margin-bottom':30},200);
	}
	setTimeout( function(){
        $('#statusmessage').animate({'margin-bottom':-150},200);
    }, 2*1000);
}