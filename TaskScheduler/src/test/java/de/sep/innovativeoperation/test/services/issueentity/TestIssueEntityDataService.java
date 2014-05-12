package de.sep.innovativeoperation.test.services.issueentity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIssueEntityDataService {

	@Autowired
	IssueEntityDataService issueEntityDataService;
	@Autowired
	IssueEntityDAO issueEntityDAO;
	@Autowired
	IssueDraftDAO issueDraftDAO;
	private IssueEntity issueEntity;
	
	@Before
	public void setUp(){
		
		issueEntity = issueEntityDAO.save(new IssueEntity(IssueStatus.NEW, IssueResolution.UNRESOLVED ,new IssueDraft("newDraftName", "newDraftDescription", IssueType.TASK)));
	}
	
	//TODO issueEntityDataServiceTest vs DAO Test
	@Test 
	public void testGetByIdEntityDataService(){		
		IssueEntity receivedIssueEntity = issueEntityDataService.getById(issueEntity.getId());
		assertNotNull(receivedIssueEntity);		
	}
//	createIssueEntity(issueDraftId, issueEntity)
	
	@Test
	public void testCreateIssueEntityByEntityDataService(){	
		System.out.println("testCreateIssueEntityByEntityDataService");
		IssueEntity newIssueEntity = new IssueEntity();
		System.out.println("newIssueEntity = null? "+ newIssueEntity==null);
				
		newIssueEntity.setIssueResolution(IssueResolution.UNRESOLVED);
		newIssueEntity.setIssueStatus(IssueStatus.NEW);
		
		IssueDraft newIssueDraft = new IssueDraft();
		newIssueDraft.setIssueDescription("Description = testCreateIssueEntityByEntityDataService");
		newIssueDraft.setIssueName("Name = testCreateIssueEntityByEntityDataService");
		newIssueDraft.setIssueType(IssueType.TASK);
		
		System.out.println("newIssueDraft ID = " + newIssueDraft.getId());
		newIssueDraft = issueDraftDAO.save(newIssueDraft);
		System.out.println("newIssueDraft ID = " + newIssueDraft.getId());

		IssueEntity receivedIssueEntity = issueEntityDataService.createIssueEntity(newIssueDraft.getId(), newIssueEntity);
		System.out.println("receivedIssueEntity = null? "+ receivedIssueEntity==null);
		assertNotNull(receivedIssueEntity);	
		assertTrue(receivedIssueEntity.getId()>0);
	}
	//TODO issueEntityDataServiceTest vs DAO Test

	@Test
	public void testUpdateIssueEntityByEntityDataService(){
		IssueEntity alteredIssueEntity = new IssueEntity();
		alteredIssueEntity.setIssueResolution(IssueResolution.DONE);
		alteredIssueEntity.setIssueStatus(IssueStatus.RESOLVED);

				System.out.println("change:");
				System.out.println("resolution from: "+ issueEntity.getIssueResolution()+" TO: "+ alteredIssueEntity.getIssueResolution());
				System.out.println("status from: "+ issueEntity.getIssueStatus()+" TO: "+ alteredIssueEntity.getIssueStatus());
		issueEntity = issueEntityDataService.updateIssueEntity(issueEntity.getId(), alteredIssueEntity);
		assertTrue(issueEntity.getIssueResolution().equals(IssueResolution.DONE));
		assertTrue(issueEntity.getIssueStatus().equals(IssueStatus.RESOLVED));

	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void testExceptionIsThrownForGetIntMAX_VALUEIssueEntityDataService(){		
		issueEntityDataService.getById(Integer.MAX_VALUE);
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void testExceptionIsThrownForGetIntMIN_VALUEIssueEntityDataService(){		
		issueEntityDataService.getById(Integer.MIN_VALUE);
	}
	
	
	
	
//	@After
//	public void cleanDatabase(){
////		if (issueEntityDAO.) TODO cleanDatabase
//		if (issueEntity!=null){
//			int id = issueEntity.getId();
//			System.out.println("to remove: " + issueEntity.getId());
//			issueEntityDAO.remove(issueEntity);
//			IssueEntity reallyRemovedIssueEntity = issueEntityDAO.findById(id);
//			System.out.println(reallyRemovedIssueEntity!=null);
//			System.out.println("removed: " +issueEntity.getId());
//		}else
//			System.out.println("issueEntity was null");
//	}
	
//	@Test
//	public void test(){
//		issueEntityDataService.deleteIssueEntity(id);
//		issueEntityDataService.getAllIssueEntities();
//		issueEntityDataService.getIssueEntity(issueEntityId)
//		issueEntityDataService.getClass()
//		issueEntityDataService.updateIssueEntity(id, issueEntity);
//		
//	}
}
