package de.sep.innovativeoperation.taskscheduler.service.assembler.event;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.EventController;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventsResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourcesAssembler;

@Service
public class EventsResourceAssembler extends AbstractGenericDataResourcesAssembler<EventResource, EventsResource>{

	public EventsResourceAssembler() {
		super(EventController.class,EventsResource.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EventsResource toResource(Iterable<EventResource> entity) {
		EventsResource resource = new EventsResource(entity);
		
		//TODO
		return resource;
	}

}
