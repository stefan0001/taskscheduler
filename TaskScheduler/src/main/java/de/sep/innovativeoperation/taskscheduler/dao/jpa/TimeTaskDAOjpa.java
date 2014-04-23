package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.TimeTask;

@Repository
public class TimeTaskDAOjpa extends GenericDAOjpa<TimeTask> implements TimeTaskDAO {

	@Override
	protected void addJoinsToRoot(Root<TimeTask> root) {

		
	}



}
