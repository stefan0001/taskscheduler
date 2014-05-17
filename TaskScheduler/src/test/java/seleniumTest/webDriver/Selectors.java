package seleniumTest.webDriver;

public interface Selectors {

	//overview and createTask
	String block_todo = "columnNew";
	String block_imProgress = "columnInProgress";
	String block_done = "columnClosed";

	String button_uebersicht = "taskOverviewButton";
	String button_neuerTask = "newTaskButton";
	String button_issueErstellen = "newIssueButton";
	String button_suchen = "filterIssueView";
	String button_createTaskBreak = "Abbrechen";
	String button_speichernTask = "";
	String button_eventAuswaehlen = "";
	String button_speichernEvent = "";
	String button_issueAuswaehlen = "selectSelectIssue";
	String button_speichernIssue = "";
	String button_neuesIssue = "selectNewIssue";

	String eingabefeld_filterIssueName = "filterIssueName";
	
	String checkbox_filterIssueTyp = "filterIssueType";
	String checkbox_filterIssueResolution = "filterIssueResolution";
	//create task
	String eingabefeld_taskName = "newTaskName";
	String eingabefeld_datum = "TaskDate";
	String eingabefeld_uhrzeit = "TaskTime";
	String eingabefeld_issueNameFuerTask = "newIssueNameForTask";
	String eingabefeld_issueBeschreibungFuerTask = "IssueDescription";
	
	String eingabe_datum = "";
	String eingabe_uhrzeit = "";

	String radioButton_eventbasiertTastErstellen = "radioNewEventTask";
	String radioButton_zeitbasiertTaskErstellen = "radioNewTimeTask";
	String radioButton_events = "";
	String radioButton_issues = "";
		
	//editTask
	String button_submitActiveTask = "";
	String button_active = "";
	String button_deactive = "";
	String button_fireTime = "";
	String radioButton_eventbasiertUebersicht = "radioEventTasks";
	String radioButton_zeitbasiertUebersicht = "radioTimeTasks";
	String text_fireCounter = "";
	
	//editIssue
	String checkbox_tasksUebersicht ="";
	String eingabefeld_issueName = "newIssueName";
	String eingabefeld_issueBeschreibung = "newIssueIssueDescription";
	String button_issueBearbeiten = "";
	String dropdownMenu_status = "";
	String dropdownMenu_issueType = "";
	String dropdownMenu_resolution = "";
}
