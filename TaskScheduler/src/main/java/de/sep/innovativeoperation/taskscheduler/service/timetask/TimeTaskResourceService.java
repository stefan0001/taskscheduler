package de.sep.innovativeoperation.taskscheduler.service.timetask;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericResourceService;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft.IssueDraftResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft.IssueDraftsResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.timetask.TimeTaskResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.timetask.TimeTasksResourceAssembler;


@Service
@Transactional
public class TimeTaskResourceService extends AbstractGenericResourceService<TimeTask,TimeTaskResource, TimeTasksResource>{
	//DATA SERVICE	
	@Autowired
	private TimeTaskDataService timeTaskDataService;
	
	//ASSEMBLER
	
	//TIMETASK
	@Autowired
	private TimeTaskResourceAssembler timeTaskResourceAssembler;
	@Autowired
	private TimeTasksResourceAssembler timeTasksResourceAssembler;
	
	//ISSUEDRAFT
	@Autowired
	private IssueDraftResourceAssembler issueDraftResourceAssembler;
	@Autowired
	private IssueDraftsResourceAssembler issueDraftsResourceAssembler;
	
	
	
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
	
	
	/**
	 * get all IssueDrafts for the TimeTask with the id
	 * @param id 	id of the TimeTask
	 * @return
	 */
	public IssueDraftsResource getIssueDraftsforTimeTask(int id){
		//get issuedraft
		Set<IssueDraft> issueDrafts = timeTaskDataService.getIssueDraftsforTimeTask(id);
		//generate resources
		List<IssueDraftResource> issueDraftResoruces = issueDraftResourceAssembler.toResources(issueDrafts);
		//generate resources to one resource
		return issueDraftsResourceAssembler.toResource(issueDraftResoruces);
		
	}
	
	
	
	/**
	 * add a IssueDraft to a TimeTask
	 * creating a new issuedraft for the issuedraftid==0 
	 * creating a relation for issuedraftid != 0
	 * @param id                  id of the task
	 * @param issueDraftResource  the issuedraft with the issuedraftid
	 * @return IssueDraftResource
	 */
	public IssueDraftResource addIssueDraftstoTimeTask(int id, IssueDraftResource issueDraftResource){
		 IssueDraft issueDraft = timeTaskDataService.addIssueDraftstoTimeTask(id, issueDraftResource.getContent());
		 IssueDraftResource newIssueDraftResource = issueDraftResourceAssembler.toResource(issueDraft);
		 
		 return newIssueDraftResource;

	}
}
