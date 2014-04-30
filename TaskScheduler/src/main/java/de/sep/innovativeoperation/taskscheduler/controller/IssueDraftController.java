package de.sep.innovativeoperation.taskscheduler.controller;

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
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.IssueDraftService;
import de.sep.innovativeoperation.taskscheduler.service.IssueEntityService;

/**
 * Controller for CRUD operations on Issue Templates
 * 
 * @author Stefan
 * 
 */
@Controller
@RequestMapping(value = "/issuedraft")
public class IssueDraftController {

	//SERVICES
	@Autowired
	private IssueDraftService issueDraftService;
	@Autowired
	private IssueEntityService issueEntityService;
	
	
	
	
	/**
	 * Load all IssueDrafts
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<IssueDraftResource> getIssueDrafts() {
		List<IssueDraft> issueDrafts = issueDraftService.getAllIssueDrafts();
		
		return null;
	}
	
	
	/**
	 * Load one IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody IssueDraftResource getIssueDraft( @PathVariable("issuedraftid") int id) {
		IssueDraft issueDraft = issueDraftService.getIssueDraft(id);

		return null;
	}
	
	/**
	 * Update an issuedraft
	 * @param id			The id of the issuedraft
	 * @param issueDraft	The updated information of the issuedraft
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody IssueDraftResource getIssueDraft( @PathVariable("issuedraftid") int id,  @RequestBody IssueDraft issueDraft) {
		IssueDraft updatedIssueDraft = issueDraftService.updateIssueDraft(id, issueDraft);

		return null;
	}
	
	
	/**
	 * Delete IssueDraft with a given id
	 * @param id
	 * @param issueDraft
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody void deleteIssueDraft( @PathVariable("issuedraftid") int id) {
		issueDraftService.deleteIssueDraft(id);
	}
	
	
	//TODO
	/**
	 * Load all IssueEntities for a given IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}/issueentity",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<IssueEntityResource> getIssueEntitiesforIssueDrafts( @PathVariable("issuedraftid") int id) {
		
		Set<IssueEntity> issueEntities = issueDraftService.getIssueEntitiesForIssueDraft(id);

		return null;
	}
	
	
	/**
	 * Create new IssueEntity for a IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}/issueentity",method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody IssueEntityResource createIssueEntityforIssueDrafts( @PathVariable("issuedraftid") int id, @RequestBody IssueEntity issueEntity) {

		IssueEntity createdIssueEntity = issueEntityService.createIssueEntity(id, issueEntity);

		return null;
	}
	
	
	
	
	/**
	 * Receive a new Issue Draft and save it
	 * @param issueDraft
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody IssueDraftResource createIssueDraft( @RequestBody IssueDraft issueDraft) {

		issueDraft = issueDraftService.createIssueDraft(issueDraft);

		return null;
	}
	
	
	
	


}
