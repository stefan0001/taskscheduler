package de.sep.innovativeoperation.test.persistence.issueentity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDraftDAO {
	@Autowired
	IssueDraftDAO issueDraftDAO;
	
	@Test
	public void test(){
		System.out.println(issueDraftDAO.getIssueEntitiesForIssueDraft(1).size() );
	}
}
