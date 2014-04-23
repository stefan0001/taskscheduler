package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.EventTask;

@Repository
public class EventTaskDAOjpa extends GenericDAOjpa<EventTask> implements EventTaskDAO{

	@Override
	protected void addJoinsToRoot(Root<EventTask> root) {
		// Fetch Entities and join them
		root.fetch("issueDrafts", JoinType.LEFT);
	}







}
