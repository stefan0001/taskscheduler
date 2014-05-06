package de.sep.innovativeoperation.taskscheduler.service.timetask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericResourceService;
import de.sep.innovativeoperation.taskscheduler.service.assembler.timetask.TimeTaskResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.timetask.TimeTasksResourceAssembler;


@Service
@Transactional
public class TimeTaskResourceService extends AbstractGenericResourceService<TimeTask,TimeTaskResource, TimeTasksResource>{
	//DATA SERVICE	
	@Autowired
	private TimeTaskDataService timeTaskDataService;
	
	@Autowired
	private TimeTaskResourceAssembler timeTaskResourceAssembler;
	
	@Autowired
	private TimeTasksResourceAssembler timeTasksResourceAssembler;
	
	public TimeTaskResource createTimeTask(TimeTaskResource timeTaskResource){
		TimeTask timeTask = timeTaskDataService.createTimeTask(timeTaskResource.getContent() );
		TimeTaskResource resource =  timeTaskResourceAssembler.toResource(timeTask);
		return resource;
	}
	
	/**
	 * update a TimeTask with the given id
	 * @param id	id of the TimeTask
	 * @param timeTask
	 * @return
	 */
	public TimeTaskResource updateTimeTask(int id, TimeTaskResource timeTaskResource){
		TimeTask timeTask = timeTaskDataService.updateTimeTask(id , timeTaskResource.getContent() );
		TimeTaskResource resource =  timeTaskResourceAssembler.toResource(timeTask);
		return resource;
	}
}
