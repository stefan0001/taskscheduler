package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueEntityValidationService;

/**
 * Logic for IssueEntity management
 * 
 * @author Stefan
 * 
 */
@Service
@Transactional
public class IssueEntityService {

	//DAO's
	@Autowired
	private IssueEntityDAO issueEntityDAO;

	
	//Services
	@Autowired
	private IssueDraftService issueDraftService;
	
	@Autowired
	private IssueEntityValidationService issueEntityValidationService;
	
	
	
	/**
	 * load all IssueEntities
	 * @return
	 */
	public List<IssueEntity> getAllIssueEntities() {
		return issueEntityDAO.fetchAll();
	}
	
	
	/**
	 * load one IssueEntity
	 * @return
	 */
	public IssueEntity getIssueEntity(int issueEntityId) {
		IssueEntity issueEntity = issueEntityDAO.findById(issueEntityId);
		
		if(issueEntity == null){
			throw new ResourceNotFoundException();
		}
		
		return issueEntity;
	}
	
	//TODO
	public IssueEntity createIssueEntity(int issueDraftId, IssueEntity issueEntity) {
		//set id to 0 to tell the database it should be a new entity
		issueEntity.setId( 0 );
		
		issueEntityValidationService.checkObject(issueEntity);
				
		//find the issueDraft
		IssueDraft issueDraft = issueDraftService.getIssueDraft(issueDraftId);
		
		if(issueDraft == null){
			throw new ResourceNotFoundException();
		}
		
		issueEntity.setIssueDraft(issueDraft);
		
		issueEntityDAO.save(issueEntity);
		
		return issueEntity;
	}
	
	

	
	
	
	
	

}
