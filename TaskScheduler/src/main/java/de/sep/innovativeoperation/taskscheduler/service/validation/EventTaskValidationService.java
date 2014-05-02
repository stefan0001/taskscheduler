package de.sep.innovativeoperation.taskscheduler.service.validation;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.model.EventTask;

@Service
public class EventTaskValidationService implements
		AbstractGenericValidationService<EventTask> {

	public void checkObject(EventTask eventTask) throws ValidationFailureException {
		if(eventTask.getIssueDrafts().size() == 0){
			throw new ValidationFailureException();
		}else if(eventTask.getEvent() == null){
			throw new ValidationFailureException();			
		}
		
	}

}
