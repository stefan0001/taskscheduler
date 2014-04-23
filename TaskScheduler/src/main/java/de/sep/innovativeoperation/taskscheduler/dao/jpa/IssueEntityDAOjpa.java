package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Repository
public class IssueEntityDAOjpa extends GenericDAOjpa<IssueEntity> implements IssueEntityDAO{


	public List<IssueEntity> fetchAllWithRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	public IssueEntity findByIdWithRelations(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*Concrete JPA implementation */
	

}
