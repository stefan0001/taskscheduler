package de.sep.innovativeoperation.taskscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;

/**
 * Logic for IssueEntity management
 * 
 * @author Stefan
 * 
 */
@Service
public class IssueEntityService {
	
	@Autowired
	IssueEntityDAO issueEntityDAO;

}
