package de.sep.innovativeoperation.taskscheduler.service.validation;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.exception.validation.issuedraft.IssueDraftValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;

@Service
public class IssueDraftValidationService implements AbstractGenericVaildationService<IssueDraft> {
	
	//TODO
	@Override
	public void checkObject(IssueDraft object) throws IssueDraftValidationFailureException {
		
		if (object.getIssueName() == null) {
			throw new IssueDraftValidationFailureException();
		} else if (object.getIssueDescription() == null) {
			throw new IssueDraftValidationFailureException();
		} else if (object.getIssueType() == null) {
			throw new IssueDraftValidationFailureException();
		} else if (object.getId() != 0){
			throw new IssueDraftValidationFailureException();
		}
	}

}
