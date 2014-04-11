package de.sep.innovativeoperation.taskscheduler.dao;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAOImpl;
import de.sep.innovativeoperation.taskscheduler.model.IssueTemplate;

@Repository
public class IssueTemplateDAO extends GenericDAOImpl<IssueTemplate> {

	@Override
	protected String getClassName() {
		return "IssueTemplate";
	}
}
