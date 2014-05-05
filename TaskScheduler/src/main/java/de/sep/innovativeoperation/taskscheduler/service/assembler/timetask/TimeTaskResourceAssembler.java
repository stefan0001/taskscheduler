package de.sep.innovativeoperation.taskscheduler.service.assembler.timetask;

import de.sep.innovativeoperation.taskscheduler.controller.TimeTaskController;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;

public class TimeTaskResourceAssembler extends AbstractGenericDataResourceAssembler<TimeTask, TimeTaskResource>{

	public TimeTaskResourceAssembler() {
		super(TimeTaskController.class, TimeTaskResource.class);
	}

	@Override
	public TimeTaskResource toResource(TimeTask entity) {
		TimeTaskResource resource = new TimeTaskResource(entity);
		
		
		return resource;
	}

}
