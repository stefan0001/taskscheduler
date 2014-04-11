package de.sep.innovativeoperation.taskscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

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
	private IssueEntityDAO issueEntityDAO;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<IssueEntity> getIssueEntities() {
		return issueEntityDAO.fetchAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void delteIssueEntities() {
		issueEntityDAO.deleteAll();
	}

}