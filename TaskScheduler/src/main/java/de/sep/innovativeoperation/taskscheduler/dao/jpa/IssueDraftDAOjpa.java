package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.Set;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Repository
public class IssueDraftDAOjpa extends GenericDAOjpa<IssueDraft> implements
		IssueDraftDAO {


	public Set<IssueEntity> getIssueEntitiesForIssueDraft(int id) {
		IssueDraft issueDraft = this.findById(id);

		if (issueDraft != null) {
			Set<IssueEntity> issueentities = issueDraft.getIssueEntities();
			issueentities.size();
			return issueentities;
		}


		return null;

	}


}
