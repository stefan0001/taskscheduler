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
@RequestMapping(value = "/issuedraft")
public class IssueDraftController {

	@Autowired
	private IssueDraftDAO issueDraftDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<IssueDraft> getIssueDrafts() {
		List<IssueDraft> list = issueDraftDAO.fetchAll();
		return list;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void delteIssueDrafts() {
		issueDraftDAO.deleteAll();
	}

}
