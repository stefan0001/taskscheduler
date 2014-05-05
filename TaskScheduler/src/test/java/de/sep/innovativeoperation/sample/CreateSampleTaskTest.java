package de.sep.innovativeoperation.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;


@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CreateSampleTaskTest {
	@Autowired
	TimeTaskDAO timeTaskDAO;
	
	@Autowired
	IssueDraftDAO issueDraftDAO;
	
	
	
	@Test
	public void test(){
		IssueDraft issueDraft = new IssueDraft("test","test",IssueType.BUG);
		issueDraftDAO.save(issueDraft);
		TimeTask timeTask = new TimeTask("test");
		timeTask.setId(0);
		System.out.println("test");
		timeTaskDAO.save(timeTask);
	}
}
