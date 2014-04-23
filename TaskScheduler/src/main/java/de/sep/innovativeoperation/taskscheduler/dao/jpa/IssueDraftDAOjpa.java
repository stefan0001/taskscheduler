package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;

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

}
