package de.sep.innovativeoperation.taskscheduler.service.assembler.timetask;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.TimeTaskController;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourcesAssembler;


@Service
public class TimeTasksResourceAssembler  extends AbstractGenericDataResourcesAssembler<TimeTaskResource,TimeTasksResource> {

	public TimeTasksResourceAssembler() {
		super(TimeTaskController.class, TimeTasksResource.class);
	}


	public TimeTasksResource toResource(Iterable<TimeTaskResource> entity) {
		TimeTasksResource resource = new TimeTasksResource(entity);
		
		return resource;
	}



}
