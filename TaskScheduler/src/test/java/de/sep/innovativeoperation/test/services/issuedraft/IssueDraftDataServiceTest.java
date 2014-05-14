package de.sep.innovativeoperation.test.services.issuedraft;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftDataService;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;
import de.sep.innovativeoperation.taskscheduler.service.timetask.TimeTaskDataService;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class IssueDraftDataServiceTest {
	
	@Autowired
	IssueDraftDataService issueDraftDataService;

	@Autowired
	IssueEntityDataService issueEntityDataService;
	
	@Autowired
	TimeTaskDataService timeTaskDataService;

//	private Event event;
//	private Event otherEvent;
//	private EventTask eventTask;
//	private int maxNameLength = 100;

	@Before
	public void setUp() throws Exception {
		

	}

	@Test
	public void testCreateIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa",IssueType.BUG);
		IssueDraft savedIssueDraft  = issueDraftDataService.createIssueDraft(
				issueDraft);
		assertTrue(savedIssueDraft.getId() > 0);
		assertNotNull(issueDraftDataService.getById(savedIssueDraft.getId()));
	}

	@Test
	public void testUpdateIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa",IssueType.BUG);
		IssueDraft otherIssueDraft = new IssueDraft("baa", "foo",IssueType.IMPROVEMENT);

		IssueDraft savedIssueDraft  = issueDraftDataService.createIssueDraft(
				issueDraft);
		
		IssueDraft updatedIssueDraft = issueDraftDataService.updateIssueDraft(savedIssueDraft.getId(), otherIssueDraft);
		
		assertTrue(savedIssueDraft.getId()>0);
		assertTrue(updatedIssueDraft.getId()>0);
		
		assertTrue(updatedIssueDraft.getIssueDescription().equals(otherIssueDraft.getIssueDescription()));
		assertTrue(updatedIssueDraft.getIssueName().equals(otherIssueDraft.getIssueName()));
		assertTrue(updatedIssueDraft.getIssueType().equals(otherIssueDraft.getIssueType()));


	}

	@Test
	public void testGetIssueEntitiesForIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa",IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService.createIssueDraft(issueDraft);
		
		assertTrue(savedIssueDraft.getId()>0);
		
		IssueEntity newIssueEntity = new IssueEntity(IssueStatus.NEW,IssueResolution.UNRESOLVED, issueDraft);
		IssueEntity savedIssueEntity = issueEntityDataService.createIssueEntity(savedIssueDraft.getId(), newIssueEntity);
		
		assertTrue(savedIssueEntity.getId()>0);
		
		Set<IssueEntity> issueEntities = issueDraftDataService.getIssueEntitiesForIssueDraft(savedIssueDraft.getId());
		assertTrue(savedIssueEntity.getId()>0);
		
		assertTrue(issueEntities.contains(savedIssueEntity));
		assertTrue(issueEntities.contains(issueDraftDataService.getById(savedIssueEntity.getId())));
	}

	@Test
	public void testGetTimeTasksForIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa",IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService.createIssueDraft(issueDraft);
		
		TimeTask newTimeTask = new TimeTask("Müll rausbringen",Calendar.getInstance(),Calendar.getInstance(),0,3600,false);
		
		TimeTask savedTimeTask = timeTaskDataService.createTimeTask(newTimeTask);
		assertTrue(savedTimeTask.getId()>0);
		IssueDraft relatedIssueDraft = timeTaskDataService.createRelationTimeTaskIssueDraft(savedTimeTask.getId(), savedIssueDraft);
		
		assertNotNull(relatedIssueDraft);
				
		Set<TimeTask> timeTasks = issueDraftDataService.getTimeTasksForIssueDraft(relatedIssueDraft.getId());
		assertTrue(relatedIssueDraft.getEventTasks().isEmpty());
		for (TimeTask timeTask : timeTasks) {
			System.out.println(timeTask.getId()+" " + timeTask.getName());
		}
		assertTrue(savedTimeTask.equals(savedTimeTask));
		assertTrue(relatedIssueDraft.getEventTasks().contains(savedTimeTask));		
		assertTrue(timeTasks.contains(savedTimeTask));

	}

	@Test
	public void testFilterIssueEntity() {
		fail("Not yet implemented");
	}

}
