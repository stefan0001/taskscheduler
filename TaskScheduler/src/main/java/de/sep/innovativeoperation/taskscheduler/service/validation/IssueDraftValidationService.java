package de.sep.innovativeoperation.taskscheduler.service.validation;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;

@Service
public class IssueDraftValidationService implements AbstractGenericValidationService<IssueDraft> {
	
	//TODO
	public void checkObject(IssueDraft object) throws ValidationFailureException {
		
		if (object.getIssueName() == null) {
			throw new ValidationFailureException();
		} else if (object.getIssueDescription() == null) {
			throw new ValidationFailureException();
		} else if (object.getIssueType() == null) {
			throw new ValidationFailureException();
		} 
	}

}
