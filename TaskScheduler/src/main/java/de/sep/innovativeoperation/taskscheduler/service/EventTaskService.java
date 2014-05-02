package de.sep.innovativeoperation.taskscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.EventTask;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventTaskValidationService;

@Service
public class EventTaskService {
	
	@Autowired
	private EventTaskDAO eventTaskDAO;
	
	@Autowired
	private EventTaskValidationService validationService;
	
	public EventTask createEventTask(EventTask eventTask){
		
		//check constraints before saving
		validationService.checkObject(eventTask);
		eventTask.setId(0);
		return eventTaskDAO.save(eventTask);
	}

	
}
