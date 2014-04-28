var data = {};

data.column1 = "spalte";
data.column2 = "spalte";
data.column3 = "spalte";

data.setColumn1 = function(col) {
	data.column1 = col;
}

data.setColumn2 = function(col) {
	data.column2 = col;
}

data.setColumn3 = function(col) {
	data.column3 = col;
}

data.getColumn1 = function() {
	return data.column1;
}

data.getColumn2 = function() {
	return data.column2;
}

data.getColumn3 = function() {
	return data.column3;
}