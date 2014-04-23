package de.sep.innovativeoperation.test.persistence.issueentity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.IssueType;

@TransactionConfiguration(defaultRollback = false)
@Transactional
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPersistenceIssueEntity {

	@Autowired
	protected IssueEntityDAO issueEntityDAO;
	@Autowired
	protected IssueDraftDAO issueDraftDAO;

	@Test
	public void testEntity() {
		IssueDraft id = new IssueDraft("TEST", "TEST", IssueType.BUG);

		IssueEntity ie = new IssueEntity(IssueStatus.NEW, IssueResolution.DONE,id);
		ie = issueEntityDAO.save(ie);

		IssueEntity ie2 = issueEntityDAO.findById(ie.getId());
		System.out.println(ie.getId());
		assertTrue(ie.getId() == ie2.getId());

	}
}
