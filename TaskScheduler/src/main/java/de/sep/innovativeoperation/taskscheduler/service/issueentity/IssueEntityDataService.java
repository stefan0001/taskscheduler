package de.sep.innovativeoperation.taskscheduler.service.issueentity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftDataService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueEntityValidationService;

/**
 * Logic for IssueEntity management
 * 
 * @author Stefan
 * 
 */
@Service
@Transactional
public class IssueEntityDataService {

	//DAO's
	@Autowired
	private IssueEntityDAO issueEntityDAO;

	
	//Services
	@Autowired
	private IssueDraftDataService issueDraftService;
	
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
		//find the issueDraft
		IssueDraft issueDraft = issueDraftService.getIssueDraft(issueDraftId);
		
		System.out.println(issueDraft);
		if(issueDraft == null){
			throw new ResourceNotFoundException();
		}
		
		//set id to 0 to tell the database it should be a new entity
		issueEntity.setId( 0 );
		issueEntity.setIssueDraft(issueDraft);

		issueEntityValidationService.checkObject(issueEntity);
				

		issueEntity = issueEntityDAO.save(issueEntity);
		
		
		return issueEntity;
	}
	
	/**
	 * Update IssueEntity
	 * @param id
	 * @param issueEntity
	 * @return
	 */
	// TODO id should be != 0
	public IssueEntity updateIssueEntity(int id, IssueEntity issueEntity) {

		// id change is not allowed
		issueEntity.setId(id);

		issueEntityValidationService.checkObject(issueEntity);

		// search for object
		IssueEntity oldEntity = issueEntityDAO.findById(id);

		if (oldEntity == null) {
			throw new ResourceNotFoundException();
		}
		
		//draft change is not allowed
		issueEntity.setIssueDraft(oldEntity.getIssueDraft());

		issueEntity = issueEntityDAO.save(issueEntity);

		return issueEntity;

	}
	
	
	/**
	 * Delete a IssueEntity with a given id
	 * @param id
	 */
	public void deleteIssueEntity(int id){
		//find issueentity
		IssueEntity issueEntity = issueEntityDAO.findById(id);

		if (issueEntity == null) {
			throw new ResourceNotFoundException();
		}

		issueEntityDAO.remove(issueEntity);
	}
	
	
	
	

}
