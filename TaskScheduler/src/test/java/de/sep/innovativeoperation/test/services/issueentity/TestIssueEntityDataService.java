package de.sep.innovativeoperation.test.services.issueentity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIssueEntityDataService {

	@Autowired
	IssueEntityDataService issueEntityDataService;
	
	@Before
	public void setUp(){
		IssueEntity issueEntity = new IssueEntity();
	}
	@Test(expected = ResourceNotFoundException.class)
	public void testExceptionIsThrownForGetIntMAX_VALUEIssueEntity(){		
		issueEntityDataService.getById(Integer.MAX_VALUE);
	}
	@Test
	public void testGetFirstIssueEntity(){		
		IssueEntity issueEntity = issueEntityDataService.getById(1);
		assertNotNull(issueEntity);
		assertTrue(issueEntity.getId()==1);
	}
	
//	@Test
//	public void test(){
//		issueEntityDataService.createIssueEntity(issueDraftId, issueEntity);
//		issueEntityDataService.deleteIssueEntity(id);
//		issueEntityDataService.getAllIssueEntities();
//		issueEntityDataService.getIssueEntity(issueEntityId)
//		issueEntityDataService.getClass()
//		issueEntityDataService.updateIssueEntity(id, issueEntity);
//		
//	}
}
