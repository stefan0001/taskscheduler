package de.sep.innovativeoperation.taskscheduler.test;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.event.EventDataService;
import de.sep.innovativeoperation.taskscheduler.service.eventtask.EventTaskDataService;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftDataService;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;
import de.sep.innovativeoperation.taskscheduler.service.timetask.TimeTaskDataService;


@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class CreateSampleContentTest {
	
	@Autowired
	IssueDraftDataService issueDraftDataService;
	
	@Autowired
	IssueEntityDataService issueEntityDataService;
	
	@Autowired
	TimeTaskDataService timeTaskDataService;
	
	@Autowired
	EventDataService eventDataService;
	
	@Autowired
	EventTaskDataService eventTaskDataService;
	
	
	

	
	
	@Test
	public void createSampleContent(){
		IssueDraft issueDraft = new IssueDraft("TEST","TEST",IssueType.BUG);
		issueDraft = issueDraftDataService.createIssueDraft(issueDraft);
		
		IssueEntity issueEntity = new IssueEntity(IssueStatus.OPEN, IssueResolution.FIXED,null);
		issueEntity = issueEntityDataService.createIssueEntity(issueDraft.getId(), issueEntity);
		
		Calendar firstFireTime = Calendar.getInstance();
		TimeTask timeTask = new TimeTask("TEST",firstFireTime, Calendar.getInstance(), 3600);
		timeTask = timeTaskDataService.createTimeTask(timeTask);
		
		timeTaskDataService.createRelationTimeTaskIssueDraft(timeTask.getId(), issueDraft);
		
		
		Event event = new Event("TEST");
		event = eventDataService.createEvent(event);
		
		EventTask eventTask = new EventTask("TEST");
		eventTaskDataService.createEventTask(event.getId(), eventTask);
	
		
		
	}
}
