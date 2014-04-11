
    function test() {
         var fbURL="http://localhost:8082/TaskScheduler/issueentities";

			$.ajax({
			url: fbURL+"&callback=?",
			method: 'get',
			type: 'json',
			success: function (resp) {
				alert(resp);
			},
			error: function(e) {
				alert('Error: '+e);
			}  
		});
    }

//function show() {
//	alert("test1");
//	$.ajax({
//		url: 'http://localhost:8082/TaskScheduler/issueentities',
//		type: 'json',
//		method: 'get',
//		done(function(data) {
//			$.each(data, function(item, index) {
//				addRow(item.issueStatus, item.issueResolution, item.issueTemplate);
//			});
//		}
//	});
//	
//}

//function addRow(issueStatus, issueResolution, issueTemplate) {
//	alert("test2");
//	var table = document.createElement("table");
//	var row = document.createElement("tr");
//	var cell1 = document.createElement("td");
//	var cell2 = document.createElement("td");
//	var cell3 = document.createElement("td");
//	cell1.appendChild(document.createTextNode(issueStatus));
//	cell1.appendChild(document.createTextNode(issueResolution));
//	cell1.appendChild(document.createTextNode(issueTemplate));
//	row.appendChild(cell1);
//	row.appendChild(cell2);
//	row.appendChild(cell3);
//	table.appendChild(row);
//	
//	var body = document.getElementById("body");
//	body.appendChild(table);
//}