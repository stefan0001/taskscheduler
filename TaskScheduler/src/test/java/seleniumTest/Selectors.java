package seleniumTest;

public interface Selectors {

	//overview and createTask
	String button_uebersicht = "";
	String button_neuerTask = "";
	String button_issueErstellen = "";
	String button_createTaskBreak = "";
	String button_speichernTask = "";
	String button_eventAuswaehlen = "";
	String button_speichernEvent = "";
	String button_issueAuswaehlen = "";
	String button_speichernIssue = "";
	String button_neuesIssue = "";

	String eingabefeld_taskName = "";
	String eingabefeld_taskBeschreibung = "";
	String eingabefeld_datum = "";
	String eingabefeld_uhrzeit = "";
	String eingabefeld_endDatum = "";
	String eingabefeld_issueName = "";
	String eingabefeld_issueBeschreibung = "";

	String radioButton_eventbasiertTastErstellen = "";
	String radioButton_zeitbasiertTaskErstellen = "";

	String checkbox_wiederholung = "";
	String checkbox_events = "";
	String checkbox_issues = "";
	
	CharSequence eingabe_datum = "";
	CharSequence eingabe_uhrzeit = "";
	CharSequence eingabe_endDatum = "";
	
	//editTask
	String button_submitActiveTask = "";
	String button_active = "";
	String button_deactive = "";
	String button_fireTime = "";
	String radioButton_eventbasiertUebersicht = "";
	String radioButton_zeitbasiertUebersicht = "";
	String checkbox_tasksUebersicht = "";
	String text_fireCounter = "";
	
	//editIssue
	String button_issueBearbeiten = "";
	String dropdownMenu_status = "";
	String dropdownMenu_issueType = "";
	String dropdownMenu_resolution = "";
}
