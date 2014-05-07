package de.sep.innovativeoperation.test.persistence.issuedraft;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RemoveIssueDraft {
	
	@Autowired 
	IssueDraftDAO issueDraftDAO;
	
	@Test
	public void testSaveAndDeleteIssueEntityFromIssueEntityDAO() {
		// SAVE
		
		IssueDraft issueDraft = new IssueDraft("test","AA", IssueType.BUG);
		issueDraft = issueDraftDAO.save(issueDraft);
		
		int id = issueDraft.getId();


		// CHECK
		Assert.assertNull(issueDraftDAO.findById(id));

	}
}
