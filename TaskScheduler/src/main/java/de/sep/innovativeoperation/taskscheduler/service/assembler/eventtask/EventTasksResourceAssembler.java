package de.sep.innovativeoperation.taskscheduler.service.assembler.eventtask;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.EventTaskController;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourcesAssembler;


@Service
public class EventTasksResourceAssembler extends AbstractGenericDataResourcesAssembler<EventTaskResource, EventTasksResource>{

	public EventTasksResourceAssembler(){
		super(EventTaskController.class, EventTasksResource.class);
	}



	@Override
	public EventTasksResource toResource(Iterable<EventTaskResource> entity) {
		EventTasksResource resource = new EventTasksResource(entity);
		
		//TODO
		return resource;
	}

}
