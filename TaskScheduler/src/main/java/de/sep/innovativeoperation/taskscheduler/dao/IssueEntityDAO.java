package de.sep.innovativeoperation.taskscheduler.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;

@Repository
public interface IssueEntityDAO extends GenericDAO<IssueEntity> {

	public List<IssueEntity> filterIssueEntity(IssueEntity issueEntity, IssueDraft issueDraft);
}
