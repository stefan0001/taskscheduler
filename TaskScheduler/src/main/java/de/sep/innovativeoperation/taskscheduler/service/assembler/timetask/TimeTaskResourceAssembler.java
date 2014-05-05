package de.sep.innovativeoperation.taskscheduler.service.assembler.timetask;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.TimeTaskController;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;

@Service
public class TimeTaskResourceAssembler extends AbstractGenericDataResourceAssembler<TimeTask, TimeTaskResource>{

	public TimeTaskResourceAssembler() {
		super(TimeTaskController.class, TimeTaskResource.class);
	}

	public TimeTaskResource toResource(TimeTask entity) {
		TimeTaskResource resource = new TimeTaskResource(entity);
		
		
		return resource;
	}

}
