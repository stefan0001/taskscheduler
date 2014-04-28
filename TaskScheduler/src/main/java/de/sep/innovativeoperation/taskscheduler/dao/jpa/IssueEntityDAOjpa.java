package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Repository
public class IssueEntityDAOjpa extends GenericDAOjpa<IssueEntity> implements IssueEntityDAO{


}
