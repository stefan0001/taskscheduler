package de.sep.innovativeoperation.taskscheduler.dao;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAO;
import de.sep.innovativeoperation.taskscheduler.model.Event;

@Repository
public interface EventDAO extends GenericDAO<Event>{

}
