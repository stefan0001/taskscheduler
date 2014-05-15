package de.sep.innovativeoperation.test.services.eventTask;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNotValidException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNullException;
import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.service.event.EventDataService;
import de.sep.innovativeoperation.taskscheduler.service.eventtask.EventTaskDataService;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftDataService;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class EventTaskDataServiceTest {

	@Autowired
	EventTaskDataService eventTaskDataService;

	@Autowired
	EventDataService eventDataService;
	@Autowired
	IssueDraftDataService issueDraftDataService;

	private Event event;
	private Event otherEvent;
	private EventTask eventTask;
	private int maxNameLength = 100;

	@Before
	public void setUp() throws Exception {
		event = new Event("foo");
//		event.setId(0);
		event.setEventTasks(new HashSet<EventTask>());
		event = eventDataService.createEvent(event);
		

		otherEvent = new Event("baa");
//		otherEvent.setId(0);

		eventTask = new EventTask();
		eventTask.setName("DooFoo");
//		eventTask.s

	}

	@Test
	public void testCreateGoodEventTaskWithSavedEventMethodIntEventTask() {
		Event newEvent = new Event("foo");
		newEvent.setEventTasks(new HashSet<EventTask>());
		Event savedEvent = eventDataService.createEvent(newEvent);
		assertTrue(savedEvent.getId()>0);
		EventTask newEventTask = new EventTask("foo");
		newEventTask.setIssueDrafts(new HashSet<IssueDraft>());
		// assertNotNull(eventDataService.getById(event.getId()));
		assertNotNull(eventTaskDataService);
		assertNotNull(savedEvent);
		assertNotNull(eventTask);
		
		EventTask savedEventTask = eventTaskDataService.createEventTask(
				savedEvent.getId(), newEventTask);
		assertTrue(savedEventTask.getId() > 0);
		assertTrue(savedEventTask.getEvent().equals(savedEvent));
	}

	@Test(expected = NullPointerException.class)
	public void testCreateNullEventTaskWithSavedEventMethodIntEventTask() {
		eventTaskDataService.createEventTask(event.getId(), null);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testCreateEventTaskWithBadEventIdMethodIntEventTask() {
		eventTaskDataService.createEventTask(-1, eventTask);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testCreateGoodEventTaskWithUnsavedEventMethodIntEventTask() {
		Event unsavedEvent = new Event("unsaved");
		EventTask savedEventTask = eventTaskDataService.createEventTask(
				unsavedEvent.getId(), eventTask);
//		assertTrue(savedEventTask.getId() > 0);
//		assertTrue(savedEventTask.getEvent().equals(unsavedEvent));
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testCreateGoodEventTaskWithUnsavedEventMethodEventEventTask() {
		Event newEvent = new Event("baa");
		assertTrue(newEvent.getId()==0);
		EventTask savedEventTask = eventTaskDataService.createEventTask(
				newEvent.getId(), eventTask);
//		assertTrue(savedEventTask.getId() > 0);
//		assertTrue(savedEventTask.getEvent().getName()
//				.equals(newEvent.getName()));
//		assertTrue(savedEventTask.getEvent().getId() > 0);
	}

	@Test
	public void testCreateGoodEventTaskWithSavedEventMethodEventEventTask() {

		EventTask savedEventTask = eventTaskDataService.createEventTask(event.getId(),
				eventTask);

		assertTrue(savedEventTask.getId() > 0);
		assertTrue(savedEventTask.getEvent().getName().equals(event.getName()));
		assertTrue(savedEventTask.getEvent().getId() > 0);
		assertTrue(savedEventTask.getEvent().getId() == event.getId());
	}

	@Test
	public void testUpdateEventTask() {
		EventTask otherEventTask = new EventTask();
		otherEventTask.setName("DooBaa");

		EventTask savedEventTask = eventTaskDataService.createEventTask(event.getId(),
				eventTask);

		EventTask updatedEventTask = eventTaskDataService.updateEventTask(
				savedEventTask.getId(), otherEventTask);

		assertTrue(updatedEventTask.getId() > 0);
		assertTrue(updatedEventTask.getEvent().getId() > 0);
		assertTrue(updatedEventTask.getName().equals(otherEventTask.getName()));
	}

	@Test(expected = NullPointerException.class)
	public void testUpdateEventTaskWithBadId() {
		EventTask otherEventTask = new EventTask();
		otherEventTask.setName("DooBaa");

		eventTaskDataService.updateEventTask(-1, otherEventTask);
	}

	@Test
	public void testGetIssueDraftsforEventTask() {
		IssueDraft newIssueDraft = new IssueDraft("foo", "dooFoo",
				IssueType.BUG);

		IssueDraft savedIssueDraft = issueDraftDataService.createIssueDraft(newIssueDraft);

		EventTask newEventTask = new EventTask("DooFooAndDooBaa");
	
		EventTask savedEventTask = eventTaskDataService.createEventTask(event.getId(),
				newEventTask);
		
		IssueDraft relatedIssueDraft = eventTaskDataService.createRelationEventTaskIssueDraft(savedEventTask.getId(), savedIssueDraft);
		
		assertTrue(savedEventTask.getId() > 0);
		Set<IssueDraft> receivedIssueDrafts = eventTaskDataService
				.getIssueDraftsforEventTask(savedEventTask.getId());
		
		assertTrue(receivedIssueDrafts.contains(relatedIssueDraft));
//		
//		
//		assertFalse(receivedIssueDrafts.isEmpty());
//		assertNotNull(receivedIssueDrafts);
//		// assertTrue(receivedIssueDrafts.size()==1);
//		for (IssueDraft issueDraft : receivedIssueDrafts) {
//			assertTrue(issueDraft.getId() > 0);
//			System.out.println(issueDraft.getIssueName());
//		}
//		assertTrue(receivedIssueDrafts.contains(newIssueDraft));

	}

	@Test
	public void testCreateRelationEventTaskIssueDraft() {
		
		IssueDraft newIssueDraft = new IssueDraft("foo", "dooFoo",
				IssueType.BUG);

		IssueDraft savedIssueDraft = issueDraftDataService.createIssueDraft(newIssueDraft);

		EventTask newEventTask = new EventTask("DooFooAndDooBaa");
	
		EventTask savedEventTask = eventTaskDataService.createEventTask(event.getId(),
				newEventTask);
		
		IssueDraft relatedIssueDraft = eventTaskDataService.createRelationEventTaskIssueDraft(savedEventTask.getId(), savedIssueDraft);
		
		assertTrue(relatedIssueDraft.getEventTasks().contains(savedEventTask));
		assertTrue(savedEventTask.getIssueDrafts().contains(relatedIssueDraft));

//		Event newEvent = new Event("hitFooBaa");
//		newEvent.setEventTasks(new HashSet<EventTask>());
//		IssueDraft issueDraftOne = new IssueDraft("foo", "dooFoo",
//				IssueType.BUG);
//		IssueDraft issueDraftTwo = new IssueDraft("baa", "dooBaa",
//				IssueType.BUG);
//
//		Set<IssueDraft> issueDrafts = new HashSet<IssueDraft>();
//		issueDrafts.add(issueDraftOne);
//		issueDrafts.add(issueDraftTwo);
//		EventTask eventTaskToRelateWith = new EventTask();
//		eventTaskToRelateWith.setName("DooFooAndDooBaa");
//
//		eventTaskToRelateWith = eventTaskDataService.createEventTask(
//				event.getId(), eventTaskToRelateWith);
//
//		assertTrue(eventTaskToRelateWith.getId() > 0);
//		IssueDraft relatedIssueDraft = eventTaskDataService
//				.createRelationEventTaskIssueDraft(
//						eventTaskToRelateWith.getId(), issueDraftOne);
//		assertTrue(relatedIssueDraft.getId() > 0);
//	
//		assertTrue(relatedIssueDraft.getIssueName().equals(
//				issueDraftOne.getIssueName()));
//
//		assertTrue(eventTaskToRelateWith.getIssueDrafts().contains(
//				issueDraftOne));
//	
//		relatedIssueDraft = eventTaskDataService
//				.createRelationEventTaskIssueDraft(
//						eventTaskToRelateWith.getId(), issueDraftTwo);
//		assertTrue(relatedIssueDraft.getId() > 0);
//		assertTrue(eventTaskToRelateWith.getIssueDrafts().contains(
//				issueDraftOne));

	}

	@Test
	public void testDeleteRelationEventTaskIssueDraft() {
		IssueDraft issueDraftOne = new IssueDraft("foo", "dooFoo",
				IssueType.BUG);
//		event = new Event("fooEvent");
//		Event savedEvent = eventDataService.createEvent(event);
		assertTrue(event.getId()>0);
		EventTask savedEventTask = eventTaskDataService.createEventTask(event.getId(),
				eventTask);
		IssueDraft savedIssueDraft = eventTaskDataService
				.createRelationEventTaskIssueDraft(savedEventTask.getId(),
						issueDraftOne);
		assertTrue(savedEventTask.getIssueDrafts().contains(savedIssueDraft));
		eventTaskDataService.deleteRelationEventTaskIssueDraft(
				savedEventTask.getId(), savedIssueDraft.getId());
		assertFalse(savedEventTask.getIssueDrafts().contains(savedIssueDraft));
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testDeleteRelationEventTaskUnrelatedIssueDraft() {
		IssueDraft issueDraftOne = new IssueDraft("foo", "dooFoo",
				IssueType.BUG);
		IssueDraft issueDraftTwo = new IssueDraft("baa", "dooBaa",
				IssueType.BUG);

		IssueDraft savedIssueDraft = eventTaskDataService
				.createRelationEventTaskIssueDraft(eventTask.getId(),
						issueDraftTwo);
		assertTrue(savedIssueDraft.getId() > 0);
		eventTaskDataService.deleteRelationEventTaskIssueDraft(
				eventTask.getId(), savedIssueDraft.getId());
		eventTaskDataService.deleteRelationEventTaskIssueDraft(
				eventTask.getId(), savedIssueDraft.getId());

	}

	@Test
	public void testGetAllEventTasksForEvent() {
		Event newEvent = new Event("foo");
		newEvent.setEventTasks(new HashSet<EventTask>());
		Event savedEvent = eventDataService.createEvent(newEvent);
		EventTask newEventTask = new EventTask("baa");
		newEventTask.setEvent(savedEvent);
		assertTrue(savedEvent.getId()>0);
		EventTask createdEventTask = eventTaskDataService.createEventTask(savedEvent.getId(), newEventTask);
		Set<EventTask> eventTasks = eventTaskDataService.getAllEventTasksForEvent(savedEvent.getId());
		assertNotNull(eventTasks);
		assertFalse(eventTasks.isEmpty());
		assertTrue(eventTasks.contains(createdEventTask));
	}

}
