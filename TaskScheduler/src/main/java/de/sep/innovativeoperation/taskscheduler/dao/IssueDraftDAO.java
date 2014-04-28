package de.sep.innovativeoperation.taskscheduler.dao;

import java.util.Set;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Repository
public interface IssueDraftDAO extends GenericDAO<IssueDraft>{
	
	
	public Set<IssueEntity> getIssueEntitiesForIssueDraft(IssueDraft issueDraft);
	
	
}
