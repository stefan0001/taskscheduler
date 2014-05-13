package de.sep.innovativeoperation.taskscheduler.controller;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftResourceService;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityResourceService;
/**
 * Controller for CRUD operations on Issue Drafts
 * 
 * @author Stefan
 * 
 */
@Controller
@RequestMapping(value = "/issuedraft")
public class IssueDraftController {

	//SERVICES
	@Autowired
	private IssueDraftResourceService issueDraftResourceService;
	@Autowired
	private IssueEntityResourceService issueEntityResourceService;
	
	
	
	
	/**
	 * Load all IssueDrafts
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = JSON)
	public @ResponseBody IssueDraftsResource getIssueDrafts() {
		return issueDraftResourceService.getAll();
		

	}
	
//	/**
//	 * Search for IssueDrafts that looks like
//	 * @param issueDraftResource
//	 * @return
//	 */
//	@RequestMapping(method = RequestMethod.GET, produces = JSON)
//	public @ResponseBody IssueDraftsResource getIssueDrafts(IssueDraftResource issueDraftResource) {
//		return issueEntityResourceService
//		
//
//	}
	
	
	/**
	 * Load one IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.GET, produces = JSON)
	public @ResponseBody IssueDraftResource getIssueDraft( @PathVariable("issuedraftid") int id) {
		return issueDraftResourceService.getById(id);
	}
	
	/**
	 * Update an issuedraft
	 * @param id			The id of the issuedraft
	 * @param issueDraft	The updated information of the issuedraft
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.PUT, produces = JSON)
	public @ResponseBody IssueDraftResource getIssueDraft( @PathVariable("issuedraftid") int id,  @RequestBody IssueDraftResource issueDraftResource) {
		return issueDraftResourceService.updateIssueDraft(id, issueDraftResource);
	}
	
	
	/**
	 * Delete IssueDraft with a given id
	 * @param id
	 * @param issueDraft
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.DELETE, produces = JSON)
	public @ResponseBody void deleteIssueDraft( @PathVariable("issuedraftid") int id) {
		issueDraftResourceService.deleteById(id);
	}
	
	

	/**
	 * Load all IssueEntities for a given IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}/issueentity",method = RequestMethod.GET, produces = JSON)
	public @ResponseBody IssueEntitiesResource getIssueEntitiesforIssueDrafts( @PathVariable("issuedraftid") int id) {
		return issueDraftResourceService.getIssueEntitiesForIssueDraft(id);
	}
	
	/**
	 * Create new IssueEntity for a IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}/issueentity",method = RequestMethod.POST, produces = JSON)
	public @ResponseBody IssueEntityResource createIssueEntityforIssueDrafts( @PathVariable("issuedraftid") int id, @RequestBody IssueEntityResource issueEntityResource) {
		return issueEntityResourceService.createIssueEntity(id, issueEntityResource);
	}
	
	
	
	
	/**
	 * Receive a new Issue Draft and save it
	 * @param issueDraft
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, produces = JSON)
	public @ResponseBody IssueDraftResource createIssueDraft( @RequestBody IssueDraftResource issueDraftResource) {
		return issueDraftResourceService.createIssueDraft(issueDraftResource);
	}
	
	

	
	
	
	


}
