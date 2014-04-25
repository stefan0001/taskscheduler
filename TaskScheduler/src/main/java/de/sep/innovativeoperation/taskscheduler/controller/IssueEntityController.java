package de.sep.innovativeoperation.taskscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.exception.ResourceNotFoundExecption;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.resource.assembler.IssueEntityResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.resource.model.IssueEntityResource;

/**
 * Controller for CRUD operations on Issue Entities
 * 
 * @author Stefan
 * 
 */
@Controller
@RequestMapping(value = "/issueentity")
@Transactional
public class IssueEntityController {

	@Autowired
	private IssueEntityDAO issueEntityDAO;
	
	@Autowired
	private IssueEntityResourceAssembler issueEntityResourceAssembler;

	
	/**
	 * Load all IssueEntities
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<IssueEntityResource> getIssueEntities() {
		return issueEntityResourceAssembler.toResources(issueEntityDAO.fetchAll());
	}
	
	/**
	 * Load one IssueEntity
	 * @return
	 */
	@RequestMapping(value="/{issueentityid}",method = RequestMethod.GET)
	public @ResponseBody IssueEntityResource getIssueEntity( @PathVariable("issueentityid") int id) {
		IssueEntity issueEntity = issueEntityDAO.findById(id);
		
		if(issueEntity == null){
			throw new ResourceNotFoundExecption();
		}
		
		return issueEntityResourceAssembler.toResource( issueEntity );
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void delteIssueEntities() {
		
	}

}
