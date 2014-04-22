package de.sep.innovativeoperation.taskscheduler.daoJpa;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.EventTask;

@Repository
public class EventTaskDAOjpa extends GenericDAOjpa<EventTask> implements EventTaskDAO{

}
