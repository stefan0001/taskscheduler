package de.sep.innovativeoperation.taskscheduler.service.assembler.event;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.EventController;
import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;

@Service
public class EventResourceAssembler extends AbstractGenericDataResourceAssembler<Event, EventResource> {

	public EventResourceAssembler() {
		super(EventController.class,EventResource.class);
	}

	@Override
	public EventResource toResource(Event entity) {
		EventResource resource = new EventResource(entity);
		
		// TODO
		return resource;
	}

}
