package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.dao.IssueTemplateDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueTemplate;

/**
 * Logic for IssueTemeplate management
 * @author Stefan
 *
 */
@Service
public class IssueTemplateService {
	@Autowired
	IssueTemplateDAO issueTemplateDAO;

	
	public List<IssueTemplate> fetchAllIssueTemplates(){
		return issueTemplateDAO.fetchAll();
	}
}
