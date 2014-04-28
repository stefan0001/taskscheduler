package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Repository
public class IssueDraftDAOjpa extends GenericDAOjpa<IssueDraft> implements
		IssueDraftDAO {

	@Transactional
	public Set<IssueEntity> getIssueEntitiesForIssueDraft(IssueDraft issueDraft) {
		
		//get Issueentities
		Set<IssueEntity> issueEntities = issueDraft.getIssueEntities();
		
		//eager initialize collection
		issueEntities.size();
		
		return issueEntities;

	}


}
