package de.sep.innovativeoperation.taskscheduler.service.assembler.timetask;

import de.sep.innovativeoperation.taskscheduler.controller.TimeTaskController;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourcesAssembler;

public class TimeTasksResourceAssembler  extends AbstractGenericDataResourcesAssembler<TimeTaskResource,TimeTasksResource> {

	public TimeTasksResourceAssembler() {
		super(TimeTaskController.class, TimeTasksResource.class);
	}


	public TimeTasksResource toResource(Iterable<TimeTaskResource> entity) {
		TimeTasksResource resource = new TimeTasksResource(entity);
		
		return resource;
	}



}
