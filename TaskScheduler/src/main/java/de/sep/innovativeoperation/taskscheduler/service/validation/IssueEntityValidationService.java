package de.sep.innovativeoperation.taskscheduler.service.validation;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

@Service
public class IssueEntityValidationService implements AbstractGenericValidationService<IssueEntity>{


	@Override
	public void checkObject(IssueEntity object) throws ValidationFailureException {
		if (object.getIssueResolution() == null) {
			throw new ValidationFailureException();
		} else if (object.getIssueStatus() == null) {
			throw new ValidationFailureException();
		} 
	}

}
