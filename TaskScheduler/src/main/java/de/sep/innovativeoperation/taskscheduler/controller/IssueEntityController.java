package de.sep.innovativeoperation.taskscheduler.controller;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityResourceService;
/**
 * Controller for CRUD operations on Issue Entities
 * 
 * @author Stefan
 * 
 */
@Controller
@RequestMapping(value = "/issueentity")
public class IssueEntityController {

	
	// ResourceService
	@Autowired
	private IssueEntityResourceService issueEntityResourceService;

	/**
	 * Load all IssueEntities
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = JSON)
	public @ResponseBody IssueEntitiesResource getIssueEntities() {
		return issueEntityResourceService.getAllIssueEntities();
	}

	/**
	 * Load one IssueEntity
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{issueentityid}", method = RequestMethod.GET, produces = JSON)
	public @ResponseBody IssueEntityResource getIssueEntity(@PathVariable("issueentityid") int id) {
		return issueEntityResourceService.getIssueEntity(id);

	}

	/**
	 * Update one issueEntity
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{issueentityid}", method = RequestMethod.PUT, produces = JSON)
	public @ResponseBody IssueEntityResource updateIssueEntity(@PathVariable("issueentityid") int id, @RequestBody IssueEntityResource issueEntityResource) {
		return issueEntityResourceService.updateIssueEntity(id, issueEntityResource);
	}

	/**
	 * Delete a IssueEntity with a given id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{issueentityid}", method = RequestMethod.DELETE, produces = JSON)
	public void deleteIssueEntity(@PathVariable("issueentityid") int id) {
		issueEntityResourceService.deleteIssueEntity(id);
	}

}
