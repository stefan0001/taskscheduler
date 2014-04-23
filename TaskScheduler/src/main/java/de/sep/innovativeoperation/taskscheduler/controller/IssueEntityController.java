package de.sep.innovativeoperation.taskscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.service.IssueEntityService;

/**
 * Controller for CRUD operations on Issue Entities
 * 
 * @author Stefan
 * 
 */
@Controller
@RequestMapping(value = "/issueentities")
@Transactional
public class IssueEntityController {

	@Autowired
	private IssueEntityService issueEntityService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<IssueEntity> getIssueEntities() {
		return issueEntityService.getAllIssueEntities();
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void delteIssueEntities() {
		issueEntityService.deleteAll();
	}

}
