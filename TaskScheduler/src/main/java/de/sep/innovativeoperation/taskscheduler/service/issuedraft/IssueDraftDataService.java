package de.sep.innovativeoperation.taskscheduler.service.issuedraft;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericDataService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueDraftValidationService;

/**
 * Logic for IssueDraft management
 * 
 * @author Stefan
 * 
 */
@Service
@Transactional
public class IssueDraftDataService extends AbstractGenericDataService<IssueDraft> {

	@Autowired
	private IssueDraftDAO issueDraftDAO;

	@Autowired
	private IssueDraftValidationService issueDraftValidationService;

	
	public IssueDraft createIssueDraft(IssueDraft issueDraft) {
		System.out.println(issueDraft.getIssueEntities());
		// set id to 0 to tell the database it should be a new entity
		issueDraft.setId(0);

		issueDraftValidationService.checkObject(issueDraft);
		return issueDraftDAO.save(issueDraft);
	}



	public IssueDraft updateIssueDraft(int id, IssueDraft issueDraft) {


		issueDraftValidationService.checkObject(issueDraft);

		// search for object
		IssueDraft issueDraftOld = this.getById(id);
		//update object
		issueDraftOld.setIssueName(issueDraft.getIssueName());
		issueDraftOld.setIssueDescription(issueDraft.getIssueDescription());
		issueDraftOld.setIssueType(issueDraft.getIssueType());

		
		return issueDraftOld;

	}
	

	/**
	 * load all IssueEntities for one IssueDraft
	 * 
	 * @param issueDraftId
	 * @return
	 */
	public Set<IssueEntity> getIssueEntitiesForIssueDraft(int issueDraftId) {
		IssueDraft issueDraft = this.getById(issueDraftId);
		
		Set<IssueEntity> issueEntities = issueDraft.getIssueEntities();

		
		return issueEntities;
	}



}
