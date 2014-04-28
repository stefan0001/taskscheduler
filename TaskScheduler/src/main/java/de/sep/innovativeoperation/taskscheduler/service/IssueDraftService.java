package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.IssueType;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueDraftValidationService;

/**
 * Logic for IssueDraft management
 * 
 * @author Stefan
 * 
 */
@Service
@Transactional
public class IssueDraftService {

	@Autowired
	private IssueDraftDAO issueDraftDAO;

	@Autowired
	private IssueDraftValidationService issueDraftValidationService;

	// TODO id should be 0
	public IssueDraft createIssueDraft(IssueDraft issueDraft) {

		// set id to 0 to tell the database it should be a new entity
		issueDraft.setId(0);

		issueDraftValidationService.checkObject(issueDraft);
		return issueDraftDAO.save(issueDraft);
	}

	// TODO id should be != 0
	public IssueDraft updateIssueDraft(int id, IssueDraft issueDraft) {

		// id change is not allowed
		issueDraft.setId(id);

		issueDraftValidationService.checkObject(issueDraft);

		// search for object
		IssueDraft oldDraft = issueDraftDAO.findById(id);

		if (oldDraft == null) {
			throw new ResourceNotFoundException();
		}

		issueDraftDAO.save(issueDraft);

		return issueDraft;

	}
	
	/**
	 * Delete a IssueDraft with a given id
	 * @param id
	 */
	public void deleteIssueDraft(int id) {

		//find issuedraft

		IssueDraft issueDraft = issueDraftDAO.findById(id);

		if (issueDraft == null) {
			throw new ResourceNotFoundException();
		}

		issueDraftDAO.remove(issueDraft);

	}

	/**
	 * load all IssueDrafts
	 * 
	 * @param issueDraftId
	 * @return
	 */
	public List<IssueDraft> getAllIssueDrafts() {
		List<IssueDraft> issueDrafts = issueDraftDAO.fetchAll();

		return issueDrafts;
	}

	/**
	 * load one IssueDraft
	 * 
	 * @param issueDraftId
	 * @return
	 */
	public IssueDraft getIssueDraft(int issueDraftId) {
		IssueDraft issueDraft = issueDraftDAO.findById(issueDraftId);

		if (issueDraft == null) {
			throw new ResourceNotFoundException();
		}

		return issueDraft;
	}

	/**
	 * load all IssueEntities for one IssueDraft
	 * 
	 * @param issueDraftId
	 * @return
	 */
	public Set<IssueEntity> getIssueEntitiesForIssueDraft(int issueDraftId) {
		IssueDraft issueDraft = issueDraftDAO.findById(issueDraftId);

		if (issueDraft == null) {
			throw new ResourceNotFoundException();
		}
		Set<IssueEntity> issueEntities = issueDraftDAO
				.getIssueEntitiesForIssueDraft(issueDraft);

		if (issueEntities == null) {
			throw new ResourceNotFoundException();
		}
		return issueEntities;
	}

	@Transactional(rollbackFor = ValidationFailureException.class)
	public void test() throws ValidationFailureException {
		IssueDraft id1 = new IssueDraft("OMG1", "OMG", IssueType.BUG);
		this.createIssueDraft(id1);
		IssueDraft id2 = new IssueDraft("OMG2", null, IssueType.BUG);
		this.createIssueDraft(id2);
	}

}
