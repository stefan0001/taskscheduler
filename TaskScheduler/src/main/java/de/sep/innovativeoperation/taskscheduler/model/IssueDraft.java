package de.sep.innovativeoperation.taskscheduler.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
public class IssueDraft implements Serializable {
	
	
	public IssueDraft() {
	}

	
	/**
	 * @param issuename 
	 * @param issueDescription Description of what is to do.
	 * @param issueType is an enum, look up the list for valid values
	 */
	public IssueDraft(String issuename, String issueDescription,
			IssueType issueType) {
		this.issueName = issuename;
		this.issueDescription = issueDescription;
		this.issueType = issueType;
	}
	
	
	
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
	@OneToMany(mappedBy="issueDraft", fetch=FetchType.EAGER )
	private Set<IssueEntity> issueEntites = new HashSet<IssueEntity>();
	
	/*Child of the Task <--> IssueDraft relationship */
	@ManyToMany(mappedBy="issueDrafts", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE )
	private Set<Task> tasks = new HashSet<Task>();
	


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
	
	public void setIssueEntities(Set<IssueEntity> issueEntities){
		this.issueEntites = issueEntities;
		
	}
	
	public void setTasks(Set<Task> tasks){
		this.tasks = tasks;
		
	}
	
	public Set<Task> getTasks(){
		return this.tasks;
	}

}
