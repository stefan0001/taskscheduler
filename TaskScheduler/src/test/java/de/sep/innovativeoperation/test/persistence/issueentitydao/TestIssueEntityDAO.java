package de.sep.innovativeoperation.test.persistence.issueentitydao;

import org.junit.Assert;
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
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;


@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestIssueEntityDAO {
	
	@Autowired
	IssueEntityDAO issueEntityDAO;
	
	
	/**
	 * Testing save
	 */
	@Test
	public void testSave() {
		//SETUP
		IssueDraft issueDraft = new IssueDraft("TESTDAO","TESTDAO",IssueType.BUG);
		IssueEntity issueEntity = new IssueEntity(IssueStatus.CLOSED, IssueResolution.CANNOT_REPRODUCE, issueDraft);
		
		//SAVE
		IssueEntity issueEntitySaved = issueEntityDAO.save(issueEntity);
		
		//FIND BACK
		IssueEntity issueEntityDB = issueEntityDAO.findById(issueEntitySaved.getId());

		
		//CHECK

		//After Saving an Entity got a ID
		Assert.assertTrue(issueEntitySaved.getId() > 0);
		
		
		//Check IssueStatus
		Assert.assertTrue(issueEntity.getIssueStatus() == issueEntityDB.getIssueStatus() );
		
		//Check IssueResolution
		Assert.assertTrue(issueEntity.getIssueResolution() == issueEntityDB.getIssueResolution() );

	}
	
	

}
