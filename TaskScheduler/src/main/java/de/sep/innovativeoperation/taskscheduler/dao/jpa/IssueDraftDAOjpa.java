package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.Set;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Repository
public class IssueDraftDAOjpa extends GenericDAOjpa<IssueDraft> implements IssueDraftDAO {

	public void addJoinsToRoot(Root<IssueDraft> root) {
		// Fetch Entities and join them
		root.fetch("issueEntities", JoinType.LEFT);
		// Fetch EventTasks and join them
		root.fetch("eventTasks", JoinType.LEFT);
		// Fetch EventTasks and join them
		root.fetch("timeTasks", JoinType.LEFT);

	}

	@Transactional
	public Set<IssueEntity> getIssueEntitiesForIssueDraft(int id) {
		IssueDraft issueDraft = this.findByIdWithRelations(id);
		
		if( issueDraft != null ){
			
			return issueDraft.getIssueEntities();
		}
		
		return null;

	}

	
}
