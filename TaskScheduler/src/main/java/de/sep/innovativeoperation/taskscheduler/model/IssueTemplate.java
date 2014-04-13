package de.sep.innovativeoperation.taskscheduler.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Stefan
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IssueTemplate implements Serializable {
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

	/**
	 * Blank Constructor for this IssueTemplate
	 */
	public IssueTemplate() {

	}

	/**
	 * 
	 * @param issuename
	 * @param issueDescription
	 * @param issueType
	 */
	public IssueTemplate(String issuename, String issueDescription,
			IssueType issueType) {
		this.issueName = issuename;
		this.issueDescription = issueDescription;
		this.issueType = issueType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
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

}
