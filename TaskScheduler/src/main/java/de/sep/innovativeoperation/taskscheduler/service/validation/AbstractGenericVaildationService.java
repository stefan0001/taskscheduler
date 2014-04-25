package de.sep.innovativeoperation.taskscheduler.service.validation;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;

@Service
public interface AbstractGenericVaildationService<T> {
	
	public abstract void checkObject(T object) throws ValidationFailureException;
}
