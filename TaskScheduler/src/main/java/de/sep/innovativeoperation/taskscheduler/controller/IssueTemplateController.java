package de.sep.innovativeoperation.taskscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.model.IssueTemplate;
import de.sep.innovativeoperation.taskscheduler.service.IssueTemplateService;

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
	private IssueTemplateService issueTemplateService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<IssueTemplate> getIssueListJSON() {
		return issueTemplateService.fetchAllIssueTemplates();
	}

}
