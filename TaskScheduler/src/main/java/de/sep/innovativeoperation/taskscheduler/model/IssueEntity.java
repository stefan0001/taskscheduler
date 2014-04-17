package de.sep.innovativeoperation.taskscheduler.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Stefan
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IssueEntity implements Serializable {
	

	public IssueEntity() {
	}
	
	/**
	 * 
	 * @param issueStatus
	 * @param issueResolution
	 * @param issueDraft
	 */
	public IssueEntity(IssueStatus issueStatus,
			IssueResolution issueResolution, IssueDraft issueDraft) {
		this.issueStatus = issueStatus;
		this.issueResolution = issueResolution;
		this.issueDraft = issueDraft;
	}
	
	
	
	
	/*
	 * Automatisch vortlaufende, von der Datenbank generierte ID
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;

	@NotNull
	@Enumerated(EnumType.STRING)
	private IssueResolution issueResolution;


	/*Owner of the IssueDraft <--> IssueEntity relationship*/
	@NotNull
	@ManyToOne(cascade = {CascadeType.ALL})
	private IssueDraft issueDraft;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId (){
		return id;
	}
	
	public IssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	public IssueResolution getIssueResolution() {
		return issueResolution;
	}

	public void setIssueResolution(IssueResolution issueResolution) {
		this.issueResolution = issueResolution;
	}

	public IssueDraft getIssueTemplate() {
		return issueDraft;
	}
	
	public void setIssueTemplate(IssueDraft issueTemplate) {
		this.issueDraft = issueTemplate;
	}

}
