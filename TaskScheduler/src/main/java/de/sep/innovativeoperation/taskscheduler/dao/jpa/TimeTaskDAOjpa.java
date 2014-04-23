package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.List;

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

	public TimeTask findByIdWithRelations(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
