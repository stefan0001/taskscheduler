package de.sep.innovativeoperation.taskscheduler.model.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Stefan
 * 
 */
@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties({"issueDraft"})

//@XmlElement
//@XmlRootElement
public class IssueEntity extends AbstractDataModel implements Serializable {

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
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "ISSUEDRAFT_ISSUEDRAFTID")
	private IssueDraft issueDraft;
	
	
	public IssueEntity() {
	}
	
	/**
	 * 
	 * @param issueStatus
	 * @param issueResolution
	 * @param issueDraft
	 */
	public IssueEntity(IssueStatus issueStatus,IssueResolution issueResolution, IssueDraft issueDraft) {
		this.issueStatus = issueStatus;
		this.issueResolution = issueResolution;
		this.issueDraft = issueDraft;
	}
	
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

	public IssueDraft getIssueDraft() {
		return issueDraft;
	}
	
	public void setIssueDraft(IssueDraft issueDraft) {
		this.issueDraft = issueDraft;
	}


}
