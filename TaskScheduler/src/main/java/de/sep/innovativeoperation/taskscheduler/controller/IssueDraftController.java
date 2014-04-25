package de.sep.innovativeoperation.taskscheduler.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.exception.ResourceNotFoundExecption;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.resource.assembler.IssueDraftResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.resource.assembler.IssueEntityResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.resource.model.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.resource.model.IssueEntityResource;

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
	@Autowired
	private IssueEntityResourceAssembler issueEntityResourceAssembler;
	
	
	/**
	 * Load all IssueDrafts
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<IssueDraftResource> getIssueDrafts() {
		List<IssueDraft> issueDrafts = issueDraftDAO.fetchAll();
		
		return issueDraftResourceAssembler.toResources(issueDrafts);
	}
	
	
	/**
	 * Load one IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody IssueDraftResource getIssueDraft( @PathVariable("issuedraftid") int id) {
		IssueDraft issueDraft = issueDraftDAO.findById(id);
		if(issueDraft == null){
			throw new ResourceNotFoundExecption();
		}

		return issueDraftResourceAssembler.toResource(issueDraft);
	}
	
	
	/**
	 * Load all IssueEntities for a given IssueDraft
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{issuedraftid}/issueentity",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<IssueEntityResource> getIssueEntitiesforIssueDrafts( @PathVariable("issuedraftid") int id) {
		Set<IssueEntity> issueEntities = issueDraftDAO.getIssueEntitiesForIssueDraft(id);
		if(issueEntities == null){
			throw new ResourceNotFoundExecption();
		}
		return issueEntityResourceAssembler.toResources(issueEntities);
	}
	
	
	//TODO
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody IssueDraftResource createIssueDraft( @RequestBody IssueDraft issueDraft) {

		return issueDraftResourceAssembler.toResource(issueDraft);
		
	}
	
	


}
