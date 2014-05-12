package de.sep.innovativeoperation.taskscheduler.service.eventtask;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericDataService;
import de.sep.innovativeoperation.taskscheduler.service.event.EventDataService;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventTaskValidationService;

@Service
@Transactional
public class EventTaskDataService extends AbstractGenericDataService<EventTask> {

	
	//SERVICES
	@Autowired
	private EventTaskValidationService eventTaskValidationService;
	
	@Autowired
	private EventDataService eventDataService;
	
	//DAO
	@Autowired
	private EventTaskDAO EventTaskDAO;
	
	
	/**
	 * Create a new EventTask
	 * @param eventid  id of the event
	 * @param EventTask 
	 * @return EventTask from database
	 */
	public EventTask createEventTask(int eventid, EventTask eventTask) {
		Event event = eventDataService.getById(eventid);
		
		// set id to 0 to tell the database it should be a new entity
		eventTask.setId(0);
		
		eventTask.setEvent(event);

		eventTaskValidationService.checkObject(eventTask);
		return EventTaskDAO.save(eventTask);
	}
	
	//TODO
	public EventTask createEventTask(Event event, EventTask eventTask) {
		
		if(event.getId() == 0){
			//creating a new event and receive it with a id
			event = eventDataService.createEvent(event);
		} 
		
		
		return createEventTask(event.getId() , eventTask);

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
