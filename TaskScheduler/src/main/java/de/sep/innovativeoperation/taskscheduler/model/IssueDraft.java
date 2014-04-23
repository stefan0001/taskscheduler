package de.sep.innovativeoperation.taskscheduler.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity

public class IssueDraft implements Serializable {

	/*Auto-generated ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int issueDraftId;

	@NotNull
	private String issueName;

	@NotNull
	private String issueDescription;

	@NotNull
	@Enumerated(EnumType.STRING)
	private IssueType issueType;


	/*Child of the IssueEntity <--> IssueDraft relationship */
	@OneToMany(mappedBy = "issueDraft", cascade = {CascadeType.ALL})
	private Set<IssueEntity> issueEntites = new HashSet<IssueEntity>();
	

	/*Child  of the TimeTask <--> IssueDraft relationship */
	@ManyToMany(mappedBy = "issueDrafts", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<TimeTask> timeTasks = new HashSet<TimeTask>();
	

	/*Child  of the EventTask <--> IssueDraft relationship */
	@ManyToMany(mappedBy = "issueDrafts", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<EventTask> eventTasks = new HashSet<EventTask>();
	
	public IssueDraft(){
		
	}
	
	public IssueDraft(String issueName, String issueDescription, IssueType issueType){
		this.issueName = issueName;
		this.issueDescription = issueDescription;
		this.issueType = issueType;
	}


	public void setIssueDraftId(int issueDraftId) {
		this.issueDraftId = issueDraftId;
	}

	public int getIssueDraftId() {
		return issueDraftId;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	
	public String getIssueName() {
		return issueName;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public IssueType getIssueType() {
		return issueType;
	}
	
	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}
	
	@JsonIgnore
	public void setTimeTasks(Set<TimeTask> timeTasks){
		this.timeTasks = timeTasks;
		
	}
	@JsonIgnore
	public Set<TimeTask> getTimeTasks(){
		return this.timeTasks;
	}
	@JsonIgnore
	public void setEventTasks(Set<EventTask> eventTasks){
		this.eventTasks = eventTasks;
		
	}
	@JsonIgnore
	public Set<EventTask> getTasks(){
		return this.eventTasks;
	}

	@JsonIgnore
	public Set<IssueEntity> getIssueEntites() {
		return issueEntites;
	}

	@JsonIgnore
	public void setIssueEntites(Set<IssueEntity> issueEntites) {
		this.issueEntites = issueEntites;
	}

}
