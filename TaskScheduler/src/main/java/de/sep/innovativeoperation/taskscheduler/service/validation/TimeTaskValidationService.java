package de.sep.innovativeoperation.taskscheduler.service.validation;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;

@Service
public class TimeTaskValidationService implements AbstractGenericValidationService<TimeTask> {

	//TODO
	@Override
	public void checkObject(TimeTask object) throws ValidationFailureException {
		if (object.getName() == null) {
			throw new ValidationFailureException();
		} 

		
	}

}
