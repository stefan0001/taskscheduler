package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;

@Repository
public class TimeTaskDAOjpa extends GenericDAOjpa<TimeTask> implements TimeTaskDAO {

	public List<TimeTask> getTimeTaskWithNextFireTimeOlderThan(Calendar firetime) {
		TypedQuery<TimeTask> query = em.createQuery("SELECT e FROM TimeTask e WHERE e.nextFireTime < :arg1", TimeTask.class);
		query.setParameter("arg1", firetime);

		return query.getResultList();
	}




}
