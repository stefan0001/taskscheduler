package de.sep.innovativeoperation.taskscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.resource.assembler.IssueDraftResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.resource.model.IssueDraftResource;

/**
 * Controller for CRUD operations on Issue Templates
 * 
 * @author Stefan
 * 
 */
@Controller
@RequestMapping(value = "/issuedraft")
public class IssueDraftController {

	@Autowired
	private IssueDraftDAO issueDraftDAO;
	
	@Autowired
	private IssueDraftResourceAssembler issueDraftResourceAssembler;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<IssueDraftResource> getIssueDrafts() {
		List<IssueDraft> issueDrafts = issueDraftDAO.fetchAll();
		
		return issueDraftResourceAssembler.toResources(issueDrafts);
	}
	
	@RequestMapping(value="/{issuedraftid}/issueentity",method = RequestMethod.GET)
	public @ResponseBody List<IssueEntity> getIssueEntitiesforIssueDrafts( @PathVariable("issuedraftid") int id) {
		//TODO
		return null;
	}
	
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.GET)
	public @ResponseBody IssueDraftResource getIssueDraft( @PathVariable("issuedraftid") int id) {
		IssueDraft issueDraft = issueDraftDAO.findById(id);

		return issueDraftResourceAssembler.toResource(issueDraft);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void delteIssueDrafts() {
		issueDraftDAO.deleteAll();
	}

}
