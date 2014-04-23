package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.EventTask;

@Repository
public class EventTaskDAOjpa extends GenericDAOjpa<EventTask> implements EventTaskDAO{



	public List<EventTask> fetchAllWithRelations() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addJoinsToRoot(Root<EventTask> root) {
		// TODO Auto-generated method stub
		
	}


}
