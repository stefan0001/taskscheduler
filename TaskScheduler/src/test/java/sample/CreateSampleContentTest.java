package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;


@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CreateSampleContentTest {
	@Autowired
	TimeTaskDAO timeTaskDAO;
	
	@Autowired
	IssueDraftDAO issueDraftDAO;
	
	@Autowired
	IssueEntityDAO issueEntityDAO;
	
	@Test
	public void test(){
		TimeTask timeTask = new TimeTask("test");

		
		IssueDraft issueDraft = new IssueDraft("Test","Test",IssueType.BUG);


		
		timeTaskDAO.save(timeTask);
		issueDraftDAO.save(issueDraft);
		IssueEntity issueEntity = new IssueEntity(IssueStatus.CLOSED, IssueResolution.CANNOT_REPRODUCE, issueDraft);
		issueEntityDAO.save(issueEntity);
		
		timeTask.getIssueDrafts().add(issueDraft);
		
		
		
		
	}
}
