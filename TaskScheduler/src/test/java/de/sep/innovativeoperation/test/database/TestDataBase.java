package de.sep.innovativeoperation.test.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;

@Transactional
//@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDataBase {

	@Autowired
	IssueDraftDAO issueDraftDAO;
	@Autowired
	IssueEntityDAO issueEntityDAO;

	@Test
	public void test() {
		IssueDraft issueDraft = new IssueDraft("testName 1",
				"testDescription 1", IssueType.BUG);
		issueDraft = issueDraftDAO.save(issueDraft);
		System.out.println("issueDraftID = " +issueDraft.getId());
		IssueEntity issueEntity = new IssueEntity(IssueStatus.NEW,
				IssueResolution.UNRESOLVED, issueDraft);
		issueEntity = issueEntityDAO.save(issueEntity);
		System.out.println(issueEntity.getId());
	}
}
