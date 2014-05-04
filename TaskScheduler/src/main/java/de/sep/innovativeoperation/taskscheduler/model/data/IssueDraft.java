package de.sep.innovativeoperation.taskscheduler.model.data;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties({"issueEntities","timeTasks","eventTasks"})
public class IssueDraft extends AbstractDataModel {



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
	private Set<IssueEntity> issueEntities;
	

	/*Child  of the TimeTask <--> IssueDraft relationship */
	@ManyToMany(mappedBy = "issueDrafts", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<TimeTask> timeTasks;
	

	/*Child  of the EventTask <--> IssueDraft relationship */
	@ManyToMany(mappedBy = "issueDrafts", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<EventTask> eventTasks;
	
	
	/**
	 * Creates an IssueDraft with no name, no description, no type with empty relations
	 */
	public IssueDraft(){
		this(null, null, null);
	}
	

	/**
	 * Creates an IssueDraftwith with empty relations
	 * @param issueName
	 * @param issueDescription
	 * @param issueType
	 */
	public IssueDraft(String issueName, String issueDescription, IssueType issueType){
		this(issueName, issueDescription, issueType, new HashSet<IssueEntity>(), new HashSet<TimeTask>(), new HashSet<EventTask>());
	}
	

	/**
	 * Creates an IssueDraftwith all Relations
	 * @param issueName
	 * @param issueDescription
	 * @param issueType
	 * @param issueEntities
	 * @param timeTasks
	 * @param eventTasks
	 */

	public IssueDraft(String issueName, String issueDescription,
			IssueType issueType, Set<IssueEntity> issueEntities,
			Set<TimeTask> timeTasks, Set<EventTask> eventTasks) {
		this.issueName = issueName;
		this.issueDescription = issueDescription;
		this.issueType = issueType;
		this.issueEntities = issueEntities;
		this.timeTasks = timeTasks;
		this.eventTasks = eventTasks;
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
	

	public void setTimeTasks(Set<TimeTask> timeTasks){
		this.timeTasks = timeTasks;
		
	}

	public Set<TimeTask> getTimeTasks(){
		return this.timeTasks;
	}

	public void setEventTasks(Set<EventTask> eventTasks){
		this.eventTasks = eventTasks;
		
	}

	public Set<EventTask> getEventTasks(){
		return this.eventTasks;
	}


	public Set<IssueEntity> getIssueEntities() {
		return issueEntities;
	}


	public void setIssueEntities(Set<IssueEntity> issueEntites) {
		this.issueEntities = issueEntites;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eventTasks == null) ? 0 : eventTasks.hashCode());
		result = prime * result + id;
		result = prime
				* result
				+ ((issueDescription == null) ? 0 : issueDescription.hashCode());
		result = prime * result
				+ ((issueEntities == null) ? 0 : issueEntities.hashCode());
		result = prime * result
				+ ((issueName == null) ? 0 : issueName.hashCode());
		result = prime * result
				+ ((issueType == null) ? 0 : issueType.hashCode());
		result = prime * result
				+ ((timeTasks == null) ? 0 : timeTasks.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueDraft other = (IssueDraft) obj;
		if (eventTasks == null) {
			if (other.eventTasks != null)
				return false;
		} else if (!eventTasks.equals(other.eventTasks))
			return false;
		if (id != other.id)
			return false;
		if (issueDescription == null) {
			if (other.issueDescription != null)
				return false;
		} else if (!issueDescription.equals(other.issueDescription))
			return false;
		if (issueEntities == null) {
			if (other.issueEntities != null)
				return false;
		} else if (!issueEntities.equals(other.issueEntities))
			return false;
		if (issueName == null) {
			if (other.issueName != null)
				return false;
		} else if (!issueName.equals(other.issueName))
			return false;
		if (issueType != other.issueType)
			return false;
		if (timeTasks == null) {
			if (other.timeTasks != null)
				return false;
		} else if (!timeTasks.equals(other.timeTasks))
			return false;
		return true;
	}

	
	
}
