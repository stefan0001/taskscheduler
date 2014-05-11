package de.sep.innovativeoperation.taskscheduler.service.eventtask;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericResourceService;
import de.sep.innovativeoperation.taskscheduler.service.assembler.eventtask.EventTaskResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.eventtask.EventTasksResourceAssembler;

@Service
@Transactional
public class EventTaskResourceService extends AbstractGenericResourceService<EventTask, EventTaskResource, EventTasksResource>{
	//DATA SERVICE
	@Autowired
	private EventTaskDataService eventTaskDataService;
	
	//ASSEMBLER
	@Autowired
	private EventTaskResourceAssembler eventTaskResourceAssembler;
	@Autowired
	private EventTasksResourceAssembler eventTasksResourceAssembler;

	
	
	/**
	 * Create a new EventTask
	 * @param eventTaskResource EventTaskResources containing the information for creating a new EventTask
	 * @return	EventTaskresource containing the new EventTask from the Database
	 */
	public EventTaskResource createEventTask(EventTaskResource eventTaskResource) {
		EventTask createdEventTask = eventTaskDataService.createEventTask(eventTaskResource.getContent());
		return eventTaskResourceAssembler.toResource(createdEventTask);

	}

	/**
	 * Update a EventTask
	 * @param id	id of the event task
	 * @param eventTaskResource	EventTaskResources containing the information for the update
	 * @return the updated EventTaskResource
	 */
	public EventTaskResource updateEventTask(int id, EventTaskResource eventTaskResource) {
		EventTask updateEventTask = eventTaskDataService.updateEventTask(id, eventTaskResource.getContent());
		return eventTaskResourceAssembler.toResource(updateEventTask);
	}
}
