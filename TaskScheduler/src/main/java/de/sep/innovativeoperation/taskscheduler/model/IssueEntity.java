package de.sep.innovativeoperation.taskscheduler.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonUnwrapped;

/**
 * 
 * @author Stefan
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IssueEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;

	@NotNull
	@Enumerated(EnumType.STRING)
	private IssueResolution issueResolution;

	@NotNull
	@ManyToOne
	@JsonUnwrapped
	private IssueTemplate issueTemplate;

	/**
	 * Blank Constructor for this IssueEntity
	 */
	public IssueEntity() {
	}

	public IssueEntity(IssueStatus issueStatus,
			IssueResolution issueResolution, IssueTemplate issueTemplate) {
		this.issueStatus = issueStatus;
		this.issueResolution = issueResolution;
		this.issueTemplate = issueTemplate;
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

	public IssueTemplate getIssueTemplate() {
		return issueTemplate;
	}
	

}
