package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.TimeTask;

@Repository
public class TimeTaskDAOjpa extends GenericDAOjpa<TimeTask> implements TimeTaskDAO {


	public List<TimeTask> fetchAllWithRelations() {
		// TODO Auto-generated method stub
		return null;
	}
	/*Concrete JPA implementation */


	@Override
	public void addJoinsToRoot(Root<TimeTask> root) {
		// TODO Auto-generated method stub
		
	}


}
