package de.sep.innovativeoperation.taskscheduler.controller;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.timetask.TimeTaskResourceService;

@Controller
@RequestMapping(value = "/timetask")
public class TimeTaskController {
	
	//ResourceService
	@Autowired
	TimeTaskResourceService timeTaskResourceService;
	
	/**
	 * Load all TimetTasks
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = JSON)
	public @ResponseBody TimeTasksResource getAllTimeTask() {
		return timeTaskResourceService.getAll();
	}

	/**
	 * Load one TimeTask
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{timetaskid}", method = RequestMethod.GET, produces = JSON)
	public @ResponseBody TimeTaskResource getOneTimeTask(@PathVariable("timetaskid") int id) {
		return timeTaskResourceService.getById(id);

	}


	/**
	 * Delete a TimeTask with a given id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{timetaskid}", method = RequestMethod.DELETE, produces = JSON)
	public void deleteIssueEntity(@PathVariable("timetaskid") int id) {
		timeTaskResourceService.deleteById(id);
	}
	
	
	/**
	 * Create new TimeTask
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, produces = JSON)
	public @ResponseBody TimeTaskResource createTimeTask( @RequestBody TimeTaskResource timeTaskResource) {
		return timeTaskResourceService.createTimeTask(timeTaskResource);
	}
	
	
	
	/**
	 * Update a TimeTask
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{timetaskid}",method = RequestMethod.PUT, produces = JSON)
	public @ResponseBody TimeTaskResource updateTimeTask( @PathVariable("timetaskid") int id, @RequestBody TimeTaskResource timeTaskResource) {
		return timeTaskResourceService.updateTimeTask(id, timeTaskResource);
	}
	
	
	/**
	 * get all IssueDrafts for the TimeTask with the id
	 * @param id
	 * @return IssueDraftResource
	 */
	@RequestMapping(value="/{timetaskid}/issuedraft",method = RequestMethod.GET, produces = JSON)
	public @ResponseBody IssueDraftsResource getIssueDraftsforTimeTask(@PathVariable("timetaskid") int id){
		return timeTaskResourceService.getIssueDraftsforTimeTask(id);
	}
	
	
	
	/**
	 * add a IssueDraft to a TimeTask
	 * creating a new issuedraft for the issuedraftid==0 
	 * creating a relation for issuedraftid != 0
	 * @param id                  id of the task
	 * @param issueDraftResource  the issuedraft with the issuedraftid
	 * @return IssueDraftResource
	 */
	@RequestMapping(value="/{timetaskid}/issuedraft",method = RequestMethod.POST, produces = JSON)
	public @ResponseBody IssueDraftResource addIssueDraftstoTimeTask(@PathVariable("timetaskid") int id, @RequestBody IssueDraftResource issueDraftResource){
		return timeTaskResourceService.addIssueDraftstoTimeTask(id, issueDraftResource);
	}
	
	
	

}
