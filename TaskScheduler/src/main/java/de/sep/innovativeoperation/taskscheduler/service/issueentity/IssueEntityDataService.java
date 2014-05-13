package de.sep.innovativeoperation.taskscheduler.service.issueentity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNullException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericDataService;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftDataService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueDraftValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueEntityValidationService;

/**
 * Logic for IssueEntity management
 * 
 * @author Stefan
 * 
 */
@Service
@Transactional
public class IssueEntityDataService extends
		AbstractGenericDataService<IssueEntity> {

	// DAO's
	@Autowired
	private IssueEntityDAO issueEntityDAO;

	// Services
	@Autowired
	private IssueDraftDataService issueDraftService;

	@Autowired
	private IssueEntityValidationService issueEntityValidationService;

	@Autowired
	private IssueDraftValidationService issueDraftValidationService;

	// TODO
	public IssueEntity createIssueEntity(int issueDraftId, IssueEntity issueEntity) {
		// find the issueDraft
		IssueDraft issueDraft = issueDraftService.getById(issueDraftId);

		// set id to 0 to tell the database it should be a new entity
		issueEntity.setId(0);
		issueEntity.setIssueDraft(issueDraft);

		issueEntityValidationService.checkObject(issueEntity);

		issueEntity = issueEntityDAO.save(issueEntity);

		return issueEntity;
	}

	/**
	 * Update IssueEntity
	 * 
	 * @param id
	 * @param issueEntity
	 * @return
	 */
	// TODO id should be != 0
	public IssueEntity updateIssueEntity(int id, IssueEntity issueEntity) {

		issueEntityValidationService.checkObject(issueEntity);

		// search for object
		IssueEntity oldEntity = this.getById(id);

		// update object
		oldEntity.setIssueResolution(issueEntity.getIssueResolution());
		oldEntity.setIssueStatus(issueEntity.getIssueStatus());

		return oldEntity;
		

	}

	public List<IssueEntity> filterIssueEntity(IssueEntity issueEntity, IssueDraft issueDraft) {
		// check values ignore null values
		try {
			issueEntityValidationService.checkIssueStatus(issueEntity
					.getIssueStatus());
		} catch (ValueIsNullException e) {
		}

		try {
			issueEntityValidationService.checkIssueResolution(issueEntity
					.getIssueResolution());
		} catch (ValueIsNullException e) {
		}

		try {
			issueDraftValidationService.checkIssueName(issueDraft
					.getIssueName());
		} catch (ValueIsNullException e) {
		}

		try {
			issueDraftValidationService.checkIssueDescription(issueDraft
					.getIssueDescription());
		} catch (ValueIsNullException e) {
		}

		try {
			issueDraftValidationService.checkIssueType(issueDraft
					.getIssueType());
		} catch (ValueIsNullException e) {
		}

		return issueEntityDAO.filterIssueEntity(issueEntity.getIssueStatus(),
				issueEntity.getIssueResolution(), issueDraft.getIssueName(),
				issueDraft.getIssueDescription(), issueDraft.getIssueType());

	}

}
