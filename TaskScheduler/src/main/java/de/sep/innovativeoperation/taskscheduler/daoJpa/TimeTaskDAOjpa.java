package de.sep.innovativeoperation.taskscheduler.daoJpa;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.TimeTask;

@Repository
public class TimeTaskDAOjpa extends GenericDAOjpa<TimeTask> implements TimeTaskDAO {
	/*Concrete JPA implementation */
}
