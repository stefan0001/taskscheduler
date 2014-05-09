package de.sep.innovativeoperation.taskscheduler.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class IssueEntityDAOTest {
	@Autowired
	IssueEntityDAO issueEntityDAO;
	
	@Test
	public void test(){
		IssueEntity iefilter = new IssueEntity();
		iefilter.setIssueStatus(IssueStatus.NEW);
		IssueDraft idfilter = new IssueDraft();
		
		System.out.println("______________________________");
		System.out.println("issueentitysize: " + issueEntityDAO.filterIssueEntity(iefilter, idfilter).size());
		System.out.println("______________________________");
		
	}
}
