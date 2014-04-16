package de.sep.innovativeoperation.taskscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;

/**
 * Controller for CRUD operations on Issue Templates
 * 
 * @author Stefan
 * 
 */
@Controller
@RequestMapping(value = "/issuetemplates")
public class IssueTemplateController {

	@Autowired
	private IssueDraftDAO issueTemplateDAO;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<IssueDraft> getIssueTemplates() {
		return issueDraftDAO.fetchAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void delteIssueTemplates() {
		issueDraftDAO.deleteAll();
	}

}
