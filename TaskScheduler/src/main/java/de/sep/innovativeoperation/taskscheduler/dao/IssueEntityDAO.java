package de.sep.innovativeoperation.taskscheduler.dao;

import org.springframework.stereotype.Component;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAOImpl;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Component
public class IssueEntityDAO extends GenericDAOImpl<IssueEntity> {

	
	@Override
	protected String getClassName() {
		return "IssueEntity";
	}

}
