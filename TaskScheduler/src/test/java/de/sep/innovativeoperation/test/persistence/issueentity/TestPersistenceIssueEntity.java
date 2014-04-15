package de.sep.innovativeoperation.test.persistence.issueentity;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.dao.IssueTemplateDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.IssueTemplate;
import de.sep.innovativeoperation.taskscheduler.model.IssueType;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPersistenceIssueEntity {

	@Autowired
	protected IssueEntityDAO issueEntityDAO;
	@Autowired
	protected IssueTemplateDAO issueTemplateDAO;

	@PersistenceContext(unitName = "H2Connection")
	protected EntityManager em;

	@Test
	public void testEntity() {

		IssueTemplate it = new IssueTemplate("TEST", "TEST", IssueType.BUG);
		it = issueTemplateDAO.save(it);

		IssueEntity ie = new IssueEntity(IssueStatus.NEW, IssueResolution.DONE,
				it);

		ie = issueEntityDAO.save(ie);

		IssueEntity ie2 = issueEntityDAO.findById(ie.getId());
		System.out.println(ie.getId());
		assertTrue(ie.getId() == ie2.getId());
		
	}
}
