package de.sep.innovativeoperation.taskscheduler.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAOImpl;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Component
public class IssueEntityDAO extends GenericDAOImpl<IssueEntity> {

	
	
	protected String getClassName() {
		return "IssueEntity";
	}
	
	@Override
	public IssueEntity findById(int id){
		
		return em.find(persistentClass, id);
	}

}

