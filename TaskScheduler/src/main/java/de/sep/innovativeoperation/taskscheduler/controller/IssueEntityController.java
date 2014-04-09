package de.sep.innovativeoperation.taskscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class IssueEntityController {

	@Autowired
	private IssueEntityService issueEntityService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody IssueEntity getIssueListJSON() {
		return new IssueEntity();
	}

}
