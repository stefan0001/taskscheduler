package de.sep.innovativeoperation.taskscheduler.service.trigger;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;

@Service
@Transactional
public class TimeTaskTrigger {

	@Autowired
	GenericDAO<IssueEntity> issueEntityDAO;
	
	/**
	 * Creates Issues for time tasks
	 * @param timeTask to which Issues shall be created
	 */
	public void trigger(TimeTask timeTask){
		
		Set<IssueDraft> issueDrafts = timeTask.getIssueDrafts();
		Iterator<IssueDraft> iterator = issueDrafts.iterator();
		
		while(iterator.hasNext()){
			IssueDraft current = iterator.next();
			createIssueFor(current);
		}
		
	}
	
	private IssueEntity createIssueFor(IssueDraft issueDraft){
		IssueEntity issueEntity = new IssueEntity();
		issueEntity.setId(0);
		issueEntity.setIssueResolution(IssueResolution.UNRESOLVED);
		issueEntity.setIssueStatus(IssueStatus.NEW);
		issueEntity.setIssueDraft(issueDraft);
		
		return issueEntityDAO.save(issueEntity);
	}
	
}
