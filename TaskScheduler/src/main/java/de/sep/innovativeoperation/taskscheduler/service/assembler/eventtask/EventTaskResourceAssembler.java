package de.sep.innovativeoperation.taskscheduler.service.assembler.eventtask;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.EventTaskController;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTaskResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;


@Service
public class EventTaskResourceAssembler extends AbstractGenericDataResourceAssembler<EventTask, EventTaskResource>{

	public EventTaskResourceAssembler() {
		super(EventTaskController.class, EventTaskResource.class);
	}

	@Override
	public EventTaskResource toResource(EventTask entity) {
		EventTaskResource resource = new EventTaskResource(entity);
		
		//TODO
		return resource;
	}

}
