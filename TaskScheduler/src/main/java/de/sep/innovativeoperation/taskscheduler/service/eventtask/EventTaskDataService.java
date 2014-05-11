package de.sep.innovativeoperation.taskscheduler.service.eventtask;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericDataService;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventTaskValidationService;

@Service
@Transactional
public class EventTaskDataService extends AbstractGenericDataService<EventTask> {

	
	//SERVICES
	@Autowired
	private EventTaskValidationService eventTaskValidationService;
	
	//DAO
	@Autowired
	private EventTaskDAO EventTaskDAO;
	
	
	/**
	 * Create a new EventTask
	 * @param EventTask 
	 * @return EventTask from database
	 */
	public EventTask createEventTask(EventTask eventTask) {
		// set id to 0 to tell the database it should be a new entity
		eventTask.setId(0);

		eventTaskValidationService.checkObject(eventTask);
		return EventTaskDAO.save(eventTask);
	}



	/**
	 * update a EventTask with a given id
	 * @param id 	id of the EventTask
	 * @param EventTask the update data
	 * @return EventTask updated from database
	 */
	public EventTask updateEventTask(int id, EventTask eventTask) {

		eventTaskValidationService.checkObject(eventTask);

		// search for object
		EventTask eventTaskDB = EventTaskDAO.findById(id);
		
		//update object
		eventTaskDB.setName(eventTask.getName());
		
		
		
		return eventTaskDB;
	}
}
