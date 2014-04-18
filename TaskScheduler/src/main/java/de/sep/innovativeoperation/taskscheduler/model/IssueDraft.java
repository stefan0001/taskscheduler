package de.sep.innovativeoperation.taskscheduler.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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

@SuppressWarnings("serial")
@Entity
public class IssueDraft implements Serializable {

	/*Auto-generated ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

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
	
	/*Child  of the Task <--> IssueDraft relationship */
	@ManyToMany(mappedBy = "issueDrafts", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Task> tasks = new HashSet<Task>();
	
	public IssueDraft(){
		
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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
	
	
	public void setTasks(Set<Task> tasks){
		this.tasks = tasks;
		
	}
	
	public Set<Task> getTasks(){
		return this.tasks;
	}


	public Set<IssueEntity> getIssueEntites() {
		return issueEntites;
	}


	public void setIssueEntites(Set<IssueEntity> issueEntites) {
		this.issueEntites = issueEntites;
	}

}
